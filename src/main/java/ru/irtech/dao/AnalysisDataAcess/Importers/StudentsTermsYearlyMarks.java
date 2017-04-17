package ru.irtech.dao.AnalysisDataAcess.Importers;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Iggytoto on 16.04.2017.
 * Class that returns csv file reference with data that contains four columns: studentId (int), meanTermGrade(double),
 * meanYearlyGrade (double), isFullFamily (both parents - True, other way - false)
 */
public class StudentsTermsYearlyMarks extends BaseImporter {
    /**
     * Main processing method.
     *
     * @param databaseName target database for apply query
     * @return path to csv file
     */
    @Override
    public String importData(final File file, final String databaseName) {
        String result = "test";
        try {

            Connection connection = getConnection(databaseName);

            AbstractMap<Integer, List<Double>> studentPeriodGradeMap;
            AbstractMap<Integer, List<Double>> studentYearlyGradeMap;
            AbstractMap<Integer, List<Integer>> studentRelationsMap;
            List<Integer> studentIds;

            studentPeriodGradeMap = queryTermGrades(connection);
            studentYearlyGradeMap = queryYearGrades(connection);
            studentRelationsMap = queryRelationships(connection);
            studentIds = queryStudentIds(connection);

            FileOutputStream fos = new FileOutputStream(file);
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));

            for (int studentId : studentIds) {
                if (!studentPeriodGradeMap.containsKey(studentId)
                        || !studentYearlyGradeMap.containsKey(studentId)
                        || !studentRelationsMap.containsKey(studentId)) {
                    continue;
                }

                bw.write(studentId + "," + studentPeriodGradeMap.get(studentId) + "," + studentYearlyGradeMap.get(studentId)
                        + "," + (studentRelationsMap.get(studentId).size() >= 2 ? "True" : "False"));
                bw.newLine();
            }
            bw.close();

            connection.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return result;

    }

    /**
     * method that queries database for all student ids.
     *
     * @param connection connection to database
     * @return list of ids
     */
    private List<Integer> queryStudentIds(final Connection connection) {
        List<Integer> result = new ArrayList<>();
        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("SELECT DISTINCT u.USERID\n"
                    + "FROM users AS u\n"
                    + "INNER JOIN USERSROLES AS ur\n"
                    + "\tON u.USERID=ur.USERID\n"
                    + "\tWHERE ur.ROLEID = 4");
            while (rs.next()) {
                result.add(rs.getInt(1));
            }
            rs.close();
            st.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    /**
     * Method that queries database for students family relations (parents).
     *
     * @param connection connection to database
     * @return set of student ids and their relations (7 for mother, 8 for father)
     */
    private AbstractMap<Integer, List<Integer>> queryRelationships(final Connection connection) {
        AbstractMap<Integer, List<Integer>> result = new HashMap<>();
        Statement st;
        try {
            st = connection.createStatement();

            ResultSet rs;

            rs = st.executeQuery("SELECT userid,relationshiptypeid FROM FAMILYINFO \n"
                    + "WHERE RELATIONSHIPTYPEID = 7 OR RELATIONSHIPTYPEID =8");
            while (rs.next()) {
                int studentId = rs.getInt(1);
                int relation = rs.getInt(2);
                if (!result.containsKey(studentId)) {
                    result.put(studentId, new ArrayList<>());
                }
                result.get(studentId).add(relation);
                rs.close();
                st.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;

    }

    /**
     * Method that queries database for students yearly grades.
     *
     * @param connection connection to database
     * @return reference to resulting hashmap
     */
    private HashMap<Integer, List<Double>> queryYearGrades(final Connection connection) {
        HashMap<Integer, List<Double>> result = new HashMap<>();
        Statement st;
        try {
            st = connection.createStatement();

            ResultSet rs;
            rs = st.executeQuery("select studentid,mark from YEARTOTALS where PERIODTYPEID = 2");
            while (rs.next()) {
                int studentId = rs.getInt(1);
                double grade = rs.getDouble(2);
                if (!result.containsKey(studentId)) {
                    result.put(studentId, new ArrayList<>());
                }
                result.get(studentId).add(grade);
            }
            rs.close();
            st.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * MEthod that queries database and search for all term grades of all students.
     *
     * @param connection connection to database
     * @return reference to resulting hashmap
     */
    private HashMap<Integer, List<Double>> queryTermGrades(final Connection connection) {
        HashMap<Integer, List<Double>> result = new HashMap<>();
        Statement st;
        try {
            st = connection.createStatement();

            ResultSet rs;
            rs = st.executeQuery("select studentid, mark from totals");
            while (rs.next()) {
                int studentId = rs.getInt(1);
                double grade = rs.getDouble(2);
                if (!result.containsKey(studentId)) {
                    result.put(studentId, new ArrayList<>());
                }
                result.get(studentId).add(grade);
            }
            rs.close();
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;

    }
}
