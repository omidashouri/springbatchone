package ir.omidashouri.springbatchone.a_patient1.services;

import ir.omidashouri.springbatchone.a_patient1.config.BatchConfiguration;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Service
public class ExecuteJobs {

    private final BatchConfiguration batchConfiguration;
    private final JobLauncher jobLauncher;

    @Scheduled(cron = "0 * * * * *")
    public void executeJob1() throws JobParametersInvalidException, JobExecutionAlreadyRunningException, JobRestartException, JobInstanceAlreadyCompleteException {

        JobParameters jobParameters = new JobParametersBuilder().addString("time", LocalDateTime.now().toString()).toJobParameters();
        JobExecution jobExecution = jobLauncher.run(batchConfiguration.helloWorldsJob(),jobParameters);
        System.out.println(jobExecution.getStatus().isRunning());
    }
}
