package ru.irtech.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.irtech.schedule.AdviseMessage;

/**
 * Created by liana on 6/28/17.
 */

@Controller
public class AdviceController {


    public int countShownAdvice=0;

    public SimpMessagingTemplate getTemplate() {
        return template;
    }
    @Autowired
    public void setTemplate(SimpMessagingTemplate template) {
        this.template = template;
    }

    private SimpMessagingTemplate template;

    @MessageMapping("/get-advice")
    public void advice(Integer index) {
        if(countShownAdvice != AdviseMessage.advertisements.size()){
            getTemplate().convertAndSend("/partnerAdvertisement", AdviseMessage.advertisements.get(countShownAdvice));
            countShownAdvice++;
        }
        else
            countShownAdvice = 0;
    }
}
