package ir.omidashouri.springbatchone.multithread.others;

import java.util.concurrent.Exchanger;

public class ExchangerThreadOne77 implements Runnable {
    private int counter;
    private Exchanger<Integer> exchanger;

    public ExchangerThreadOne77(Exchanger<Integer> exchanger) {
        this.exchanger = exchanger;
    }


    @Override
    public void run() {
        while (true) {
            counter = counter + 2;
            System.out.println("First Thread incremented the counter " + counter);
            try {
                counter = exchanger.exchange(counter);
                Thread.sleep(1000);
            } catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            }
        }
    }
}
