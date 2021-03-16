package ir.omidashouri.springbatchone.jobs;

import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.job.flow.FlowExecutionStatus;
import org.springframework.batch.core.job.flow.JobExecutionDecider;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class GiveToCustomerCorrectItemDecider implements JobExecutionDecider {
    @Override
    public FlowExecutionStatus decide(JobExecution jobExecution, StepExecution stepExecution) {
        String correctItem =  "CORRECT_ITEM";
        String notCorrectItem = "NOT_CORRECT";
        System.out.println("Give to Customer Correct Item Decider result is: >> " + correctItem);
        return new FlowExecutionStatus(correctItem);
    }
}
