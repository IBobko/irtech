package ru.irtech.dto;

/**
 * Created by Iggytoto on 29.04.2017.
 * Class represents result for UI graphical representation of correlation between family status and mean grades of the
 * student
 */
public class FamiltyToGradesCorrelationResponse extends ControllerResponse{
    /**
     * Correlation value by term grades
     */
    private final double termsCorrelation;

    /**
     * Correlation alue by yearly grades
     */
    private final double yearlyCorrelation;

    /**
     * Main C-tor
     *
     * @param termsValue  term grades correlation
     * @param yearlyValue yearly grades correlation
     */
    public FamiltyToGradesCorrelationResponse(double termsValue, double yearlyValue) {
        super("OK");
        termsCorrelation = termsValue;
        yearlyCorrelation = yearlyValue;
    }

    /**
     * Returns terms correlation value
     *
     * @return
     */
    public double getTermsCorrelation() {
        return this.termsCorrelation;
    }

    /**
     * Returns yearly correlation value
     *
     * @return
     */
    public double getYearlyCorrelation() {
        return this.yearlyCorrelation;
    }
}
