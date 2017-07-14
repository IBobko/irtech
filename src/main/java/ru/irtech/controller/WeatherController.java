package ru.irtech.controller;


import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.irtech.domain.WeatherDomain;
import ru.irtech.form.WeatherForm;
import ru.irtech.service.WeatherService;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
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
     * Service for working with weather.
     */
    private WeatherService weatherService;

    private WeatherService getWeatherService() {
        return weatherService;
    }

    @Autowired
    public void setWeatherService(final WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @PersistenceContext
    EntityManager entityManager;
    /**
     * Index method.
     *
     * @return response.
     */
    @RequestMapping(value="", method = RequestMethod.GET)
    public String index(Model model)
    {
        if (!model.containsAttribute("filterForm")) {
            model.addAttribute("filterForm", new WeatherForm());
        }
        return "weather/index";
    }

    @RequestMapping(value = "",method = RequestMethod.POST)
    @ResponseBody
    public void index_post(final HttpServletResponse response, final HttpServletRequest request, @Validated final WeatherForm filterForm, final BindingResult bindingResult, final Model model) throws IOException {
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
                    if (counter1 >= 10) {
                        Thread.sleep(1000);
                        counter1 = 0;
                    }
                    if (counter2 == 599) {
                        return;
                    }
                    wetherDomain = getWeatherService().getWeatherByDateAndRegion(fromCalendar, filterForm.getRegion());
                    weatherDomainSet.add(wetherDomain);
                    fromCalendar.setTimeInMillis(fromCalendar.getTimeInMillis() + (1000 * 60 * 60 * 24));
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

    @RequestMapping("/stat")
    @ResponseBody
    public List stat() {
        Query query = entityManager.createNativeQuery("\n" +
                "    SELECT wds.*,iar.* FROM weather w\n" +
                "    JOIN weather_daily_summary wds ON w.id = wds.id\n" +
                "    JOIN irtech_avg_results iar ON CAST(iar.donedate as DATE) = CAST (w.date AS DATE)\n" +
                "    WHERE city = 'RU/Temryuk'");

        return query.getResultList();

    }
    @RequestMapping("/chart")
    public String weather_chart() {
        return "weather/chart";
    }
    @RequestMapping("/data.tsv")
    @ResponseBody
    public String a() {
        return "letter\tfrequency\n" +
                "A\t.08167\n" +
                "B\t.01492\n" +
                "C\t.02780\n" +
                "D\t.04253\n" +
                "E\t.12702\n" +
                "F\t.02288\n" +
                "G\t.02022\n" +
                "H\t.06094\n" +
                "I\t.06973\n" +
                "J\t.00153\n" +
                "K\t.00747\n" +
                "L\t.04025\n" +
                "M\t.02517\n" +
                "N\t.06749\n" +
                "O\t.07507\n" +
                "P\t.01929\n" +
                "Q\t.00098\n" +
                "R\t.05987\n" +
                "S\t.06333\n" +
                "T\t.09056\n" +
                "U\t.02758\n" +
                "V\t.01037\n" +
                "W\t.02465\n" +
                "X\t.00150\n" +
                "Y\t.01971\n" +
                "Z\t.00074";
    }


}
