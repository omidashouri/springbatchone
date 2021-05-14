package ir.omidashouri.springbatchone.multithread.others;

public class LockLoopExample {

    public static void execute7LockLoop() {
        LockLoop lockLoop = new LockLoop();

        Thread t13 = new Thread(new Runnable() {
            @Override
            public void run() {
                lockLoop.increment();
            }
        });

        Thread t14 = new Thread(new Runnable() {
            @Override
            public void run() {
                lockLoop.increment();
            }
        });


        t13.start();
        t14.start();

        try {
            t13.join();
            t14.join();
        } catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
        }

        System.out.println("counter value is: " + lockLoop.incrementValue());
    }
}
