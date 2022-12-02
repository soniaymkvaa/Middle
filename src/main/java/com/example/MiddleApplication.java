package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@RequestMapping(path = "api/v1/hello")
public class MiddleApplication {
    public static void main(String[] args) {
        SpringApplication.run(MiddleApplication.class, args);
    }
    @GetMapping
    public String sayHello() {
        return "hello";
    }
}
