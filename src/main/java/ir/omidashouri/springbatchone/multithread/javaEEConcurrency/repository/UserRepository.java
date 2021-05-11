package ir.omidashouri.springbatchone.multithread.javaEEConcurrency.repository;

import ir.omidashouri.springbatchone.multithread.javaEEConcurrency.beans.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends CrudRepository<UserEntity, Long> {

}
