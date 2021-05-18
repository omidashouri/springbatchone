package ir.omidashouri.springbatchone.multithread.javaEEConcurrency.service;

import ir.omidashouri.springbatchone.multithread.javaEEConcurrency.beans.ShippedOrderEntity;
import ir.omidashouri.springbatchone.multithread.javaEEConcurrency.repository.ShippedOrderRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
@RequiredArgsConstructor
public class ShippedOrderServiceImpl implements ShippedOrderService {

    private final ShippedOrderRepository shippedOrderRepository;

    @Override
    public List<ShippedOrderEntity> getAll() {
        List<ShippedOrderEntity> shippedOrders = new ArrayList<>();

        shippedOrderRepository.findAll()
                .iterator()
                .forEachRemaining(shippedOrders::add);
        return shippedOrders;
    }
}
