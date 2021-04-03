package ir.omidashouri.springbatchone.multithread;

public class Process {

    public void produce() throws InterruptedException{
        synchronized (this){
            System.out.println("Running the produce method...then wait...");
            wait();
            System.out.println("Running the produce method...resume from wait...");
        }
    }

    public void consume() throws InterruptedException{
        Thread.sleep(1000);
        synchronized (this){
            System.out.println("Consume method is executing...");
            notify();
            Thread.sleep(5000);
        }
    }
}
