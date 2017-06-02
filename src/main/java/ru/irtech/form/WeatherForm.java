package ru.irtech.form;

/**
 * @author Igor Bobko <limit-speed@yandex.ru>.
 */
public class WeatherForm {
    /**
     * Region.
     */
    private String region;
    /**
     * Year from.
     */
    private Integer yearFrom;
    /**
     * Month from.
     */
    private Integer monFrom;
    /**
     * Day from.
     */
    private Integer dayFrom;
    /**
     * Year to.
     */
    private Integer yearTo;
    /**
     * Month to.
     */
    private Integer monto;
    /**
     * Day to.
     */
    private Integer dayTo;

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

    public Integer getMonto() {
        return monto;
    }

    public void setMonto(final Integer monto) {
        this.monto = monto;
    }

    public Integer getDayTo() {
        return dayTo;
    }

    public void setDayTo(final Integer dayTo) {
        this.dayTo = dayTo;
    }
}
