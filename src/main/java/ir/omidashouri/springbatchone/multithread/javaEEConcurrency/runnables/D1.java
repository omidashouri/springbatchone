package ir.omidashouri.springbatchone.multithread.javaEEConcurrency.runnables;

import org.springframework.stereotype.Component;

import java.util.concurrent.Callable;
import java.util.logging.Level;
import java.util.logging.Logger;

@Component
public class D1 implements Callable<Boolean> {
    @Override
    public Boolean call() throws Exception {
        Logger.getLogger(D1.class.getName()).log(Level.INFO,"Logging some something!");
        return true;
    }
}
