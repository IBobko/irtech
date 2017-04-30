package ru.irtech.dto.exactHumanitarianResponseDtos;

import java.util.Date;

/**
 * Created by Iggytoto on 30.04.2017.
 * Grade data transport object.
 */
public class GradeDto {
    /**
     * date of the grade was marked.
     */
    private final Date date;

    /**
     * the grade itself.
     */
    private final double grade;

    /**
     * Main C-tor.
     *
     * @param date  date of the grade.
     * @param grade the grade itself.
     */
    public GradeDto(final Date date, final double grade) {
        this.grade = grade;
        this.date = date;
    }

    /**
     * gets the date.
     *
     * @return
     */
    public Date getDate() {
        return this.date;
    }

    /**
     * gets the grade/
     *
     * @return
     */
    public double getGrade() {
        return this.grade;
    }
}
