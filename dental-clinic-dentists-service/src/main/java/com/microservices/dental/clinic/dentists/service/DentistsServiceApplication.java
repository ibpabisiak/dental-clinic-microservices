package com.microservices.dental.clinic.dentists.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class DentistsServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(DentistsServiceApplication.class, args);
    }
}