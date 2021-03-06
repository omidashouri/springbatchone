package ir.omidashouri.springbatchone.multithread.javaEEConcurrency.repository;

import ir.omidashouri.springbatchone.multithread.javaEEConcurrency.beans.BankAccountEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BankAccountRepository extends CrudRepository<BankAccountEntity, Long > {

    List<BankAccountEntity>  findAll();
}
