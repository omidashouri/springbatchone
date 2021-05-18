package ir.omidashouri.springbatchone.multithread.javaEEConcurrency.service;

import ir.omidashouri.springbatchone.multithread.javaEEConcurrency.beans.ShippedOrderEntity;
import ir.omidashouri.springbatchone.multithread.javaEEConcurrency.repository.ShippedOrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.function.Supplier;


@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ShippedOrderServiceImpl implements ShippedOrderService {

    private final ShippedOrderRepository shippedOrderRepository;
    private final ExecutorService executorServiceFixed3ThreadPool;


    @Override
    public List<ShippedOrderEntity> getAll() {
        List<ShippedOrderEntity> shippedOrders = new ArrayList<>();

        shippedOrderRepository.findAll()
                .iterator()
                .forEachRemaining(shippedOrders::add);
        return shippedOrders;
    }

    @Override
    public Supplier<List<ShippedOrderEntity>> getAllSupplier() {
        return () -> this.getAll();
    }

    @Override
    public List<ShippedOrderEntity> getAllThread() throws ExecutionException, InterruptedException {
        return CompletableFuture.supplyAsync(this.getAllSupplier(), executorServiceFixed3ThreadPool).get();
    }

    @Override
    public Supplier<Long> countAllSupplier() {
        return shippedOrderRepository::count;
    }

    @Override
    public Long countAllThread() throws ExecutionException, InterruptedException {
        return CompletableFuture.supplyAsync(this.countAllSupplier(), executorServiceFixed3ThreadPool).get();
    }


}
