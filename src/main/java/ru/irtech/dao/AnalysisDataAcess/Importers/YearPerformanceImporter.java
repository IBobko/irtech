package ru.irtech.dao.AnalysisDataAcess.Importers;

import ru.irtech.form.PerformanceForm;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Galieva Dilyara 01.06.20117.
 * Class dedicated to data selection from database
 * selects information about grades
 * by different grouppings
 */
public class YearPerformanceImporter extends PerformanceClass {

    /**
     * method that queries assignment, quarter or year results.
     *
     * @param connection connection to database
     * @param pForm      form that contains all needed input data from view
     *                   In case if groupings :
     *                   1. student - all fields should be provided
     *                   2. class - studentId should be null
     *                   3. parallel - additionally to previous remove className
     *                   4. school - additionally to previous remove grade
     *                   5. all subjects - remove subjectName
     * @return list of query results
     */
    List<String> queryResults(final Connection connection, final PerformanceForm pForm) {
        List<String> result = new ArrayList<>();
        try {
            Statement st = connection.createStatement();
            String queryString = "";
            queryString = formYearQuery();
            String[] options = super.createOptions(pForm);
            queryString = "select avg(R.MARK), " + options[2] + queryString + options[0] + options[1];
            System.out.println(queryString);
            ResultSet rs = st.executeQuery(queryString);
            while (rs.next()) {
                result.add(rs.toString());
            }
            rs.close();
            st.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * method that queries year results.
     *
     * @return query body before where clause
     */
    private String formYearQuery() {
        return " from  SCHOOLS S   \n"
                + "join SCHOOLYEARS YSY on YSY.SCHOOLID=S.SCHOOLID  \n"
                + "join GLOBALYEARS Y on Y.GLOBALYEARID=YSY.GLOBALYEARID  \n"
                + "join CLASSES CL on CL.SCHOOLYEARID=YSY.SCHOOLYEARID  \n"
                + "join CLASSSUBJECTGROUPS CSG on CSG.PCLASSID=CL.CLASSID  \n"
                + "join SUBJECTGROUPS SG on SG.ID=CSG.ID  \n"
                + "join SUBJECTS SJ on SJ.SUBJECTID=SG.SUBJECTID  \n"
                + "join GLOBALSUBJECTS GSJ on GSJ.GLOBALSUBJID=SJ.GLOBALSUBJID  \n"
                + "join STUDENTSCLASSES SC on SC.CLASSID=CL.CLASSID   \n"
                + "join STUDENTS ST on ST.STUDENTID=SC.STUDENTID  \n"
                + "join USERS U on U.USERID=ST.STUDENTID  \n"
                + "join YEARTOTALS R on R.STUDENTID=ST.STUDENTID  \n"
                + "and R.SGID=CSG.ID ";
    }

}
