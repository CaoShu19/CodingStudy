package org.example.config;

import org.example.model.TOrder;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author : Str2ke
 * @date : 2023/12/7 上午12:44
 * @Desc :
 */

@Configuration//标记次此类为配置类
//@ComponentScan(value = "org.example")
//@ConfigurationPropertiesScan(value = "org.example")
public class Config {

    @Bean(name = "myBean") //将此对象注入ioc容器
    public TOrder getTOrder() {
        TOrder tOrder = new TOrder();
        tOrder.setName("byConfig");
        return tOrder;
    }

    @Bean
    @ConditionalOnMissingBean(DataMaskingProperties.class)
    public DataMaskingProperties dataMaskingProperties() {
        return new DataMaskingProperties();
    }

}
