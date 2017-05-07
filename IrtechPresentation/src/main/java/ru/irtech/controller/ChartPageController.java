package ru.irtech.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Igor Bobko <limit-speed@yandex.ru>.
 */
@Controller
@RequestMapping("/chart")
public class ChartPageController {
    /**
     * Returns template of test chart.
     *
     * @return Tenplate of test chart.
     */
    @RequestMapping("")
    public String index() {
        return "chart/index";
    }

}
