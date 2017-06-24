package ru.irtech.service;

import ru.irtech.domain.WeatherDomain;
import java.util.Calendar;

/**
 * @author Igor Bobko <limit-speed@yandex.ru>.
 */
public interface WeatherService {
    /**
     * Returns WeatherDomain trying to get it by database or web-site.
     * Before ypu pass calendar ypu need to be confident that you nullify the calendar argument.
     *
     * @param calendar Date of weather.
     * @param region   Region of weather.
     * @throws Exception Exception with message which error occurred.
     * @return WeatherDomain.
     */
    WeatherDomain getWeatherByDateAndRegion(final Calendar calendar, final String region) throws Exception;
}
