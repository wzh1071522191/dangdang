package com.jk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class AyrClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(AyrClientApplication.class, args);
    }

}
