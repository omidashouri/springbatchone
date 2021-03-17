package ir.omidashouri.springbatchone.jobs;

import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.job.flow.FlowExecutionStatus;
import org.springframework.batch.core.job.flow.JobExecutionDecider;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class DeliveryDecider implements JobExecutionDecider {
    @Override
    public FlowExecutionStatus decide(JobExecution jobExecution, StepExecution stepExecution) {
        String result = LocalDateTime.now().getHour() < 12 ? "PRESENT" : "NOT_PRESENT";
        result = "PRESENT";
        System.out.println("Delivery Decider result is: >> " + result);
        return new FlowExecutionStatus(result);
    }
}
