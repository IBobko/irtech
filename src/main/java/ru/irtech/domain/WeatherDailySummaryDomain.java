package ru.irtech.domain;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Calendar;

/**
 * @author Igor Bobko <limit-speed@yandex.ru>.
 */
@Entity
@Table(name = "weather_daily_summary")
public class WeatherDailySummaryDomain implements Serializable {
    private Integer id;
    private String data;
    private Calendar date;
    private Double snowfallm;
    private Double precipi;
    private Double precipsource;
    private Double since1Julheatingdegreedays;
    private Double snowfalli;
    private Double precipm;
    private Double meantempm;
    private Double since1Julsnowfallm;
    private Double monthtodateheatingdegreedays;
    private Double thunder;
    private Double meantempi;
    private Double since1Julsnowfalli;
    private Double meanvisi;
    private Double since1Jancoolingdegreedaysnormal;
    private Double maxwspdi;
    private Double meanvism;
    private Double mintempm;
    private Double minhumidity;
    private Double mintempi;
    private Double humidity;
    private Double monthtodatecoolingdegreedaysnormal;
    private Double maxwspdm;
    private Double monthtodateheatingdegreedaysnormal;
    private Double rain;
    private Double gdegreedays;
    private Double since1Sepcoolingdegreedaysnormal;
    private Double monthtodatecoolingdegreedays;
    private Double since1Sepheatingdegreedaysnormal;
    private Double heatingdegreedaysnormal;
    private Double monthtodatesnowfalli;
    private Double mindewptm;
    private Double snow;
    private Double monthtodatesnowfallm;
    private Double mindewpti;
    private Double heatingdegreedays;
    private Double snowdepthm;
    private Double maxdewptm;
    private Double fog;
    private Double snowdepthi;
    private Double maxdewpti;
    private Double maxtempm;
    private Double minwspdi;
    private Double maxtempi;
    private Double since1Sepcoolingdegreedays;
    private Double meanpressurem;
    private Double minwspdm;
    private Double coolingdegreedaysnormal;
    private Double minpressurem;
    private Double minvisi;
    private Double tornado;
    private Double meandewpti;
    private Double maxhumidity;
    private Double minpressurei;
    private Double minvism;
    private Double meandewptm;
    private Double maxpressurem;
    private Double since1Jancoolingdegreedays;
    private Double hail;
    private Double meanwindspdm;
    private Double maxpressurei;
    private Double meanwdire;
    private Double since1Julheatingdegreedaysnormal;
    private Double meanwdird;
    private Double maxvism;
    private Double since1Sepheatingdegreedays;
    private Double meanwindspdi;
    private Double maxvisi;
    private Double meanpressurei;
    private Double coolingdegreedays;
    private WeatherDomain weatherDomain;

    @OneToOne(cascade = CascadeType.REMOVE)
    @PrimaryKeyJoinColumn
    public WeatherDomain getWeatherDomain() {
        return weatherDomain;
    }

    public void setWeatherDomain(WeatherDomain weatherDomain) {
        this.weatherDomain = weatherDomain;
    }

    @Id
    @GeneratedValue(generator = "SharedPrimaryKeyGenerator")
    @GenericGenerator(name = "SharedPrimaryKeyGenerator", strategy = "foreign", parameters = @Parameter(name = "property", value = "weatherDomain"))
    @Column(name = "ID", unique = true, nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "data", nullable = true, length = -1)
    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Basic
    @Column(name = "date", nullable = true)
    public Calendar getDate() {
        return date;
    }

    public void setDate(Calendar date) {
        this.date = date;
    }

    @Basic
    @Column(name = "snowfallm", nullable = true, precision = 0)
    public Double getSnowfallm() {
        return snowfallm;
    }

    public void setSnowfallm(Double snowfallm) {
        this.snowfallm = snowfallm;
    }

    @Basic
    @Column(name = "precipi", nullable = true, precision = 0)
    public Double getPrecipi() {
        return precipi;
    }

    public void setPrecipi(Double precipi) {
        this.precipi = precipi;
    }

    @Basic
    @Column(name = "precipsource", nullable = true, precision = 0)
    public Double getPrecipsource() {
        return precipsource;
    }

    public void setPrecipsource(Double precipsource) {
        this.precipsource = precipsource;
    }

    @Basic
    @Column(name = "since1julheatingdegreedays", nullable = true, precision = 0)
    public Double getSince1Julheatingdegreedays() {
        return since1Julheatingdegreedays;
    }

    public void setSince1Julheatingdegreedays(Double since1Julheatingdegreedays) {
        this.since1Julheatingdegreedays = since1Julheatingdegreedays;
    }

    @Basic
    @Column(name = "snowfalli", nullable = true, precision = 0)
    public Double getSnowfalli() {
        return snowfalli;
    }

    public void setSnowfalli(Double snowfalli) {
        this.snowfalli = snowfalli;
    }

    @Basic
    @Column(name = "precipm", nullable = true, precision = 0)
    public Double getPrecipm() {
        return precipm;
    }

    public void setPrecipm(Double precipm) {
        this.precipm = precipm;
    }

    @Basic
    @Column(name = "meantempm", nullable = true, precision = 0)
    public Double getMeantempm() {
        return meantempm;
    }

    public void setMeantempm(Double meantempm) {
        this.meantempm = meantempm;
    }

    @Basic
    @Column(name = "since1julsnowfallm", nullable = true, precision = 0)
    public Double getSince1Julsnowfallm() {
        return since1Julsnowfallm;
    }

    public void setSince1Julsnowfallm(Double since1Julsnowfallm) {
        this.since1Julsnowfallm = since1Julsnowfallm;
    }

    @Basic
    @Column(name = "monthtodateheatingdegreedays", nullable = true, precision = 0)
    public Double getMonthtodateheatingdegreedays() {
        return monthtodateheatingdegreedays;
    }

    public void setMonthtodateheatingdegreedays(Double monthtodateheatingdegreedays) {
        this.monthtodateheatingdegreedays = monthtodateheatingdegreedays;
    }

    @Basic
    @Column(name = "thunder", nullable = true, precision = 0)
    public Double getThunder() {
        return thunder;
    }

    public void setThunder(Double thunder) {
        this.thunder = thunder;
    }

    @Basic
    @Column(name = "meantempi", nullable = true, precision = 0)
    public Double getMeantempi() {
        return meantempi;
    }

    public void setMeantempi(Double meantempi) {
        this.meantempi = meantempi;
    }

    @Basic
    @Column(name = "since1julsnowfalli", nullable = true, precision = 0)
    public Double getSince1Julsnowfalli() {
        return since1Julsnowfalli;
    }

    public void setSince1Julsnowfalli(Double since1Julsnowfalli) {
        this.since1Julsnowfalli = since1Julsnowfalli;
    }

    @Basic
    @Column(name = "meanvisi", nullable = true, precision = 0)
    public Double getMeanvisi() {
        return meanvisi;
    }

    public void setMeanvisi(Double meanvisi) {
        this.meanvisi = meanvisi;
    }

    @Basic
    @Column(name = "since1jancoolingdegreedaysnormal", nullable = true, precision = 0)
    public Double getSince1Jancoolingdegreedaysnormal() {
        return since1Jancoolingdegreedaysnormal;
    }

    public void setSince1Jancoolingdegreedaysnormal(Double since1Jancoolingdegreedaysnormal) {
        this.since1Jancoolingdegreedaysnormal = since1Jancoolingdegreedaysnormal;
    }

    @Basic
    @Column(name = "maxwspdi", nullable = true, precision = 0)
    public Double getMaxwspdi() {
        return maxwspdi;
    }

    public void setMaxwspdi(Double maxwspdi) {
        this.maxwspdi = maxwspdi;
    }

    @Basic
    @Column(name = "meanvism", nullable = true, precision = 0)
    public Double getMeanvism() {
        return meanvism;
    }

    public void setMeanvism(Double meanvism) {
        this.meanvism = meanvism;
    }

    @Basic
    @Column(name = "mintempm", nullable = true, precision = 0)
    public Double getMintempm() {
        return mintempm;
    }

    public void setMintempm(Double mintempm) {
        this.mintempm = mintempm;
    }

    @Basic
    @Column(name = "minhumidity", nullable = true, precision = 0)
    public Double getMinhumidity() {
        return minhumidity;
    }

    public void setMinhumidity(Double minhumidity) {
        this.minhumidity = minhumidity;
    }

    @Basic
    @Column(name = "mintempi", nullable = true, precision = 0)
    public Double getMintempi() {
        return mintempi;
    }

    public void setMintempi(Double mintempi) {
        this.mintempi = mintempi;
    }

    @Basic
    @Column(name = "humidity", nullable = true, precision = 0)
    public Double getHumidity() {
        return humidity;
    }

    public void setHumidity(Double humidity) {
        this.humidity = humidity;
    }

    @Basic
    @Column(name = "monthtodatecoolingdegreedaysnormal", nullable = true, precision = 0)
    public Double getMonthtodatecoolingdegreedaysnormal() {
        return monthtodatecoolingdegreedaysnormal;
    }

    public void setMonthtodatecoolingdegreedaysnormal(Double monthtodatecoolingdegreedaysnormal) {
        this.monthtodatecoolingdegreedaysnormal = monthtodatecoolingdegreedaysnormal;
    }

    @Basic
    @Column(name = "maxwspdm", nullable = true, precision = 0)
    public Double getMaxwspdm() {
        return maxwspdm;
    }

    public void setMaxwspdm(Double maxwspdm) {
        this.maxwspdm = maxwspdm;
    }

    @Basic
    @Column(name = "monthtodateheatingdegreedaysnormal", nullable = true, precision = 0)
    public Double getMonthtodateheatingdegreedaysnormal() {
        return monthtodateheatingdegreedaysnormal;
    }

    public void setMonthtodateheatingdegreedaysnormal(Double monthtodateheatingdegreedaysnormal) {
        this.monthtodateheatingdegreedaysnormal = monthtodateheatingdegreedaysnormal;
    }

    @Basic
    @Column(name = "rain", nullable = true, precision = 0)
    public Double getRain() {
        return rain;
    }

    public void setRain(Double rain) {
        this.rain = rain;
    }

    @Basic
    @Column(name = "gdegreedays", nullable = true, precision = 0)
    public Double getGdegreedays() {
        return gdegreedays;
    }

    public void setGdegreedays(Double gdegreedays) {
        this.gdegreedays = gdegreedays;
    }

    @Basic
    @Column(name = "since1sepcoolingdegreedaysnormal", nullable = true, precision = 0)
    public Double getSince1Sepcoolingdegreedaysnormal() {
        return since1Sepcoolingdegreedaysnormal;
    }

    public void setSince1Sepcoolingdegreedaysnormal(Double since1Sepcoolingdegreedaysnormal) {
        this.since1Sepcoolingdegreedaysnormal = since1Sepcoolingdegreedaysnormal;
    }

    @Basic
    @Column(name = "monthtodatecoolingdegreedays", nullable = true, precision = 0)
    public Double getMonthtodatecoolingdegreedays() {
        return monthtodatecoolingdegreedays;
    }

    public void setMonthtodatecoolingdegreedays(Double monthtodatecoolingdegreedays) {
        this.monthtodatecoolingdegreedays = monthtodatecoolingdegreedays;
    }

    @Basic
    @Column(name = "since1sepheatingdegreedaysnormal", nullable = true, precision = 0)
    public Double getSince1Sepheatingdegreedaysnormal() {
        return since1Sepheatingdegreedaysnormal;
    }

    public void setSince1Sepheatingdegreedaysnormal(Double since1Sepheatingdegreedaysnormal) {
        this.since1Sepheatingdegreedaysnormal = since1Sepheatingdegreedaysnormal;
    }

    @Basic
    @Column(name = "heatingdegreedaysnormal", nullable = true, precision = 0)
    public Double getHeatingdegreedaysnormal() {
        return heatingdegreedaysnormal;
    }

    public void setHeatingdegreedaysnormal(Double heatingdegreedaysnormal) {
        this.heatingdegreedaysnormal = heatingdegreedaysnormal;
    }

    @Basic
    @Column(name = "monthtodatesnowfalli", nullable = true, precision = 0)
    public Double getMonthtodatesnowfalli() {
        return monthtodatesnowfalli;
    }

    public void setMonthtodatesnowfalli(Double monthtodatesnowfalli) {
        this.monthtodatesnowfalli = monthtodatesnowfalli;
    }

    @Basic
    @Column(name = "mindewptm", nullable = true, precision = 0)
    public Double getMindewptm() {
        return mindewptm;
    }

    public void setMindewptm(Double mindewptm) {
        this.mindewptm = mindewptm;
    }

    @Basic
    @Column(name = "snow", nullable = true, precision = 0)
    public Double getSnow() {
        return snow;
    }

    public void setSnow(Double snow) {
        this.snow = snow;
    }

    @Basic
    @Column(name = "monthtodatesnowfallm", nullable = true, precision = 0)
    public Double getMonthtodatesnowfallm() {
        return monthtodatesnowfallm;
    }

    public void setMonthtodatesnowfallm(Double monthtodatesnowfallm) {
        this.monthtodatesnowfallm = monthtodatesnowfallm;
    }

    @Basic
    @Column(name = "mindewpti", nullable = true, precision = 0)
    public Double getMindewpti() {
        return mindewpti;
    }

    public void setMindewpti(Double mindewpti) {
        this.mindewpti = mindewpti;
    }

    @Basic
    @Column(name = "heatingdegreedays", nullable = true, precision = 0)
    public Double getHeatingdegreedays() {
        return heatingdegreedays;
    }

    public void setHeatingdegreedays(Double heatingdegreedays) {
        this.heatingdegreedays = heatingdegreedays;
    }

    @Basic
    @Column(name = "snowdepthm", nullable = true, precision = 0)
    public Double getSnowdepthm() {
        return snowdepthm;
    }

    public void setSnowdepthm(Double snowdepthm) {
        this.snowdepthm = snowdepthm;
    }

    @Basic
    @Column(name = "maxdewptm", nullable = true, precision = 0)
    public Double getMaxdewptm() {
        return maxdewptm;
    }

    public void setMaxdewptm(Double maxdewptm) {
        this.maxdewptm = maxdewptm;
    }

    @Basic
    @Column(name = "fog", nullable = true, precision = 0)
    public Double getFog() {
        return fog;
    }

    public void setFog(Double fog) {
        this.fog = fog;
    }

    @Basic
    @Column(name = "snowdepthi", nullable = true, precision = 0)
    public Double getSnowdepthi() {
        return snowdepthi;
    }

    public void setSnowdepthi(Double snowdepthi) {
        this.snowdepthi = snowdepthi;
    }

    @Basic
    @Column(name = "maxdewpti", nullable = true, precision = 0)
    public Double getMaxdewpti() {
        return maxdewpti;
    }

    public void setMaxdewpti(Double maxdewpti) {
        this.maxdewpti = maxdewpti;
    }

    @Basic
    @Column(name = "maxtempm", nullable = true, precision = 0)
    public Double getMaxtempm() {
        return maxtempm;
    }

    public void setMaxtempm(Double maxtempm) {
        this.maxtempm = maxtempm;
    }

    @Basic
    @Column(name = "minwspdi", nullable = true, precision = 0)
    public Double getMinwspdi() {
        return minwspdi;
    }

    public void setMinwspdi(Double minwspdi) {
        this.minwspdi = minwspdi;
    }

    @Basic
    @Column(name = "maxtempi", nullable = true, precision = 0)
    public Double getMaxtempi() {
        return maxtempi;
    }

    public void setMaxtempi(Double maxtempi) {
        this.maxtempi = maxtempi;
    }

    @Basic
    @Column(name = "since1sepcoolingdegreedays", nullable = true, precision = 0)
    public Double getSince1Sepcoolingdegreedays() {
        return since1Sepcoolingdegreedays;
    }

    public void setSince1Sepcoolingdegreedays(Double since1Sepcoolingdegreedays) {
        this.since1Sepcoolingdegreedays = since1Sepcoolingdegreedays;
    }

    @Basic
    @Column(name = "meanpressurem", nullable = true, precision = 0)
    public Double getMeanpressurem() {
        return meanpressurem;
    }

    public void setMeanpressurem(Double meanpressurem) {
        this.meanpressurem = meanpressurem;
    }

    @Basic
    @Column(name = "minwspdm", nullable = true, precision = 0)
    public Double getMinwspdm() {
        return minwspdm;
    }

    public void setMinwspdm(Double minwspdm) {
        this.minwspdm = minwspdm;
    }

    @Basic
    @Column(name = "coolingdegreedaysnormal", nullable = true, precision = 0)
    public Double getCoolingdegreedaysnormal() {
        return coolingdegreedaysnormal;
    }

    public void setCoolingdegreedaysnormal(Double coolingdegreedaysnormal) {
        this.coolingdegreedaysnormal = coolingdegreedaysnormal;
    }

    @Basic
    @Column(name = "minpressurem", nullable = true, precision = 0)
    public Double getMinpressurem() {
        return minpressurem;
    }

    public void setMinpressurem(Double minpressurem) {
        this.minpressurem = minpressurem;
    }

    @Basic
    @Column(name = "minvisi", nullable = true, precision = 0)
    public Double getMinvisi() {
        return minvisi;
    }

    public void setMinvisi(Double minvisi) {
        this.minvisi = minvisi;
    }

    @Basic
    @Column(name = "tornado", nullable = true, precision = 0)
    public Double getTornado() {
        return tornado;
    }

    public void setTornado(Double tornado) {
        this.tornado = tornado;
    }

    @Basic
    @Column(name = "meandewpti", nullable = true, precision = 0)
    public Double getMeandewpti() {
        return meandewpti;
    }

    public void setMeandewpti(Double meandewpti) {
        this.meandewpti = meandewpti;
    }

    @Basic
    @Column(name = "maxhumidity", nullable = true, precision = 0)
    public Double getMaxhumidity() {
        return maxhumidity;
    }

    public void setMaxhumidity(Double maxhumidity) {
        this.maxhumidity = maxhumidity;
    }

    @Basic
    @Column(name = "minpressurei", nullable = true, precision = 0)
    public Double getMinpressurei() {
        return minpressurei;
    }

    public void setMinpressurei(Double minpressurei) {
        this.minpressurei = minpressurei;
    }

    @Basic
    @Column(name = "minvism", nullable = true, precision = 0)
    public Double getMinvism() {
        return minvism;
    }

    public void setMinvism(Double minvism) {
        this.minvism = minvism;
    }

    @Basic
    @Column(name = "meandewptm", nullable = true, precision = 0)
    public Double getMeandewptm() {
        return meandewptm;
    }

    public void setMeandewptm(Double meandewptm) {
        this.meandewptm = meandewptm;
    }

    @Basic
    @Column(name = "maxpressurem", nullable = true, precision = 0)
    public Double getMaxpressurem() {
        return maxpressurem;
    }

    public void setMaxpressurem(Double maxpressurem) {
        this.maxpressurem = maxpressurem;
    }

    @Basic
    @Column(name = "since1jancoolingdegreedays", nullable = true, precision = 0)
    public Double getSince1Jancoolingdegreedays() {
        return since1Jancoolingdegreedays;
    }

    public void setSince1Jancoolingdegreedays(Double since1Jancoolingdegreedays) {
        this.since1Jancoolingdegreedays = since1Jancoolingdegreedays;
    }

    @Basic
    @Column(name = "hail", nullable = true, precision = 0)
    public Double getHail() {
        return hail;
    }

    public void setHail(Double hail) {
        this.hail = hail;
    }

    @Basic
    @Column(name = "meanwindspdm", nullable = true, precision = 0)
    public Double getMeanwindspdm() {
        return meanwindspdm;
    }

    public void setMeanwindspdm(Double meanwindspdm) {
        this.meanwindspdm = meanwindspdm;
    }

    @Basic
    @Column(name = "maxpressurei", nullable = true, precision = 0)
    public Double getMaxpressurei() {
        return maxpressurei;
    }

    public void setMaxpressurei(Double maxpressurei) {
        this.maxpressurei = maxpressurei;
    }

    @Basic
    @Column(name = "meanwdire", nullable = true, precision = 0)
    public Double getMeanwdire() {
        return meanwdire;
    }

    public void setMeanwdire(Double meanwdire) {
        this.meanwdire = meanwdire;
    }

    @Basic
    @Column(name = "since1julheatingdegreedaysnormal", nullable = true, precision = 0)
    public Double getSince1Julheatingdegreedaysnormal() {
        return since1Julheatingdegreedaysnormal;
    }

    public void setSince1Julheatingdegreedaysnormal(Double since1Julheatingdegreedaysnormal) {
        this.since1Julheatingdegreedaysnormal = since1Julheatingdegreedaysnormal;
    }

    @Basic
    @Column(name = "meanwdird", nullable = true, precision = 0)
    public Double getMeanwdird() {
        return meanwdird;
    }

    public void setMeanwdird(Double meanwdird) {
        this.meanwdird = meanwdird;
    }

    @Basic
    @Column(name = "maxvism", nullable = true, precision = 0)
    public Double getMaxvism() {
        return maxvism;
    }

    public void setMaxvism(Double maxvism) {
        this.maxvism = maxvism;
    }

    @Basic
    @Column(name = "since1sepheatingdegreedays", nullable = true, precision = 0)
    public Double getSince1Sepheatingdegreedays() {
        return since1Sepheatingdegreedays;
    }

    public void setSince1Sepheatingdegreedays(Double since1Sepheatingdegreedays) {
        this.since1Sepheatingdegreedays = since1Sepheatingdegreedays;
    }

    @Basic
    @Column(name = "meanwindspdi", nullable = true, precision = 0)
    public Double getMeanwindspdi() {
        return meanwindspdi;
    }

    public void setMeanwindspdi(Double meanwindspdi) {
        this.meanwindspdi = meanwindspdi;
    }

    @Basic
    @Column(name = "maxvisi", nullable = true, precision = 0)
    public Double getMaxvisi() {
        return maxvisi;
    }

    public void setMaxvisi(Double maxvisi) {
        this.maxvisi = maxvisi;
    }

    @Basic
    @Column(name = "meanpressurei", nullable = true, precision = 0)
    public Double getMeanpressurei() {
        return meanpressurei;
    }

    public void setMeanpressurei(Double meanpressurei) {
        this.meanpressurei = meanpressurei;
    }

    @Basic
    @Column(name = "coolingdegreedays", nullable = true, precision = 0)
    public Double getCoolingdegreedays() {
        return coolingdegreedays;
    }

    public void setCoolingdegreedays(Double coolingdegreedays) {
        this.coolingdegreedays = coolingdegreedays;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        WeatherDailySummaryDomain that = (WeatherDailySummaryDomain) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (data != null ? !data.equals(that.data) : that.data != null) return false;
        if (date != null ? !date.equals(that.date) : that.date != null) return false;
        if (snowfallm != null ? !snowfallm.equals(that.snowfallm) : that.snowfallm != null) return false;
        if (precipi != null ? !precipi.equals(that.precipi) : that.precipi != null) return false;
        if (precipsource != null ? !precipsource.equals(that.precipsource) : that.precipsource != null) return false;
        if (since1Julheatingdegreedays != null ? !since1Julheatingdegreedays.equals(that.since1Julheatingdegreedays) : that.since1Julheatingdegreedays != null)
            return false;
        if (snowfalli != null ? !snowfalli.equals(that.snowfalli) : that.snowfalli != null) return false;
        if (precipm != null ? !precipm.equals(that.precipm) : that.precipm != null) return false;
        if (meantempm != null ? !meantempm.equals(that.meantempm) : that.meantempm != null) return false;
        if (since1Julsnowfallm != null ? !since1Julsnowfallm.equals(that.since1Julsnowfallm) : that.since1Julsnowfallm != null)
            return false;
        if (monthtodateheatingdegreedays != null ? !monthtodateheatingdegreedays.equals(that.monthtodateheatingdegreedays) : that.monthtodateheatingdegreedays != null)
            return false;
        if (thunder != null ? !thunder.equals(that.thunder) : that.thunder != null) return false;
        if (meantempi != null ? !meantempi.equals(that.meantempi) : that.meantempi != null) return false;
        if (since1Julsnowfalli != null ? !since1Julsnowfalli.equals(that.since1Julsnowfalli) : that.since1Julsnowfalli != null)
            return false;
        if (meanvisi != null ? !meanvisi.equals(that.meanvisi) : that.meanvisi != null) return false;
        if (since1Jancoolingdegreedaysnormal != null ? !since1Jancoolingdegreedaysnormal.equals(that.since1Jancoolingdegreedaysnormal) : that.since1Jancoolingdegreedaysnormal != null)
            return false;
        if (maxwspdi != null ? !maxwspdi.equals(that.maxwspdi) : that.maxwspdi != null) return false;
        if (meanvism != null ? !meanvism.equals(that.meanvism) : that.meanvism != null) return false;
        if (mintempm != null ? !mintempm.equals(that.mintempm) : that.mintempm != null) return false;
        if (minhumidity != null ? !minhumidity.equals(that.minhumidity) : that.minhumidity != null) return false;
        if (mintempi != null ? !mintempi.equals(that.mintempi) : that.mintempi != null) return false;
        if (humidity != null ? !humidity.equals(that.humidity) : that.humidity != null) return false;
        if (monthtodatecoolingdegreedaysnormal != null ? !monthtodatecoolingdegreedaysnormal.equals(that.monthtodatecoolingdegreedaysnormal) : that.monthtodatecoolingdegreedaysnormal != null)
            return false;
        if (maxwspdm != null ? !maxwspdm.equals(that.maxwspdm) : that.maxwspdm != null) return false;
        if (monthtodateheatingdegreedaysnormal != null ? !monthtodateheatingdegreedaysnormal.equals(that.monthtodateheatingdegreedaysnormal) : that.monthtodateheatingdegreedaysnormal != null)
            return false;
        if (rain != null ? !rain.equals(that.rain) : that.rain != null) return false;
        if (gdegreedays != null ? !gdegreedays.equals(that.gdegreedays) : that.gdegreedays != null) return false;
        if (since1Sepcoolingdegreedaysnormal != null ? !since1Sepcoolingdegreedaysnormal.equals(that.since1Sepcoolingdegreedaysnormal) : that.since1Sepcoolingdegreedaysnormal != null)
            return false;
        if (monthtodatecoolingdegreedays != null ? !monthtodatecoolingdegreedays.equals(that.monthtodatecoolingdegreedays) : that.monthtodatecoolingdegreedays != null)
            return false;
        if (since1Sepheatingdegreedaysnormal != null ? !since1Sepheatingdegreedaysnormal.equals(that.since1Sepheatingdegreedaysnormal) : that.since1Sepheatingdegreedaysnormal != null)
            return false;
        if (heatingdegreedaysnormal != null ? !heatingdegreedaysnormal.equals(that.heatingdegreedaysnormal) : that.heatingdegreedaysnormal != null)
            return false;
        if (monthtodatesnowfalli != null ? !monthtodatesnowfalli.equals(that.monthtodatesnowfalli) : that.monthtodatesnowfalli != null)
            return false;
        if (mindewptm != null ? !mindewptm.equals(that.mindewptm) : that.mindewptm != null) return false;
        if (snow != null ? !snow.equals(that.snow) : that.snow != null) return false;
        if (monthtodatesnowfallm != null ? !monthtodatesnowfallm.equals(that.monthtodatesnowfallm) : that.monthtodatesnowfallm != null)
            return false;
        if (mindewpti != null ? !mindewpti.equals(that.mindewpti) : that.mindewpti != null) return false;
        if (heatingdegreedays != null ? !heatingdegreedays.equals(that.heatingdegreedays) : that.heatingdegreedays != null)
            return false;
        if (snowdepthm != null ? !snowdepthm.equals(that.snowdepthm) : that.snowdepthm != null) return false;
        if (maxdewptm != null ? !maxdewptm.equals(that.maxdewptm) : that.maxdewptm != null) return false;
        if (fog != null ? !fog.equals(that.fog) : that.fog != null) return false;
        if (snowdepthi != null ? !snowdepthi.equals(that.snowdepthi) : that.snowdepthi != null) return false;
        if (maxdewpti != null ? !maxdewpti.equals(that.maxdewpti) : that.maxdewpti != null) return false;
        if (maxtempm != null ? !maxtempm.equals(that.maxtempm) : that.maxtempm != null) return false;
        if (minwspdi != null ? !minwspdi.equals(that.minwspdi) : that.minwspdi != null) return false;
        if (maxtempi != null ? !maxtempi.equals(that.maxtempi) : that.maxtempi != null) return false;
        if (since1Sepcoolingdegreedays != null ? !since1Sepcoolingdegreedays.equals(that.since1Sepcoolingdegreedays) : that.since1Sepcoolingdegreedays != null)
            return false;
        if (meanpressurem != null ? !meanpressurem.equals(that.meanpressurem) : that.meanpressurem != null)
            return false;
        if (minwspdm != null ? !minwspdm.equals(that.minwspdm) : that.minwspdm != null) return false;
        if (coolingdegreedaysnormal != null ? !coolingdegreedaysnormal.equals(that.coolingdegreedaysnormal) : that.coolingdegreedaysnormal != null)
            return false;
        if (minpressurem != null ? !minpressurem.equals(that.minpressurem) : that.minpressurem != null) return false;
        if (minvisi != null ? !minvisi.equals(that.minvisi) : that.minvisi != null) return false;
        if (tornado != null ? !tornado.equals(that.tornado) : that.tornado != null) return false;
        if (meandewpti != null ? !meandewpti.equals(that.meandewpti) : that.meandewpti != null) return false;
        if (maxhumidity != null ? !maxhumidity.equals(that.maxhumidity) : that.maxhumidity != null) return false;
        if (minpressurei != null ? !minpressurei.equals(that.minpressurei) : that.minpressurei != null) return false;
        if (minvism != null ? !minvism.equals(that.minvism) : that.minvism != null) return false;
        if (meandewptm != null ? !meandewptm.equals(that.meandewptm) : that.meandewptm != null) return false;
        if (maxpressurem != null ? !maxpressurem.equals(that.maxpressurem) : that.maxpressurem != null) return false;
        if (since1Jancoolingdegreedays != null ? !since1Jancoolingdegreedays.equals(that.since1Jancoolingdegreedays) : that.since1Jancoolingdegreedays != null)
            return false;
        if (hail != null ? !hail.equals(that.hail) : that.hail != null) return false;
        if (meanwindspdm != null ? !meanwindspdm.equals(that.meanwindspdm) : that.meanwindspdm != null) return false;
        if (maxpressurei != null ? !maxpressurei.equals(that.maxpressurei) : that.maxpressurei != null) return false;
        if (meanwdire != null ? !meanwdire.equals(that.meanwdire) : that.meanwdire != null) return false;
        if (since1Julheatingdegreedaysnormal != null ? !since1Julheatingdegreedaysnormal.equals(that.since1Julheatingdegreedaysnormal) : that.since1Julheatingdegreedaysnormal != null)
            return false;
        if (meanwdird != null ? !meanwdird.equals(that.meanwdird) : that.meanwdird != null) return false;
        if (maxvism != null ? !maxvism.equals(that.maxvism) : that.maxvism != null) return false;
        if (since1Sepheatingdegreedays != null ? !since1Sepheatingdegreedays.equals(that.since1Sepheatingdegreedays) : that.since1Sepheatingdegreedays != null)
            return false;
        if (meanwindspdi != null ? !meanwindspdi.equals(that.meanwindspdi) : that.meanwindspdi != null) return false;
        if (maxvisi != null ? !maxvisi.equals(that.maxvisi) : that.maxvisi != null) return false;
        if (meanpressurei != null ? !meanpressurei.equals(that.meanpressurei) : that.meanpressurei != null)
            return false;
        if (coolingdegreedays != null ? !coolingdegreedays.equals(that.coolingdegreedays) : that.coolingdegreedays != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (data != null ? data.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (snowfallm != null ? snowfallm.hashCode() : 0);
        result = 31 * result + (precipi != null ? precipi.hashCode() : 0);
        result = 31 * result + (precipsource != null ? precipsource.hashCode() : 0);
        result = 31 * result + (since1Julheatingdegreedays != null ? since1Julheatingdegreedays.hashCode() : 0);
        result = 31 * result + (snowfalli != null ? snowfalli.hashCode() : 0);
        result = 31 * result + (precipm != null ? precipm.hashCode() : 0);
        result = 31 * result + (meantempm != null ? meantempm.hashCode() : 0);
        result = 31 * result + (since1Julsnowfallm != null ? since1Julsnowfallm.hashCode() : 0);
        result = 31 * result + (monthtodateheatingdegreedays != null ? monthtodateheatingdegreedays.hashCode() : 0);
        result = 31 * result + (thunder != null ? thunder.hashCode() : 0);
        result = 31 * result + (meantempi != null ? meantempi.hashCode() : 0);
        result = 31 * result + (since1Julsnowfalli != null ? since1Julsnowfalli.hashCode() : 0);
        result = 31 * result + (meanvisi != null ? meanvisi.hashCode() : 0);
        result = 31 * result + (since1Jancoolingdegreedaysnormal != null ? since1Jancoolingdegreedaysnormal.hashCode() : 0);
        result = 31 * result + (maxwspdi != null ? maxwspdi.hashCode() : 0);
        result = 31 * result + (meanvism != null ? meanvism.hashCode() : 0);
        result = 31 * result + (mintempm != null ? mintempm.hashCode() : 0);
        result = 31 * result + (minhumidity != null ? minhumidity.hashCode() : 0);
        result = 31 * result + (mintempi != null ? mintempi.hashCode() : 0);
        result = 31 * result + (humidity != null ? humidity.hashCode() : 0);
        result = 31 * result + (monthtodatecoolingdegreedaysnormal != null ? monthtodatecoolingdegreedaysnormal.hashCode() : 0);
        result = 31 * result + (maxwspdm != null ? maxwspdm.hashCode() : 0);
        result = 31 * result + (monthtodateheatingdegreedaysnormal != null ? monthtodateheatingdegreedaysnormal.hashCode() : 0);
        result = 31 * result + (rain != null ? rain.hashCode() : 0);
        result = 31 * result + (gdegreedays != null ? gdegreedays.hashCode() : 0);
        result = 31 * result + (since1Sepcoolingdegreedaysnormal != null ? since1Sepcoolingdegreedaysnormal.hashCode() : 0);
        result = 31 * result + (monthtodatecoolingdegreedays != null ? monthtodatecoolingdegreedays.hashCode() : 0);
        result = 31 * result + (since1Sepheatingdegreedaysnormal != null ? since1Sepheatingdegreedaysnormal.hashCode() : 0);
        result = 31 * result + (heatingdegreedaysnormal != null ? heatingdegreedaysnormal.hashCode() : 0);
        result = 31 * result + (monthtodatesnowfalli != null ? monthtodatesnowfalli.hashCode() : 0);
        result = 31 * result + (mindewptm != null ? mindewptm.hashCode() : 0);
        result = 31 * result + (snow != null ? snow.hashCode() : 0);
        result = 31 * result + (monthtodatesnowfallm != null ? monthtodatesnowfallm.hashCode() : 0);
        result = 31 * result + (mindewpti != null ? mindewpti.hashCode() : 0);
        result = 31 * result + (heatingdegreedays != null ? heatingdegreedays.hashCode() : 0);
        result = 31 * result + (snowdepthm != null ? snowdepthm.hashCode() : 0);
        result = 31 * result + (maxdewptm != null ? maxdewptm.hashCode() : 0);
        result = 31 * result + (fog != null ? fog.hashCode() : 0);
        result = 31 * result + (snowdepthi != null ? snowdepthi.hashCode() : 0);
        result = 31 * result + (maxdewpti != null ? maxdewpti.hashCode() : 0);
        result = 31 * result + (maxtempm != null ? maxtempm.hashCode() : 0);
        result = 31 * result + (minwspdi != null ? minwspdi.hashCode() : 0);
        result = 31 * result + (maxtempi != null ? maxtempi.hashCode() : 0);
        result = 31 * result + (since1Sepcoolingdegreedays != null ? since1Sepcoolingdegreedays.hashCode() : 0);
        result = 31 * result + (meanpressurem != null ? meanpressurem.hashCode() : 0);
        result = 31 * result + (minwspdm != null ? minwspdm.hashCode() : 0);
        result = 31 * result + (coolingdegreedaysnormal != null ? coolingdegreedaysnormal.hashCode() : 0);
        result = 31 * result + (minpressurem != null ? minpressurem.hashCode() : 0);
        result = 31 * result + (minvisi != null ? minvisi.hashCode() : 0);
        result = 31 * result + (tornado != null ? tornado.hashCode() : 0);
        result = 31 * result + (meandewpti != null ? meandewpti.hashCode() : 0);
        result = 31 * result + (maxhumidity != null ? maxhumidity.hashCode() : 0);
        result = 31 * result + (minpressurei != null ? minpressurei.hashCode() : 0);
        result = 31 * result + (minvism != null ? minvism.hashCode() : 0);
        result = 31 * result + (meandewptm != null ? meandewptm.hashCode() : 0);
        result = 31 * result + (maxpressurem != null ? maxpressurem.hashCode() : 0);
        result = 31 * result + (since1Jancoolingdegreedays != null ? since1Jancoolingdegreedays.hashCode() : 0);
        result = 31 * result + (hail != null ? hail.hashCode() : 0);
        result = 31 * result + (meanwindspdm != null ? meanwindspdm.hashCode() : 0);
        result = 31 * result + (maxpressurei != null ? maxpressurei.hashCode() : 0);
        result = 31 * result + (meanwdire != null ? meanwdire.hashCode() : 0);
        result = 31 * result + (since1Julheatingdegreedaysnormal != null ? since1Julheatingdegreedaysnormal.hashCode() : 0);
        result = 31 * result + (meanwdird != null ? meanwdird.hashCode() : 0);
        result = 31 * result + (maxvism != null ? maxvism.hashCode() : 0);
        result = 31 * result + (since1Sepheatingdegreedays != null ? since1Sepheatingdegreedays.hashCode() : 0);
        result = 31 * result + (meanwindspdi != null ? meanwindspdi.hashCode() : 0);
        result = 31 * result + (maxvisi != null ? maxvisi.hashCode() : 0);
        result = 31 * result + (meanpressurei != null ? meanpressurei.hashCode() : 0);
        result = 31 * result + (coolingdegreedays != null ? coolingdegreedays.hashCode() : 0);
        return result;
    }
}
