package ir.omidashouri.springbatchone.multithread.others;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class LatchWorker71Execute {

    public static void execute() {
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        CountDownLatch countDownLatch = new CountDownLatch(5);
        for (int i = 0; i < 5; i++) {
            executorService.execute(new LatchWorker71(i+1, countDownLatch));
        }
        try {
//            stop all thread until the count down reach zero then continue
            countDownLatch.await();
        } catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
        }
//        execute when latch reach zero
        System.out.println("All the prerequisites are done...");
        executorService.shutdown();
    }
}
