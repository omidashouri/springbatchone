package ir.omidashouri.springbatchone.multithread;

public class StaticClass {



    public static void execute1(){
        System.out.println("### Execute 1 ### ");

        new Runner1().run();
        new Runner2().run();

        System.out.println("+++ +++ +++");
    }

    public static void execute2(){
        System.out.println("### Execute 2 ### ");

        Thread t1 = new Thread(new Runner1());
        Thread t2 = new Thread(new Runner2());

        t1.start();
        t2.start();

        System.out.println("+++ +++ +++");
    }

    public static void execute3(){
        System.out.println("### Execute 3 ### ");

        Thread t3 = new Runner3();
        Thread t4 = new Runner4();


        t3.start();
        t4.start();

        System.out.println("+++ +++ +++");
    }

    public static void execute4(){
        System.out.println("### Execute 4 ### ");

        Thread t5 = new Runner3();
        System.out.println("current thread name is: "+ Thread.currentThread().getName());
        Thread t6 = new Runner4();
        System.out.println("current thread name is: "+ Thread.currentThread().getName());


        t5.start();
        t6.start();

        try {
//            wait for thread t5 to die then execute next line
            t5.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("+++ +++ +++");
    }

    public static void execute5(){
        System.out.println("### Execute 5 ### ");

        Thread t7 = new Thread(new InfiniteLoop());
        t7.setName("daemonThread");
        t7.setDaemon(true);
        System.out.println("current thread name is: "+ Thread.currentThread().getName());
        Thread t8 = new Thread(new Runner1());
        t8.setName("normalThread");
        System.out.println("current thread name is: "+ Thread.currentThread().getName());


        t7.start();
        t8.start();

        try {
            t8.join();
            t7.stop();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("+++ +++ +++");
    }
}
