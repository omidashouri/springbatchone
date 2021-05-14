package ir.omidashouri.springbatchone.multithread.others;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

public class LatchWorker71 implements Runnable {
    private int id;
    private CountDownLatch countDownLatch;
    private Random random;

    public LatchWorker71(int id, CountDownLatch countDownLatch) {
        this.id = id;
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        doWork();
        countDownLatch.countDown();
    }

    private void doWork() {
        System.out.println("Thread with id " + this.id + "  starts working ...");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
        }
    }


}
