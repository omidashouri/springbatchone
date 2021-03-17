package ir.omidashouri.springbatchone.item;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ChunkBasedItemReader implements ItemReader<String> {

    private List<String> dataSet = new ArrayList<>();
    private Iterator<String> iterator;

    public ChunkBasedItemReader() {
        this.dataSet.add("1");
        this.dataSet.add("2");
        this.dataSet.add("3");
        this.dataSet.add("4");
        this.dataSet.add("5");
        this.iterator = this.dataSet.iterator();
    }


    @Override
    public String read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
        return this.iterator.hasNext() ? iterator.next() : null;
    }
}
