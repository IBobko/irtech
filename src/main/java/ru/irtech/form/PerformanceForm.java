package ru.irtech.form;

import javax.ws.rs.core.Form;

/**
 * Created by Dilyara Galieva 08.06.2017.
 * form with values returned from view
 * todo validation of fields
 */
public class PerformanceForm extends Form {
    /**
     *  id of the student whose grades will be analyzed.
     */
    private Integer student;

    /**
     *  name of the class.
     */
    private String className;

    /**
     * student's grade.
     */
    private Integer grade;

    /**
     *  school number.
     */
    private Integer schoolName;

    /**
     * date from which we do analysis.
     */
    private String dateFrom;

    /**
     *  date to which do analysis.
     */
    private String dateTo;

    /**
     *  name of the subject grades for which we are analyzing.
     */
    private String subjectName;

    /**
     *  studying year number.
     */
    private String schoolYearName;

    /**
     * studying term number.
     */
    private String termName;

    /**
     * getter for student.
     * @return student id
     */
    public Integer getStudent() {
        if (student == null) {
            return 0;
        }
        return student;
    }

    /**
     * setter for student.
     * @param student student id
     */
    public void setStudent(final Integer student) {
        this.student = student;
    }

    /**
     * getter for class.
     * @return name class name
     */
    public String getClassName() {
        if (className == null) {
            return "";
        }
        return className;
    }

    /**
     * setter for class.
     * @param className class name
     */
    public void setClassName(final String className) {
        this.className = className;
    }

    /**
     * getter for grade.
     * @return grade number
     */
    public Integer getGrade() {
        if (grade == null) {
            return 0;
        }
        return grade;
    }

    /**
     * setter for grade.
     * @param grade grade number
     */
    public void setGrade(final Integer grade) {
        this.grade = grade;
    }

    /**
     * getter for schoolName.
     * @return school number
     */
    public Integer getSchoolName() {
        if (schoolName == null) {
            return 0;
        }
        return schoolName;
    }

    /**
     * setter for school name.
     * @param schoolName name of the school
     */
    public void setSchoolName(final Integer schoolName) {
        this.schoolName = schoolName;
    }

    /**
     * getter for from.
     * @return date from which analysis starts
     */
    public String getDateFrom() {
        if (dateFrom == null) {
            return "";
        }
        return dateFrom;
    }

    /**
     * setter for from date.
     * @param dateFrom date from which analysis will be performed
     */
    public void setDateFrom(final String dateFrom) {
        this.dateFrom = dateFrom;
    }

    /**
     * getter for to.
     * @return date till which analysis starts
     */
    public String getDateTo() {
        if (dateTo == null) {
            return "";
        }
        return dateTo;
    }

    /**
     * setter for to date.
     * @param dateTo date till which analysis will be performed
     */
    public void setDateTo(final String dateTo) {
        this.dateTo = dateTo;
    }

    /**
     * getter for term name.
     * @return name of the term
     */
    public String getTermName() {
        if (termName == null) {
            return "";
        }
        return termName;
    }

    /**
     * setter for school term name.
     * @param termName term for analysis
     */
    public void setTermName(final String termName) {
        this.termName = termName;
    }

    /**
     * getter for school year name.
     * @return studying year number
     */
    public String getSchoolYearName() {
        if (schoolYearName == null) {
            return "";
        }
        return schoolYearName;
    }

    /**
     * setter for school year name.
     * @param schoolYearName studying year name
     */
    public void setSchoolYearName(final String schoolYearName) {
        this.schoolYearName = schoolYearName;
    }

    /**
     * getter for subject.
     * @return subject for which analysis is done
     */
    public String getSubjectName() {
        if (subjectName == null) {
            return "";
        }
        return subjectName;
    }

    /**
     * setter for subject.
     * @param subjectName subject name
     */
    public void setSubjectName(final String subjectName) {
        this.subjectName = subjectName;
    }
}
