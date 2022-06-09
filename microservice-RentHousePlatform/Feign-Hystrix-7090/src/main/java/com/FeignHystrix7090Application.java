package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@EnableHystrix
//@EnableCircuitBreaker
@EnableFeignClients
public class FeignHystrix7090Application {

    public static void main(String[] args) {
        SpringApplication.run(FeignHystrix7090Application.class, args);
    }

}
