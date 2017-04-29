package ru.irtech.engine.config;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.core.JmsTemplate;

/**
 * @author Igor Bobko <limit-speed@yandex.ru>.
 */
@Configuration
public class MessagingConfiguration {

    /**
     * Broker URL.
     */
    private static final String DEFAULT_BROKER_URL = "tcp://localhost:61616";

    /**
     * order-queue.
     */
    private static final String ORDER_QUEUE = "order-queue";

    /**
     * Connection Factory.
     *
     * @return Connection factory.
     */
    @Bean
    public ActiveMQConnectionFactory connectionFactory() {
        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory();
        connectionFactory.setBrokerURL(DEFAULT_BROKER_URL);
        return connectionFactory;
    }

    /**
     * JmsTemplate.
     *
     * @return JmsTemplate
     */
    @Bean
    public JmsTemplate jmsTemplate() {
        JmsTemplate template = new JmsTemplate();
        template.setConnectionFactory(connectionFactory());
        template.setDefaultDestinationName(ORDER_QUEUE);
        return template;
    }


}
