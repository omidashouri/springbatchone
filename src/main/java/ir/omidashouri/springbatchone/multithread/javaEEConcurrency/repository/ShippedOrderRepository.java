package ir.omidashouri.springbatchone.multithread.javaEEConcurrency.repository;

import ir.omidashouri.springbatchone.multithread.javaEEConcurrency.beans.ShippedOrderEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShippedOrderRepository extends CrudRepository<ShippedOrderEntity,Long> {
}
