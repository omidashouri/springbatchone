package ir.omidashouri.springbatchone.multithread;

import java.util.concurrent.Exchanger;

public class ExchangerThreadExecute77 {

    public static void execute(){
        Exchanger<Integer> exchanger = new Exchanger();

        new Thread(new ExchangerThreadOne77(exchanger)).start();
        new Thread(new ExchangerThreadTwo77(exchanger)).start();
    }
}
