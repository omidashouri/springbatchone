package ir.omidashouri.springbatchone.multithread.javaEEConcurrency.utility;


import ir.omidashouri.springbatchone.multithread.javaEEConcurrency.beans.BankAccountEntity;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.*;

@Configuration
public class ThreadConfiguration {


    @Bean
    public ExecutorService executorServiceFixed3ThreadPool(){
        return Executors.newFixedThreadPool(3);
    }

    @Bean
    public ExecutorService executorServiceCachedThreadPool(){
        return Executors.newCachedThreadPool();
    }


    @Bean
    public ScheduledExecutorService executorServiceSingleThreadScheduledExecutor(){
      return Executors.newSingleThreadScheduledExecutor();
    }

    @Bean
    public BankAccountEntity bankAccountz(){
        return new BankAccountEntity();
    }

}
