package ru.irtech.service;

import org.json.JSONArray;
import ru.irtech.domain.WeatherDomain;

import java.lang.reflect.Method;
import java.util.Calendar;

/**
 * @author Igor Bobko <limit-speed@yandex.ru>.
 */
public interface WeatherService {
    String downloadHistoryForDay(final Calendar calendar,final String region);
    JSONArray getDailySummary(final String fullResponse);
    WeatherDomain downloadAndSave(final Calendar calendar, final String region);
    WeatherDomain getWeatherByDateAndRegion(final Calendar calendar, final String region);
}
