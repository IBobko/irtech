package ru.irtech.dto;

/**
 * Created by Iggytoto on 05.08.2017.
 */
public class AttendanceToGradesResponse extends ControllerResponse {

    private double attendanceGradeCorrelation;

    private double meanSkipsByBestGrades;
    private double meanSkipsByGoodGrades;
    private double meanSkipsByAverageGrades;

    private double percentSkipsByBestGrades;
    private double percentSkipsByGoodGrades;
    private double percentSkipsByAverageGrades;


    /**
     * Main c-tor.
     */
    public AttendanceToGradesResponse() {
        super(OK_MESSAGE);
    }

    public double getAttendanceGradeCorrelation() {
        return attendanceGradeCorrelation;
    }

    public void setAttendanceGradeCorrelation(double attendanceGradeCorrelation) {
        this.attendanceGradeCorrelation = attendanceGradeCorrelation;
    }

    public double getMeanSkipsByBestGrades() {
        return meanSkipsByBestGrades;
    }

    public void setMeanSkipsByBestGrades(double meanSkipsByBestGrades) {
        this.meanSkipsByBestGrades = meanSkipsByBestGrades;
    }

    public double getMeanSkipsByGoodGrades() {
        return meanSkipsByGoodGrades;
    }

    public void setMeanSkipsByGoodGrades(double meanSkipsByGoodGrades) {
        this.meanSkipsByGoodGrades = meanSkipsByGoodGrades;
    }

    public double getMeanSkipsByAverageGrades() {
        return meanSkipsByAverageGrades;
    }

    public void setMeanSkipsByAverageGrades(double meanSkipsByAverageGrades) {
        this.meanSkipsByAverageGrades = meanSkipsByAverageGrades;
    }

    public double getPercentSkipsByBestGrades() {
        return percentSkipsByBestGrades;
    }

    public void setPercentSkipsByBestGrades(double percentSkipsByBestGrades) {
        this.percentSkipsByBestGrades = percentSkipsByBestGrades;
    }

    public double getPercentSkipsByGoodGrades() {
        return percentSkipsByGoodGrades;
    }

    public void setPercentSkipsByGoodGrades(double percentSkipsByGoodGrades) {
        this.percentSkipsByGoodGrades = percentSkipsByGoodGrades;
    }

    public double getPercentSkipsByAverageGrades() {
        return percentSkipsByAverageGrades;
    }

    public void setPercentSkipsByAverageGrades(double percentSkipsByAverageGrades) {
        this.percentSkipsByAverageGrades = percentSkipsByAverageGrades;
    }
}
