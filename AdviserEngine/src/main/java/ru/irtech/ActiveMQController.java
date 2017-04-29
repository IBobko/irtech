package ru.irtech;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.jms.Session;

/**
 * @author Igor Bobko <limit-speed@yandex.ru>.
 */
@Controller
public class ActiveMQController {

    private JmsTemplate jmsTemplate;

    private JmsTemplate getJmsTemplate() {
        return jmsTemplate;
    }

    @Autowired
    public void setJmsTemplate(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    @ResponseBody
    @RequestMapping
    public String index() {

        getJmsTemplate().send("order-response-queue", Session::createMessage);
        return "hello";
    }

}
