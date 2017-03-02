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
    @RequestMapping("")
    @ResponseBody
    public String index() {
        return "Hello world";
    }
}
