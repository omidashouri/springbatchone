package ir.omidashouri.springbatchone.configuration;

import ir.omidashouri.springbatchone.jobs.DeliveryDecider;
import ir.omidashouri.springbatchone.jobs.GiveToCustomerCorrectItemDecider;
import ir.omidashouri.springbatchone.tasklets.*;
import lombok.AllArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.job.flow.JobExecutionDecider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@AllArgsConstructor
@Configuration
@EnableBatchProcessing
public class JobConfiguration {


    private JobBuilderFactory jobBuilderFactory;

    private StepBuilderFactory stepBuilderFactory;

    private HelloWorldTasklet helloWorldTasklet;

    private PackageItemStepTasklet packageItemStepTasklet;

    private DriveToAddressTasklet driveToAddressTasklet;

    private GivePackageToCustomerTasklet givePackageToCustomerTasklet;

    private StorePackageTasklet storePackageTasklet;

    private LeaveAtDoorTasklet leaveAtDoorTasklet;

    private ThankCustomerTasklet thankCustomerTasklet;

    private GiveRefundTasklet giveRefundTasklet;

    private GiveToCustomerCorrectItemDecider giveToCustomer_CorrectItemDecider;


    @Bean
    public JobExecutionDecider jobExecutionDeliveryDecider(){
        return new DeliveryDecider();
    }


//    ---------------------------------------

    @Bean
    public Step helloWorldStep() {
        return stepBuilderFactory
                .get("step1")
                .tasklet(helloWorldTasklet)
                .build();
    }

    @Bean
    public Job helloWorldJob() {
        return jobBuilderFactory
                .get("helloWordJob")
                .start(helloWorldStep())
                .build();
    }


//    ---------------------------------------

    @Bean
    public Step giveRefundStep(){
        return this
                .stepBuilderFactory
                .get("giveRefundStep")
                .tasklet(giveRefundTasklet)
                .build();
    }


    @Bean
    public Step thankCustomerStep(){
        return this
                .stepBuilderFactory
                .get("thankCustomerStep")
                .tasklet(thankCustomerTasklet)
                .build();
    }

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
                            //driveToAddressStep: if failed ->
                            .on("FAILED")
                            .to(storePackageStep())
                        .from(driveToAddressStep())
                            //driveToAddressStep: if other status ->
                            .on("*")
                            .to(jobExecutionDeliveryDecider())
                                //driveToAddressStep: other status: if PRESENT ->
                                .on("PRESENT")
                                .to(givePackageToCustomerStep())

                                    .next(giveToCustomer_CorrectItemDecider)
                                        //driveToAddressStep: other status: if PRESENT: Correct Item ->
                                        .on("CORRECT_ITEM")
                                        .to(thankCustomerStep())
                                    .from(giveToCustomer_CorrectItemDecider)
                                        //driveToAddressStep: other status: if PRESENT:  inCorrect Item ->
                                        .on("INCORRECT_ITEM")
                                        .to(giveRefundStep())

                            .from(jobExecutionDeliveryDecider())
                            //driveToAddressStep: other status: if NOT PRESENT ->
                                .on("NOT_PRESENT")
                                .to(leaveAtDoorStep())

                        .end()
        .build();
    }

}
