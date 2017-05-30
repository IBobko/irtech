package ru.irtech.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;

/**
 * @author Igor Bobko <limit-speed@yandex.ru>.
 */
@Entity
@Table(name = "weather")
public class WeatherDomain implements Serializable {
    /**
     * Primary key.
     */
    private Integer id;
    /**
     * Region.
     */
    private String city;
    /**
     * JSON data.
     */
    private String weather;
    /**
     * Date.
     */
    private Timestamp date;
    /**
     * Daily summary.
     */
    private WeatherDailySummaryDomain weatherDailySummary;

    @OneToOne(cascade = CascadeType.REMOVE, mappedBy = "weatherDomain")
    @PrimaryKeyJoinColumn
    public WeatherDailySummaryDomain getWeatherDailySummary() {
        return weatherDailySummary;
    }

    public void setWeatherDailySummary(final WeatherDailySummaryDomain weatherDailySummary) {
        this.weatherDailySummary = weatherDailySummary;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq", sequenceName = "weather_id_seq", allocationSize = 1)
    @Column(name = "id", nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(final Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "city", nullable = false)
    public String getCity() {
        return city;
    }

    public void setCity(final String city) {
        this.city = city;
    }

    @Basic
    @Column(name = "weather", nullable = false, length = -1)
    public String getWeather() {
        return weather;
    }

    public void setWeather(final String weather) {
        this.weather = weather;
    }

    @Basic
    @Column(name = "date", nullable = false)
    public Timestamp getDate() {
        return date;
    }

    public void setDate(final Timestamp date) {
        this.date = date;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof WeatherDomain)) {
            return false;
        }
        WeatherDomain that = (WeatherDomain) o;
        return Objects.equals(getId(), that.getId())
                && Objects.equals(getCity(), that.getCity())
                && Objects.equals(getWeather(), that.getWeather())
                && Objects.equals(getDate(), that.getDate())
                && Objects.equals(getWeatherDailySummary(), that.getWeatherDailySummary());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getCity(), getWeather(), getDate(), getWeatherDailySummary());
    }
}
