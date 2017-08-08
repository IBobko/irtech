package ru.irtech.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.irtech.domain.WeatherDomain;
import ru.irtech.form.ChartForWeatherForm;
import ru.irtech.form.WeatherForm;
import ru.irtech.service.WeatherService;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


/*
    snowfallm
    precipi
    precipsource
    since1julheatingdegreedays
    snowfalli
    precipm
    meantempm
    since1julsnowfallm
    monthtodateheatingdegreedays
    thunder
    meantempi
    since1julsnowfalli
    meanvisi
    since1jancoolingdegreedaysnormal
    maxwspdi
    meanvism
    mintempm
    minhumidity
    mintempi
    humidity
    monthtodatecoolingdegreedaysnormal
    maxwspdm
    monthtodateheatingdegreedaysnormal
    rain
    gdegreedays
    since1sepcoolingdegreedaysnormal
    monthtodatecoolingdegreedays
    since1sepheatingdegreedaysnormal
    heatingdegreedaysnormal
    monthtodatesnowfalli
    mindewptm
    snow
    monthtodatesnowfallm
    mindewpti
    heatingdegreedays
    snowdepthm
    maxdewptm
    fog
    snowdepthi
    maxdewpti
    maxtempm
    minwspdi
    maxtempi
    since1sepcoolingdegreedays
    meanpressurem
    minwspdm
    coolingdegreedaysnormal
    minpressurem
    minvisi
    tornado
    meandewpti
    maxhumidity
    minpressurei
    minvism
    meandewptm
    maxpressurem
    since1jancoolingdegreedays
    hail
    meanwindspdm
    maxpressurei
    meanwdire
    since1julheatingdegreedaysnormal
    meanwdird
    maxvism
    since1sepheatingdegreedays
    meanwindspdi
    maxvisi
    meanpressurei
    coolingdegreedays
*/


/**
 * @author Igor Bobko <limit-speed@yandex.ru>.
 */
@Controller
@RequestMapping("/weather")
public class WeatherController {
    /**
     * Allowed requests per minute.
     */
    private static final Integer REQUESTS_PER_MINUTE = 10;

    /**
     * One day.
     */
    private static final Integer MILLISECONDS_IN_ONE_DAY = 1000 * 60 * 60 * 24;

    /**
     * 1 second.
     */
    private static final Integer SLEEP_TIME = 1000;
    /**
     * Allowed requests per day.
     */
    private static final Integer REQUESTS_PER_DAY = 600;
    /**
     * Object for working with db.
     */
    @PersistenceContext
    private EntityManager entityManager;
    /**
     * Service for working with weather.
     */
    private WeatherService weatherService;

    private WeatherService getWeatherService() {
        return weatherService;
    }

    /**
     * Weather service.
     *
     * @param weatherService Injected realization.
     */
    @Autowired
    public void setWeatherService(final WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    /**
     * Index method.
     *
     * @param model stores attributes of page.
     * @return response.
     */
    @RequestMapping(value = "", method = RequestMethod.GET)
    public String index(final Model model) {
        if (!model.containsAttribute("filterForm")) {
            model.addAttribute("filterForm", new WeatherForm());
        }
        return "weather/index";
    }

    /**
     * Performs post request about weather.
     *
     * @param response      response.
     * @param filterForm    form.
     * @param bindingResult validator.
     * @param model         stores attributes of page.
     * @throws IOException in some cases:)
     */
    @RequestMapping(value = "", method = RequestMethod.POST)
    @ResponseBody
    public void indexPost(final HttpServletResponse response, @Validated final WeatherForm filterForm, final BindingResult bindingResult, final Model model) throws IOException {
        if (!bindingResult.hasErrors()) {
            final Calendar fromCalendar = new GregorianCalendar();
            fromCalendar.setTimeInMillis(0);
            fromCalendar.set(Calendar.YEAR, filterForm.getYearFrom());
            fromCalendar.set(Calendar.MONTH, filterForm.getMonFrom() - 1);
            fromCalendar.set(Calendar.DAY_OF_MONTH, filterForm.getDayFrom());
            final Calendar toCalendar = new GregorianCalendar();
            toCalendar.setTimeInMillis(0);
            toCalendar.set(Calendar.YEAR, filterForm.getYearTo());
            toCalendar.set(Calendar.MONTH, filterForm.getMonTo() - 1);
            toCalendar.set(Calendar.DAY_OF_MONTH, filterForm.getDayTo());

            final Set<WeatherDomain> weatherDomainSet = new HashSet<>();

            int counter1 = 0;
            int counter2 = 0;


            while (fromCalendar.compareTo(toCalendar) < 0) {
                response.getWriter().println(fromCalendar.toString() + "<br/>");
                WeatherDomain wetherDomain;
                try {
                    if (counter1 >= REQUESTS_PER_MINUTE) {
                        Thread.sleep(SLEEP_TIME);
                        counter1 = 0;
                    }
                    if (counter2 >= REQUESTS_PER_DAY) {
                        return;
                    }
                    wetherDomain = getWeatherService().getWeatherByDateAndRegion(fromCalendar, filterForm.getRegion());
                    weatherDomainSet.add(wetherDomain);
                    fromCalendar.setTimeInMillis(fromCalendar.getTimeInMillis() + (MILLISECONDS_IN_ONE_DAY));
                    counter1++;
                    counter2++;
                } catch (Exception e) {
                    model.addAttribute("errors", e);
                    break;
                }
            }
            model.addAttribute("weathers", weatherDomainSet);
        }
    }

    /**
     * Page with weather chart.
     *
     * @param model Stores attributes.
     * @param request request.
     * @param form Form with data.
     * @return Template name.
     */
    @RequestMapping("/chart")
    public String chart(final Model model, final HttpServletRequest request, final ChartForWeatherForm form) {
        final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        final Query query = entityManager.createNativeQuery("\n"
                + "    SELECT schoolid FROM irtech_avg_results w\n"
                + "    GROUP BY schoolid");
        final List<Integer> results = query.getResultList();
        final List<String> sc = new ArrayList<>();
        for (final Integer o: results) {
            sc.add(o.toString());
        }

        HashMap<Integer, String> cities = new HashMap<>();
        cities.put(1626, "Темрюк");

        model.addAttribute("cities", cities);
        model.addAttribute("schools", sc);
        model.addAttribute("school", form.getSchool());
        model.addAttribute("dtpFrom", sdf.format(form.getDtpFrom().getTime()));
        model.addAttribute("dtpTo", sdf.format(form.getDtpTo().getTime()));
        return "weather/chart";
    }

    /**
     * The method generates data for chart.
     * @param request .
     * @param form Form with data.
     * @return The data for chart.
     * @throws ParseException .
     */
    @SuppressWarnings("unchecked")
    @ResponseBody
    @RequestMapping("/data.tsv")
    public String data(final HttpServletRequest request, final ChartForWeatherForm form) throws ParseException {
        final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        final String dateFromStr = sdf.format(form.getDtpFrom().getTime());
        final String dateToStr = sdf.format(form.getDtpTo().getTime());

        String school = "";
        if (form.getSchool() != null && !form.getSchool().equals(0)) {
            school = " AND iar.schoolid = " + form.getSchool();
        }
        String city = "";
        if (form.getCity() != null && !form.getCity().equals(0)) {
            school = " AND iar.cityid = " + form.getCity();
        }

        final Query query = entityManager.createNativeQuery("\n"
                + "    SELECT AVG(iar.avg_result),meantempm FROM weather w\n"
                + "    JOIN weather_daily_summary wds ON w.id = wds.id\n"
                + "    JOIN irtech_avg_results iar ON CAST(iar.donedate AS DATE) = CAST (w.date AS DATE)\n"
                + "    WHERE CAST(iar.donedate AS DATE) BETWEEN '" + dateFromStr + "' AND '" + dateToStr + "' AND city = 'RU/Temryuk' " + school + city + " GROUP BY meantempm ORDER BY meantempm");

        final List<Object[]> results = query.getResultList();
        StringBuilder r = new StringBuilder("letter\tfrequency\n");
        for (Object[] u : results) {
            final BigDecimal grade = (BigDecimal) u[0];
            r.append(u[1].toString()).append("\t").append(grade.setScale(0, BigDecimal.ROUND_HALF_UP)).append("\n");
        }
        return r.toString();
    }


}
