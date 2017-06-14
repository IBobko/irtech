package ru.irtech.dao.AnalysisDataAcess.Model;

/**
 * Created by Iggytoto on 14.06.2017.
 * <p>
 * Class that represents studentid - average student grade - number of class skips of the student.
 */
public class StudentMeanGradeAttendance {

    /**
     * Student id.
     */
    private final int studentId;

    /**
     * Average Grade.
     */
    private final double meanGrade;

    /**
     * Count of class misses.
     */
    private final int skipsCount;

    /**
     * C-tor
     *
     * @param studentId id.
     * @param meanGrade avg grade.
     * @param missCount misses count.
     */
    public StudentMeanGradeAttendance(final int studentId, final double meanGrade, final int missCount) {
        this.studentId = studentId;
        this.meanGrade = meanGrade;
        this.skipsCount = missCount;
    }

    /**
     * gets skips.
     *
     * @return skips.
     */
    public int getSkipsCount() {
        return skipsCount;
    }

    /**
     * gets avg grade.
     *
     * @return avg grade.
     */
    public double getMeanGrade() {
        return meanGrade;
    }

    /**
     * gets student id.
     *
     * @return id.
     */
    public int getStudentId() {
        return studentId;
    }
}
