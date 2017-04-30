package ru.irtech.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.irtech.dao.AnalysisDataAcess.Importers.StudentsPeriodGradesImporter;
import ru.irtech.dao.AnalysisDataAcess.Importers.exactAndHumanitarianGrades.ExactHumanitarianGrade;
import ru.irtech.dto.ControllerResponse;
import ru.irtech.dto.exactHumanitarianResponseDtos.ExactHumanitarianGradesResponse;
import ru.irtech.dto.exactHumanitarianResponseDtos.GradeDto;

import java.util.ArrayList;
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

        //TODO toDate and fromDate should be converted to Date objects somehow
        Date from = new Date(fromDate);
        Date to = new Date(toDate);

        StudentsPeriodGradesImporter importer = new StudentsPeriodGradesImporter();
        ExactHumanitarianGrade[] grades = importer.getGrades(id, from, to);

        ArrayList<GradeDto> exact = new ArrayList<GradeDto>();
        ArrayList<GradeDto> humanitarian = new ArrayList<GradeDto>();

        for (ExactHumanitarianGrade grade : grades) {
            GradeDto gradeDto = new GradeDto(grade.getDate(), grade.getGrade());
            switch (grade.getType()) {
                case Exact:
                    exact.add(gradeDto);
                    break;
                case Humanitarian:
                    humanitarian.add(gradeDto);
                    break;
                default:
                    continue;
            }
        }

        return new ExactHumanitarianGradesResponse((GradeDto[]) exact.toArray(), (GradeDto[]) humanitarian.toArray());
    }
}
