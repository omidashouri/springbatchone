package ir.omidashouri.springbatchone.multithread.threadEssentials;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Consumer;

public class My3ParallelSort {

    int[] numbers = ThreadLocalRandom.current().ints(100_000_000).toArray();


    public static void sorting(String description, int[] numbers,
                               Consumer<int[]> sortAlgorithm) {
        long time = System.currentTimeMillis();
        sortAlgorithm.accept(numbers);
        time = System.currentTimeMillis() - time;
        System.out.println(description + " time = " + time + " ms");
    }

    public static void execute() {
        int[] numbersSeq = new My3ParallelSort().numbers.clone();
        int[] numbersPar = new My3ParallelSort().numbers.clone();

        for (int i = 1; i < 2; i++) {
//            FOR SORTED ARRAY PARALLEL TAKE MORE TIME
            sorting("seq", numbersSeq, Arrays::sort);
            sorting("par", numbersPar, Arrays::parallelSort);
        }
    }
}
