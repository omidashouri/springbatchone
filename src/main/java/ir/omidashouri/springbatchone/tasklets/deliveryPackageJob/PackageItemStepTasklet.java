package ir.omidashouri.springbatchone.tasklets.deliveryPackageJob;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.stereotype.Component;

@Component
public class PackageItemStepTasklet implements Tasklet {
    @Override
    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {

        String item = "ITEM";
        String date = "DATE";

/*        item = chunkContext.getStepContext().getJobParameters().get("item").toString();
        date = chunkContext.getStepContext().getJobParameters().get("run.date").toString();*/

        System.out.println(String.format("The %s has been packaged on %s",item ,date));
        return RepeatStatus.FINISHED;
    }
}
