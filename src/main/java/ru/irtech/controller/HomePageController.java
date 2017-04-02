package ru.irtech.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
    public String index() {
        return "index";

    }
}
