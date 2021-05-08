package ir.omidashouri.springbatchone.multithread.threadEssentials;

import java.time.LocalTime;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class My2ExecutorService {
    ScheduledExecutorService timer = Executors.newSingleThreadScheduledExecutor();

    public static void execute() {
        new My2ExecutorService()
                .timer
                .scheduleAtFixedRate(() -> System.out.println(LocalTime.now()), 0, 1, TimeUnit.SECONDS);
        new My2ExecutorService()
                .timer
                .scheduleAtFixedRate(()-> System.out.println("hellow world"),0,200,TimeUnit.MILLISECONDS);

        System.out.println("Main: I am done, outta here!");
    }
}
