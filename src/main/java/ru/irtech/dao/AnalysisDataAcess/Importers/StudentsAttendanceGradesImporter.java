package ru.irtech.dao.AnalysisDataAcess.Importers;

import ru.irtech.dao.AnalysisDataAcess.Model.StudentAttendanceGrade;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Iggytoto on 05.08.2017.
 */
public class StudentsAttendanceGradesImporter extends BaseImporter implements IArrayImporter<StudentAttendanceGrade> {
    @Override
    public List<StudentAttendanceGrade> importAllData(final String databaseName) {
        Connection connection = getConnection(databaseName);

        List<StudentAttendanceGrade> result = new ArrayList<>();
        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("select * from irtech_attendance_grades");
            while (rs.next()) {
                result.add(new StudentAttendanceGrade(rs.getInt(1), rs.getInt(2), rs.getDouble(3)));
            }
            rs.close();
            st.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public List<StudentAttendanceGrade> importData(final String databaseName, final Date dateFrom, final Date dateTo) {
        return importAllData(databaseName);
    }
}
