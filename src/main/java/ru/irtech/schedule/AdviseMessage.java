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
     * Temporary array of advertisement advices
     * todo move to DBO
     */
    private ArrayList<String> advertisements = new ArrayList<String>() {
        {
            add("{\"id\":1001,\"content\":\"<a href=&#34https://ad.admitad.com/g/05442bf5b3095ebd86e53a47696a87/?ulp=http%3A%2F%2Fnetology.ru%2F&#34 target=&#34_blank&#34><img src=&#34./resources/advertisements/netologia.png&#34 class=&#34advertisementImage&#34/></a><div>Получите востребованную интернет профессию!</div>\"}");
            add("{\"id\":1002,\"content\":\"<a href=&#34https://ad.admitad.com/g/ap2mflhpx9095ebd86e552dab193aa/?ulp=http%3A%2F%2Frepetitors.info%2F&#34 target=&#34_blank&#34><img src=&#34./resources/advertisements/vash-repititor.jpg&#34 class=&#34advertisementImage&#34/></a><div>Ваш репетитор уже ждет вас!</div>\"}");
            add("{\"id\":1003,\"content\":\"<a href=&#34https://ad.admitad.com/g/0abba212ff095ebd86e51ac5a4392d/?ulp=https%3A%2F%2Fpuzzle-english.com%2F&#34 target=&#34_blank&#34><img src=&#34./resources/advertisements/puzzle-english.png&#34 class=&#34advertisementImage&#34/></a><div>Начните понимать анлийский на слух!</div>\"}");
            add("{\"id\":1004,\"content\":\"<a href=&#34https://ad.admitad.com/g/ejv76qyygv095ebd86e5731073a875/?ulp=https%3A%2F%2Fupstudy.ru%2F&#34 target=&#34_blank&#34><img src=&#34./resources/advertisements/upstudy.jpg&#34 class=&#34advertisementImage&#34/></a><div>Учи и учись</div>\"}");
            add("{\"id\":1005,\"content\":\"<a href=&#34https://ad.admitad.com/g/6fz1m1rqml095ebd86e5806ff16a4a/&#34 target=&#34_blank&#34><img src=&#34./resources/advertisements/tcs.jpg&#34 class=&#34advertisementImage&#34/></a><div>Карта для умного шопинга!</div>\"}");
        }
    };

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
    private void getPartnerAdvertisement() {
        int index = new Random().nextInt(advertisements.size());
        getTemplate().convertAndSend("/partnerAdvertisement", advertisements.get(index));
    }

}
