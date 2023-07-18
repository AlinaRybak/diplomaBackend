package com.example.diploma;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class DiplomaApplication {
    public static void main(String[] args) {
        SpringApplication.run(DiplomaApplication.class, args);
    }

    @GetMapping("user")
    public String getUser(){
        return "Hello";
    }
}
