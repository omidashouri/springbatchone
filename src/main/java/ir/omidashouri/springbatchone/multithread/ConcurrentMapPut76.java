package ir.omidashouri.springbatchone.multithread;

import java.util.concurrent.ConcurrentMap;

public class ConcurrentMapPut76 implements Runnable{

    private ConcurrentMap<String, Integer> concurrentMap;

    public ConcurrentMapPut76(ConcurrentMap<String, Integer> concurrentMap) {
        this.concurrentMap = concurrentMap;
    }


    @Override
    public void run() {

        try {
        concurrentMap.put("B",1);
        concurrentMap.put("H",2);
        Thread.sleep(1000);
        concurrentMap.put("F",3);
        concurrentMap.put("A",4);
        Thread.sleep(1000);
        concurrentMap.put("E",5);
        } catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
        }

    }
}
