package ir.omidashouri.springbatchone.multithread.diningPhilosophers;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Chopstick {

    private int id;
    private Lock lock;

    public Chopstick(int id) {
        this.id = id;
        this.lock = new ReentrantLock();
    }

    public boolean pickUp(Philosopher philosopher, State state) {
        try {
            if (lock.tryLock(10, TimeUnit.MILLISECONDS)) {
                System.out.println(philosopher + " picked up " + state.toString() + " " + this);
                return true;
            }
        } catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
        }
        return false;
    }

    public void putDown(Philosopher philosopher, State state) {
        lock.unlock();
        System.out.println(philosopher + " put down " + state.toString() + " " + this);
    }

    @Override
    public String toString() {
        return "Chopstick " + id;
    }
}
