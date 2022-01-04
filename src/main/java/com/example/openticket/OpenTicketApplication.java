package com.example.openticket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class OpenTicketApplication {

    public static void main(String[] args) {
        SpringApplication.run(OpenTicketApplication.class, args);
    }

}
