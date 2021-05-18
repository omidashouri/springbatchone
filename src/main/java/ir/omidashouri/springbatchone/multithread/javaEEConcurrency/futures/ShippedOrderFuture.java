package ir.omidashouri.springbatchone.multithread.javaEEConcurrency.futures;

import ir.omidashouri.springbatchone.multithread.javaEEConcurrency.beans.ShippedOrderEntity;

import java.util.List;
import java.util.concurrent.ExecutionException;

public interface ShippedOrderFuture {

    List<ShippedOrderEntity> getAll() throws ExecutionException, InterruptedException;

}
