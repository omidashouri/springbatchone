package ir.omidashouri.springbatchone.multithread.others;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CyclicBarrier72Execute {
    public static void execute() {

        ExecutorService executorService = Executors.newFixedThreadPool(5);

        CyclicBarrier cyclicBarrier = new CyclicBarrier(5, new Runnable() {
            @Override
            public void run() {
                System.out.println("All the tasks are finished ...");
            }
        });

        for (int i = 0; i < 5; i++) {
            executorService.execute(new CyclicBarrier72(i+1, cyclicBarrier));
        }

        executorService.shutdown();
    }

}
