package ru.irtech.dto.Attendance;

import ru.irtech.dto.ControllerResponse;

/**
 * Created by Iggytoto on 14.06.2017.
 *
 * Transport object for percentages of who was skipping classes.
 */
public class GradesAttendanceTableResponse extends ControllerResponse {

    /**
     * sets length.
     */
    private static final int SETS_LENGTH = 3;

    /**
     * Set that represents class skips percentages.
     * [0] -   percent of 1000-800 skips of all students.
     * [1] -   percent of 799-500 skips of all students.
     * [2] -   percent of <500 skips of all students.
     */
    private final double[] skipsPercentages;

    /**
     * Main c-tor.
     *
     * @param skipsPercentages
     */
    public GradesAttendanceTableResponse(double[] skipsPercentages) {
        super(OK_MESSAGE);
        this.skipsPercentages = skipsPercentages;
    }

    /**
     * gets percentages.
     *
     * @return array of percentages.
     */
    public double[] getSkipsPercentages() {
        return skipsPercentages;
    }
}
