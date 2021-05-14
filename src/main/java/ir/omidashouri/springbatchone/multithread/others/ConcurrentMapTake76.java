package ir.omidashouri.springbatchone.multithread.others;

import java.util.concurrent.ConcurrentMap;

public class ConcurrentMapTake76 implements Runnable{
    private ConcurrentMap<String, Integer> concurrentMap;

    public ConcurrentMapTake76(ConcurrentMap<String, Integer> concurrentMap) {
        this.concurrentMap = concurrentMap;
    }


    @Override
    public void run() {
        try {
            Thread.sleep(5000);
            System.out.println(concurrentMap.get("A"));
            Thread.sleep(1000);
            System.out.println(concurrentMap.get("E"));
            System.out.println(concurrentMap.get("F"));
        } catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
        }
    }
}
