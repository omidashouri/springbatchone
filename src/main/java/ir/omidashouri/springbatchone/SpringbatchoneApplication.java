package ir.omidashouri.springbatchone;

import ir.omidashouri.springbatchone.multithread.javaEEConcurrency.execute.ExecuteUsers;
import ir.omidashouri.springbatchone.multithread.javaEEConcurrency.runnables.A1;
import ir.omidashouri.springbatchone.multithread.javaEEConcurrency.runnables.B1;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbatchoneApplication {

    public static void main(String[] args) {

        System.out.println("current thread name is: " + Thread.currentThread().getName());

        SpringApplication.run(SpringbatchoneApplication.class, args);

        System.out.println("Number of threads: "+Runtime.getRuntime().availableProcessors());

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

//        SemaphoreDownloadExecutor.download();

//        DeadLock.executeDeadLock();

//        LiveLock.executeLiveLock();

//        new AtomicIntegerExample().executeAtomicInteger();

//        new Task_52Executor().singleThreadExecutor();

//        new Task_52Executor().fixedThreadPool();

//        new StockMarketUpdater_54().scheduledThreadPool();

//        new Task_52Executor().fixedThreadPoolShutDown();

//        new Processor_57Executor().execute();

//        new LatchWorker71Execute().execute();

//        new CyclicBarrier72Execute().execute();

//        new BlockingQueueExecute73().execute();
        
//        new DelayWorkerExecute74().execute();

//        new PriorityQueueExecute75().execute();

//        new ConcurrentMapExecute76().execute();

//        new ExchangerThreadExecute77().execute();


/*        try {
            new ExecuteDiningPhilosopher().execute();
        } catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
        }*/

//        new ExecuteStudentLibrary().execute();

//        new My1MultiThread().execute();

//        new My2ExecutorService().execute();

//        new My3ParallelSort().execute();


//        new My4CounterExecutor().execute();


//        new SumExample().execute();


//        new A1().execute();


//        new B1().execute();



    }


}
