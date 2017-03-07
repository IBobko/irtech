package ru.irtech.schedule;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author Igor Bobko <limit-speed@yandex.ru>.
 */
@Component
public class AdviseMessage {

    /**
     *
     */
    private static final long TIME_FOR_SENDING = 5000;
    /**
     * For WeSocket usage.
     */
    private SimpMessagingTemplate template;

    /**
     * Getter for WebSocket usage.
     *
     * @return template for WeSocket usage
     */
    private SimpMessagingTemplate getTemplate() {
        return template;
    }

    /**
     * Setter for SimpMessagingTemplate.
     *
     * @param template instance of SimpMessagingTemplate
     */
    @Autowired
    private void setTemplate(final SimpMessagingTemplate template) {
        this.template = template;
    }

    /**
     * Function sends advise to the subscribers.
     */
    @Scheduled(fixedRate = AdviseMessage.TIME_FOR_SENDING)
    private void reportCurrentTime() {
        getTemplate().convertAndSend("/", "    А вы знали что завтра будет"
                + "очень холодно? Не забудте одеть шапку. Если у вас нет шапки"
                + " то рекомендую купить её. \n"
                + "<a target=\"_blank\""
                + "href=\"http://pilnikov.ru/zhenskie-shapki.html\">"
                + "Купить шапку без регистрации и смс!</a>");
    }

}
