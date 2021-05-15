package ir.omidashouri.springbatchone.multithread.javaEEConcurrency.controller;

import ir.omidashouri.springbatchone.multithread.javaEEConcurrency.beans.BankAccountEntity;
import ir.omidashouri.springbatchone.multithread.javaEEConcurrency.beans.BankAccountTransactionEntity;
import ir.omidashouri.springbatchone.multithread.javaEEConcurrency.runnables.F1ReportsProcessor;
import ir.omidashouri.springbatchone.multithread.javaEEConcurrency.service.BankAccountService;
import ir.omidashouri.springbatchone.multithread.javaEEConcurrency.service.BankAccountTransactionService;
import ir.omidashouri.springbatchone.multithread.javaEEConcurrency.utility.ExportReportView;
import ir.omidashouri.springbatchone.multithread.javaEEConcurrency.utility.ThreadConfiguration;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

@Controller
@RequestMapping("/bank")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class BankController {

    private final ExportReportView exportReportView;
    private final BankAccountService bankAccountService;
    private final BankAccountTransactionService bankAccountTransactionService;
    private final ExecutorService executorServiceFixed3ThreadPool;

    //    http://localhost:8080/b
    @GetMapping("")
    public String executeC1() {
        return "bank";
    }

    @GetMapping("/report")
    public ModelAndView report() throws ExecutionException, InterruptedException {

        List<BankAccountTransactionEntity> bankAccountTransactions = Collections.synchronizedList(new ArrayList());
        List<Long> bankAccountTransactionIdz = new ArrayList<>();
/*        bankAccountTransactions
                .add(new BankAccountTransactionEntity(1L, 1, 1D, new Date(),1));
        bankAccountTransactions
                .add(new BankAccountTransactionEntity(2L, 2, 2D, new Date(),2));*/

        List<BankAccountEntity> bankAccounts = bankAccountService.getAllBankAccounts();

        for (BankAccountEntity bankAccount : bankAccounts) {
            Future<List<Long>> futures = executorServiceFixed3ThreadPool
                    .submit(new F1ReportsProcessor(bankAccount, bankAccountTransactionService));
            bankAccountTransactionIdz.addAll(futures.get());
        }

        bankAccountTransactions = bankAccountTransactionService.getTransactionById(bankAccountTransactionIdz);


        return new ModelAndView(exportReportView, "bankAccountTransactionList", bankAccountTransactions);
    }

}
