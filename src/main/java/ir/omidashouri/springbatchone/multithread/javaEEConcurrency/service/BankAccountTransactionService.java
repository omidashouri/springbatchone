package ir.omidashouri.springbatchone.multithread.javaEEConcurrency.service;

import ir.omidashouri.springbatchone.multithread.javaEEConcurrency.beans.BankAccountTransactionEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BankAccountTransactionService {

    List<BankAccountTransactionEntity> getTransactionsByAccountNumber(Integer accountNumber);

    List<BankAccountTransactionEntity> getTransactionById(List<Long> idz);
}
