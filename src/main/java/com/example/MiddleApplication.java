package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class MiddleApplication {
    public static void main(String[] args) {
        SpringApplication.run(MiddleApplication.class, args);
    }
    @GetMapping(path="/test")
    public String getData(){
        return "Hello World!";
    }

}
