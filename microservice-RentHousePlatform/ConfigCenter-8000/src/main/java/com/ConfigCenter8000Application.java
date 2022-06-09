package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer

public class ConfigCenter8000Application {

    public static void main(String[] args) {
        SpringApplication.run(ConfigCenter8000Application.class, args);
    }

}
