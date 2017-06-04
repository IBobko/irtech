package ru.irtech.service.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ru.irtech.service.WeatherService;

import java.util.Calendar;
import java.util.GregorianCalendar;

import static org.junit.Assert.*;

/**
 * @author Igor Bobko <limit-speed@yandex.ru>.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class WeatherServiceImplTest {
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

    @Test
    public void downloadHistoryForDay() throws Exception {

    }

    @Test
    public void getDailySummary() throws Exception {

    }

    @Test
    public void getWeatherByDateAndRegion() throws Exception {
        Thread.sleep(20000); // Connection to remote wundergraund server do not always perform immediate after starting application.
        final Calendar calendar = new GregorianCalendar();
        calendar.setTimeInMillis(0);
        calendar.set(Calendar.YEAR,2017);
        calendar.set(Calendar.MONTH,3);
        calendar.set(Calendar.DAY_OF_MONTH,2);
        String region = "RU/Moscow";
        getWeatherService().getWeatherByDateAndRegion(calendar,region);
    }

}