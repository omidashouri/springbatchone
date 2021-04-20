package ir.omidashouri.springbatchone.multithread;

import java.util.concurrent.BlockingQueue;

public class BlockingQueuePut73 implements Runnable{

    private BlockingQueue<Integer> integerBlockingQueue;

    public BlockingQueuePut73(BlockingQueue<Integer> integerBlockingQueue) {
        this.integerBlockingQueue = integerBlockingQueue;
    }

    @Override
    public void run() {

        int counter = 0;

        while (true){
            try {
                integerBlockingQueue.put(counter);
                System.out.println("putting items to the queue ...  "+counter);
                counter++;
                Thread.sleep(30);

            } catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            }
        }
    }
}
