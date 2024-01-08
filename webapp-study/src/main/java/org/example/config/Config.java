package org.example.config;

import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author : Str2ke
 * @date : 2023/12/7 上午12:44
 * @Desc :
 */

@Configuration
@ComponentScan(value = "org.example")
@ConfigurationPropertiesScan(value = "org.example")
public class Config {
}
