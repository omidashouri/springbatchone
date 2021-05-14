package ir.omidashouri.springbatchone.multithread.others;

public class WorkerVolatileExecute {

    public static void execute10WorkerVolatile() {
        WorkerVolatile workerVolatile = new WorkerVolatile();
        Thread thread = new Thread(workerVolatile);
        thread.start();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
        }
        System.out.println("Algorithm is terminated ...");
        workerVolatile.setTerminated(true);
    }
}
