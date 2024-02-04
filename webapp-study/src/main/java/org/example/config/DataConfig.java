package org.example.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author : Str2ke
 * @date : 2024/2/5 上午1:33
 * @Desc :
 */
@Configuration
public class DataConfig {
    @Bean
    public ObjectMapper objectMapper() {
        return new ObjectMapper();
    }

}
