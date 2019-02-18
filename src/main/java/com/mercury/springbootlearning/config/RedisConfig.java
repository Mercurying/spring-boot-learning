package com.mercury.springbootlearning.config;

import org.springframework.cache.CacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;


/**
 * 配置redis 缓存redisCacheManager
 */

@Configuration
public class RedisConfig {

    @Bean
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(redisConnectionFactory);
        redisTemplate.setKeySerializer(keySerializer());
        redisTemplate.setValueSerializer(valueSerializer());
        redisTemplate.setHashKeySerializer(valueSerializer());
        redisTemplate.setHashValueSerializer(valueSerializer());
        return redisTemplate;
    }

    /**
     * @param redisTemplate
     * @return 标注@primary 将会首先注入Bean
     * 注意spring boot 1.X 配置与spring boot 2.x 配置不相同
     */
    @Primary
    @Bean
    public CacheManager cacheManger(RedisTemplate redisTemplate) {
        RedisCacheManager cacheManager = new RedisCacheManager(redisTemplate);
        // 设置默认失效时间 s
        cacheManager.setDefaultExpiration(300);
        // Map<String, Long> expiresMap = new HashMap<>();
        // expiresMap.put("person", 5L);
        // cacheManager.setExpires(expiresMap);
        return cacheManager;
    }


    // 自定义key序列化器
    private RedisSerializer<String> keySerializer() {
        return new StringRedisSerializer();
    }

    // 自定义value序列化器
    private RedisSerializer<Object> valueSerializer() {
        return new GenericJackson2JsonRedisSerializer();
    }
}
