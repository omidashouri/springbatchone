package ir.omidashouri.springbatchone.configuration;


import ir.omidashouri.springbatchone.entity.OrderItem;
import ir.omidashouri.springbatchone.item.ChunkBasedItemWriterOrder;
import ir.omidashouri.springbatchone.item.JdbcPagingQueryProvider;
import ir.omidashouri.springbatchone.item.OrderRowMapper;
import lombok.AllArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.PagingQueryProvider;
import org.springframework.batch.item.database.builder.JdbcPagingItemReaderBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;

@AllArgsConstructor
@Configuration
//@EnableBatchProcessing
public class JobConfigurationFour {


    public JobBuilderFactory jobBuilderFactory;
    public StepBuilderFactory stepBuilderFactory;
    public DataSource dataSource;
    public static String ORDER_SQL = "SELECT order_id, first_name, last_name, " +
            "email, cost, item_id, item_name, ship_date " +
            "from SHIPPED_ORDER order by order_id";


    @Bean
    public ItemWriter<OrderItem> chunkBasedItemWriterOrderJdbcPaging(){
        return new ChunkBasedItemWriterOrder();
    }

    @Bean
    public RowMapper<OrderItem> orderRowMapperPaging(){
        return new OrderRowMapper();
    }

    @Bean
    public PagingQueryProvider queryProviderPaging(){
            return new JdbcPagingQueryProvider().getPagingQueryProvider(dataSource);
    }

    @Bean
    public ItemReader<OrderItem> jdbcItemReaderPaging(){
        return new JdbcPagingItemReaderBuilder<OrderItem>()
                .dataSource(dataSource)
                .name("jdbcCursorItemReader")
                .queryProvider(queryProviderPaging())
                .rowMapper(orderRowMapperPaging())
                .pageSize(10) //equal to chunk size
                .build();
    }

    @Bean
    public Step chunkBasedStepOrderJdbcPaging(){
        return this
                .stepBuilderFactory
                .get("chunkBasedStepOrderJdbcPaging")
                .<OrderItem, OrderItem>chunk(10)
                .reader(jdbcItemReaderPaging())
                .writer(chunkBasedItemWriterOrderJdbcPaging())
                .build();
    }

    @Bean
    public Job jobOrderJdbcPaging(){
        return this
                .jobBuilderFactory
                .get("job-chunk-Order-JDBC-Paging")
                .start(chunkBasedStepOrderJdbcPaging())
                .build();
    }

}
