package ru.irtech.form;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Created by igor on 15.07.17.
 */
public class ChartForWeatherForm {
    /**
     * Data to.
     */
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Calendar dtpTo = new GregorianCalendar(2016, 0, 1);
    /**
     * Data from.
     */
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Calendar dtpFrom = new GregorianCalendar(2015, 0, 1);
    /**
     * School.
     */
    private Integer school = 953;
    /**
     * School.
     */
    private Integer city = 1626;

    public ChartForWeatherForm() {

    }

    public Integer getCity() {
        return city;
    }

    public void setCity(Integer city) {
        this.city = city;
    }

    public Calendar getDtpTo() {
        return dtpTo;
    }

    public void setDtpTo(final Calendar dtpTo) {
        this.dtpTo = dtpTo;
    }

    public Calendar getDtpFrom() {
        return dtpFrom;
    }

    public void setDtpFrom(final Calendar dtpFrom) {
        this.dtpFrom = dtpFrom;
    }

    public Integer getSchool() {
        return school;
    }

    public void setSchool(final Integer school) {
        this.school = school;
    }

}
