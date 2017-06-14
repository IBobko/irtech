package ru.irtech.dao.AnalysisDataAcess.Importers;

import ru.irtech.dao.AnalysisDataAcess.Model.School;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Iggytoto on 06.06.2017.
 */
public class SchoolsImporter extends BaseImporter implements IArrayImporter<School> {

    /**
     * All schools sql query filenames.
     */
    private static final String ALL_SCHOOLS_SQL_FILENAME = "AllSchools.sql";

    /**
     * All students for schools sql filename.
     */
    private static final String SCHOOLS_STUDENTS_SQL_FILENAME = "SchoolStudents.sql";

    /**
     * School id sql tag to replace.
     */
    private static final String SCHOOL_ID_SQL_TAG = "@SCHOOLID";

    /**
     * Sql query.
     */
    private final String allSchoolsQuery;

    /**
     * Sql query.
     */
    private final String schoolsStudentsQuery;

    /**
     * C-tor.
     */
    public SchoolsImporter() {
        allSchoolsQuery = ALL_SCHOOLS_SQL_FILENAME;
        schoolsStudentsQuery = SCHOOLS_STUDENTS_SQL_FILENAME;
    }

    /**
     * Returns list of all schools with students.
     *
     * @param databaseName database name to import from
     * @return list of schools.
     */
    @Override
    public List<School> importAllData(final String databaseName) {
        Connection connection = getConnection(databaseName);
        return querySchools(connection);
    }

    /**
     * Currently not implemented and returns null. No need to implement.
     *
     * @param databaseName database name to import from.
     * @param dateFrom     from time.
     * @param dateTo       to time.
     * @return null.
     */
    @Override
    public List<School> importData(final String databaseName, final Date dateFrom, final Date dateTo) {
        return null;
    }

    /**
     * Query student family statuses.
     *
     * @param connection connection to database.
     * @return List of schools.
     */
    private List<School> querySchools(final Connection connection) {
        List<Integer> schools = new ArrayList<>();
        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(allSchoolsQuery);
            while (rs.next()) {
                schools.add(rs.getInt(1));
            }
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        List<School> result = new ArrayList<>();

        for (Integer schoolId : schools) {
            List<Integer> students = new ArrayList<>();
            String query = schoolsStudentsQuery.replace(SCHOOL_ID_SQL_TAG, schoolId.toString());

            try {
                Statement st = connection.createStatement();
                ResultSet rs = st.executeQuery(query);
                while (rs.next()) {
                    students.add(rs.getInt(1));
                    rs.getInt(4)
                }
                rs.close();
                st.close();
            } catch (Exception e) {
                e.printStackTrace();
                continue;
            }

            result.add(new School(schoolId, students));
        }

        return result;
    }
}
