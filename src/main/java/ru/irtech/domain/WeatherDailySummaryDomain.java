package ru.irtech.domain;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Objects;

/**
 * @author Igor Bobko <limit-speed@yandex.ru>.
 */
@Entity
@Table(name = "weather_daily_summary")
public class WeatherDailySummaryDomain implements Serializable {
    /**
     * id.
     */
    private Integer id;
    /**
     * data.
     */
    private String data;
    /**
     * date.
     */
    private Calendar date;
    /**
     * snowfallm.
     */
    private Double snowfallm;
    /**
     * snowfallm.
     */
    private Double precipi;
    /**
     * snowfallm.
     */
    private Double precipsource;
    /**
     * snowfallm.
     */
    private Double since1Julheatingdegreedays;
    /**
     * snowfallm.
     */
    private Double snowfalli;
    /**
     * snowfallm.
     */
    private Double precipm;
    /**
     * snowfallm.
     */
    private Double meantempm;
    /**
     * snowfallm.
     */
    private Double since1Julsnowfallm;
    /**
     * snowfallm.
     */
    private Double monthtodateheatingdegreedays;
    /**
     * snowfallm.
     */
    private Double thunder;
    /**
     * snowfallm.
     */
    private Double meantempi;
    /**
     * snowfallm.
     */
    private Double since1Julsnowfalli;
    /**
     * snowfallm.
     */
    private Double meanvisi;
    /**
     * snowfallm.
     */
    private Double since1Jancoolingdegreedaysnormal;
    /**
     * snowfallm.
     */
    private Double maxwspdi;
    /**
     * snowfallm.
     */
    private Double meanvism;
    /**
     * snowfallm.
     */
    private Double mintempm;
    /**
     * snowfallm.
     */
    private Double minhumidity;
    /**
     * snowfallm.
     */
    private Double mintempi;
    /**
     * snowfallm.
     */
    private Double humidity;
    /**
     * snowfallm.
     */
    private Double monthtodatecoolingdegreedaysnormal;
    /**
     * snowfallm.
     */
    private Double maxwspdm;
    /**
     * snowfallm.
     */
    private Double monthtodateheatingdegreedaysnormal;
    /**
     * snowfallm.
     */
    private Double rain;
    /**
     * snowfallm.
     */
    private Double gdegreedays;
    /**
     * snowfallm.
     */
    private Double since1Sepcoolingdegreedaysnormal;
    /**
     * snowfallm.
     */
    private Double monthtodatecoolingdegreedays;
    /**
     * snowfallm.
     */
    private Double since1Sepheatingdegreedaysnormal;
    /**
     * snowfallm.
     */
    private Double heatingdegreedaysnormal;
    /**
     * snowfallm.
     */

    private Double monthtodatesnowfalli;
    /**
     * snowfallm.
     */
    private Double mindewptm;
    /**
     * snowfallm.
     */
    private Double snow;
    /**
     * snowfallm.
     */
    private Double monthtodatesnowfallm;
    /**
     * snowfallm.
     */
    private Double mindewpti;
    /**
     * snowfallm.
     */
    private Double heatingdegreedays;
    /**
     * snowfallm.
     */
    private Double snowdepthm;
    /**
     * snowfallm.
     */
    private Double maxdewptm;
    /**
     * snowfallm.
     */
    private Double fog;
    /**
     * snowfallm.
     */
    private Double snowdepthi;
    /**
     * snowfallm.
     */
    private Double maxdewpti;
    /**
     * snowfallm.
     */
    private Double maxtempm;
    /**
     * snowfallm.
     */
    private Double minwspdi;
    /**
     * snowfallm.
     */
    private Double maxtempi;
    /**
     * snowfallm.
     */
    private Double since1Sepcoolingdegreedays;
    /**
     * snowfallm.
     */
    private Double meanpressurem;
    /**
     * snowfallm.
     */
    private Double minwspdm;
    /**
     * snowfallm.
     */
    private Double coolingdegreedaysnormal;
    /**
     * snowfallm.
     */
    private Double minpressurem;
    /**
     * snowfallm.
     */
    private Double minvisi;
    /**
     * snowfallm.
     */
    private Double tornado;
    /**
     * snowfallm.
     */

    private Double meandewpti;
    /**
     * snowfallm.
     */

    private Double maxhumidity;
    /**
     * snowfallm.
     */

    private Double minpressurei;
    /**
     * snowfallm.
     */

    private Double minvism;
    /**
     * snowfallm.
     */

    private Double meandewptm;
    /**
     * snowfallm.
     */

    private Double maxpressurem;
    /**
     * snowfallm.
     */

    private Double since1Jancoolingdegreedays;
    /**
     * snowfallm.
     */

    private Double hail;

    /**
     * snowfallm.
     */
    private Double meanwindspdm;
    /**
     * snowfallm.
     */

    private Double maxpressurei;
    /**
     * snowfallm.
     */

    private Double meanwdire;
    /**
     * snowfallm.
     */

    private Double since1Julheatingdegreedaysnormal;
    /**
     * snowfallm.
     */

    private Double meanwdird;
    /**
     * snowfallm.
     */

    private Double maxvism;
    /**
     * snowfallm.
     */

    private Double since1Sepheatingdegreedays;

    /**
     * snowfallm.
     */
    private Double meanwindspdi;
    /**
     * snowfallm.
     */

    private Double maxvisi;

    /**
     * snowfallm.
     */
    private Double meanpressurei;
    /**
     * snowfallm.
     */
    private Double coolingdegreedays;
    /**
     * snowfallm.
     */
    private WeatherDomain weatherDomain;

    @OneToOne(cascade = CascadeType.REMOVE)
    @PrimaryKeyJoinColumn
    public WeatherDomain getWeatherDomain() {
        return weatherDomain;
    }

    public void setWeatherDomain(final WeatherDomain weatherDomain) {
        this.weatherDomain = weatherDomain;
    }

    @Id
    @GeneratedValue(generator = "SharedPrimaryKeyGenerator")
    @GenericGenerator(name = "SharedPrimaryKeyGenerator", strategy = "foreign", parameters = @Parameter(name = "property", value = "weatherDomain"))
    @Column(name = "ID", unique = true, nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(final Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "data", nullable = true, length = -1)
    public String getData() {
        return data;
    }

    public void setData(final String data) {
        this.data = data;
    }

    @Basic
    @Column(name = "date", nullable = true)
    public Calendar getDate() {
        return date;
    }

    public void setDate(final Calendar date) {
        this.date = date;
    }

    @Basic
    @Column(name = "snowfallm", nullable = true, precision = 0)
    public Double getSnowfallm() {
        return snowfallm;
    }

    public void setSnowfallm(final Double snowfallm) {
        this.snowfallm = snowfallm;
    }

    @Basic
    @Column(name = "precipi", nullable = true, precision = 0)
    public Double getPrecipi() {
        return precipi;
    }

    public void setPrecipi(final Double precipi) {
        this.precipi = precipi;
    }

    @Basic
    @Column(name = "precipsource", nullable = true, precision = 0)
    public Double getPrecipsource() {
        return precipsource;
    }

    public void setPrecipsource(final Double precipsource) {
        this.precipsource = precipsource;
    }

    @Basic
    @Column(name = "since1julheatingdegreedays", nullable = true, precision = 0)
    public Double getSince1Julheatingdegreedays() {
        return since1Julheatingdegreedays;
    }

    public void setSince1Julheatingdegreedays(final Double since1Julheatingdegreedays) {
        this.since1Julheatingdegreedays = since1Julheatingdegreedays;
    }

    @Basic
    @Column(name = "snowfalli", nullable = true, precision = 0)
    public Double getSnowfalli() {
        return snowfalli;
    }

    public void setSnowfalli(final Double snowfalli) {
        this.snowfalli = snowfalli;
    }

    @Basic
    @Column(name = "precipm", nullable = true, precision = 0)
    public Double getPrecipm() {
        return precipm;
    }

    public void setPrecipm(final Double precipm) {
        this.precipm = precipm;
    }

    @Basic
    @Column(name = "meantempm", nullable = true, precision = 0)
    public Double getMeantempm() {
        return meantempm;
    }

    public void setMeantempm(final Double meantempm) {
        this.meantempm = meantempm;
    }

    @Basic
    @Column(name = "since1julsnowfallm", nullable = true, precision = 0)
    public Double getSince1Julsnowfallm() {
        return since1Julsnowfallm;
    }

    public void setSince1Julsnowfallm(final Double since1Julsnowfallm) {
        this.since1Julsnowfallm = since1Julsnowfallm;
    }

    @Basic
    @Column(name = "monthtodateheatingdegreedays", nullable = true, precision = 0)
    public Double getMonthtodateheatingdegreedays() {
        return monthtodateheatingdegreedays;
    }

    public void setMonthtodateheatingdegreedays(final Double monthtodateheatingdegreedays) {
        this.monthtodateheatingdegreedays = monthtodateheatingdegreedays;
    }

    @Basic
    @Column(name = "thunder", nullable = true, precision = 0)
    public Double getThunder() {
        return thunder;
    }

    public void setThunder(final Double thunder) {
        this.thunder = thunder;
    }

    @Basic
    @Column(name = "meantempi", nullable = true, precision = 0)
    public Double getMeantempi() {
        return meantempi;
    }

    public void setMeantempi(final Double meantempi) {
        this.meantempi = meantempi;
    }

    @Basic
    @Column(name = "since1julsnowfalli", nullable = true, precision = 0)
    public Double getSince1Julsnowfalli() {
        return since1Julsnowfalli;
    }

    public void setSince1Julsnowfalli(final Double since1Julsnowfalli) {
        this.since1Julsnowfalli = since1Julsnowfalli;
    }

    @Basic
    @Column(name = "meanvisi", nullable = true, precision = 0)
    public Double getMeanvisi() {
        return meanvisi;
    }

    public void setMeanvisi(final Double meanvisi) {
        this.meanvisi = meanvisi;
    }

    @Basic
    @Column(name = "since1jancoolingdegreedaysnormal", nullable = true, precision = 0)
    public Double getSince1Jancoolingdegreedaysnormal() {
        return since1Jancoolingdegreedaysnormal;
    }

    public void setSince1Jancoolingdegreedaysnormal(final Double since1Jancoolingdegreedaysnormal) {
        this.since1Jancoolingdegreedaysnormal = since1Jancoolingdegreedaysnormal;
    }

    @Basic
    @Column(name = "maxwspdi", nullable = true, precision = 0)
    public Double getMaxwspdi() {
        return maxwspdi;
    }

    public void setMaxwspdi(final Double maxwspdi) {
        this.maxwspdi = maxwspdi;
    }

    @Basic
    @Column(name = "meanvism", nullable = true, precision = 0)
    public Double getMeanvism() {
        return meanvism;
    }

    public void setMeanvism(final Double meanvism) {
        this.meanvism = meanvism;
    }

    @Basic
    @Column(name = "mintempm", nullable = true, precision = 0)
    public Double getMintempm() {
        return mintempm;
    }

    public void setMintempm(final Double mintempm) {
        this.mintempm = mintempm;
    }

    @Basic
    @Column(name = "minhumidity", nullable = true, precision = 0)
    public Double getMinhumidity() {
        return minhumidity;
    }

    public void setMinhumidity(final Double minhumidity) {
        this.minhumidity = minhumidity;
    }

    @Basic
    @Column(name = "mintempi", nullable = true, precision = 0)
    public Double getMintempi() {
        return mintempi;
    }

    public void setMintempi(final Double mintempi) {
        this.mintempi = mintempi;
    }

    @Basic
    @Column(name = "humidity", nullable = true, precision = 0)
    public Double getHumidity() {
        return humidity;
    }

    public void setHumidity(final Double humidity) {
        this.humidity = humidity;
    }

    @Basic
    @Column(name = "monthtodatecoolingdegreedaysnormal", nullable = true, precision = 0)
    public Double getMonthtodatecoolingdegreedaysnormal() {
        return monthtodatecoolingdegreedaysnormal;
    }

    public void setMonthtodatecoolingdegreedaysnormal(final Double monthtodatecoolingdegreedaysnormal) {
        this.monthtodatecoolingdegreedaysnormal = monthtodatecoolingdegreedaysnormal;
    }

    @Basic
    @Column(name = "maxwspdm", nullable = true, precision = 0)
    public Double getMaxwspdm() {
        return maxwspdm;
    }

    public void setMaxwspdm(final Double maxwspdm) {
        this.maxwspdm = maxwspdm;
    }

    @Basic
    @Column(name = "monthtodateheatingdegreedaysnormal", nullable = true, precision = 0)
    public Double getMonthtodateheatingdegreedaysnormal() {
        return monthtodateheatingdegreedaysnormal;
    }

    public void setMonthtodateheatingdegreedaysnormal(final Double monthtodateheatingdegreedaysnormal) {
        this.monthtodateheatingdegreedaysnormal = monthtodateheatingdegreedaysnormal;
    }

    @Basic
    @Column(name = "rain", nullable = true, precision = 0)
    public Double getRain() {
        return rain;
    }

    public void setRain(final Double rain) {
        this.rain = rain;
    }

    @Basic
    @Column(name = "gdegreedays", nullable = true, precision = 0)
    public Double getGdegreedays() {
        return gdegreedays;
    }

    public void setGdegreedays(final Double gdegreedays) {
        this.gdegreedays = gdegreedays;
    }

    @Basic
    @Column(name = "since1sepcoolingdegreedaysnormal", nullable = true, precision = 0)
    public Double getSince1Sepcoolingdegreedaysnormal() {
        return since1Sepcoolingdegreedaysnormal;
    }

    public void setSince1Sepcoolingdegreedaysnormal(final Double since1Sepcoolingdegreedaysnormal) {
        this.since1Sepcoolingdegreedaysnormal = since1Sepcoolingdegreedaysnormal;
    }

    @Basic
    @Column(name = "monthtodatecoolingdegreedays", nullable = true, precision = 0)
    public Double getMonthtodatecoolingdegreedays() {
        return monthtodatecoolingdegreedays;
    }

    public void setMonthtodatecoolingdegreedays(final Double monthtodatecoolingdegreedays) {
        this.monthtodatecoolingdegreedays = monthtodatecoolingdegreedays;
    }

    @Basic
    @Column(name = "since1sepheatingdegreedaysnormal", nullable = true, precision = 0)
    public Double getSince1Sepheatingdegreedaysnormal() {
        return since1Sepheatingdegreedaysnormal;
    }

    public void setSince1Sepheatingdegreedaysnormal(final Double since1Sepheatingdegreedaysnormal) {
        this.since1Sepheatingdegreedaysnormal = since1Sepheatingdegreedaysnormal;
    }

    @Basic
    @Column(name = "heatingdegreedaysnormal", nullable = true, precision = 0)
    public Double getHeatingdegreedaysnormal() {
        return heatingdegreedaysnormal;
    }

    public void setHeatingdegreedaysnormal(final Double heatingdegreedaysnormal) {
        this.heatingdegreedaysnormal = heatingdegreedaysnormal;
    }

    @Basic
    @Column(name = "monthtodatesnowfalli", nullable = true, precision = 0)
    public Double getMonthtodatesnowfalli() {
        return monthtodatesnowfalli;
    }

    public void setMonthtodatesnowfalli(final Double monthtodatesnowfalli) {
        this.monthtodatesnowfalli = monthtodatesnowfalli;
    }

    @Basic
    @Column(name = "mindewptm", nullable = true, precision = 0)
    public Double getMindewptm() {
        return mindewptm;
    }

    public void setMindewptm(final Double mindewptm) {
        this.mindewptm = mindewptm;
    }

    @Basic
    @Column(name = "snow", nullable = true, precision = 0)
    public Double getSnow() {
        return snow;
    }

    public void setSnow(final Double snow) {
        this.snow = snow;
    }

    @Basic
    @Column(name = "monthtodatesnowfallm", nullable = true, precision = 0)
    public Double getMonthtodatesnowfallm() {
        return monthtodatesnowfallm;
    }

    public void setMonthtodatesnowfallm(final Double monthtodatesnowfallm) {
        this.monthtodatesnowfallm = monthtodatesnowfallm;
    }

    @Basic
    @Column(name = "mindewpti", nullable = true, precision = 0)
    public Double getMindewpti() {
        return mindewpti;
    }

    public void setMindewpti(final Double mindewpti) {
        this.mindewpti = mindewpti;
    }

    @Basic
    @Column(name = "heatingdegreedays", nullable = true, precision = 0)
    public Double getHeatingdegreedays() {
        return heatingdegreedays;
    }

    public void setHeatingdegreedays(final Double heatingdegreedays) {
        this.heatingdegreedays = heatingdegreedays;
    }

    @Basic
    @Column(name = "snowdepthm", nullable = true, precision = 0)
    public Double getSnowdepthm() {
        return snowdepthm;
    }

    public void setSnowdepthm(final Double snowdepthm) {
        this.snowdepthm = snowdepthm;
    }

    @Basic
    @Column(name = "maxdewptm", nullable = true, precision = 0)
    public Double getMaxdewptm() {
        return maxdewptm;
    }

    public void setMaxdewptm(final Double maxdewptm) {
        this.maxdewptm = maxdewptm;
    }

    @Basic
    @Column(name = "fog", nullable = true, precision = 0)
    public Double getFog() {
        return fog;
    }

    public void setFog(final Double fog) {
        this.fog = fog;
    }

    @Basic
    @Column(name = "snowdepthi", nullable = true, precision = 0)
    public Double getSnowdepthi() {
        return snowdepthi;
    }

    public void setSnowdepthi(final Double snowdepthi) {
        this.snowdepthi = snowdepthi;
    }

    @Basic
    @Column(name = "maxdewpti", nullable = true, precision = 0)
    public Double getMaxdewpti() {
        return maxdewpti;
    }

    public void setMaxdewpti(final Double maxdewpti) {
        this.maxdewpti = maxdewpti;
    }

    @Basic
    @Column(name = "maxtempm", nullable = true, precision = 0)
    public Double getMaxtempm() {
        return maxtempm;
    }

    public void setMaxtempm(final Double maxtempm) {
        this.maxtempm = maxtempm;
    }

    @Basic
    @Column(name = "minwspdi", nullable = true, precision = 0)
    public Double getMinwspdi() {
        return minwspdi;
    }

    public void setMinwspdi(final Double minwspdi) {
        this.minwspdi = minwspdi;
    }

    @Basic
    @Column(name = "maxtempi", nullable = true, precision = 0)
    public Double getMaxtempi() {
        return maxtempi;
    }

    public void setMaxtempi(final Double maxtempi) {
        this.maxtempi = maxtempi;
    }

    @Basic
    @Column(name = "since1sepcoolingdegreedays", nullable = true, precision = 0)
    public Double getSince1Sepcoolingdegreedays() {
        return since1Sepcoolingdegreedays;
    }

    public void setSince1Sepcoolingdegreedays(final Double since1Sepcoolingdegreedays) {
        this.since1Sepcoolingdegreedays = since1Sepcoolingdegreedays;
    }

    @Basic
    @Column(name = "meanpressurem", nullable = true, precision = 0)
    public Double getMeanpressurem() {
        return meanpressurem;
    }

    public void setMeanpressurem(final Double meanpressurem) {
        this.meanpressurem = meanpressurem;
    }

    @Basic
    @Column(name = "minwspdm", nullable = true, precision = 0)
    public Double getMinwspdm() {
        return minwspdm;
    }

    public void setMinwspdm(final Double minwspdm) {
        this.minwspdm = minwspdm;
    }

    @Basic
    @Column(name = "coolingdegreedaysnormal", nullable = true, precision = 0)
    public Double getCoolingdegreedaysnormal() {
        return coolingdegreedaysnormal;
    }

    public void setCoolingdegreedaysnormal(final Double coolingdegreedaysnormal) {
        this.coolingdegreedaysnormal = coolingdegreedaysnormal;
    }

    @Basic
    @Column(name = "minpressurem", nullable = true, precision = 0)
    public Double getMinpressurem() {
        return minpressurem;
    }

    public void setMinpressurem(final Double minpressurem) {
        this.minpressurem = minpressurem;
    }

    @Basic
    @Column(name = "minvisi", nullable = true, precision = 0)
    public Double getMinvisi() {
        return minvisi;
    }

    public void setMinvisi(final Double minvisi) {
        this.minvisi = minvisi;
    }

    @Basic
    @Column(name = "tornado", nullable = true, precision = 0)
    public Double getTornado() {
        return tornado;
    }

    public void setTornado(final Double tornado) {
        this.tornado = tornado;
    }

    @Basic
    @Column(name = "meandewpti", nullable = true, precision = 0)
    public Double getMeandewpti() {
        return meandewpti;
    }

    public void setMeandewpti(final Double meandewpti) {
        this.meandewpti = meandewpti;
    }

    @Basic
    @Column(name = "maxhumidity", nullable = true, precision = 0)
    public Double getMaxhumidity() {
        return maxhumidity;
    }

    public void setMaxhumidity(final Double maxhumidity) {
        this.maxhumidity = maxhumidity;
    }

    @Basic
    @Column(name = "minpressurei", nullable = true, precision = 0)
    public Double getMinpressurei() {
        return minpressurei;
    }

    public void setMinpressurei(final Double minpressurei) {
        this.minpressurei = minpressurei;
    }

    @Basic
    @Column(name = "minvism", nullable = true, precision = 0)
    public Double getMinvism() {
        return minvism;
    }

    public void setMinvism(final Double minvism) {
        this.minvism = minvism;
    }

    @Basic
    @Column(name = "meandewptm", nullable = true, precision = 0)
    public Double getMeandewptm() {
        return meandewptm;
    }

    public void setMeandewptm(final Double meandewptm) {
        this.meandewptm = meandewptm;
    }

    @Basic
    @Column(name = "maxpressurem", nullable = true, precision = 0)
    public Double getMaxpressurem() {
        return maxpressurem;
    }

    public void setMaxpressurem(final Double maxpressurem) {
        this.maxpressurem = maxpressurem;
    }

    @Basic
    @Column(name = "since1jancoolingdegreedays", nullable = true, precision = 0)
    public Double getSince1Jancoolingdegreedays() {
        return since1Jancoolingdegreedays;
    }

    public void setSince1Jancoolingdegreedays(final Double since1Jancoolingdegreedays) {
        this.since1Jancoolingdegreedays = since1Jancoolingdegreedays;
    }

    @Basic
    @Column(name = "hail", nullable = true, precision = 0)
    public Double getHail() {
        return hail;
    }

    public void setHail(final Double hail) {
        this.hail = hail;
    }

    @Basic
    @Column(name = "meanwindspdm", nullable = true, precision = 0)
    public Double getMeanwindspdm() {
        return meanwindspdm;
    }

    public void setMeanwindspdm(final Double meanwindspdm) {
        this.meanwindspdm = meanwindspdm;
    }

    @Basic
    @Column(name = "maxpressurei", nullable = true, precision = 0)
    public Double getMaxpressurei() {
        return maxpressurei;
    }

    public void setMaxpressurei(final Double maxpressurei) {
        this.maxpressurei = maxpressurei;
    }

    @Basic
    @Column(name = "meanwdire", nullable = true, precision = 0)
    public Double getMeanwdire() {
        return meanwdire;
    }

    public void setMeanwdire(final Double meanwdire) {
        this.meanwdire = meanwdire;
    }

    @Basic
    @Column(name = "since1julheatingdegreedaysnormal", nullable = true, precision = 0)
    public Double getSince1Julheatingdegreedaysnormal() {
        return since1Julheatingdegreedaysnormal;
    }

    public void setSince1Julheatingdegreedaysnormal(final Double since1Julheatingdegreedaysnormal) {
        this.since1Julheatingdegreedaysnormal = since1Julheatingdegreedaysnormal;
    }

    @Basic
    @Column(name = "meanwdird", nullable = true, precision = 0)
    public Double getMeanwdird() {
        return meanwdird;
    }

    public void setMeanwdird(final Double meanwdird) {
        this.meanwdird = meanwdird;
    }

    @Basic
    @Column(name = "maxvism", nullable = true, precision = 0)
    public Double getMaxvism() {
        return maxvism;
    }

    public void setMaxvism(final Double maxvism) {
        this.maxvism = maxvism;
    }

    @Basic
    @Column(name = "since1sepheatingdegreedays", nullable = true, precision = 0)
    public Double getSince1Sepheatingdegreedays() {
        return since1Sepheatingdegreedays;
    }

    public void setSince1Sepheatingdegreedays(final Double since1Sepheatingdegreedays) {
        this.since1Sepheatingdegreedays = since1Sepheatingdegreedays;
    }

    @Basic
    @Column(name = "meanwindspdi", nullable = true, precision = 0)
    public Double getMeanwindspdi() {
        return meanwindspdi;
    }

    public void setMeanwindspdi(final Double meanwindspdi) {
        this.meanwindspdi = meanwindspdi;
    }

    @Basic
    @Column(name = "maxvisi", nullable = true, precision = 0)
    public Double getMaxvisi() {
        return maxvisi;
    }

    public void setMaxvisi(final Double maxvisi) {
        this.maxvisi = maxvisi;
    }

    @Basic
    @Column(name = "meanpressurei", nullable = true, precision = 0)
    public Double getMeanpressurei() {
        return meanpressurei;
    }

    public void setMeanpressurei(final Double meanpressurei) {
        this.meanpressurei = meanpressurei;
    }

    @Basic
    @Column(name = "coolingdegreedays", nullable = true, precision = 0)
    public Double getCoolingdegreedays() {
        return coolingdegreedays;
    }

    public void setCoolingdegreedays(final Double coolingdegreedays) {
        this.coolingdegreedays = coolingdegreedays;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof WeatherDailySummaryDomain)) {
            return false;
        }
        WeatherDailySummaryDomain that = (WeatherDailySummaryDomain) o;
        return Objects.equals(getId(), that.getId())
                && Objects.equals(getData(), that.getData())
                && Objects.equals(getDate(), that.getDate())
                && Objects.equals(getSnowfallm(), that.getSnowfallm())
                && Objects.equals(getPrecipi(), that.getPrecipi())
                && Objects.equals(getPrecipsource(), that.getPrecipsource())
                && Objects.equals(getSince1Julheatingdegreedays(), that.getSince1Julheatingdegreedays())
                && Objects.equals(getSnowfalli(), that.getSnowfalli())
                && Objects.equals(getPrecipm(), that.getPrecipm())
                && Objects.equals(getMeantempm(), that.getMeantempm())
                && Objects.equals(getSince1Julsnowfallm(), that.getSince1Julsnowfallm())
                && Objects.equals(getMonthtodateheatingdegreedays(), that.getMonthtodateheatingdegreedays())
                && Objects.equals(getThunder(), that.getThunder())
                && Objects.equals(getMeantempi(), that.getMeantempi())
                && Objects.equals(getSince1Julsnowfalli(), that.getSince1Julsnowfalli())
                && Objects.equals(getMeanvisi(), that.getMeanvisi())
                && Objects.equals(getSince1Jancoolingdegreedaysnormal(), that.getSince1Jancoolingdegreedaysnormal())
                && Objects.equals(getMaxwspdi(), that.getMaxwspdi())
                && Objects.equals(getMeanvism(), that.getMeanvism())
                && Objects.equals(getMintempm(), that.getMintempm())
                && Objects.equals(getMinhumidity(), that.getMinhumidity())
                && Objects.equals(getMintempi(), that.getMintempi())
                && Objects.equals(getHumidity(), that.getHumidity())
                && Objects.equals(getMonthtodatecoolingdegreedaysnormal(), that.getMonthtodatecoolingdegreedaysnormal())
                && Objects.equals(getMaxwspdm(), that.getMaxwspdm())
                && Objects.equals(getMonthtodateheatingdegreedaysnormal(), that.getMonthtodateheatingdegreedaysnormal())
                && Objects.equals(getRain(), that.getRain())
                && Objects.equals(getGdegreedays(), that.getGdegreedays())
                && Objects.equals(getSince1Sepcoolingdegreedaysnormal(), that.getSince1Sepcoolingdegreedaysnormal())
                && Objects.equals(getMonthtodatecoolingdegreedays(), that.getMonthtodatecoolingdegreedays())
                && Objects.equals(getSince1Sepheatingdegreedaysnormal(), that.getSince1Sepheatingdegreedaysnormal())
                && Objects.equals(getHeatingdegreedaysnormal(), that.getHeatingdegreedaysnormal())
                && Objects.equals(getMonthtodatesnowfalli(), that.getMonthtodatesnowfalli())
                && Objects.equals(getMindewptm(), that.getMindewptm())
                && Objects.equals(getSnow(), that.getSnow())
                && Objects.equals(getMonthtodatesnowfallm(), that.getMonthtodatesnowfallm())
                && Objects.equals(getMindewpti(), that.getMindewpti())
                && Objects.equals(getHeatingdegreedays(), that.getHeatingdegreedays())
                && Objects.equals(getSnowdepthm(), that.getSnowdepthm())
                && Objects.equals(getMaxdewptm(), that.getMaxdewptm())
                && Objects.equals(getFog(), that.getFog())
                && Objects.equals(getSnowdepthi(), that.getSnowdepthi())
                && Objects.equals(getMaxdewpti(), that.getMaxdewpti())
                && Objects.equals(getMaxtempm(), that.getMaxtempm())
                && Objects.equals(getMinwspdi(), that.getMinwspdi())
                && Objects.equals(getMaxtempi(), that.getMaxtempi())
                && Objects.equals(getSince1Sepcoolingdegreedays(), that.getSince1Sepcoolingdegreedays())
                && Objects.equals(getMeanpressurem(), that.getMeanpressurem())
                && Objects.equals(getMinwspdm(), that.getMinwspdm())
                && Objects.equals(getCoolingdegreedaysnormal(), that.getCoolingdegreedaysnormal())
                && Objects.equals(getMinpressurem(), that.getMinpressurem())
                && Objects.equals(getMinvisi(), that.getMinvisi())
                && Objects.equals(getTornado(), that.getTornado())
                && Objects.equals(getMeandewpti(), that.getMeandewpti())
                && Objects.equals(getMaxhumidity(), that.getMaxhumidity())
                && Objects.equals(getMinpressurei(), that.getMinpressurei())
                && Objects.equals(getMinvism(), that.getMinvism())
                && Objects.equals(getMeandewptm(), that.getMeandewptm())
                && Objects.equals(getMaxpressurem(), that.getMaxpressurem())
                && Objects.equals(getSince1Jancoolingdegreedays(), that.getSince1Jancoolingdegreedays())
                && Objects.equals(getHail(), that.getHail())
                && Objects.equals(getMeanwindspdm(), that.getMeanwindspdm())
                && Objects.equals(getMaxpressurei(), that.getMaxpressurei())
                && Objects.equals(getMeanwdire(), that.getMeanwdire())
                && Objects.equals(getSince1Julheatingdegreedaysnormal(), that.getSince1Julheatingdegreedaysnormal())
                && Objects.equals(getMeanwdird(), that.getMeanwdird())
                && Objects.equals(getMaxvism(), that.getMaxvism())
                && Objects.equals(getSince1Sepheatingdegreedays(), that.getSince1Sepheatingdegreedays())
                && Objects.equals(getMeanwindspdi(), that.getMeanwindspdi())
                && Objects.equals(getMaxvisi(), that.getMaxvisi())
                && Objects.equals(getMeanpressurei(), that.getMeanpressurei())
                && Objects.equals(getCoolingdegreedays(), that.getCoolingdegreedays())
                && Objects.equals(getWeatherDomain(), that.getWeatherDomain());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getData(), getDate(), getSnowfallm(), getPrecipi(), getPrecipsource(), getSince1Julheatingdegreedays(), getSnowfalli(), getPrecipm(), getMeantempm(), getSince1Julsnowfallm(), getMonthtodateheatingdegreedays(), getThunder(), getMeantempi(), getSince1Julsnowfalli(), getMeanvisi(), getSince1Jancoolingdegreedaysnormal(), getMaxwspdi(), getMeanvism(), getMintempm(), getMinhumidity(), getMintempi(), getHumidity(), getMonthtodatecoolingdegreedaysnormal(), getMaxwspdm(), getMonthtodateheatingdegreedaysnormal(), getRain(), getGdegreedays(), getSince1Sepcoolingdegreedaysnormal(), getMonthtodatecoolingdegreedays(), getSince1Sepheatingdegreedaysnormal(), getHeatingdegreedaysnormal(), getMonthtodatesnowfalli(), getMindewptm(), getSnow(), getMonthtodatesnowfallm(), getMindewpti(), getHeatingdegreedays(), getSnowdepthm(), getMaxdewptm(), getFog(), getSnowdepthi(), getMaxdewpti(), getMaxtempm(), getMinwspdi(), getMaxtempi(), getSince1Sepcoolingdegreedays(), getMeanpressurem(), getMinwspdm(), getCoolingdegreedaysnormal(), getMinpressurem(), getMinvisi(), getTornado(), getMeandewpti(), getMaxhumidity(), getMinpressurei(), getMinvism(), getMeandewptm(), getMaxpressurem(), getSince1Jancoolingdegreedays(), getHail(), getMeanwindspdm(), getMaxpressurei(), getMeanwdire(), getSince1Julheatingdegreedaysnormal(), getMeanwdird(), getMaxvism(), getSince1Sepheatingdegreedays(), getMeanwindspdi(), getMaxvisi(), getMeanpressurei(), getCoolingdegreedays(), getWeatherDomain());
    }
}
