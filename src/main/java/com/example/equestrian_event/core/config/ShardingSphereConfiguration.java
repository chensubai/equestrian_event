package com.example.equestrian_event.core.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;

/**
 * ShardingSphere 配置类，控制是否开启 ShardingSphere
 */
@Configuration
@EnableAutoConfiguration(exclude = {
    org.apache.shardingsphere.spring.boot.ShardingSphereAutoConfiguration.class
})
@ConditionalOnProperty(
    prefix = "spring.shardingsphere",
    name = {"enabled"},
    havingValue = "false"
)
public class ShardingSphereConfiguration {

}
