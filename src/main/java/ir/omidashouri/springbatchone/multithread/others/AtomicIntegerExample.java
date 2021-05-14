package ir.omidashouri.springbatchone.multithread.others;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerExample {

/*    private static int counter = 0;
    public synchronized static void increment() {
        for (int i = 0; i < 1000; i++) {
            counter++;
        }
    }*/

    private static AtomicInteger counter = new AtomicInteger(0);

    public static void increment() {
        for (int i = 0; i < 1000; i++) {
            counter.getAndIncrement();
        }
    }

    Thread t1 = new Thread(new Runnable() {
        @Override
        public void run() {
            increment();
        }
    });

    Thread t2 = new Thread(() -> {
        increment();
    });


    public void executeAtomicInteger() {

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
        }
        System.out.println("Counter: " + counter);
    }
}
