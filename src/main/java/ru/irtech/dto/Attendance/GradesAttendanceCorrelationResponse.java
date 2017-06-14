package ru.irtech.dto.Attendance;

import ru.irtech.dto.ControllerResponse;

/**
 * Created by Iggytoto on 14.06.2017.
 * <p>
 * Transport object to represent correlation between mean grade and class skip count.
 */
public class GradesAttendanceCorrelationResponse extends ControllerResponse {

    /**
     * Correlation value;
     */
    private final double correlation;

    /**
     * C-tor.
     *
     * @param correlation correlation.
     */
    public GradesAttendanceCorrelationResponse(final double correlation) {
        super(OK_MESSAGE);
        this.correlation = correlation;
    }

    /**
     * gets the correlation.
     *
     * @return correlation value.
     */
    public double getCorrelation() {
        return correlation;
    }
}
