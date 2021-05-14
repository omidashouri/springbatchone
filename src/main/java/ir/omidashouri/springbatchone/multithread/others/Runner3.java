package ir.omidashouri.springbatchone.multithread.others;

public class Runner3 extends Thread{
    @Override
    public void run() {
        System.out.println("current thread name is: "+ Thread.currentThread().getName());
        for(int i=0;i<10;i++){
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Runner3: "+i);
        }
    }
}
