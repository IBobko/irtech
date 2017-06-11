package ru.irtech.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.irtech.domain.WeatherDomain;
import ru.irtech.form.WeatherForm;
import ru.irtech.service.WeatherService;

import javax.servlet.http.HttpServletRequest;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Set;


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

    /**
     * Index method.
     *
     * @param request       Request Object.
     * @param filterForm    form Object.
     * @param bindingResult Binding result.
     * @param model         Model.
     * @return response.
     */
    @RequestMapping("")
    public String index(final HttpServletRequest request, @Validated final WeatherForm filterForm, final BindingResult bindingResult, final Model model) {
        if (request.getMethod().equals("POST")) {
            model.addAttribute("filterForm", filterForm);
            if (!bindingResult.hasErrors()) {
                final Calendar fromCalendar = new GregorianCalendar();
                fromCalendar.setTimeInMillis(0);
                fromCalendar.set(Calendar.YEAR, filterForm.getYearFrom());
                fromCalendar.set(Calendar.MONTH, filterForm.getMonFrom() - 1);
                fromCalendar.set(Calendar.DAY_OF_MONTH, filterForm.getDayFrom());
                final Calendar toCalendar = new GregorianCalendar();
                toCalendar.set(Calendar.YEAR, filterForm.getYearTo());
                toCalendar.set(Calendar.MONTH, filterForm.getMonTo() - 1);
                toCalendar.set(Calendar.DAY_OF_MONTH, filterForm.getDayTo());

                Set<WeatherDomain> weatherDomainSet = new HashSet<>();
                while (fromCalendar.compareTo(toCalendar) < 0) {
                    WeatherDomain wetherDomain = null;
                    try {
                        wetherDomain = getWeatherService().getWeatherByDateAndRegion(fromCalendar, filterForm.getRegion());
                        weatherDomainSet.add(wetherDomain);
                        fromCalendar.roll(Calendar.DAY_OF_MONTH, true);
                    } catch (Exception e) {
                        model.addAttribute("errors", e);
                        break;
                    }
                }
                model.addAttribute("weathers", weatherDomainSet);
            }
        }
        if (!model.containsAttribute("filterForm")) {
            model.addAttribute("filterForm", new WeatherForm());
        }
        return "weather/index";
    }
}
