package ir.omidashouri.springbatchone.multithread.javaEEConcurrency.controller;

import ir.omidashouri.springbatchone.multithread.javaEEConcurrency.beans.ShippedOrderEntity;
import ir.omidashouri.springbatchone.multithread.javaEEConcurrency.service.ShippedOrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.time.Duration;
import java.time.Instant;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Controller
@RequestMapping("/shippedOrder")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ShippedOrderController {

    private final ShippedOrderService shippedOrderService;

    //    http://localhost:8080/shippedOrder/all
    @GetMapping("/allThread")
    public ModelAndView getAllThread() throws ExecutionException, InterruptedException {

        Instant begin = Instant.now();
        System.out.println("Begin Time >>> " + begin);



        Instant end = Instant.now();
        System.out.println("End Time >>> " + end);

        List<ShippedOrderEntity> shippedOrders = shippedOrderService.getAllThread();

        System.out.println("Duration >>> " + Duration.between(begin, end).toMillis());

        System.out.println(shippedOrders.size());
        return new ModelAndView();
    }

    //    http://localhost:8080/shippedOrder/all
    @GetMapping("/allNormal")
    public ModelAndView getAllNormal() throws ExecutionException, InterruptedException {

        Instant begin = Instant.now();
        System.out.println("Begin Time >>> " + begin);

        List<ShippedOrderEntity> shippedOrders = shippedOrderService.getAll();

        Instant end = begin.now();
        System.out.println("End Time >>> " + end);
        System.out.println("Duration >>> " + Duration.between(begin, end).toMillis());

        System.out.println(shippedOrders.size());
        return new ModelAndView();
    }
}
