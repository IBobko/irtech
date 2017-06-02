package ru.irtech.form;

/**
 * @author Igor Bobko <limit-speed@yandex.ru>.
 */
public class WeatherForm {
    private String region;
    private Integer year_from;
    private Integer mon_from;
    private Integer day_from;

    private Integer year_to;
    private Integer mon_to;
    private Integer day_to;

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public Integer getYear_from() {
        return year_from;
    }

    public void setYear_from(Integer year_from) {
        this.year_from = year_from;
    }

    public Integer getMon_from() {
        return mon_from;
    }

    public void setMon_from(Integer mon_from) {
        this.mon_from = mon_from;
    }

    public Integer getDay_from() {
        return day_from;
    }

    public void setDay_from(Integer day_from) {
        this.day_from = day_from;
    }

    public Integer getYear_to() {
        return year_to;
    }

    public void setYear_to(Integer year_to) {
        this.year_to = year_to;
    }

    public Integer getMon_to() {
        return mon_to;
    }

    public void setMon_to(Integer mon_to) {
        this.mon_to = mon_to;
    }

    public Integer getDay_to() {
        return day_to;
    }

    public void setDay_to(Integer day_to) {
        this.day_to = day_to;
    }
}
