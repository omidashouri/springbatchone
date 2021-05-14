package ir.omidashouri.springbatchone.multithread.others;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

public class PriorityQueueExecute75 {



    public static void execute(){
        BlockingQueue<PersonCompareName> blockingQueue = new PriorityBlockingQueue<>();
        new Thread(new PriorityQueuePut75(blockingQueue)).start();
        new Thread(new PriorityQueueTake75(blockingQueue)).start();
    }
}
