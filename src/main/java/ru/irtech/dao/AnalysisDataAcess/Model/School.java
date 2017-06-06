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
     * @param schoolId
     * @param studentsId
     */
    public School(Integer schoolId, List<Integer> studentsId) {
        this.schoolId = schoolId;
        this.studentsId = studentsId;
    }

    /**
     * gets school id.
     *
     * @return
     */
    public Integer getSchoolId() {
        return schoolId;
    }

    /**
     * gets arrays of students id.
     *
     * @return
     */
    public List<Integer> getStudentsId() {
        return studentsId;
    }
}
