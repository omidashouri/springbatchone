package ir.omidashouri.springbatchone.multithread.others;

import java.util.concurrent.BlockingQueue;

public class PriorityQueuePut75 implements Runnable{

    private BlockingQueue<PersonCompareName> blockingQueuePerson;

    public PriorityQueuePut75(BlockingQueue<PersonCompareName> blockingQueuePerson) {
        this.blockingQueuePerson = blockingQueuePerson;
    }


    @Override
    public void run() {

            try {
                blockingQueuePerson.put(new PersonCompareName(12,"Ali"));
                blockingQueuePerson.put(new PersonCompareName(45,"Golamreza"));
                blockingQueuePerson.put(new PersonCompareName(70,"Daryoush"));
                Thread.sleep(1000);
                blockingQueuePerson.put(new PersonCompareName(32,"Neda"));
                Thread.sleep(1000);
                blockingQueuePerson.put(new PersonCompareName(34,"Kaveh"));
            } catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            }

    }
}
