package ir.omidashouri.springbatchone.configuration;

import ir.omidashouri.springbatchone.myBatchClasses.Tasklet1;
import lombok.AllArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@AllArgsConstructor
@Configuration
@EnableBatchProcessing
public class JobConfiguration {


    private final JobBuilderFactory jobBuilderFactory;
    private final StepBuilderFactory stepBuilderFactory;


    @Bean
    public Step step1() {
        return stepBuilderFactory
                .get("step1")
                .tasklet(new Tasklet1())
                .build();
    }

    @Bean
    public Job helloWorldJob() {
        return jobBuilderFactory
                .get("helloWordJob")
                .start(step1())
                .build();
    }

}
