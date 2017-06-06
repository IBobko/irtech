package ru.irtech.dao.AnalysisDataAcess.Importers;

import ru.irtech.dao.AnalysisDataAcess.Model.StudentFamilyStatus;

import java.io.IOException;
import java.nio.charset.Charset;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Iggytoto on 06.06.2017.
 * <p>
 * Class that acess database and returns array of student's family statuses
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
     * @param databaseName database name to import from
     * @return
     */
    @Override
    public StudentFamilyStatus[] importData(String databaseName) {
        return new StudentFamilyStatus[0];
    }

    private List<Integer> queryStudentIds(final Connection connection) {
        List<Integer> result = new ArrayList<>();
        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(allStudentsQuery);
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
}
