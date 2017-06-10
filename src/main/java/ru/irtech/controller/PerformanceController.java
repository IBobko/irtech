package ru.irtech.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.irtech.dao.AnalysisDataAcess.DataBaseList;
import ru.irtech.dao.AnalysisDataAcess.Importers.*;
import ru.irtech.form.PerformanceForm;

import java.io.File;
import java.io.IOException;
import java.util.Date;

/**
 * Created by Dilyara Galieva on 01.06.2017.
 * Controller that returns Performance results as JSON Objects.
 * todo add JSON
 */
@Controller
public class PerformanceController {

    /**
     * Returns template of test chart.
     *
     * @return Tenplate of test chart.
     */
    @RequestMapping(value = "performance", method = RequestMethod.GET)
    public String index() {
        return "analysis/index";
    }

    /**
     * Method that writes assignment performance results into file.
     *
     * @param pForm form with input information for query
     * @throws IOException throws IO exception in case of temporary file creation errors.
     */
    @RequestMapping(value = "/assignment", method = RequestMethod.GET)
    public void getAssignmentPerformance(@Validated final PerformanceForm pForm) throws IOException {
        Date date = new Date();
        File file = File.createTempFile("/ap", Long.toString(date.getTime()));

        try {
            PerformanceClass importer = new AssignmentPerformanceImporter();
            importer.loadForm(pForm);
            importer.importData(file, DataBaseList.getDataBases().get(0));

            if (file.getTotalSpace() == 0) {
                System.out.println("No data"); // FOR TEST COMMENT THIS LINE
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            if (file.exists()) {
                file.delete();
            }
        }
    }

    /**
     * Method that quarter performance into file.
     *
     * @param pForm form with input information for query
     * @throws IOException throws IO exception in case of temporary file creation errors.
     */
    @RequestMapping(value = "/quarter", method = RequestMethod.GET)
    @ResponseBody
    public void getQuarterPerformance(@Validated final PerformanceForm pForm) throws IOException {
        Date date = new Date();
        File file = File.createTempFile("/qp", Long.toString(date.getTime()));

        try {
            PerformanceClass importer = new QuarterPerformanceImporter();
            importer.loadForm(pForm);
            importer.importData(file, DataBaseList.getDataBases().get(0));

            if (file.getTotalSpace() == 0) {
                System.out.println("No data"); // FOR TEST COMMENT THIS LINE
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            if (file.exists()) {
                file.delete();
            }
        }
    }

    /**
     * Method that returns year performance.
     *
     * @param pForm form with input information for query
     * @throws IOException throws IO exception in case of temporary file creation errors.
     */
    @RequestMapping(value = "/year", method = RequestMethod.GET)
    @ResponseBody
    public void getYearPerformance(@Validated final PerformanceForm pForm) throws IOException {
        Date date = new Date();
        File file = File.createTempFile("/yp", Long.toString(date.getTime()));

        try {
            PerformanceClass importer = new YearPerformanceImporter();
            importer.loadForm(pForm);
            importer.importData(file, DataBaseList.getDataBases().get(0));

            if (file.getTotalSpace() == 0) {
                System.out.println("No data"); // FOR TEST COMMENT THIS LINE
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            if (file.exists()) {
                file.delete();
            }
        }
    }
}
