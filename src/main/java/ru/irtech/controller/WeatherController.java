package ru.irtech.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import ru.irtech.domain.WeatherDomain;
import ru.irtech.form.WeatherForm;
import ru.irtech.service.WeatherService;

import javax.servlet.http.HttpServletRequest;
import java.util.Calendar;
import java.util.GregorianCalendar;


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
     * @return response.
     */
    @RequestMapping("")
    public String index(final HttpServletRequest request, final WeatherForm form,final Model model) {
        //model.addAllAttributes(request.getA)

        return "weather/index";
    }


    /**
     *  Test method.
     * @return response.
     */
    @ResponseBody
    @RequestMapping("/test")
    public String test() {


        Calendar calendar = new GregorianCalendar();
        WeatherDomain wd = getWeatherService().getWeatherByDateAndRegion(calendar, "RU/Moscow");
        if (wd != null) {
            return wd.toString();
        } else {
            return "";
        }
    }
}
