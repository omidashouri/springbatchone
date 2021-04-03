package ir.omidashouri.springbatchone.multithread;

public class ProcessorExample {

    public static void execute7Processor() {
        System.out.println("### Execute Producer Class ### ");
        Processor processor = new Processor();

        Thread t11 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    processor.producer();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread t12 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    processor.consume();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        t11.start();
        t12.start();

        System.out.println("+++ +++ +++");
    }
}
