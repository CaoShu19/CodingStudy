package org.example.config;

import org.example.controller.UserController;
import org.example.service.UserService;
import org.example.service.impl.UserServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * @author : Str2ke
 * @date : 2024/1/19 上午12:02
 * @Desc :
 */
@Configuration
@ComponentScan("org.example.*")
public class Config {

//    @Bean
//    public UserService getUserService() {
//        return new UserServiceImpl();
//    }

//    @Bean
//    public UserController getUserController(UserService userService) {
//        return new UserController(userService);
//    }
}
