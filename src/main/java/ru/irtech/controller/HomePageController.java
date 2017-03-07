package ru.irtech.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Igor Bobko <limit-speed@yandex.ru>.
 */
@RequestMapping("/")
@Controller
public class HomePageController {
    /**
     * Main page of our site.
     *
     * @return Text which provided users.
     */
    @RequestMapping("")
    @ResponseBody
    public String index() {
        return "IrTech main page. Development Version Server.";
    }
}
