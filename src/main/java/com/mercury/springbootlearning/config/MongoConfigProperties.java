//package com.mercury.springbootlearning.config;
//
//import org.springframework.boot.autoconfigure.mongo.MongoProperties;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Primary;
//
//@Configuration
//public class MongoConfigProperties {
//
//    @Primary
//    @Bean(name = "mongoConfigProperties")
//    @ConfigurationProperties(prefix = "spring.data.mongodb")
//    public MongoProperties mongoProperties() {
//        return new MongoProperties();
//    }
//}
