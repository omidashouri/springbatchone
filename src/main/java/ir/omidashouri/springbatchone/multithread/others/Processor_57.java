package ir.omidashouri.springbatchone.multithread.others;

import java.util.concurrent.Callable;

public class Processor_57 implements Callable<String> {
    private int id;

    public Processor_57(int id) {
        this.id = id;
    }


    @Override
    public String call() throws Exception {
        Thread.sleep(1000);
        return "ID: " + id;
    }
}
