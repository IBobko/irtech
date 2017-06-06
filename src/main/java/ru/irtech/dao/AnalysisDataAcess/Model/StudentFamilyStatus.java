package ru.irtech.dao.AnalysisDataAcess.Model;

/**
 * Created by Iggytoto on 06.06.2017.
 *
 * Class that represents single student family status.[
 */
public class StudentFamilyStatus {
    /**
     * Student id.
     */
    private final Integer studentId;

    /**
     * Student family status.
     */
    private final boolean isFamilyFull;

    /**
     * C-tor.
     *
     * @param studentId
     * @param isFamilyFull
     */
    public StudentFamilyStatus(final Integer studentId, final boolean isFamilyFull) {
        this.studentId = studentId;
        this.isFamilyFull = isFamilyFull;
    }

    /**
     * gets the family status.
     *
     * @return
     */
    public boolean isFamilyFull() {
        return isFamilyFull;
    }

    /**
     * gets student id.
     *
     * @return
     */
    public Integer getStudentId() {
        return studentId;
    }
}
