package ru.irtech.dao.AnalysisDataAcess.Importers;

import ru.irtech.dao.AnalysisDataAcess.Model.StudentMeanGradeAttendance;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Iggytoto on 14.06.2017.
 * <p>
 * Combined importer that recovers from base StudentMeanGradeAttendances
 */
public class StudentsMeanGradeAttendanceImporter extends BaseImporter implements ICsvImporter, IArrayImporter<StudentMeanGradeAttendance> {

    /**
     * SQL path.
     */
    private static final String SQL_FILE_NAME = "StudentidMeanGradeAttendanceCount.sql";

    /**
     * IArray implementation.
     *
     * @param databaseName database name to import from.
     * @return set od StudentMeanGradeAttendances.
     */
    @Override
    public List<StudentMeanGradeAttendance> importAllData(final String databaseName) {
        return getData(databaseName);
    }

    /**
     * Not implemented method yet.
     *
     * @param databaseName database name to import from.
     * @param dateFrom     from time.
     * @param dateTo       to time.
     * @return null.
     */
    @Override
    public List<StudentMeanGradeAttendance> importData(final String databaseName, final Date dateFrom, final Date dateTo) {
        return null;
    }

    /**
     * ICsvImporter implementation.
     *
     * @param file         file to write
     * @param databaseName database name to connect to.
     * @return path to csv file.
     */
    @Override
    public String importData(final File file, final String databaseName) {
        try {
            List<StudentMeanGradeAttendance> data = getData(databaseName);

            FileOutputStream fos = new FileOutputStream(file);
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));

            for (StudentMeanGradeAttendance entity : data) {
                bw.write(entity.getStudentId() + "," + entity.getMeanGrade() + "," + entity.getSkipsCount());
                bw.newLine();
            }
            bw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return file.getPath();
    }

    /**
     * Main processing method.
     *
     * @param dataBaseName database name to query.
     * @return Set of StudentMeanGradeAttendances.
     */
    private List<StudentMeanGradeAttendance> getData(final String dataBaseName) {
        List<StudentMeanGradeAttendance> result = new ArrayList<>();

        Connection connection = getConnection(dataBaseName);

        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(readSql(SQL_FILE_NAME, Charset.defaultCharset()));
            while (rs.next()) {
                result.add(new StudentMeanGradeAttendance(rs.getInt(1), rs.getDouble(2), rs.getInt(3)));
            }
            rs.close();
            st.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }
}
