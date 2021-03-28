package ir.omidashouri.springbatchone.item;

import ir.omidashouri.springbatchone.entity.OrderItem;
import org.springframework.batch.item.ItemWriter;

import java.util.List;

public class ChunkBasedItemWriterOrder implements ItemWriter<OrderItem> {
    @Override
    public void write(List<? extends OrderItem> items) throws Exception {
        System.out.println(String.format("Received list of size: %s", items.size()));
        items.forEach(System.out::println);
    }
}
