package ru.irtech.dao.AnalysisDataAcess.Importers;

import ru.irtech.dao.AnalysisDataAcess.Importers.exactAndHumanitarianGrades.ExactHumanitarianGrade;

import java.util.Date;

/**
 * Created by Iggytoto on 30.04.2017.
 * Class that imports students grades for a given period
 */
public class StudentsPeriodGradesImporter extends BaseImporter {
    /**
     * Main processing method that imports grades and returns it in array form.
     *
     * @param studentId student id.
     * @param fromDate  from date.
     * @param toDate    to date.
     * @return set of grades.
     */
    public ExactHumanitarianGrade[] getGrades(final int studentId, final Date fromDate, final Date toDate) {
        //TODO REQUEST TO DB AND GET THE DATA
        return new ExactHumanitarianGrade[0];
    }
}
