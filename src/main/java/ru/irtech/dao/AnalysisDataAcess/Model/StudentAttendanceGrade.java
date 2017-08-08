package ru.irtech.dao.AnalysisDataAcess.Model;

/**
 * Created by Iggytoto on 05.08.2017.
 */
public class StudentAttendanceGrade {
    /**
     * Student id.
     */
    private int studentid;
    /**
     * Skip count.
     */
    private int skipsCount;
    /**
     * Mean grade.
     */
    private double meanGrade;

    /**
     * Constructor.
     *
     * @param studentid Student id.
     * @param skipsCount Skip count.
     * @param meanGrade Mean grade.
     */
    public StudentAttendanceGrade(final int studentid, final int skipsCount, final double meanGrade) {

        this.studentid = studentid;
        this.skipsCount = skipsCount;
        this.meanGrade = meanGrade;
    }

    public int getStudentid() {
        return studentid;
    }

    public void setStudentid(final int studentid) {
        this.studentid = studentid;
    }

    public int getSkipsCount() {
        return skipsCount;
    }

    public void setSkipsCount(final int skipsCount) {
        this.skipsCount = skipsCount;
    }

    public double getMeanGrade() {
        return meanGrade;
    }

    public void setMeanGrade(final double meanGrade) {
        this.meanGrade = meanGrade;
    }
}
