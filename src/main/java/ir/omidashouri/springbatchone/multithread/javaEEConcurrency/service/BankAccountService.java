package ir.omidashouri.springbatchone.multithread.javaEEConcurrency.service;

import ir.omidashouri.springbatchone.multithread.javaEEConcurrency.beans.BankAccountEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BankAccountService {

    public List<BankAccountEntity> getAllBankAccounts();
}
