package ir.omidashouri.springbatchone.multithread;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class StockMarketUpdater_54 implements Runnable{
    @Override
    public void run() {
        System.out.println("Updating and downloading stock related data from web ...");
    }

     public static void scheduledThreadPool(){
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);
        scheduledExecutorService.scheduleAtFixedRate(new StockMarketUpdater_54(),1000,5000, TimeUnit.MILLISECONDS);
     }
}
