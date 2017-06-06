package ru.irtech.dao.AnalysisDataAcess.Importers;

import ru.irtech.dao.AnalysisDataAcess.Model.StudentFamilyStatus;

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
 * <p>
 * Class that access database and returns array of student's family statuses
 */
public class StudentsFamilyStatusImporter extends BaseImporter implements IArrayImporter<StudentFamilyStatus> {

    /**
     * Sql filenames.
     */
    private final static String ALL_STUDENTS_SQL_FILENAME = "AllStudentsFamilyStatus.sql";

    /**
     * Sql queries.
     */
    private final String allStudentsQuery;

    /**
     * C-tor.
     *
     * @throws IOException
     */
    public StudentsFamilyStatusImporter() throws IOException {
        this.allStudentsQuery = readSql(ALL_STUDENTS_SQL_FILENAME, Charset.defaultCharset());
    }

    /**
     * Get the family statuses.
     *
     * @param databaseName database name to import from.
     * @return
     */
    @Override
    public List<StudentFamilyStatus> importAllData(String databaseName) {
        Connection connection = getConnection(databaseName);
        List<StudentFamilyStatus> statuses = queryStudentsFamilyStatus(connection, new Date(0), new Date());

        return statuses;
    }

    /**
     * Get the family statuses within the given period
     *
     * @param databaseName database name to import from.
     * @param dateFrom     from time.
     * @param dateTo       to time.
     * @return
     */
    @Override
    public List<StudentFamilyStatus> importData(final String databaseName, final Date dateFrom, final Date dateTo) {
        Connection connection = getConnection(databaseName);
        List<StudentFamilyStatus> statuses = queryStudentsFamilyStatus(connection, dateFrom, dateTo);

        return statuses;
    }

    /**
     * Query student family statuses.
     *
     * @param connection
     * @return
     */
    private List<StudentFamilyStatus> queryStudentsFamilyStatus(final Connection connection, final Date from, final Date to) {
        List<StudentFamilyStatus> result = new ArrayList<>();
        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(allStudentsQuery);
            while (rs.next()) {
                result.add(new StudentFamilyStatus(rs.getInt(1), rs.getInt(2) >= 2));
            }
            rs.close();
            st.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }
}
