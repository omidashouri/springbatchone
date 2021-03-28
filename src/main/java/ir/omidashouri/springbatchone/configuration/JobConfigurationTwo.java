package ir.omidashouri.springbatchone.configuration;


import ir.omidashouri.springbatchone.entity.Order;
import ir.omidashouri.springbatchone.item.*;
import lombok.AllArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.repository.support.SimpleJobRepository;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;


@AllArgsConstructor
@Configuration
//@EnableBatchProcessing
public class JobConfigurationTwo {



    public JobBuilderFactory jobBuilderFactory;
    public StepBuilderFactory stepBuilderFactory;
    public static String[] tokens = new String[]{"order_id", "first_name", "last_name",
            "email", "cost", "item_id",
            "item_name", "ship_date"};

    @Bean
    public ItemWriter<String> chunkBasedItemWriter(){
        return new ChunkBasedItemWriter();
    }

    @Bean
    public ItemReader<String> chunkBasedItemReader(){
        return new ChunkBasedItemReader();
    }

    @Bean
    public ItemWriter<Order> chunkBasedItemWriterOrder(){
        return new ChunkBasedItemWriterOrder();
    }

    @Bean
    public ItemReader<Order> chunkBasedItemReaderOrder(){
        return new ChunkBasedItemReaderOrder();
    }

    @Bean
    public ItemReader<Order> chunkBasedItemReaderOrder2(){

        FlatFileItemReader<Order> flatFileItemReader = new FlatFileItemReader();
        DefaultLineMapper<Order> orderLineMapper = new DefaultLineMapper();
        DelimitedLineTokenizer delimitedLineTokenizer = new DelimitedLineTokenizer();
        OrderFieldSetMapper orderFieldSetMapper = new OrderFieldSetMapper();

        ResourceLoader resourceLoader = new DefaultResourceLoader();
        Resource resource = resourceLoader.getResource("classpath:data/shipped_orders.csv");

        File file = new File("classpath:data/shipped_orders.csv");
        File file2 = null;
        try {
            file2 = ResourceUtils.getFile("classpath:data/shipped_orders.csv");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        flatFileItemReader.setLinesToSkip(1);
//        flatFileItemReader.setResource(new FileSystemResource(file2));
        flatFileItemReader.setResource(resource);

        delimitedLineTokenizer.setNames(tokens);

        orderLineMapper.setLineTokenizer(delimitedLineTokenizer);
        orderLineMapper.setFieldSetMapper(orderFieldSetMapper);

        flatFileItemReader.setLineMapper(orderLineMapper);
        return flatFileItemReader;

    }

    @Bean
    public OrderFieldSetMapper orderFieldSetMapper(){
        return new OrderFieldSetMapper();
    }

    @Bean
    public Step chunkBasedStepOrder(){
        return this
                .stepBuilderFactory
                .get("chunkBasedStepOrder")
                .<Order,Order>chunk(5)
                .reader(chunkBasedItemReaderOrder2())
                .writer(chunkBasedItemWriterOrder())
                .build();
    }

    @Bean
    public Job jobOrder(){
        return this
                .jobBuilderFactory
                .get("job-chunk-Order")
                .start(chunkBasedStepOrder())
                .build();
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
