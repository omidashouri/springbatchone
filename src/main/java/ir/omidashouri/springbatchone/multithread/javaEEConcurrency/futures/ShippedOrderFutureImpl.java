package ir.omidashouri.springbatchone.multithread.javaEEConcurrency.futures;

import ir.omidashouri.springbatchone.multithread.javaEEConcurrency.beans.ShippedOrderEntity;
import ir.omidashouri.springbatchone.multithread.javaEEConcurrency.service.ShippedOrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Supplier;

@Component
@RequiredArgsConstructor
public class ShippedOrderFutureImpl implements ShippedOrderFuture {

    private final ShippedOrderService shippedOrderService;

    @Override
    public List<ShippedOrderEntity> getAll() throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        Supplier<List<ShippedOrderEntity>> listSupplier = () -> shippedOrderService.getAll();

        return CompletableFuture.supplyAsync(listSupplier,executorService).get();
    }


}
