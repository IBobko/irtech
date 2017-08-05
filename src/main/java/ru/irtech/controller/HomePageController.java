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

    /**
     * Grades page.
     *
     * @return sgo screen page with grades.
     */
    @RequestMapping("grades")
    public String sgoGrades() {
        return "sgo_pages/sgo_grades";
    }

    /**
     * Schedule page.
     *
     * @return sgo screen page with schedule.
     */
    @RequestMapping("schedule")
    public String sgoSchedule() {
        return "sgo_pages/sgo_schedule";
    }

    /**
     * Plan page.
     *
     * @return sgo screen page with schedule.
     */
    @RequestMapping("plan")
    public String sgoPlan() {
        return "sgo_pages/sgo_plan";
    }

}
