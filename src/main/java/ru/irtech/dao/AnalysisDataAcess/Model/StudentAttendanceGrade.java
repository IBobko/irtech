package ru.irtech.dao.AnalysisDataAcess.Model;

/**
 * Created by Iggytoto on 05.08.2017.
 */
public class StudentAttendanceGrade {
    private int studentid;
    private int skipsCount;
    private double meanGrade;

    public StudentAttendanceGrade(int studentid, int skipsCount, double meanGrade) {

        this.studentid = studentid;
        this.skipsCount = skipsCount;
        this.meanGrade = meanGrade;
    }

    public int getStudentid() {
        return studentid;
    }

    public void setStudentid(int studentid) {
        this.studentid = studentid;
    }

    public int getSkipsCount() {
        return skipsCount;
    }

    public void setSkipsCount(int skipsCount) {
        this.skipsCount = skipsCount;
    }

    public double getMeanGrade() {
        return meanGrade;
    }

    public void setMeanGrade(double meanGrade) {
        this.meanGrade = meanGrade;
    }
}
