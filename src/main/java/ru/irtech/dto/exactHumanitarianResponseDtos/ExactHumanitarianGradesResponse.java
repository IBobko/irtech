package ru.irtech.dto.exactHumanitarianResponseDtos;

import ru.irtech.dto.ControllerResponse;

/**
 * Created by Iggytoto on 30.04.2017.
 */
public class ExactHumanitarianGradesResponse extends ControllerResponse {

    /**
     * exact sciences grades and dates.
     */
    private final GradeDto[] exactGrades;

    /**
     * humanitarian sciences grades and dates.
     */
    private final GradeDto[] humanitarianGrades;

    /**
     * Main c-tor.
     *
     * @param exactGrades        exact grades
     * @param humanitarianGrades humanitarian grades
     */
    public ExactHumanitarianGradesResponse(final GradeDto[] exactGrades, final GradeDto[] humanitarianGrades) {
        super("OK");
        this.exactGrades = exactGrades;
        this.humanitarianGrades = humanitarianGrades;
    }

    /**
     * returns exact sciences grades.
     *
     * @return exact sciences grades.
     */
    public GradeDto[] getExactGrades() {
        return this.exactGrades;
    }

    /**
     * returns humanitarian sciences grades.
     *
     * @return humanitarian sciences grades.
     */
    public GradeDto[] getHumanitarianGrades() {
        return this.humanitarianGrades;
    }
}
