package ir.omidashouri.springbatchone.multithread.javaEEConcurrency.runnables;

import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class B1 {
    Runnable runnable = () -> {
        try {
            ResourceLoader resourceLoader = new DefaultResourceLoader();
            Resource resource = resourceLoader.getResource("javaeeconcurencyfiles/sample.txt");
            InputStream inputStream = resource.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            while (reader.ready()) {
                String line = reader.readLine();
                System.out.println(Thread.currentThread().getName() + " >> " + line);
            }
        } catch (
                IOException e) {
            e.printStackTrace();
        }
    };

    public static void execute() {
        Thread thread = new Thread(new B1().runnable);
        thread.start();
    }
}
