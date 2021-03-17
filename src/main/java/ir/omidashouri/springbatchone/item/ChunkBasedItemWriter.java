package ir.omidashouri.springbatchone.item;

import org.springframework.batch.item.ItemWriter;

import java.util.List;

public class ChunkBasedItemWriter implements ItemWriter<String> {
    @Override
    public void write(List<? extends String> items) throws Exception {
        System.out.println(String.format("Received list of size: %s", items.size()));
        items.forEach(System.out::println);
    }
}
