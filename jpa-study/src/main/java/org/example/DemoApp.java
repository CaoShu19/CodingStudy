package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Component;

/**
 * @author : Str2ke
 * @date : 2024/1/7 下午8:21
 * @Desc :
 */

@Component("{org.example.*}")
@SpringBootApplication
@EnableJpaRepositories
public class DemoApp {
    public static void main(String[] args) {
        SpringApplication.run(DemoApp.class, args);
    }
}
