package ir.omidashouri.springbatchone.multithread.others;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BlockingQueueExecute73 {

    public static void execute(){
        BlockingQueue<Integer> integerBlockingQueue = new ArrayBlockingQueue<>(10);

        BlockingQueuePut73 blockingQueuePut73 = new BlockingQueuePut73(integerBlockingQueue);
        BlockingQueueTake73 blockingQueueTake73 = new BlockingQueueTake73(integerBlockingQueue);

        new Thread(blockingQueuePut73).start();
        new Thread(blockingQueueTake73).start();
    }
}
