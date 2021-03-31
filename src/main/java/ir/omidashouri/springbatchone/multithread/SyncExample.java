package ir.omidashouri.springbatchone.multithread;

public class SyncExample {
    public static int counterAsync = 0;
    public static int counterSync = 0;

    public static int counterSync1 = 0;
    public static int counterSync2 = 0;

    private static final Object lock1 = new Object();
    private static final Object lock2 = new Object();

    public static void incrementCounter1() {
        synchronized(lock1){
            System.out.println("counterSync1 for " + Thread.currentThread().getName() + "is: " + counterSync1);
            counterSync1++;
        }
    }
    public static void incrementCounter2() {
        synchronized(lock2){
            System.out.println("counterSync2 for " + Thread.currentThread().getName() + "is: " + counterSync2);
            counterSync2++;
        }
    }



//    method executed only by a single thread at a given time
    public static void incrementCounter() {
        synchronized(SyncExample.class){
            System.out.println("counterSync for " + Thread.currentThread().getName() + "is: " + counterSync);
            counterSync++;
        }
    }

    public static void processASynchrony() {

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    System.out.println("call increment ASynchrony by: "+Thread.currentThread().getName());
                    counterAsync++;
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    System.out.println("call increment ASynchrony by: "+Thread.currentThread().getName());
                    counterAsync++;
                }
            }
        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("The ASynchronize Counter is: " + counterAsync);
    }

    public static void processSynchrony() {

        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    incrementCounter();
                }
            }
        });

        Thread t4 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    incrementCounter();
                }
            }
        });

        t3.start();
        t4.start();

        try {
            t3.join();
            t4.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("The Synchronize Counter is: " + counterSync);
    }

//    solve the locking problem on class for better speed
    public static void processSynchrony2() {

        Thread t5 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    incrementCounter1();
                }
            }
        });

        Thread t6 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    incrementCounter2();
                }
            }
        });

        t5.start();
        t6.start();

        try {
            t5.join();
            t6.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("The Synchronize Counter 1 is: " + counterSync1);
        System.out.println("The Synchronize Counter 2 is: " + counterSync2);
    }
}
