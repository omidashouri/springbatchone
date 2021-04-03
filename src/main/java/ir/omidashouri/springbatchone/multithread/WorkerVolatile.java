package ir.omidashouri.springbatchone.multithread;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WorkerVolatile implements Runnable{

    private volatile boolean terminated;

    @Override
    public void run() {

        while(!terminated){
            System.out.println("working is running ...");
            try {
                Thread.sleep(500);
            } catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            }
        }
    }
}
