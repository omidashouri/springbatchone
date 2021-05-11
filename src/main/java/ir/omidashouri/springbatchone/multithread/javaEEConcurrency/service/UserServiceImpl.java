package ir.omidashouri.springbatchone.multithread.javaEEConcurrency.service;

import ir.omidashouri.springbatchone.multithread.javaEEConcurrency.beans.UserEntity;
import ir.omidashouri.springbatchone.multithread.javaEEConcurrency.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class UserServiceImpl implements UserService {


    private final UserRepository userRepository;


    @Override
    public List<UserEntity> saveAll(List<UserEntity> users) {
        List<UserEntity> userEntities = new ArrayList<>();
        userRepository.saveAll(users).forEach(userEntities::add);
        return userEntities;
    }

    @Override
    public UserEntity saveUser(UserEntity user) {
        return userRepository.save(user);
    }

    @Override
    public Long countUsers() {
        return userRepository.count();
    }
}
