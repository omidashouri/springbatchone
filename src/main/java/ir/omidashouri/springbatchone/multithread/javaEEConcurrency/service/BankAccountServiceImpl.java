package ir.omidashouri.springbatchone.multithread.javaEEConcurrency.service;

import ir.omidashouri.springbatchone.multithread.javaEEConcurrency.beans.BankAccountEntity;
import ir.omidashouri.springbatchone.multithread.javaEEConcurrency.repository.BankAccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BankAccountServiceImpl implements BankAccountService {

    private final BankAccountRepository bankAccountRepository;

    @Override
    public List<BankAccountEntity> getAllBankAccounts() {
        List<BankAccountEntity> bankAccounts = new ArrayList<>();
        bankAccountRepository.findAll().forEach(bankAccounts::add);
        return bankAccounts;
    }
}
