package ir.omidashouri.springbatchone.multithread.javaEEConcurrency.runnables;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

import java.io.*;

public class A1 extends Thread{

    @Override
    public void run(){

        try {
            ClassLoader classLoader = getClass().getClassLoader();

            ResourceLoader resourceLoader = new DefaultResourceLoader();
            Resource resource = resourceLoader.getResource("javaeeconcurencyfiles/sample.txt");
            InputStream inputStream = resource.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            while (reader.ready()) {
                String line = reader.readLine();
                System.out.println(Thread.currentThread().getName()+" >> "+line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public static void execute(){
        A1 a = new A1();
        A1 b = new A1();
        A1 c = new A1();

        a.start();
        b.start();
        c.start();
    }


    private String readFromInputStream(InputStream inputStream)
            throws IOException {
        StringBuilder resultStringBuilder = new StringBuilder();
        try (BufferedReader br
                     = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            while ((line = br.readLine()) != null) {
                resultStringBuilder.append(line).append("\n");
            }
        }
        return resultStringBuilder.toString();
    }
}
