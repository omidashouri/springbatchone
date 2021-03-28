package ir.omidashouri.springbatchone.configuration;


import ir.omidashouri.springbatchone.entity.Order;
import ir.omidashouri.springbatchone.item.ChunkBasedItemWriterOrder;
import ir.omidashouri.springbatchone.item.OrderRowMapper;
import lombok.AllArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.builder.JdbcCursorItemReaderBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;

@AllArgsConstructor
@Configuration
@EnableBatchProcessing
public class JobConfigurationThree {


    public JobBuilderFactory jobBuilderFactory;
    public StepBuilderFactory stepBuilderFactory;
    public DataSource dataSource;
    public static String ORDER_SQL = "SELECT order_id, first_name, last_name, " +
            "email, cost, item_id, item_name, ship_date " +
            "from SHIPPED_ORDER order by order_id";


    @Bean
    public ItemWriter<Order> chunkBasedItemWriterOrderJdbc(){
        return new ChunkBasedItemWriterOrder();
    }

    @Bean
    public RowMapper<Order> orderRowMapper(){
        return new OrderRowMapper();
    }

    @Bean
    public ItemReader<Order> jdbcItemReader(){
        return new JdbcCursorItemReaderBuilder<Order>()
                .dataSource(dataSource)
                .name("jdbcCursorItemReader")
                .sql(ORDER_SQL)
                .rowMapper(orderRowMapper())
                .build();
    }

    @Bean
    public Step chunkBasedStepOrderJdbc(){
        return this
                .stepBuilderFactory
                .get("chunkBasedStepOrderJdbc")
                .<Order,Order>chunk(6)
                .reader(jdbcItemReader())
                .writer(chunkBasedItemWriterOrderJdbc())
                .build();
    }

    @Bean
    public Job jobOrderJdbc(){
        return this
                .jobBuilderFactory
                .get("job-chunk-Order-JDBC")
                .start(chunkBasedStepOrderJdbc())
                .build();
    }

}
