package ir.omidashouri.springbatchone.multithread.javaEEConcurrency.service;

import ir.omidashouri.springbatchone.multithread.javaEEConcurrency.beans.UserEntity;

import java.util.List;

public interface UserService {

    List<UserEntity> saveAll(List<UserEntity> users);

    UserEntity saveUser(UserEntity user);

    Long countUsers();
}
