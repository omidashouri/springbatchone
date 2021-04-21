package ir.omidashouri.springbatchone.multithread;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class ConcurrentMapExecute76 {

    public static void execute(){
        ConcurrentMap<String,Integer> concurrentMap = new ConcurrentHashMap<>();

        new Thread(new ConcurrentMapPut76(concurrentMap)).start();
        new Thread(new ConcurrentMapTake76(concurrentMap)).start();

//        create synchronized list, that is too slow
        List<String> strings = new ArrayList<>();
        List<String> synchronizedStrings = Collections.synchronizedList(strings);

    }
}
