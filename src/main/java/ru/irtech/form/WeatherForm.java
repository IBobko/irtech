package ru.irtech.form;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * @author Igor Bobko <limit-speed@yandex.ru>.
 */
public class WeatherForm {
    /**
     * Minimum allowed year.
     */
    private static final int MIN_YEAR = 2000;

    /**
     * Maximal allowed year.
     */
    private static final int MAX_YEAR = 2017;

    /**
     * Minimal allowed month.
     */
    private static final int MIN_MONTH = 1;

    /**
     * Maximal allowed month.
     */
    private static final int MAX_MONTH = 12;

    /**
     * Minimal allowed day.
     */
    private static final int MIN_DAY = 1;

    /**
     * Maximal allowed day.
     */
    private static final int MAX_DAY = 31;

    /**
     * Region. /todo предоставить list regions.
     */
    @NotNull
    private String region = "RU/Moscow";
    /**
     * Starting year which must be no less WeatherForm.MIN_YEAR and no more WeatherForm.MAX_YEAR.
     */
    @NotNull
    @Min(value = MIN_YEAR)
    @Max(value = MAX_YEAR)
    private Integer yearFrom = MAX_YEAR;
    /**
     * Starting month from which must be no less 1 and no more 12.
     */
    @NotNull
    @Min(value = MIN_MONTH)
    @Max(value = MAX_MONTH)
    private Integer monFrom = MIN_MONTH;
    /**
     * Starting day which must be no less 1 and no more 31.
     */
    @NotNull
    @Min(value = MIN_DAY)
    @Max(value = MAX_DAY)
    private Integer dayFrom = MIN_DAY;
    /**
     * Finishing year which must be no less 2000 and no more than the current year.
     */
    @NotNull
    @Min(value = MIN_YEAR)
    @Max(value = MAX_YEAR)
    private Integer yearTo = MAX_YEAR;
    /**
     * Finishing month from which must be no less 1 and no more 12.
     */
    @NotNull
    @Min(value = MIN_MONTH)
    @Max(value = MAX_MONTH)
    private Integer monTo = MIN_MONTH;
    /**
     * Finishing day from which must be no less 1 and no more 31.
     */
    @NotNull
    @Min(value = MIN_DAY)
    @Max(value = MAX_DAY)
    private Integer dayTo = MIN_DAY;

    public String getRegion() {
        return region;
    }

    public void setRegion(final String region) {
        this.region = region;
    }

    public Integer getYearFrom() {
        return yearFrom;
    }

    public void setYearFrom(final Integer yearFrom) {
        this.yearFrom = yearFrom;
    }

    public Integer getMonFrom() {
        return monFrom;
    }

    public void setMonFrom(final Integer monFrom) {
        this.monFrom = monFrom;
    }

    public Integer getDayFrom() {
        return dayFrom;
    }

    public void setDayFrom(final Integer dayFrom) {
        this.dayFrom = dayFrom;
    }

    public Integer getYearTo() {
        return yearTo;
    }

    public void setYearTo(final Integer yearTo) {
        this.yearTo = yearTo;
    }

    public Integer getMonTo() {
        return monTo;
    }

    public void setMonTo(final Integer monTo) {
        this.monTo = monTo;
    }

    public Integer getDayTo() {
        return dayTo;
    }

    public void setDayTo(final Integer dayTo) {
        this.dayTo = dayTo;
    }
}
