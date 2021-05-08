package ir.omidashouri.springbatchone.multithread.threadEssentials;

import java.time.LocalTime;

public class My1MultiThread {
    Thread timeThread = new Thread(()->{
     while (true){
         System.out.println(LocalTime.now());
         try {
             Thread.sleep(1000);
         } catch (InterruptedException interruptedException) {
             interruptedException.printStackTrace();
         }
     }
    },"timeThread") ;
    Runnable target;
    Thread helloThread = new Thread(()->{
        while (true){
            System.out.println("Hello World");
            try {
                Thread.sleep(200);
            } catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            }
        }
    },"helloThread");

    public static void execute(){
        new My1MultiThread().timeThread.start();
        new My1MultiThread().helloThread.start();
        System.out.println("Main: I am done, outta here!");
    }
}
