package org.example;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.retry.annotation.EnableRetry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;


@EnableRetry
@SpringBootApplication
@EnableConfigurationProperties //config need
@EnableWebMvc// swagger need
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}