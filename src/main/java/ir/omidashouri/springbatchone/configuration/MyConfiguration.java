package ir.omidashouri.springbatchone.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

@Configuration
public class MyConfiguration {

    @Value("classpath:data/shipped_orders.csv")
    Resource resource;
}
