package ru.irtech.dao.AnalysisDataAcess.Model;

/**
 * Created by Iggytoto on 06.06.2017.
 * <p>
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
     * @param studentId student id.
     * @param meanGrade mean grade.
     */
    public StudentMeanGrade(final Integer studentId, final double meanGrade) {
        this.studentId = studentId;
        this.meanGrade = meanGrade;
    }

    /**
     * gets student id.
     *
     * @return id.
     */
    public Integer getStudentId() {
        return studentId;
    }

    /**
     * gets mean grade.
     *
     * @return grade.
     */
    public double getMeanGrade() {
        return meanGrade;
    }
}
