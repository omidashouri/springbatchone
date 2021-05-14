package ir.omidashouri.springbatchone.multithread.others;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SemaphoreDownloadExecutor {


    public static void download() {
        ExecutorService executorService = Executors.newCachedThreadPool();

        for (int i = 0; i < 50; i++) {
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    SemaphoreDownloader.INSTANCE.downloadDate();

                }
            });
        }
    }
}
