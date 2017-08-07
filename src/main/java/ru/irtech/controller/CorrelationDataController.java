package ru.irtech.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.irtech.analysis.Correlation.FakeCorrelationProcessor;
import ru.irtech.analysis.Correlation.ICorrelationProcessor;
import ru.irtech.dao.AnalysisDataAcess.DataBaseList;
import ru.irtech.dao.AnalysisDataAcess.Importers.FakeTestData.StudentsTermsYearlyFakeGenerator;
import ru.irtech.dao.AnalysisDataAcess.Importers.IArrayImporter;
import ru.irtech.dao.AnalysisDataAcess.Importers.ICsvImporter;
import ru.irtech.dao.AnalysisDataAcess.Importers.StudentsAttendanceGradesImporter;
import ru.irtech.dao.AnalysisDataAcess.Model.StudentAttendanceGrade;
import ru.irtech.dto.AttendanceToGradesResponse;
import ru.irtech.dto.ControllerResponse;
import ru.irtech.dto.FamilyStatus.FamilyStatusToGradesCorrelationResponse;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Dictionary;
import java.util.List;

/**
 * Created by Iggytoto on 29.04.2017.
 * Controller that returns Correlation results as JSON Objects.
 */
@Controller
@RequestMapping("/correlationData")
public class CorrelationDataController {

    /**
     * Family to grade calculations class index.
     */
    private static final int FAMILY_TO_GRADE_CLASS_INDEX = 3;
    //USE THIS FOR REAL DATA
    //ICsvImporter stygImporter = new StudentsTermsYearlyMarks());
    /**
     * ICsvImporter implementation.
     */
    private ICsvImporter stygImporter = new StudentsTermsYearlyFakeGenerator();

    /**
     * Method that returns family status to yearly and termly grades correlation analysis results.
     *
     * @return DTO that represents results.
     * @throws IOException throws IO exception in case of temporary file creation errors.
     */
    @RequestMapping(value = "/familyToGrades", method = RequestMethod.GET)
    @ResponseBody
    public ControllerResponse getFamiltyToGradesCorrelation() throws IOException {
        Date date = new Date();
        File file = File.createTempFile("ftg", Long.toString(date.getTime()));

        try {
            stygImporter.importData(file, DataBaseList.getDataBases().get(0));

            if (file.getTotalSpace() == 0) {
                return new ControllerResponse("No data");
            }

            //USE THIS FOR REAL DATA ICorrelationProcessor processor = new PearsonsCorrelationProcessor();
            ICorrelationProcessor processor = new FakeCorrelationProcessor();
            Dictionary<Integer, Double> result = processor.parseCorrelation(file.getAbsolutePath(), FAMILY_TO_GRADE_CLASS_INDEX,
                    new Integer[]{1, 2});
            return new FamilyStatusToGradesCorrelationResponse(result.get(1), result.get(2));
        } catch (Exception e) {
            return new ControllerResponse(e.getMessage());
        } finally {
            if (file.exists()) {
                file.delete();
            }
        }
    }

    /**
     * attendanceToGrades page.
     *
     * @return response.
     */
    @RequestMapping(value = "/attendanceToGrades", method = RequestMethod.GET)
    @ResponseBody
    public ControllerResponse getAttendanceToGradesCorrelation() {
        try {
            AttendanceToGradesResponse response = new AttendanceToGradesResponse();
            IArrayImporter<StudentAttendanceGrade> importer = new StudentsAttendanceGradesImporter();
            List<StudentAttendanceGrade> rows = importer.importAllData(DataBaseList.getDataBases().get(0));

            int avgsCount = 0;
            int goodsCount = 0;
            int bestsCount = 0;

            for (StudentAttendanceGrade sag : rows) {
                if (sag.getMeanGrade() < 500) {
                    avgsCount++;
                    continue;
                }
                if (sag.getMeanGrade() < 800) {
                    goodsCount++;
                    continue;
                }
                bestsCount++;
            }

            response.setMeanSkipsByBestGrades(rows.size() / bestsCount);
            response.setMeanSkipsByAverageGrades(rows.size() / avgsCount);
            response.setMeanSkipsByGoodGrades(rows.size() / goodsCount);

            response.setPercentSkipsByAverageGrades(avgsCount / (double) rows.size());
            response.setPercentSkipsByBestGrades(bestsCount / (double) rows.size());
            response.setPercentSkipsByGoodGrades(goodsCount / (double) rows.size());


            //TODO COUNT REAL CORRELATION FROM ARRAY
            //ICorrelationProcessor icp = new PearsonsCorrelationProcessor();
            ICorrelationProcessor icp = new FakeCorrelationProcessor();
            Dictionary<Integer, Double> dict = icp.parseCorrelation(null, null, null);
            response.setAttendanceGradeCorrelation(dict.get(dict.keys().nextElement()));
            return response;
        } catch (Exception e) {
            return new ControllerResponse(e.getMessage());
        }
    }
}
