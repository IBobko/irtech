package ru.irtech.dto;

/**
 * Created by Iggytoto on 29.04.2017.
 * Class represents result for UI graphical representation of correlation between family status and mean grades of the
 * student.
 */
public class FamilyStatusToGradesCorrelationResponse extends ControllerResponse {
    /**
     * Correlation value by term grades.
     */
    private final double termsCorrelation;

    /**
     * Correlation alue by yearly grades.
     */
    private final double yearlyCorrelation;

    /**
     * Main C-tor.
     *
     * @param termsValue  term grades correlation.
     * @param yearlyValue yearly grades correlation.
     */
    public FamilyStatusToGradesCorrelationResponse(final double termsValue, final double yearlyValue) {
        super(OK_MESSAGE);
        termsCorrelation = termsValue;
        yearlyCorrelation = yearlyValue;
    }

    /**
     * Returns terms correlation value.
     *
     * @return terns correlation vlaue.
     */
    public double getTermsCorrelation() {
        return this.termsCorrelation;
    }

    /**
     * Returns yearly correlation value.
     *
     * @return yearly correlation value.
     */
    public double getYearlyCorrelation() {
        return this.yearlyCorrelation;
    }
}
