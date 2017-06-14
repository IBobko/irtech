package ru.irtech.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.irtech.analysis.Correlation.ICorrelationProcessor;
import ru.irtech.analysis.Correlation.PearsonsCorrelationProcessor;
import ru.irtech.dao.AnalysisDataAcess.DataBaseList;
import ru.irtech.dao.AnalysisDataAcess.Importers.IArrayImporter;
import ru.irtech.dao.AnalysisDataAcess.Importers.ICsvImporter;
import ru.irtech.dao.AnalysisDataAcess.Importers.StudentsMeanGradeAttendanceImporter;
import ru.irtech.dao.AnalysisDataAcess.Model.Grade;
import ru.irtech.dao.AnalysisDataAcess.Model.StudentMeanGradeAttendance;
import ru.irtech.dto.Attendance.GradesAttendanceCorrelationResponse;
import ru.irtech.dto.Attendance.GradesAttendanceTableResponse;
import ru.irtech.dto.ControllerResponse;
import ru.irtech.dto.FamilyStatus.FamilyStatusToGradesRelationResponse;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Dictionary;
import java.util.List;

/**
 * Created by Iggytoto on 14.06.2017.
 * <p>
 * Controller class that represents statistical information for the skips of the classes by students.
 */
@Controller
@RequestMapping("/skips")
public class SkipsController {

    /**
     * Response method that returns correlation value between count of skips and mean grade for all of the students.
     *
     * @return
     */
    @RequestMapping(value = "/gradesAttendanceCorrelation", method = RequestMethod.GET)
    @ResponseBody
    public ControllerResponse getGradesAttendanceCorrelation() throws IOException {
        Date date = new Date();
        File file = File.createTempFile("ftg", Long.toString(date.getTime()));

        try {
            ICsvImporter importer = new StudentsMeanGradeAttendanceImporter();
            importer.importData(file, DataBaseList.getDataBases().get(0));

            if (file.getTotalSpace() == 0) {
                return new ControllerResponse("No data");
            }

            ICorrelationProcessor processor = new PearsonsCorrelationProcessor();
            Dictionary<Integer, Double> result = processor.parseCorrelation(file.getAbsolutePath(), 1,
                    new Integer[]{2});

            return new GradesAttendanceCorrelationResponse(result.get(0));
        } catch (Exception e) {
            return new ControllerResponse(e.getMessage());
        } finally {
            if (file.exists()) {
                file.delete();
            }
        }
    }

    /**
     * Returns table that represents percentages of skips per students group.
     *
     * @return table response.
     */
    @RequestMapping(value = "/gradesAttendanceTable", method = RequestMethod.GET)
    @ResponseBody
    public ControllerResponse getGradesAttendanceTable() {
        try {
            IArrayImporter<StudentMeanGradeAttendance> importer = new StudentsMeanGradeAttendanceImporter();

            List<StudentMeanGradeAttendance> data = importer.importAllData(DataBaseList.getDataBases().get(0));

            return new GradesAttendanceTableResponse(countParams(data));
        } catch (Exception e) {
            return new ControllerResponse(e.getMessage());
        }
    }

    /**
     * Helper statistic method.
     *
     * @param grades set of grades and skips.
     * @return percentages.
     */
    private double[] countParams(final List<StudentMeanGradeAttendance> grades) {
        if (grades.size() == 0) {
            return new double[FamilyStatusToGradesRelationResponse.getSetsLength()];
        }

        double[] results = new double[FamilyStatusToGradesRelationResponse.getSetsLength()];

        int best = 0;
        int good = 0;
        int average = 0;
        int total = 0;

        for (StudentMeanGradeAttendance grade : grades) {
            if (grade.getMeanGrade() >= Grade.BEST_BORDER_GRADE) {
                best += grade.getSkipsCount();
            } else if (grade.getMeanGrade() >= Grade.GOOD_BORDER_GRADE) {
                good += grade.getSkipsCount();
            } else {
                average += grade.getSkipsCount();
            }
            total += grade.getSkipsCount();
        }

        results[0] = best / total;
        results[1] = good / total;
        results[2] = average / total;

        return results;
    }
}
