package com.mercury.springbootlearning.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * 注解@Configuration与注解@EnableWebMvc将会完全实现自己的mvc配置
 * 添加自定义路径 路径映射到指定view上
 * 这个写法不会覆盖WebAutoConfiguration中的addViewController方法
 */

@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/page").setViewName("/page");
        registry.addViewController("/ws").setViewName("/ws");
        registry.addViewController("/login").setViewName("/login");
        registry.addViewController("/chat").setViewName("/chat");
    }
}
