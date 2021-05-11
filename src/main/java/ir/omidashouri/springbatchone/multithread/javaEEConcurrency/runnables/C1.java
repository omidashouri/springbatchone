package ir.omidashouri.springbatchone.multithread.javaEEConcurrency.runnables;

import ir.omidashouri.springbatchone.multithread.javaEEConcurrency.beans.UserEntity;
import ir.omidashouri.springbatchone.multithread.javaEEConcurrency.service.UserService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.concurrent.Callable;

@Component
@AllArgsConstructor
public class C1 implements Callable<Long> {

    private final UserService userService;
    private final String userRecord;


    @Override
    public Long call() throws Exception {
        System.out.println(Thread.currentThread().getName());
        StringTokenizer stringTokenizer = new StringTokenizer(userRecord, ",");
        List<UserEntity> users = new ArrayList<>();
        UserEntity user;
        Long id=1L;
        while (stringTokenizer.hasMoreTokens()) {
            user = new UserEntity();
            user.setEmailAddress(stringTokenizer.nextToken());
            user.setName(stringTokenizer.nextToken());
            user.setIdd(Integer.valueOf(stringTokenizer.nextToken()));
            user.setId(id);
            userService.saveUser(user);
            id++;
        }
        return userService.countUsers();
    }
}
