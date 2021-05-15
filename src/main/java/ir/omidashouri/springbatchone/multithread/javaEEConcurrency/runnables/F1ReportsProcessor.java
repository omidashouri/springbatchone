package ir.omidashouri.springbatchone.multithread.javaEEConcurrency.runnables;

import ir.omidashouri.springbatchone.multithread.javaEEConcurrency.beans.BankAccountEntity;
import ir.omidashouri.springbatchone.multithread.javaEEConcurrency.beans.BankAccountTransactionEntity;
import ir.omidashouri.springbatchone.multithread.javaEEConcurrency.service.BankAccountService;
import ir.omidashouri.springbatchone.multithread.javaEEConcurrency.service.BankAccountTransactionService;
import ir.omidashouri.springbatchone.multithread.javaEEConcurrency.utility.ExportReportView;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class F1ReportsProcessor implements Callable<List<Long>> {

    private final BankAccountEntity bankAccountZ;
    private final BankAccountTransactionService bankAccountTransactionService;


    @Override
    public List<Long> call() throws Exception {
        Integer accountNumber = bankAccountZ.getAccNumber();
        List<Long> accountTransactionIdz = new ArrayList<>();

        List<BankAccountTransactionEntity> bankAccountTransactions = bankAccountTransactionService
                .getTransactionsByAccountNumber(accountNumber);

        accountTransactionIdz = bankAccountTransactions
                .stream()
                .parallel()
                .map(BankAccountTransactionEntity::getId)
                .collect(Collectors.toList());

        return accountTransactionIdz;
    }
}
