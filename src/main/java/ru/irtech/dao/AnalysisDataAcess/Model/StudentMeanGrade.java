package ru.irtech.dao.AnalysisDataAcess.Model;

/**
 * Created by Iggytoto on 06.06.2017.
 *
 * Class that represents student mean grade.
 */
public class StudentMeanGrade {

    /**
     * Student id.
     */
    private final Integer studentId;

    /**
     * Mean grade.
     */
    private final double meanGrade;

    /**
     * C-tor.
     *
     * @param studentId
     * @param meanGrade
     */
    public StudentMeanGrade(final Integer studentId,final double meanGrade) {
        this.studentId = studentId;
        this.meanGrade = meanGrade;
    }

    /**
     * gets student id.
     *
     * @return
     */
    public Integer getStudentId() {
        return studentId;
    }

    /**
     * gets mean grade.
     *
     * @return
     */
    public double getMeanGrade() {
        return meanGrade;
    }
}
