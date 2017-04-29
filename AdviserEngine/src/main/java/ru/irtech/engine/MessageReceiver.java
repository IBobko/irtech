package ru.irtech.engine;

import javax.jms.JMSException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.stereotype.Component;


/**
 * kjjhkjh.
 */
@Component
public class MessageReceiver {
    /**
     * Logger.
     */
    private static final Logger LOG = LoggerFactory.getLogger(MessageReceiver.class);

    /**
     * kjhkjh.
     */
    private static final String ORDER_RESPONSE_QUEUE = "order-response-queue";

    /**
     * sss.
     * @param message ss.
     * @throws JMSException ss.
     */

    @JmsListener(destination = ORDER_RESPONSE_QUEUE)
    public void receiveMessage(final Message<Object> message) throws JMSException {
        LOG.info("+++++++++++++++++++++++++++++++++++++++++++++++++++++");
        MessageHeaders headers =  message.getHeaders();
        LOG.info("Application : headers received : {}", headers);


    }
}
