package com.bezkoder.spring.webflux;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;

@SpringBootApplication
public class WebfuxDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebfuxDemoApplication.class, args);
    }
}