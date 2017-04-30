package ru.irtech.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.irtech.dto.ControllerResponse;

/**
 * Created by Iggytoto on 30.04.2017.
 * Controller class that operates students grades data.
 */
@Controller
@RequestMapping("/studentGrades")
public class StudentGradesController {
    /**
     * Method that returns values for exact and humanitarian grades for the given period.
     *
     * @return
     */
    @RequestMapping(value = "/exactAndHumanitarianGradesData", method = RequestMethod.GET)
    @ResponseBody
    public ControllerResponse getStudentsExactHumanitarianGradesData(
            @RequestParam("id") final int id,
            @RequestParam("fromDate") final String fromDate,
            @RequestParam("toDate") final String toDate) {
        return new ControllerResponse("NOT DEVELOPED YET");
    }
}
