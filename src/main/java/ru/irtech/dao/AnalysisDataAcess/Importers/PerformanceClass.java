package ru.irtech.dao.AnalysisDataAcess.Importers;

import ru.irtech.form.PerformanceForm;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.sql.Connection;
import java.util.List;
import java.util.Objects;

/**
 * Created by Galieva Dilyara 01.06.20117.
 * Class dedicated to data selection from database
 * selects information about students marks
 */
public abstract class PerformanceClass extends BaseImporter {
    /**
     * form that contains all input data for request performance.
     */
    private PerformanceForm pForm = new PerformanceForm();

    @Override
    public String importData(final File file, final String databaseName) {
        try {

            Connection connection = getConnection(databaseName);

            FileOutputStream fos = new FileOutputStream(file);
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
            List<String> results = queryResults(connection, pForm);
            bw.write(String.valueOf(results));
            bw.newLine();
            bw.close();

            connection.close();
        } catch (
                Exception e) {
            System.out.println(e.getMessage());
        }
        return file.getPath();
    }

    /**
     * method that queries results based on some input parameters.
     *
     * @param connection      database connection
     * @param performanceForm id of the student whose grades will be analyzed
     * @return list of query result strings
     */
    abstract List<String> queryResults(final Connection connection, PerformanceForm performanceForm);

    /**
     * method that create where clause of query.
     *
     * @param performanceForm contains params for analysis
     * @return query body after where clause
     */
    String[] createOptions(final PerformanceForm performanceForm) {
        String selectString = " ";
        String queryString = " where";
        String groupString = " group by";
        if (performanceForm.getStudent() > 0) {
            queryString = queryString + " ST.STUDENTID = " + performanceForm.getStudent() + "\n";
            groupString = groupString + " ST.STUDENTID";
            selectString = selectString + " ST.STUDENTID";
        }
        if (!Objects.equals(performanceForm.getDateFrom(), "")) {
            if (Objects.equals(queryString, " where")) {
                queryString = queryString + " R.DONEDATE >= '" + performanceForm.getDateFrom() + "'\n";
            } else {
                queryString = queryString + " and R.DONEDATE >= '" + performanceForm.getDateFrom() + "'\n";
            }
            if (!Objects.equals(performanceForm.getDateTo(), "")) {
                queryString = queryString + " and R.DONEDATE <= '" + performanceForm.getDateTo() + "'\n";
            } else {
                // default date end
                // todo make Date
                queryString = queryString + " and R.DONEDATE <= '" + performanceForm.getDateTo() + 30 + "'\n";
            }
        }
        if (!Objects.equals(performanceForm.getSubjectName(), "")) {
            if (Objects.equals(queryString, " where")) {
                queryString = queryString + " SJ.SUBJECTNAME =" + performanceForm.getSubjectName() + "\n";
            } else {
                queryString = queryString + " and SJ.SUBJECTNAME =" + performanceForm.getSubjectName() + "\n";
            }
            if (Objects.equals(groupString, " group by")) {
                groupString = groupString + " SJ.SUBJECTNAME";
            } else {
                groupString = groupString + " ,SJ.SUBJECTNAME";
            }
            if (Objects.equals(selectString, " ")) {
                selectString = selectString + " SJ.SUBJECTNAME";
            } else {
                selectString = selectString + " ,SJ.SUBJECTNAME";
            }
        }
        if (performanceForm.getGrade() > 0) {
            if (Objects.equals(queryString, " where")) {
                queryString = queryString + " CL.GRADE = " + performanceForm.getGrade() + "\n";
            } else {
                queryString = queryString + " and CL.GRADE = " + performanceForm.getGrade() + "\n";
            }
            if (Objects.equals(groupString, " group by")) {
                groupString = groupString + " CL.GRADE";
            } else {
                groupString = groupString + " ,CL.GRADE";
            }
            if (Objects.equals(selectString, " ")) {
                selectString = selectString + " CL.GRADE";
            } else {
                selectString = selectString + " ,CL.GRADE";
            }
        }
        if (!Objects.equals(performanceForm.getClassName(), "")) {
            if (Objects.equals(queryString, " where")) {
                queryString = queryString + " CL.CLASSNAME = '" + performanceForm.getClassName() + "'\n";
            } else {
                queryString = queryString + " and CL.CLASSNAME = '" + performanceForm.getClassName() + "'\n";
            }
            if (Objects.equals(groupString, " group by")) {
                groupString = groupString + " CL.CLASSNAME";
            } else {
                groupString = groupString + " ,CL.CLASSNAME";
            }
            if (Objects.equals(selectString, " ")) {
                selectString = selectString + " CL.CLASSNAME";
            } else {
                selectString = selectString + " ,CL.CLASSNAME";
            }
        }
        if (performanceForm.getSchoolName() > 0) {
            if (Objects.equals(queryString, " where")) {
                queryString = queryString + " E.EMID = " + performanceForm.getSchoolName() + "\n";
            } else {
                queryString = queryString + " and E.EMID = " + performanceForm.getSchoolName() + "\n";
            }
            if (Objects.equals(groupString, " group by")) {
                groupString = groupString + " E.EMID";
            } else {
                groupString = groupString + " ,E.EMID";
            }
            if (Objects.equals(selectString, " ")) {
                selectString = selectString + " E.EMID";
            } else {
                selectString = selectString + " ,E.EMID";
            }
        }
        if (!Objects.equals(performanceForm.getSchoolYearName(), "")) {
            if (Objects.equals(queryString, " where")) {
                queryString = queryString + " Y.SCHOOLYEARNAME=" + performanceForm.getSchoolYearName() + "\n";
            } else {
                queryString = queryString + " and Y.SCHOOLYEARNAME=" + performanceForm.getSchoolYearName() + "\n";
            }
            if (Objects.equals(groupString, " group by")) {
                groupString = groupString + " Y.SCHOOLYEARNAME";
            } else {
                groupString = groupString + ", Y.SCHOOLYEARNAME";
            }
            if (Objects.equals(selectString, " ")) {
                selectString = selectString + " Y.SCHOOLYEARNAME";
            } else {
                selectString = selectString + " ,Y.SCHOOLYEARNAME";
            }
        }
        if (!Objects.equals(performanceForm.getTermName(), "")) {
            if (Objects.equals(queryString, " where")) {
                queryString = queryString + " CT.TERMNAME LIKE '%" + performanceForm.getTermName() + "%'\n";
            } else {
                queryString = queryString + " and CT.TERMNAME LIKE '%" + performanceForm.getTermName() + "%'\n";
            }
            if (Objects.equals(groupString, " group by")) {
                groupString = groupString + " CT.TERMNAME";
            } else {
                groupString = groupString + " ,CT.TERMNAME";
            }
            if (Objects.equals(selectString, " ")) {
                selectString = selectString + " CT.TERMNAME";
            } else {
                selectString = selectString + " ,CT.TERMNAME";
            }
        }
        return new String[]{queryString, groupString, selectString};
    }

    /**
     * method that loads data to a form.
     *
     * @param performanceForm contains data entered on the view
     */
    public void loadForm(final PerformanceForm performanceForm) {
        this.pForm = performanceForm;
    }
}
