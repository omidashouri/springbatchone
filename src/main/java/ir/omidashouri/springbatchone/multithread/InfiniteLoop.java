package ir.omidashouri.springbatchone.multithread;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InfiniteLoop implements Runnable {
    private volatile boolean terminated;

    @Override
    public void run() {
        System.out.println("current thread name is: " + Thread.currentThread().getName());
        while (!terminated) {
            System.out.println("Infinite Loop Running .... ");
        }
    }
}
