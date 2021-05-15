package ir.omidashouri.springbatchone.multithread.javaEEConcurrency.controller;

import ir.omidashouri.springbatchone.multithread.javaEEConcurrency.beans.BankAccountEntity;
import ir.omidashouri.springbatchone.multithread.javaEEConcurrency.beans.BankAccountTransactionEntity;
import ir.omidashouri.springbatchone.multithread.javaEEConcurrency.runnables.F1BankReportsProcessor;
import ir.omidashouri.springbatchone.multithread.javaEEConcurrency.runnables.G1BankSchedule;
import ir.omidashouri.springbatchone.multithread.javaEEConcurrency.service.BankAccountService;
import ir.omidashouri.springbatchone.multithread.javaEEConcurrency.service.BankAccountTransactionService;
import ir.omidashouri.springbatchone.multithread.javaEEConcurrency.utility.ExportReportView;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.*;

@Controller
@RequestMapping("/bank")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class BankController {

    private final ExportReportView exportReportView;
    private final BankAccountService bankAccountService;
    private final BankAccountTransactionService bankAccountTransactionService;
    private final ExecutorService executorServiceFixed3ThreadPool;

    private final G1BankSchedule g1BankSchedule;
    private final ScheduledExecutorService executorServiceSingleThreadScheduledExecutor;

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
                    .submit(new F1BankReportsProcessor(bankAccount, bankAccountTransactionService));
            bankAccountTransactionIdz.addAll(futures.get());
        }

        bankAccountTransactions = bankAccountTransactionService.getTransactionById(bankAccountTransactionIdz);


        return new ModelAndView(exportReportView, "bankAccountTransactionList", bankAccountTransactions);
    }



//    http://localhost:8080/bank/schedule
    @GetMapping("/schedule")
    public ModelAndView schedule() throws ExecutionException, InterruptedException {

        executorServiceSingleThreadScheduledExecutor
                .scheduleAtFixedRate(g1BankSchedule,1,3,TimeUnit.SECONDS);
        System.out.println(">>>>>>>>> ");
        return new ModelAndView("bank");
    }

}
