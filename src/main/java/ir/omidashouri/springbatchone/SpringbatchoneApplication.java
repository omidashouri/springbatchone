package ir.omidashouri.springbatchone;

import ir.omidashouri.springbatchone.configuration.JobConfiguration;
import ir.omidashouri.springbatchone.multithread.StaticClass;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbatchoneApplication {

    public static void main(String[] args) {

        System.out.println("current thread name is: "+ Thread.currentThread().getName());

        SpringApplication.run(SpringbatchoneApplication.class, args);


        StaticClass.execute1();
//        StaticClass.execute2();
//        StaticClass.execute3();
        StaticClass.execute4();
//        StaticClass.execute5();
        
    }



}
