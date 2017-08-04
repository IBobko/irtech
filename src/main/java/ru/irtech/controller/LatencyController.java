package ru.irtech.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/latency")
@Controller
public class LatencyController {
    /**
     * Main page of latency
     *
     * @return Text which provided users.
     */
    @RequestMapping("")
    public String index() {
        return "latency/index";

    }

    @RequestMapping("/raw_data.csv")
    @ResponseBody
    public String row_data() {
        String ss = "Question,1,2,3,4,5,N\n" +
                "Question 1,0,0,0,0,2,2\n" +
                "Question 2,0,0,0,0,2,2\n" +
                "Question 3,0,0,0,0,2,2\n" +
                "Question 4,0,0,0,0,2,2\n" +
                "Question 5,0,0,0,0,2,2\n" +
                "Question 6,0,0,0,0,2,2\n" +
                "Question 7,0,0,0,0,2,2\n" +
                "Question 8,0,0,0,0,2,2";
        return ss;
    }
}
