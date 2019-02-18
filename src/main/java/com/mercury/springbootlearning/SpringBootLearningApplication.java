package com.mercury.springbootlearning;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

// @EnableJpaRepositories // 启用该注解添加自定义jpa实现类 默认无需添加@SpringBootApplication已配置
// @EnableCaching 启用缓存配置
@EnableCaching
@SpringBootApplication
public class SpringBootLearningApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootLearningApplication.class, args);
    }

}

