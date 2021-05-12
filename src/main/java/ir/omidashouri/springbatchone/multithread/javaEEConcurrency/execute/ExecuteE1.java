package ir.omidashouri.springbatchone.multithread.javaEEConcurrency.execute;

import ir.omidashouri.springbatchone.multithread.javaEEConcurrency.runnables.E1CleaningSchedule;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;


@Component
@AllArgsConstructor
public class ExecuteE1 {

    private final E1CleaningSchedule e1CleaningSchedule;

    public void execute(){
        ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
//        executorService.schedule(e1CleaningSchedule,5, TimeUnit.SECONDS);
        executorService.scheduleAtFixedRate(e1CleaningSchedule,3,5,TimeUnit.SECONDS);
    }
}
