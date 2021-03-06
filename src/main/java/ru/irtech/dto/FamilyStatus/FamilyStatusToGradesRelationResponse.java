package ru.irtech.dto.FamilyStatus;

import ru.irtech.dto.ControllerResponse;

/**
 * Created by Iggytoto on 02.06.2017.
 * Represents response that holds the data about family status and mean grades by categories for the requested period
 * of time.
 */
public class FamilyStatusToGradesRelationResponse extends ControllerResponse {

    /**
     * sets length.
     */
    private static final int SETS_LENGTH = 3;

    /**
     * Set that represents full family grade percentages.
     * [0] -   percent of 1000-800 grades of all full family students.
     * [1] -   percent of 799-500 grades of all full family students.
     * [2] -   percent of <500 grades of all full family students.
     */
    private final double[] fullFamilySet;

    /**
     * Set that represents not full family grade percentages.
     * [0] -   percent of 1000-800 grades of all not full family students.
     * [1] -   percent of 799-500 grades of all not full family students.
     * [2] -   percent of <500 grades of all not full family students.
     */
    private final double[] notFullFamilySet;

    /**
     * Main c-tor.
     *
     * @param fullFamilySet    set of full family percentages.
     * @param notFullFamilySet set of not full family percentages.
     */
    public FamilyStatusToGradesRelationResponse(final double[] fullFamilySet, final double[] notFullFamilySet) {
        super(OK_MESSAGE);
        this.fullFamilySet = fullFamilySet;
        this.notFullFamilySet = notFullFamilySet;
    }

    /**
     * Gets sets length.
     *
     * @return sets length.
     */
    public static int getSetsLength() {
        return SETS_LENGTH;
    }

    /**
     * Gets not full family set.
     *
     * @return not full family set.
     */
    public double[] getNotFullFamilySet() {
        return this.notFullFamilySet;
    }

    /**
     * Gets full family set.
     *
     * @return not full family set.
     */
    public double[] getFullFamilySet() {
        return this.fullFamilySet;
    }
}
