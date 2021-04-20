package ir.omidashouri.springbatchone.multithread;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrier72 implements Runnable {
    private int id;
    private Random random;
    private CyclicBarrier cyclicBarrier;

    public CyclicBarrier72(int id, CyclicBarrier cyclicBarrier) {
        this.id = id;
        this.random = new Random();
        this.cyclicBarrier = cyclicBarrier;
    }

    @Override
    public String toString() {
        return " " + this.id;
    }

    @Override
    public void run() {
        doWork();
    }

    public void doWork() {
        System.out.println("Thread with Id: " + id + " starts the tasks...");
        try {
            Thread.sleep(random.nextInt(3000));
        } catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
        }

        System.out.println("thread with id " + id + " finished...");
        try {
            cyclicBarrier.await();
            System.out.println("After await ... ");
        } catch (InterruptedException | BrokenBarrierException exception) {
            exception.printStackTrace();
        }
    }


}
