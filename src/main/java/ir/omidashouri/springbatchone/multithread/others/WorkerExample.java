package ir.omidashouri.springbatchone.multithread.others;

public class WorkerExample {

    public static void execute8Worker(){
        Worker worker = new Worker();

        Thread t15 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    worker.producer();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread t16 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    worker.consumer();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        t15.start();
        t16.start();

        try{
            t15.join();
            t16.join();
        }catch (InterruptedException interruptedException){
            interruptedException.printStackTrace();
        }
    }
}
