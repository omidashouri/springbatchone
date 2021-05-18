package ir.omidashouri.springbatchone.multithread.javaEEConcurrency.service;

import ir.omidashouri.springbatchone.multithread.javaEEConcurrency.beans.ShippedOrderEntity;

import java.util.List;

public interface ShippedOrderService {

    List<ShippedOrderEntity> getAll();
}
