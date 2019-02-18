//package com.mercury.springbootlearning.config;
//
//import com.mongodb.MongoClient;
//import com.mongodb.ServerAddress;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.boot.autoconfigure.mongo.MongoProperties;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Primary;
//import org.springframework.data.mongodb.core.MongoTemplate;
//import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
//import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
//
//@Configuration
//@EnableMongoRepositories(basePackages = "com.mercury.springbootlearning.repository")
//public class MongoConfig {
//
//    @Autowired
//    @Qualifier("mongoConfigProperties")
//    private MongoProperties mongoProperties;
//
//    @Bean
//    public MongoTemplate mongoTemplate() {
//        return new MongoTemplate(mongoDbFactory(this.mongoProperties));
//    }
//
//    @Primary
//    @Bean
//    public SimpleMongoDbFactory mongoDbFactory(MongoProperties mongoProperties) {
//        ServerAddress serverAddress = new ServerAddress(mongoProperties.getHost(), mongoProperties.getPort());
//        return new SimpleMongoDbFactory(new MongoClient(serverAddress), mongoProperties.getHost());
//    }
//}
