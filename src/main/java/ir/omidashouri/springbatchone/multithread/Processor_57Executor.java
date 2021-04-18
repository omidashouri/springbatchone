package ir.omidashouri.springbatchone.multithread;

import com.sun.el.stream.Stream;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Processor_57Executor {

    public static void execute() {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        List<Future<String>> futures = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Future<String> future = executorService.submit(new Processor_57(i));
            futures.add(future);
        }

        futures.forEach(f ->
                {
                    try {
                        System.out.println(f.get());
                    } catch (InterruptedException interruptedException) {
                        interruptedException.printStackTrace();
                    } catch (ExecutionException e) {
                        e.printStackTrace();
                    }
                }
        );

        executorService.shutdown();
    }

}
