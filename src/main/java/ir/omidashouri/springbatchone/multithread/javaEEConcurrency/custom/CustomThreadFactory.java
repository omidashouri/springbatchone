package ir.omidashouri.springbatchone.multithread.javaEEConcurrency.custom;

import org.springframework.stereotype.Component;

import java.util.concurrent.ThreadFactory;

@Component
public class CustomThreadFactory implements ThreadFactory {

    private static int counter = 0;

    @Override
    public Thread newThread(Runnable r) {
        Thread thread = new Thread(r);
        thread.setName("Custom Thread-"+(++counter));
        return thread;
    }
}
