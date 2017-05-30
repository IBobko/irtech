package ru.irtech.service;

import org.json.JSONArray;
import ru.irtech.domain.WeatherDomain;
import java.util.Calendar;

/**
 * @author Igor Bobko <limit-speed@yandex.ru>.
 */
public interface WeatherService {
    /**
     * This method downloads history for some date in some region.
     *
     * @param calendar Date for which we seek weather.
     * @param region   Region for which we seek weather with country code. For example "RU/Moscow".
     * @return JSON formatted data or null if error occurred.
     */
    String downloadHistoryForDay(final Calendar calendar, final String region);

    /**
     * This method is used for full request of history response and returns JSONArray of daily summary.
     *
     * @param fullResponse Full response about history from server.
     * @return JSONArray with daily summary.
     */
    JSONArray getDailySummary(final String fullResponse);

    /**
     * Download and save to database the weather for concrete date and region.
     *
     * @param calendar Date.
     * @param region   Region.
     * @return WeatherDomain or null.
     */
    WeatherDomain downloadAndSave(final Calendar calendar, final String region);

    /**
     * Returns WeatherDomain trying to get it by database or web-site.
     *
     * @param calendar Date of weather.
     * @param region   Region of weather.
     * @return WeatherDomain or null.
     */
    WeatherDomain getWeatherByDateAndRegion(final Calendar calendar, final String region);
}
