package ir.omidashouri.springbatchone.multithread;

public class ProcessExample {


    public static void execute6Process(){
        System.out.println("### Execute Process Class ### ");
        Process process = new Process();

        Thread t9 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    process.produce();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread t10 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    process.consume();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        t9.start();
        t10.start();

        System.out.println("+++ +++ +++");
    }
}
