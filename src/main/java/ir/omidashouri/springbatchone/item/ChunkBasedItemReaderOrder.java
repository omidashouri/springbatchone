package ir.omidashouri.springbatchone.item;

import ir.omidashouri.springbatchone.entity.OrderItem;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.core.io.FileSystemResource;

public class ChunkBasedItemReaderOrder implements ItemReader<OrderItem> {

    public static String[] tokens = new String[]{"order_id", "first_name", "last_name",
            "email", "cost", "item_id",
            "item_name", "ship_date"};
    FlatFileItemReader<OrderItem> flatFileItemReader = new FlatFileItemReader();
    DefaultLineMapper<OrderItem> orderLineMapper = new DefaultLineMapper();
    DelimitedLineTokenizer delimitedLineTokenizer = new DelimitedLineTokenizer();
    OrderFieldSetMapper orderFieldSetMapper = new OrderFieldSetMapper();

    @Override
    public OrderItem read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
        flatFileItemReader.setLinesToSkip(1);
        flatFileItemReader.setResource(new FileSystemResource("data/shipped_orders.csv"));

        delimitedLineTokenizer.setNames(tokens);

        orderLineMapper.setLineTokenizer(delimitedLineTokenizer);
        orderLineMapper.setFieldSetMapper(orderFieldSetMapper);

        flatFileItemReader.setLineMapper(orderLineMapper);
        return flatFileItemReader.read();

    }
}
