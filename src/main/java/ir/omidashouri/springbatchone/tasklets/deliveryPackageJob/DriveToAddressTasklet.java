package ir.omidashouri.springbatchone.tasklets.deliveryPackageJob;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.stereotype.Component;

@Component
public class DriveToAddressTasklet implements Tasklet {

    Boolean GOT_LOST = false;
    @Override
    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
        if(GOT_LOST){
            throw new RuntimeException("Got lost driving to the address");
        }
        System.out.println("Drive To Address Tasklet: Successfully Arrive at the address");
        return RepeatStatus.FINISHED;
    }
}
