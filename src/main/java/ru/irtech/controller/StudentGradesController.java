package ru.irtech.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.irtech.dto.ControllerResponse;
import ru.irtech.dto.exactHumanitarianResponseDtos.ExactHumanitarianGradesResponse;
import ru.irtech.dto.exactHumanitarianResponseDtos.GradeDto;

import java.util.Date;

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
     * @param id       id of the student.
     * @param fromDate search from date.
     * @param toDate   search to date.
     * @return returns default response
     */
    @RequestMapping(value = "/exactAndHumanitarianGradesData", method = RequestMethod.GET)
    @ResponseBody
    public ControllerResponse getStudentsExactHumanitarianGradesData(
            @RequestParam("id") final int id,
            @RequestParam("fromDate") final String fromDate,
            @RequestParam("toDate") final String toDate) {

        //TODO toDate and fromDate should be converted to Date objects

        GradeDto[] exact = new GradeDto[]{new GradeDto(new Date(), 5), new GradeDto(new Date(), 4)};
        GradeDto[] humanitarian = new GradeDto[]{new GradeDto(new Date(), 3), new GradeDto(new Date(), 3)};
        return new ExactHumanitarianGradesResponse(exact, humanitarian);
    }
}
