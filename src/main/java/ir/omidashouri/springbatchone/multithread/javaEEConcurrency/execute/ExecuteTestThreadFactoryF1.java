package ir.omidashouri.springbatchone.multithread.javaEEConcurrency.execute;

import ir.omidashouri.springbatchone.multithread.javaEEConcurrency.custom.CustomThreadFactory;
import ir.omidashouri.springbatchone.multithread.javaEEConcurrency.runnables.D1;
import org.springframework.stereotype.Component;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Component
public class ExecuteTestThreadFactoryF1 {
    public void execute(){
        ExecutorService executorService = Executors.newFixedThreadPool(3,new CustomThreadFactory());
        for(int i=0;i<20;i++){
            executorService.submit(new D1());

        }
    }
}
