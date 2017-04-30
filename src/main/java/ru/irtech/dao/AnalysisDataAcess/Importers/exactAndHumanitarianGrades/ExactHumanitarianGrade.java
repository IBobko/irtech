package ru.irtech.dao.AnalysisDataAcess.Importers.exactAndHumanitarianGrades;

import java.util.Date;

/**
 * Created by Iggytoto on 30.04.2017.
 * Class that represents students grade.
 */
public class ExactHumanitarianGrade {
    /**
     * grade.
     */
    private final double grade;

    /**
     * date.
     */
    private final Date date;

    /**
     * type.
     */
    private final GradeType type;

    /**
     * Main c-tor.
     *
     * @param grade grade.
     * @param date  date.
     * @param type  type.
     */
    public ExactHumanitarianGrade(final double grade, final Date date, final GradeType type) {
        this.grade = grade;
        this.date = date;
        this.type = type;
    }

    /**
     * get type.
     *
     * @return GradeType.
     */
    public GradeType getType() {
        return type;
    }

    /**
     * get date.
     *
     * @return date.
     */
    public Date getDate() {
        return date;
    }

    /**
     * get grade.
     *
     * @return grade.
     */
    public double getGrade() {
        return grade;
    }
}
