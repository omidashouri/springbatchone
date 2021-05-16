package ir.omidashouri.springbatchone.multithread.javaEEConcurrency.runnables;

import org.springframework.stereotype.Component;

import javax.security.auth.Subject;
import java.security.AccessController;
import java.util.Objects;

@Component
public class H1ContextServiceRunnable implements Runnable{
    @Override
    public void run() {
        System.out.println("Thread "+Thread.currentThread().getName());
        Subject subject = Subject.getSubject(AccessController.getContext());
        System.out.println("Security information from normal thread: "+subject);
    }
}
