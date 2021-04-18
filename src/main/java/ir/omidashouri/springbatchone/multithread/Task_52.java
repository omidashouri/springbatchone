package ir.omidashouri.springbatchone.multithread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Task_52 implements Runnable{
    private int id;

    public Task_52(int id) {
        this.id = id;
    }


    @Override
    public void run() {

            System.out.println("Task with id: " + id + " is in work - thread name: " + Thread.currentThread().getName()
            +" with thread id: "+Thread.currentThread().getId());
            long duration = Double.valueOf(Math.random() * 5).longValue();

            try {
                TimeUnit.SECONDS.sleep(duration);
            } catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
                Thread.currentThread().interrupt();
            }
    }

}
