package ir.omidashouri.springbatchone.multithread.javaEEConcurrency.execute;

import ir.omidashouri.springbatchone.multithread.javaEEConcurrency.runnables.D1;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;


@Component
@AllArgsConstructor
public class ExecuteD1 {

    private final D1 d1;


    public void execute() {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        List<Callable<Boolean>> callables = new ArrayList<>();

        for (int i = 0; i < 20; i++) {
            callables.add(d1);
        }

        try {
            List<Future<Boolean>> futures = executorService.invokeAll(callables);

            for (Future<Boolean> future : futures) {
                System.out.println("Operation result invoke All: "+future.get());
            }

            executorService.shutdown();

            System.out.println("The service is shutdown? "+executorService.awaitTermination(30,TimeUnit.MILLISECONDS));


//            System.out.println("operation result invoke Any: "+ executorService.invokeAny(callables));

        } catch (InterruptedException | ExecutionException interruptedException) {
            executorService.shutdownNow();
            interruptedException.printStackTrace();
        }
    }
}
