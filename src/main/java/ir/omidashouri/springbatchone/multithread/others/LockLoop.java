package ir.omidashouri.springbatchone.multithread.others;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockLoop {
    private int counter = 0;
    private Lock lock = new ReentrantLock();

    public void increment() {
        lock.lock();
        try {
            for (int i = 0; i < 1000; i++) {
                counter++;
            }
            System.out.println("counter is: " + counter);
        } finally {
            lock.unlock();
        }
    }

    public int incrementValue(){
        return counter;
    }
}
