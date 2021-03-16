package ir.omidashouri.springbatchone.tasklets.deliveryPackageJob;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.stereotype.Component;

@Component
public class HelloWorldTasklet implements Tasklet {
    @Override
    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
        System.out.println("Hello World Tasklet for  OMID ASHOURI !");
        return RepeatStatus.FINISHED;
    }
}
