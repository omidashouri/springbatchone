package ir.omidashouri.springbatchone.multithread.sumExample;

import java.util.Arrays;
import java.util.Random;


public class SumExample {

    static int[] random = new Random().ints(500_000_000).toArray();

    public static int sumSequential(int[] ints){
       return Arrays.stream(ints).sum();
    }

    public static int sumParallel(int[] ints){
        return Arrays.stream(ints).parallel().sum();
    }

    public static long calculateElapsedTime(long startTime){
        return System.currentTimeMillis()-startTime;

    }

    public static void execute(){

        for(int i=0;i<3;i++){
            long timeSeq = System.currentTimeMillis();
            new SumExample().sumSequential(random);
            timeSeq = calculateElapsedTime(timeSeq);

            long timePar = System.currentTimeMillis();
            new SumExample().sumParallel(random);
            timePar = calculateElapsedTime(timePar);

            System.out.println(i+"- sum in sequential takes: "+timeSeq+" ms");
            System.out.println(i+"- sum in parallel takes: "+timePar+" ms");
        }
    }

}
