package com;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.dao")
public class MicroserviceHystrixMessageAndRevert7070Application {

    public static void main(String[] args) {
        SpringApplication.run(MicroserviceHystrixMessageAndRevert7070Application.class, args);
    }

}
