package com.mercury.springbootlearning.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;

/**
 * 通过  @EnableWebSocketMessageBroker启用STOMP协议
 * 使得controller可以使用注解@MessageMapping
 */
@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig extends AbstractWebSocketMessageBrokerConfigurer {

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        // 配置指定映射结点
        registry.addEndpoint("/endpointMercury").withSockJS();
        registry.addEndpoint("/endpointChat").withSockJS();
    }

    // 配置消息代理 广播式配置/topic消息代理
    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        registry.enableSimpleBroker("/queue", "/topic");
    }
}
