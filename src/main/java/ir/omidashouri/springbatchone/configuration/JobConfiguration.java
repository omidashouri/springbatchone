package ir.omidashouri.springbatchone.configuration;

import ir.omidashouri.springbatchone.jobs.DeliveryDecider;
import ir.omidashouri.springbatchone.tasklets.*;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.job.flow.JobExecutionDecider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableBatchProcessing
public class JobConfiguration {


    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Autowired
    private Tasklet1 tasklet1;

    @Autowired
    private PackageItemStepTasklet packageItemStepTasklet;

    @Autowired
    private DriveToAddressTasklet driveToAddressTasklet;

    @Autowired
    private GivePackageToCustomerTasklet givePackageToCustomerTasklet;

    @Autowired
    private StorePackageTasklet storePackageTasklet;

    @Autowired
    private LeaveAtDoorTasklet leaveAtDoorTasklet;




    @Bean
    public JobExecutionDecider jobExecutionDeliveryDecider(){
        return new DeliveryDecider();
    }


    @Bean
    public Step step1() {
        return stepBuilderFactory
                .get("step1")
                .tasklet(tasklet1)
                .build();
    }

    @Bean
    public Job helloWorldJob() {
        return jobBuilderFactory
                .get("helloWordJob")
                .start(step1())
                .build();
    }

//    ---------------------------------------

    @Bean
    public Step leaveAtDoorStep(){
        return this
                .stepBuilderFactory
                .get("leaveAtDoorStep")
                .tasklet(leaveAtDoorTasklet)
                .build();
    }


    @Bean
    public Step storePackageStep(){
        return this
                .stepBuilderFactory
                .get("storePackageStep")
                .tasklet(storePackageTasklet)
                .build();
    }


    @Bean
    public Step givePackageToCustomerStep(){
        return this
                .stepBuilderFactory
                .get("givePackageToCustomerStep")
                .tasklet(givePackageToCustomerTasklet)
                .build();
    }


    @Bean
    public Step driveToAddressStep(){
        return this
                .stepBuilderFactory
                .get("driveToAddressStep")
                .tasklet(driveToAddressTasklet)
                .build();
    }


    @Bean
    public Step packageItemStep() {
        return this
                .stepBuilderFactory
                .get("packageItemStep")
                .tasklet(packageItemStepTasklet)
                .build();
    }


    @Bean
    public Job deliveryPackageJob() {
        return this
                .jobBuilderFactory
                .get("deliverPackageJob")
                .start(packageItemStep())

                .next(driveToAddressStep())
                    .on("FAILED").to(storePackageStep())
                .from(driveToAddressStep())
                    .on("*").to(jobExecutionDeliveryDecider())
                        .on("PRESENT").to(givePackageToCustomerStep())
                    .from(jobExecutionDeliveryDecider())
                        .on("NOT_PRESENT").to(leaveAtDoorStep())
                .end()

                .build();
    }

}
