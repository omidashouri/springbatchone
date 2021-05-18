package ir.omidashouri.springbatchone.multithread.javaEEConcurrency.service;

import ir.omidashouri.springbatchone.multithread.javaEEConcurrency.beans.ShippedOrderEntity;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.function.Consumer;
import java.util.function.Supplier;

public interface ShippedOrderService {

    List<ShippedOrderEntity> getAll();

    Supplier<List<ShippedOrderEntity>> getAllSupplier();

    List<ShippedOrderEntity> getAllThread() throws ExecutionException, InterruptedException;

    Supplier<Long> countAllSupplier();

    Long countAllThread() throws ExecutionException, InterruptedException;

}
