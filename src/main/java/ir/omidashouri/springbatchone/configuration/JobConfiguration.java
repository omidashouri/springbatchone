package ir.omidashouri.springbatchone.configuration;

import ir.omidashouri.springbatchone.executionListeners.FlowersSelectionStepExecutionListener;
import ir.omidashouri.springbatchone.jobs.DeliveryDecider;
import ir.omidashouri.springbatchone.jobs.GiveToCustomerCorrectItemDecider;
import ir.omidashouri.springbatchone.tasklets.billingJob.SendInvoiceTasklet;
import ir.omidashouri.springbatchone.tasklets.deliveryPackageJob.*;
import ir.omidashouri.springbatchone.tasklets.prepareFlowersJob.ArrangeFlowersTasklet;
import ir.omidashouri.springbatchone.tasklets.prepareFlowersJob.RemoveThornsTasklet;
import ir.omidashouri.springbatchone.tasklets.prepareFlowersJob.SelectFlowersTasklet;
import lombok.AllArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.StepExecutionListener;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.job.builder.FlowBuilder;
import org.springframework.batch.core.job.flow.Flow;
import org.springframework.batch.core.job.flow.JobExecutionDecider;
import org.springframework.batch.core.job.flow.support.SimpleFlow;
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
    public JobExecutionDecider jobExecutionDeliveryDecider() {
        return new DeliveryDecider();
    }

//    --- --- ---


    private ArrangeFlowersTasklet arrangeFlowersTasklet;

    private SelectFlowersTasklet selectflowersTasklet;

    private RemoveThornsTasklet removeThornsTasklet;

    @Bean
    public StepExecutionListener flowersSelectionStepExecutionListener() {
        return new FlowersSelectionStepExecutionListener();
    }

//    ---------------------------------------

    private SendInvoiceTasklet sendInvoiceTasklet;

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
    public Step giveRefundStep() {
        return this
                .stepBuilderFactory
                .get("giveRefundStep")
                .tasklet(giveRefundTasklet)
                .build();
    }


    @Bean
    public Step thankCustomerStep() {
        return this
                .stepBuilderFactory
                .get("thankCustomerStep")
                .tasklet(thankCustomerTasklet)
                .build();
    }

    @Bean
    public Step leaveAtDoorStep() {
        return this
                .stepBuilderFactory
                .get("leaveAtDoorStep")
                .tasklet(leaveAtDoorTasklet)
                .build();
    }


    @Bean
    public Step storePackageStep() {
        return this
                .stepBuilderFactory
                .get("storePackageStep")
                .tasklet(storePackageTasklet)
                .build();
    }


    @Bean
    public Step givePackageToCustomerStep() {
        return this
                .stepBuilderFactory
                .get("givePackageToCustomerStep")
                .tasklet(givePackageToCustomerTasklet)
                .build();
    }


    @Bean
    public Step driveToAddressStep() {
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


//    ---------------------------------------



    public Flow deliveryFlow(){
        return new FlowBuilder<SimpleFlow>("deliveryFlow")

                .start(driveToAddressStep())
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
                .build();
    }




    @Bean
    public Job deliveryPackageJob() {
        return this
                .jobBuilderFactory
                .get("deliverPackageJob")
                .start(packageItemStep())
                    .on("*")
                    .to(deliveryFlow())
                .next(nestedBillingJobStep())
                .end()
                .build();
    }


//    ---------------------------------------


    @Bean
    public Step removeThornsStep() {
        return this
                .stepBuilderFactory
                .get("removeThornsStep")
                .tasklet(removeThornsTasklet)
                .build();
    }

    @Bean
    public Step selectFlowersStep() {
        return this
                .stepBuilderFactory
                .get("selectFlowersStep")
                .tasklet(selectflowersTasklet)
                .listener(flowersSelectionStepExecutionListener())
                .build();
    }

    @Bean
    public Step arrangeFlowersStep() {
        return this
                .stepBuilderFactory
                .get("arrangeFlowersStep")
                .tasklet(arrangeFlowersTasklet)
                .build();
    }

    @Bean
    public Job prepareFlowersJob() {
        return this
                .jobBuilderFactory
                .get("prepareFlowersJob")

                    .start(selectFlowersStep())
                        .on("TRIM_REQUIRED")
                        .to(removeThornsStep())
                            .next(arrangeFlowersStep())
                    .from(selectFlowersStep())
                        .on("NO_TRIM_REQUIRED")
                        .to(arrangeFlowersStep())

                    .from(arrangeFlowersStep())
                        .on("*")
                        .to(deliveryFlow())

                .end()
                .build();
    }





//    ---------------------------------------


    public Step nestedBillingJobStep(){
        return this
                .stepBuilderFactory
                .get("nestedBillingJobStep")
                .job(billingJob())
                .build();
    }


    @Bean
    public Step sendInvoiceStep(){
        return this
                .stepBuilderFactory
                .get("invoiceStep")
                .tasklet(sendInvoiceTasklet)
                .build();
    }

    @Bean
    public Job billingJob(){
        return this
                .jobBuilderFactory
                .get("billingJob")
                .start(sendInvoiceStep())
                .build();
    }

}
