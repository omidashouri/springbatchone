package ir.omidashouri.springbatchone.multithread.javaEEConcurrency.service;

import ir.omidashouri.springbatchone.multithread.javaEEConcurrency.beans.UserEntity;
import ir.omidashouri.springbatchone.multithread.javaEEConcurrency.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceA implements UserService{

    private UserRepository userRepository;


    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<UserEntity> saveAll(List<UserEntity> users) {
        return null;
    }

    @Override
    public UserEntity saveUser(UserEntity user) {
        return null;
    }

    @Override
    public Long countUsers() {
        return userRepository.count();
    }
}
