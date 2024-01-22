package org.example.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

/**
 * @author : Str2ke
 * @date : 2024/1/21 上午1:25
 * @Desc :
 */

@Data
@Configuration
@ConfigurationProperties(prefix = "data.masking")
public class DataMaskingProperties {

    private Map<String, String> keyMap;

    public String getValue(String key) {
        return keyMap.get(key);
    }
}
