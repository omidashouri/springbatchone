package ir.omidashouri.springbatchone.multithread;

public class InfiniteLoop implements Runnable{

    @Override
    public void run() {
        System.out.println("current thread name is: "+ Thread.currentThread().getName());
        while (true){
            System.out.println("Infinite Loop Running .... ");
        }
    }
}
