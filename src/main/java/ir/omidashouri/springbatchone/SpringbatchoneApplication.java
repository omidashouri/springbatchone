package ir.omidashouri.springbatchone;

import ir.omidashouri.springbatchone.configuration.JobConfiguration;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbatchoneApplication {

    public static void main(String[] args) {

        SpringApplication.run(SpringbatchoneApplication.class, args);
    }

}
