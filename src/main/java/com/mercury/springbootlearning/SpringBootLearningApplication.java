package com.mercury.springbootlearning;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

// @EnableJpaRepositories // 启用该注解添加自定义jpa实现类 默认无需添加@SpringBootApplication已配置
// @EnableCaching 启用缓存配置
@EnableCaching
@EnableMongoRepositories(basePackages = "com.mercury.springbootlearning.repository")
@SpringBootApplication
public class SpringBootLearningApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootLearningApplication.class, args);
    }

}

