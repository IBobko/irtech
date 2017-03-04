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
    private SimpMessagingTemplate template;

    private SimpMessagingTemplate getTemplate() {
        return template;
    }

    @Autowired
    private void setTemplate(SimpMessagingTemplate template) {
        this.template = template;
    }

    @Scheduled(fixedRate = 5000)
    public void reportCurrentTime() {
        getTemplate().convertAndSend("/", "    А вы знали что завтра будет очень холодно? Не забудте одеть шапку. Если у вас нет шапки то рекомендую купить её. \\\n" +
                "<a target=\"_blank\" href=\"http://pilnikov.ru/zhenskie-shapki.html\">Купить шапку без регистрации и смс!</a> Это сообщение с сервера");
    }
}
