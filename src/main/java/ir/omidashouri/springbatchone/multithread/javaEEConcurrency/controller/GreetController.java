package ir.omidashouri.springbatchone.multithread.javaEEConcurrency.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/greetUser")
@AllArgsConstructor
public class GreetController {



//    http://localhost:8080/greetUser/
    @GetMapping
    public String getUser(){
        return "welcome to Java EE1";
    }
}
