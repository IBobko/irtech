package ru.irtech.schedule;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Random;

/**
 * @author Igor Bobko <limit-speed@yandex.ru>.
 */
@Component
public class AdviseMessage {
    /**
     * Temporary array of advertisement advices.
     * todo move to DBO
     * todo add advice type to dbo
     * 1-informational
     * 2-educational
     * 3-advertisement
     * 4-interesting fact
     */
    private ArrayList<String> advertisements = new ArrayList<String>() {
        {
            add("{\"id\":1001,\"type\":3,\"content\":\"<a href=&#34https://ad.admitad.com/g/05442bf5b3095ebd86e53a47696a87/?ulp=http%3A%2F%2Fnetology.ru%2F&#34 target=&#34_blank&#34><img src=&#34http://insgo.ru/resources/advertisements/netologia.png&#34 class=&#34advertisementImage&#34/><div>Получите востребованную интернет профессию!</div></a>\"}");
            add("{\"id\":1002,\"type\":3,\"content\":\"<a href=&#34https://ad.admitad.com/g/ap2mflhpx9095ebd86e552dab193aa/?ulp=http%3A%2F%2Frepetitors.info%2F&#34 target=&#34_blank&#34><img src=&#34http://insgo.ru/resources/advertisements/vash-repititor.jpg&#34 class=&#34advertisementImage&#34/><div>Ваш репетитор уже ждет вас!</div></a>\"}");
            add("{\"id\":1003,\"type\":3,\"content\":\"<a href=&#34https://ad.admitad.com/g/0abba212ff095ebd86e51ac5a4392d/?ulp=https%3A%2F%2Fpuzzle-english.com%2F&#34 target=&#34_blank&#34><img src=&#34http://insgo.ru/resources/advertisements/puzzle-english.png&#34 class=&#34advertisementImage&#34/><div>Начните понимать анлийский на слух!</div></a>\"}");
            add("{\"id\":1004,\"type\":3,\"content\":\"<a href=&#34https://ad.admitad.com/g/ejv76qyygv095ebd86e5731073a875/?ulp=https%3A%2F%2Fupstudy.ru%2F&#34 target=&#34_blank&#34><img src=&#34http://insgo.ru/resources/advertisements/upstudy.jpg&#34 class=&#34advertisementImage&#34/><div>Учи и учись</div></a>\"}");
            add("{\"id\":1005,\"type\":3,\"content\":\"<a href=&#34https://ad.admitad.com/g/6fz1m1rqml095ebd86e5806ff16a4a/&#34 target=&#34_blank&#34><img src=&#34https://insgo.ru/resources/advertisements/tcs.jpg&#34 class=&#34advertisementImage&#34/><div>Карта для умного шопинга!</div></a>\"}");
            add("{\"id\":1006,\"type\":4,\"content\":\"<div>А вы знали что песня Стюардесса по имени Жанна была написана в 1992 году? Вот ведь дела...</div>\"}");
            add("{\"id\":1006,\"type\":2,\"content\":\"<div>Вам выставили оценки по математике. Давай проверим что у тебя?</div>\"}");
            add("{\"id\":1006,\"type\":1,\"content\":\"<div>Сегодня в вашем городе холодно. Не забудь надеть шапку!</div>\"}");
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
        int index = new Random().nextInt(advertisements.size());
        getTemplate().convertAndSend("/partnerAdvertisement", advertisements.get(index));
    }

}
