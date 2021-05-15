package ir.omidashouri.springbatchone.multithread.javaEEConcurrency.service;

import ir.omidashouri.springbatchone.multithread.javaEEConcurrency.beans.BankAccountTransactionEntity;
import ir.omidashouri.springbatchone.multithread.javaEEConcurrency.repository.BankAccountTransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BankAccountTransactionServiceImpl implements BankAccountTransactionService {

    private final BankAccountTransactionRepository bankAccountTransactionRepository;

    @Override
    public List<BankAccountTransactionEntity> getTransactionsByAccountNumber(Integer accountNumber) {
        return bankAccountTransactionRepository.findAllByAccNumber(accountNumber);
    }

    @Override
    public List<BankAccountTransactionEntity> getTransactionById(List<Long> idz) {
        List<BankAccountTransactionEntity> bankAccountTransactions = new ArrayList<>();
        bankAccountTransactionRepository.findAllById(idz).forEach(bankAccountTransactions::add);
        return bankAccountTransactions;
    }
}
