package ir.omidashouri.springbatchone.multithread.javaEEConcurrency.runnables;

import org.springframework.stereotype.Component;

import java.io.File;


@Component
public class E1CleaningSchedule implements Runnable{
    @Override
    public void run() {
        File folder = new File("/home/omidashouri/Developer");
        File[] files = folder.listFiles();
        for(File file:files){
            System.out.println("File Name is: "+file.getName());
        }
        System.out.println(">>>>>>> FINISHED <<<<<<<<");
    }
}
