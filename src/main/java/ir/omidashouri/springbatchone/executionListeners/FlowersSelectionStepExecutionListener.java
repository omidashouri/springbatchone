package ir.omidashouri.springbatchone.executionListeners;

import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;


public class FlowersSelectionStepExecutionListener implements StepExecutionListener {
    @Override
    public void beforeStep(StepExecution stepExecution) {
        System.out.println("Executing before step logic: FlowersSelectionStepExecutionListener");
    }

    @Override
    public ExitStatus afterStep(StepExecution stepExecution) {
        System.out.println("Executing after step logic: FlowersSelectionStepExecutionListener");
//        String flowerType = stepExecution.getJobParameters().getString("type");
        String flowerType = "roses";
        if (flowerType.equalsIgnoreCase("roses")) {
            return new ExitStatus("TRIM_REQUIRED");
        } else {
            return new ExitStatus("NO_TRIM_REQUIRED");
        }
    }
}
