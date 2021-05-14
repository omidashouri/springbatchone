package ir.omidashouri.springbatchone.multithread.others;

public class Runner1 implements Runnable{

    @Override
    public void run() {
        System.out.println("current thread name is: "+ Thread.currentThread().getName());
        for(int i=0;i<10;i++){
            System.out.println("Runner1: "+i);
        }
    }
}
