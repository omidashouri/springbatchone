package ir.omidashouri.springbatchone.item;

import ir.omidashouri.springbatchone.entity.Order;
import org.springframework.batch.item.ItemWriter;

import java.util.List;

public class ChunkBasedItemWriterOrder implements ItemWriter<Order> {
    @Override
    public void write(List<? extends Order> items) throws Exception {
        System.out.println(String.format("Received list of size: %s", items.size()));
        items.forEach(System.out::println);
    }
}
