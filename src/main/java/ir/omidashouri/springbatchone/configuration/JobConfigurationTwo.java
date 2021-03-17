package ir.omidashouri.springbatchone.configuration;


import ir.omidashouri.springbatchone.item.ChunkBasedItemReader;
import ir.omidashouri.springbatchone.item.ChunkBasedItemWriter;
import lombok.AllArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@AllArgsConstructor
@Configuration
@EnableBatchProcessing
public class JobConfigurationTwo {

    public JobBuilderFactory jobBuilderFactory;
    public StepBuilderFactory stepBuilderFactory;

    @Bean
    public ItemWriter<String> chunkBasedItemWriter(){
        return new ChunkBasedItemWriter();
    }

    @Bean
    public ItemReader<String> chunkBasedItemReader(){
        return new ChunkBasedItemReader();
    }

    @Bean
    public Step chunkBasedStep(){
        return this
                .stepBuilderFactory
                .get("chunkBasedStep")
                .<String,String>chunk(3)
                .reader(chunkBasedItemReader())
                .writer(chunkBasedItemWriter())
                .build();
    }

    @Bean
    public Job job(){
        return this
                .jobBuilderFactory
                .get("job-chunk")
                .start(chunkBasedStep())
                .build();
    }

}
