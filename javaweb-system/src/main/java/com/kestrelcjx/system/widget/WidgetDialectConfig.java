package com.kestrelcjx.system.widget;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Thymeleaf方言注入
 */
@Configuration
public class WidgetDialectConfig {
    /**
     * 自定义方言注入
     *
     * @return
     */
    @Bean
    public WidgetDialect sysDialect() {
        return new WidgetDialect();
    }
}
