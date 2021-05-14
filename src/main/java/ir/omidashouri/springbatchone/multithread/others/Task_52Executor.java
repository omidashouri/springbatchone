package ir.omidashouri.springbatchone.multithread.others;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Task_52Executor {

    public static void singleThreadExecutor(){

        ExecutorService executorService = Executors.newSingleThreadExecutor();
        for(int i=0;i<5;i++){
            executorService.execute(new Task_52(i));
        }

    }

    public static void fixedThreadPool(){
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        for(int i=0;i<10;i++){
            executorService.execute(new Task_52(i+1));
        }
    }

    public static void fixedThreadPoolShutDown(){
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        for(int i=0;i<10;i++){
            executorService.execute(new Task_52(i+1));

//            prevent any further task to execute
            executorService.shutdown();

//            terminate running tasks
            try{
                if(executorService.awaitTermination(7000, TimeUnit.MILLISECONDS)){
                    executorService.shutdownNow();
                }
            }catch (InterruptedException interruptedException){
                interruptedException.printStackTrace();
            }
        }
    }
}
