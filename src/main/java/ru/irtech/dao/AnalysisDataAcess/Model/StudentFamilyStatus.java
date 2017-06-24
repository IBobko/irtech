package ru.irtech.dao.AnalysisDataAcess.Model;

/**
 * Created by Iggytoto on 06.06.2017.
 * <p>
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
     * @param studentId    student id.
     * @param isFamilyFull family full indicator.
     */
    public StudentFamilyStatus(final Integer studentId, final boolean isFamilyFull) {
        this.studentId = studentId;
        this.isFamilyFull = isFamilyFull;
    }

    /**
     * gets the family status.
     *
     * @return family full indicator.
     */
    public boolean isFamilyFull() {
        return isFamilyFull;
    }

    /**
     * gets student id.
     *
     * @return student id.
     */
    public Integer getStudentId() {
        return studentId;
    }
}
