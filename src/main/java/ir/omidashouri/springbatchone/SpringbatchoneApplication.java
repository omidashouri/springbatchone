package ir.omidashouri.springbatchone;

import ir.omidashouri.springbatchone.multithread.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbatchoneApplication {

    public static void main(String[] args) {

        System.out.println("current thread name is: "+ Thread.currentThread().getName());

        SpringApplication.run(SpringbatchoneApplication.class, args);


//        RunnerExample.execute1();
//        RunnerExample.execute2();
//        RunnerExample.execute3();
//        RunnerExample.execute4();
//        RunnerExample.execute5();

//        SyncExample.processASynchrony();
//        SyncExample.processSynchrony();
//        for run processSynchrony2 first comment processSynchrony
//        SyncExample.processSynchrony2();

//        ProcessExample.execute6Process();

//        ProcessorExample.execute7Processor();

//        LockLoopExample.execute7LockLoop();

//        WorkerExample.execute8Worker();

//        WorkerVolatileExecute.execute10WorkerVolatile();

        SemaphoreDownloadExecutor.download();

    }



}
