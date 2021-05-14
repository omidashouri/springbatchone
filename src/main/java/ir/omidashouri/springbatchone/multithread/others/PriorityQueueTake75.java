package ir.omidashouri.springbatchone.multithread.others;

import java.util.concurrent.BlockingQueue;

public class PriorityQueueTake75 implements Runnable{

    private BlockingQueue<PersonCompareName> blockingQueuePerson;


    public PriorityQueueTake75(BlockingQueue<PersonCompareName> blockingQueuePerson) {
        this.blockingQueuePerson = blockingQueuePerson;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(5000);
            System.out.println(blockingQueuePerson.take());
            Thread.sleep(1000);
            System.out.println(blockingQueuePerson.take());
            Thread.sleep(1000);
            System.out.println(blockingQueuePerson.take());
            System.out.println(blockingQueuePerson.take());
            System.out.println(blockingQueuePerson.take());
        } catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
        }

    }
}
