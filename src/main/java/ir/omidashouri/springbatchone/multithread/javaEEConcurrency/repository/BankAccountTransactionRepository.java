package ir.omidashouri.springbatchone.multithread.javaEEConcurrency.repository;

import ir.omidashouri.springbatchone.multithread.javaEEConcurrency.beans.BankAccountTransactionEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BankAccountTransactionRepository extends CrudRepository<BankAccountTransactionEntity, Long> {

    List<BankAccountTransactionEntity> findAllByAccNumber(Integer accNumber);

}
