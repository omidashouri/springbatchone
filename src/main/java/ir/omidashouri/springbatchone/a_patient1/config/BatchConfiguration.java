package ir.omidashouri.springbatchone.a_patient1.config;

import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.JobRegistry;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.support.JobRegistryBeanPostProcessor;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@RequiredArgsConstructor
@Configuration
@EnableBatchProcessing
public class BatchConfiguration  {

//    1
    private final JobBuilderFactory jobBuilderFactory;
    private final StepBuilderFactory stepBuilderFactory;

//    2
    private final MyJobValidator myJobValidator;


//    3
    @Bean
    JobRegistryBeanPostProcessor jobRegistryBeanPostProcessor(JobRegistry jobRegistry) {
        JobRegistryBeanPostProcessor postProcessor = new JobRegistryBeanPostProcessor();
        postProcessor.setJobRegistry(jobRegistry);
        return postProcessor;
    }

//     1 --------------------------------------------
    @Bean
    public Job helloWorldsJob() {
        return jobBuilderFactory
                .get("helloWordsJob")
                .start(helloWorldsStep())
                .build();
    }

    @Bean
    public Step helloWorldsStep() {
        return stepBuilderFactory
                .get("step1")
                .tasklet(helloWorldsTasklet())
                .build();
    }

    @Bean
    public Tasklet helloWorldsTasklet(){
        return (contribution, chunkContext) -> {
            System.out.println("Hello word Job One");
           return RepeatStatus.FINISHED;
        };
    }


//    2 --------------------------------------------`

    @Bean
    public Job job2(Step step2) throws Exception{
        return this.jobBuilderFactory
                .get(Constants.JOB_NAME)
//                .validator(myJobValidator)
                .start(step2)
                .build();
    }

    @Bean
    public Step step2() {
        return stepBuilderFactory
                .get("step2")
                .tasklet(tasklet2())
                .build();
    }

    @Bean
    public Tasklet tasklet2(){
        return (contribution, chunkContext) -> {
            System.out.println("Hello Job 2 ");
            return RepeatStatus.CONTINUABLE;
        };
    }

}
