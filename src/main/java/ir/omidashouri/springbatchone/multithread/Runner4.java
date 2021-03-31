package ir.omidashouri.springbatchone.multithread;

public class Runner4 extends Thread {
    @Override
    public void run() {
        System.out.println("current thread name is: " + Thread.currentThread().getName());
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Runner4: " + i);
        }
    }
}