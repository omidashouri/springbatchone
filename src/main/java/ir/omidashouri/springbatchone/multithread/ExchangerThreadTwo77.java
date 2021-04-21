package ir.omidashouri.springbatchone.multithread;

import java.util.concurrent.Exchanger;

public class ExchangerThreadTwo77 implements Runnable{

    private int counter;
    private Exchanger<Integer> exchanger;

    public ExchangerThreadTwo77(Exchanger<Integer> exchanger) {
        this.exchanger = exchanger;
    }


    @Override
    public void run() {
        while (true){
            counter = counter--;
            System.out.println("Second Thread decremented the counter "+counter);
            try {
                counter = exchanger.exchange(counter);
                Thread.sleep(1000);
            } catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            }
        }
    }
}
