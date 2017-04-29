package ru.irtech.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.irtech.analysis.Correlation.ICorrelationProcessor;
import ru.irtech.analysis.Correlation.PearsonsCorrelationProcessor;
import ru.irtech.dao.AnalysisDataAcess.DataBaseList;
import ru.irtech.dao.AnalysisDataAcess.Importers.ICsvImporter;
import ru.irtech.dao.AnalysisDataAcess.Importers.StudentsTermsYearlyMarks;
import ru.irtech.dto.ControllerResponse;
import ru.irtech.dto.FamiltyToGradesCorrelationResponse;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.Dictionary;

/**
 * Created by Iggytoto on 29.04.2017.
 * Controller that returns Correlation results as JSON Objects
 */
@Controller
@RequestMapping("/correlationData")
public class CorrelationDataController {
    /**
     * Method that returns family status to yearly and termly grades correlation analysis results
     * @return DTO that represents results
     */
    @RequestMapping(value = "/familyToGrades",method = RequestMethod.GET)
    public @ResponseBody ControllerResponse getFamiltyToGradesCorrelation() throws IOException {
        Date date = new Date();
        File file = File.createTempFile("ftg", Long.toString(date.getTime()));

        try{
            ICsvImporter importer = new StudentsTermsYearlyMarks();
            importer.importData(file, DataBaseList.getDataBases().get(0));

            if(file.getTotalSpace() == 0){
                return new ControllerResponse("No data");
            }

            ICorrelationProcessor processor = new PearsonsCorrelationProcessor();
            Dictionary<Integer,Double> result = processor.parseCorrelation(file.getAbsolutePath(),3,new Integer[] {1,2});

            return new FamiltyToGradesCorrelationResponse(result.get(1),result.get(2));
        }
        catch (Exception e){
            return new ControllerResponse(e.getMessage());
        }
        finally {
            if(file.exists()){
                file.delete();
            }
        }
    }
}
