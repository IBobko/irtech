package ru.irtech.schedule;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

/**
 * @author Igor Bobko <limit-speed@yandex.ru>.
 */
@Component
public class AdviseMessage {

    /**
     * index of advertisement that will be shown.
     */
    private int index = 0;

    /**
     * Temporary array of advertisement advices.
     * 1-informational
     * 2-educational
     * 3-advertisement
     * 4-interesting fact
     */
    private ArrayList<String> advertisements = new ArrayList<String>() {
        {
            add("{\"id\":1010,\"type\":1,\"content\":\"<div>Сегодня в вашем городе холодно. Не забудь надеть шапку!</div>\",\"link\":\"\"}");
            add("{\"id\":1009,\"type\":2,\"content\":\"<div>Сегодня 2 августа, до начала нового учебноого года осталось ровно 29 дней. Посмотри расписание летних мероприятий. </div>\",\"link\":\"http://innsgo.ru/\"}");
            add("{\"id\":1001,\"type\":3,\"content\":\"<div>Получите востребованную интернет профессию!</div>\",\"link\":\"https://ad.admitad.com/g/05442bf5b3095ebd86e53a47696a87/?ulp=http%3A%2F%2Fnetology.ru%2F\"}");
            add("{\"id\":1006,\"type\":4,\"content\":\"<div>А вы знали что песня Стюардесса по имени Жанна была написана в 1992 году? Вот ведь дела...</div>\",\"link\":\"\"}");
            add("{\"id\":1011,\"type\":1,\"content\":\"<div>Cегодня 1 июня - день защиты детей!</div>\",\"link\":\"\"}");
            add("{\"id\":1012,\"type\":2,\"content\":\"<div>Через 3 дня сам.работа по химии. Стоит начать готовиться! В этом может помочь репетитор</div>\",\"link\":\"http://repetitors.info/repetitor/chemistry/\"}");
            add("{\"id\":1002,\"type\":3,\"content\":\"<div>Ваш репетитор уже ждет вас!</div>\",\"link\":\"https://ad.admitad.com/g/ap2mflhpx9095ebd86e552dab193aa/?ulp=http%3A%2F%2Frepetitors.info%2F\"}");
            add("{\"id\":1007,\"type\":4,\"content\":\"<div>А ты знал, что в среднем дети смеются около 400 раз в день,а взрослые около 15 раз?</div>\",\"link\":\"\"}");
            add("{\"id\":1011,\"type\":1,\"content\":\"<div>Сегодня 23 февраля, день защитника отечества!</div>\",\"link\":\"\"}");
            add("{\"id\":1008,\"type\":2,\"content\":\"<div>Вам выставили оценки по математике. Давай проверим что у тебя?</div>\",\"link\":\"/grades\"}");
            add("{\"id\":1003,\"type\":3,\"content\":\"<div>Начните понимать анлийский на слух!</div>\",\"link\":\"https://ad.admitad.com/g/0abba212ff095ebd86e51ac5a4392d/?ulp=https%3A%2F%2Fpuzzle-english.com%2F\"}");
            add("{\"id\":1007,\"type\":4,\"content\":\"<div>А ты знал, что в среднем дети смеются около 400 раз в день,а взрослые около 15 раз?</div>\",\"link\":\"\"}");
            add("{\"id\":1011,\"type\":1,\"content\":\"<div>Вы посещаете Сетевой Город реже чем большинство пользователей. Заходите в систему чаще!</div>\",\"link\":\"\"}");
            add("{\"id\":1013,\"type\":2,\"content\":\"<div>Ты 2-й раз прогулял Физру. Есть шанс получить 3 за четверть. Времени до конца четверти осталось мало! Если не исправишь - выйдет 3ка</div>\",\"link\":\"/plan\"}");
            add("{\"id\":1004,\"type\":3,\"content\":\"<div>Учи и учись</div></a>\",\"link\":\"https://ad.admitad.com/g/ejv76qyygv095ebd86e5731073a875/?ulp=https%3A%2F%2Fupstudy.ru%2F\"}");
            add("{\"id\":1007,\"type\":4,\"content\":\"<div>А ты знал, что ножницы изобрел Ленонардо Да Винчи?</div>\",\"link\":\"\"}");
            add("{\"id\":1011,\"type\":1,\"content\":\"<div>Cегодня день учителя! Не забудь поздравить своего преподавателя.</div>\",\"link\":\"\"}");
            add("{\"id\":1014,\"type\":2,\"content\":\"<div>Ваш класс вышел на 2 позицию по успеваемости в школе за прошлую неделю на +0.2 ср.балла . Молодцы! Однако, опустился на 7 место по биологии</div>\",\"link\":\"/grades\"}");
            add("{\"id\":1005,\"type\":3,\"content\":\"<div>Карта для умного шопинга!</div></a>\",\"link\":\"https://ad.admitad.com/g/6fz1m1rqml095ebd86e5806ff16a4a/\"}");
            add("{\"id\":1007,\"type\":4,\"content\":\"<div>А ты знал, что память у золотой рыбки - 3 секунды?</div>\",\"link\":\"\"}");
        }
    };

    /**
     *
     */
    private static final long TIME_FOR_SENDING = 20000;
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
    private void getPartnerAdvertisement() {
        if (index >= advertisements.size()) {
            index = 0;
        }
        getTemplate().convertAndSend("/partnerAdvertisement", advertisements.get(index));
        index++;
    }

}
