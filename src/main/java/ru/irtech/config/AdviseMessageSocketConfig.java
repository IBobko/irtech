package ru.irtech.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;

/**
 * @author Igor Bobko <limit-speed@yandex.ru>.
 */
@Configuration
@EnableWebSocketMessageBroker
public class AdviseMessageSocketConfig extends AbstractWebSocketMessageBrokerConfigurer {
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/advises").setAllowedOrigins("*").withSockJS();
    }

}

