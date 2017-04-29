package ru.irtech.engine.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;

import javax.jms.ConnectionFactory;

/**
 * MessagingListenerConfiguration.
 */
@Configuration
@EnableJms
public class MessagingListenerConfiguration {

    /**
     * ConnectionFactory.
     */
    private ConnectionFactory connectionFactory;

    public ConnectionFactory getConnectionFactory() {
        return connectionFactory;
    }

    @Autowired
    public void setConnectionFactory(final ConnectionFactory connectionFactory) {
        this.connectionFactory = connectionFactory;
    }

    /**
     * DefaultJmsListenerContainerFactory.
     *
     * @return DefaultJmsListenerContainerFactory
     */
    @Bean
    public DefaultJmsListenerContainerFactory jmsListenerContainerFactory() {
        DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
        factory.setConnectionFactory(connectionFactory);
        return factory;
    }

}
