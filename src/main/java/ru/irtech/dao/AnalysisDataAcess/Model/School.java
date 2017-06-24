package ru.irtech.dao.AnalysisDataAcess.Model;

import java.util.List;

/**
 * Created by Iggytoto on 06.06.2017.
 * <p>
 * Class that represents single school
 */
public class School {

    /**
     * Current School Id.
     */
    private final Integer schoolId;

    /**
     * All students ids.
     */
    private final List<Integer> studentsId;

    /**
     * C-tor.
     *
     * @param schoolId   school id.
     * @param studentsId students id.
     */
    public School(final Integer schoolId, final List<Integer> studentsId) {
        this.schoolId = schoolId;
        this.studentsId = studentsId;
    }

    /**
     * gets school id.
     *
     * @return school id.
     */
    public Integer getSchoolId() {
        return schoolId;
    }

    /**
     * gets arrays of students id.
     *
     * @return students id.
     */
    public List<Integer> getStudentsId() {
        return studentsId;
    }
}
