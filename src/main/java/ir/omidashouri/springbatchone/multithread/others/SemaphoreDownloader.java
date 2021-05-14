package ir.omidashouri.springbatchone.multithread.others;

import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

public enum SemaphoreDownloader {
    INSTANCE;
    private AtomicInteger atomicInteger = new AtomicInteger();
    private Semaphore semaphore = new Semaphore(5, true);

    public void downloadDate(){
        try {
            semaphore.acquire();
            download();
            System.out.println("Download Executed ...");
        } catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
        }finally {
            semaphore.release();
        }
    }

    private void download() {

        System.out.println("Downloading date from the web ..."+atomicInteger.incrementAndGet());
        try {
            Thread.sleep(5000);
        } catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
        }
    }

}
