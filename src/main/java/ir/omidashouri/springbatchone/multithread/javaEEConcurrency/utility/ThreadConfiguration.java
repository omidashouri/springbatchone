package ir.omidashouri.springbatchone.multithread.javaEEConcurrency.utility;


import ir.omidashouri.springbatchone.multithread.javaEEConcurrency.beans.BankAccountEntity;
import org.apache.tomcat.util.descriptor.web.ContextService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

import java.util.concurrent.*;

@Configuration
public class ThreadConfiguration {


    @Bean
    public WebApplicationContext currentWebApplicationContext(){
      return ContextLoader.getCurrentWebApplicationContext();
    }

    @Bean
    public ExecutorService executorServiceThreadPoolExecutor(ThreadFactory threadFactory){
        return  new ThreadPoolExecutor(3, 10, 5, TimeUnit.SECONDS, new ArrayBlockingQueue<>(2), threadFactory);
    }

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
