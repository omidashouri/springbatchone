package ir.omidashouri.springbatchone.multithread;

import java.util.concurrent.BlockingQueue;

public class BlockingQueueTake73 implements Runnable{


    private BlockingQueue<Integer> integerBlockingQueue;

    public BlockingQueueTake73(BlockingQueue<Integer> integerBlockingQueue) {
        this.integerBlockingQueue = integerBlockingQueue;
    }

    @Override
    public void run() {

        int counter = 0;

        while (true){
            try {
                int number = integerBlockingQueue.take();
                System.out.println("taking items to the queue ...  "+number);
                Thread.sleep(1000);

            } catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            }
        }
    }
}
