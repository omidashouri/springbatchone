package ir.omidashouri.springbatchone.multithread.others;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Worker {

    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public void producer() throws InterruptedException{
        lock.lock();
        System.out.println("producer method start ...");
        condition.await();
        System.out.println("producer method again return");
        lock.unlock();
    }

    public void consumer() throws InterruptedException{
        lock.lock();
        Thread.sleep(2000);
        System.out.println("consumer method start ...");
        condition.signal();
        System.out.println("consumer method end ...");
        lock.unlock();
    }
}
