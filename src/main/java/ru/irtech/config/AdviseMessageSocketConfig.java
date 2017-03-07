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
    /**
     * Register STOMP endpoints mapping each to a specific URL and (optionally)
     * enabling and configuring SockJS fallback options.
     *
     * @param registry A registry for configuring message broker options.
     */
    @Override
    public void registerStompEndpoints(final StompEndpointRegistry registry) {
        registry.addEndpoint("/advises").setAllowedOrigins("*").withSockJS();
    }

}

