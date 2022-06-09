package com;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.dao")
public class MicroserviceHystrixProduct7050Application {

    public static void main(String[] args) {
        SpringApplication.run(MicroserviceHystrixProduct7050Application.class, args);
    }

}
