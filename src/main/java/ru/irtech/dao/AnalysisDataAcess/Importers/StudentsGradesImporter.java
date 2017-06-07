package ru.irtech.dao.AnalysisDataAcess.Importers;

import ru.irtech.dao.AnalysisDataAcess.Model.StudentMeanGrade;

import java.io.IOException;
import java.nio.charset.Charset;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Iggytoto on 06.06.2017.
 */
public class StudentsGradesImporter extends BaseImporter implements IArrayImporter<StudentMeanGrade> {

    /**
     * Sql filenames.
     */
    private final static String ALL_STUDENTS_GRADES_SQL_FILENAME = "AllStudentsGrades.sql";

    /**
     * Sql queries.
     */
    private final String allStudentsGradesQuery;

    /**
     * C-tor.
     *
     * @throws IOException
     */
    public StudentsGradesImporter() throws IOException {
        this.allStudentsGradesQuery = readSql(ALL_STUDENTS_GRADES_SQL_FILENAME, Charset.defaultCharset());
    }

    /**
     * Main import method.
     *
     * @param databaseName database name to import from
     * @return
     */
    @Override
    public List<StudentMeanGrade> importAllData(final String databaseName) {
        Connection connection = getConnection(databaseName);
        return queryStudentsFamilyStatus(connection);
    }

    @Override
    public List<StudentMeanGrade> importData(String databaseName, Date dateFrom, Date dateTo) {
        return null;
    }

    /**
     * Query to base that returns array of students mean grades.
     *
     * @param connection
     * @return
     */
    private List<StudentMeanGrade> queryStudentsFamilyStatus(final Connection connection) {
        List<StudentMeanGrade> result = new ArrayList<>();
        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(allStudentsGradesQuery);
            while (rs.next()) {
                result.add(new StudentMeanGrade(rs.getInt(1), rs.getDouble(2)));
            }
            rs.close();
            st.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }
}
