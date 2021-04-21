package ir.omidashouri.springbatchone.multithread;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.DelayQueue;

public class DelayWorkerExecute74 {

    public static void execute(){
        BlockingQueue<DelayedWorker74> blockingQueueDelayedWorker74 = new DelayQueue<>();

        try {
            blockingQueueDelayedWorker74.put(new DelayedWorker74(1000, "this is the first message ..."));
            blockingQueueDelayedWorker74.put(new DelayedWorker74(10000, "this is the second message ..."));
            blockingQueueDelayedWorker74.put(new DelayedWorker74(4000, "this is the third message ..."));
        } catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
        }

        while (!blockingQueueDelayedWorker74.isEmpty()){
                try {
                    System.out.println(blockingQueueDelayedWorker74.take());
                } catch (InterruptedException interruptedException) {
                    interruptedException.printStackTrace();
                }
        }
    }
}
