package ru.irtech.service.impl;

import org.apache.commons.io.IOUtils;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ru.irtech.domain.SettingsDomain;
import ru.irtech.domain.WeatherDailySummaryDomain;
import ru.irtech.domain.WeatherDomain;
import ru.irtech.service.WeatherService;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.io.StringWriter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;

/**
 * @author Igor Bobko <limit-speed@yandex.ru>.
 */
@Service
@Transactional
public class WeatherServiceImpl implements WeatherService {

    /**
     * This is temporary variable, because now we have problem with timezone in postgresql.
     */
    private static final Integer TEMP_MOVE_BY_TIMEZONE_MILLISECONDS = 3 * 1000 * 60 * 60;

    /**
     * Max allowed requests per day.
     */
    private static final Integer MAX_REQUESTS_PER_DAY = 500;
    /**
     * Max allowed requests per minute.
     */
    private static final Integer MAX_REQUESTS_PER_MINUTE = 10;

    /**
     * Milliseconds for sleeping. .
     */
    private static final Integer MILLISECONDS_FOR_SLEEPING = 60000;

    /**
     * This format is used for storing the date data about limited access to weather.
     */
    private static final String DATE_FORMAT_FOR_SETTINGS = "yyyy-MM-dd-HH-mm";
    /**
     * This format is used for getting history of weather.
     */
    private static final String HISTORY_DATE_FORMAT = "yyyyMMdd";
    /**
     * Current minute key.
     */
    private final String WEATHER_CURRENT_MINUTE_KEY = "weather_current_minute";
    /**
     * Is used for forming the proper string for getting the date data.
     */
    private DateFormat dateFormatForSettings = new SimpleDateFormat(DATE_FORMAT_FOR_SETTINGS);
    /**
     * For manipulation with database objects.
     */
    private EntityManager entityManager;
    /**
     * Is used for forming the proper string for getting history data.
     */
    private DateFormat simpleDateFormat = new SimpleDateFormat(HISTORY_DATE_FORMAT);
    /**
     * Wunderground key.
     */
    @Value("${wunderground.key}")
    private String wundergroundKey;
    /**
     * Wunderground api address.
     */
    @Value("${wunderground.api.address}")
    private String wundergroundApiAddress;

    /**
     * saves manager.
     *
     * @param entityManager manager.
     */
    @PersistenceContext
    public void setEntityManager(final EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    /**
     * This method downloads history for some date in some region.
     *
     * @param calendar Date for which we seek weather.
     * @param region   Region for which we seek weather with country code. For example "RU/Moscow".
     * @return JSON formatted data or null if error occurred.
     * @throws Exception .
     */
    private String downloadHistoryForDay(final Calendar calendar, final String region) throws Exception {
        if (calendar == null) {
            return null;
        }
        if (region == null || region.trim().isEmpty()) {
            return null;
        }

//        if (getRequestsMadePerDay() > MAX_REQUESTS_PER_DAY) {
//            throw new Exception("Извините, сегодня лимит исчерпан.");
//        }
//
//        if (getRequestsMadePerMinute() > MAX_REQUESTS_PER_MINUTE) {
//            setCurrentRunningMinute();
//            Thread.sleep(MILLISECONDS_FOR_SLEEPING);
//            return downloadHistoryForDay(calendar, region);
//        }

        String historyString = "/history_" + simpleDateFormat.format(calendar.getTime());
        historyString += "/q/" + region + ".json";
        final CloseableHttpClient httpclient = HttpClientBuilder.create().build();
        final HttpPost httppost = new HttpPost(wundergroundApiAddress + wundergroundKey + historyString);
        final CloseableHttpResponse response = httpclient.execute(httppost);
        final StringWriter writer = new StringWriter();
        IOUtils.copy(response.getEntity().getContent(), writer, "UTF-8");
        setTimeOfLastRequest();
        return writer.toString();
    }

    /**
     * This method is used for full request of history response and returns JSONArray of daily summary.
     *
     * @param fullResponse Full response about history from server.
     * @return JSONArray with daily summary.
     */
    public JSONArray getDailySummary(final String fullResponse) {
        JSONObject obj = new JSONObject(fullResponse);
        return obj.getJSONObject("history").getJSONArray("dailysummary");

    }

    /**
     * Download and save to database the weather for concrete date and region.
     *
     * @param calendar Date.
     * @param region   Region.
     * @return WeatherDomain or null.
     * @throws Exception .
     */
    private WeatherDomain downloadAndSave(final Calendar calendar, final String region) throws Exception {
        String response = downloadHistoryForDay(calendar, region);
        if (response == null) {
            return null;
        }
        return saveHistoryResponse(response, region);
    }

    /**
     * Saves history of weather to database.
     *
     * @param response JSON format of history weather.
     * @param region   Region.
     * @return WeatherDomain or null.
     */
    private WeatherDomain saveHistoryResponse(final String response, final String region) {
        if (response == null) {
            return null;
        }

        JSONObject root = new JSONObject(response);

        JSONObject history = root.getJSONObject("history");
        JSONObject date = history.getJSONObject("date");
        Calendar calendar = new GregorianCalendar();
        calendar.setTimeInMillis(0);
        calendar.set(Calendar.YEAR, date.getInt("year"));
        calendar.set(Calendar.MONTH, date.getInt("mon") - 1);
        calendar.set(Calendar.DAY_OF_MONTH, date.getInt("mday"));
        calendar.set(Calendar.HOUR, date.getInt("hour"));


        Timestamp timestamp = new Timestamp(calendar.getTime().getTime());

        WeatherDomain weatherDomain = getWeatherFromDatabase(calendar, region);

        if (weatherDomain == null) {
            weatherDomain = new WeatherDomain();
        }

        weatherDomain.setCity(region);
        weatherDomain.setWeather(response);
        weatherDomain.setDate(timestamp);

        entityManager.persist(weatherDomain);

        final JSONArray summaries = getDailySummary(response);

        final WeatherDailySummaryDomain dailySummaryDomain = new WeatherDailySummaryDomain();
        dailySummaryDomain.setId(weatherDomain.getId());

        dailySummaryDomain.setData(summaries.get(0).toString());


        JSONObject jsonObject = new JSONObject(summaries.get(0).toString());

        JSONObject dateJson = jsonObject.getJSONObject("date");

        Calendar dcalendar = new GregorianCalendar();
        dcalendar.setTimeInMillis(0);
        dcalendar.set(Calendar.HOUR, dateJson.getInt("hour"));
        dcalendar.set(Calendar.YEAR, dateJson.getInt("year"));
        dcalendar.set(Calendar.DAY_OF_MONTH, dateJson.getInt("mday"));
        dcalendar.set(Calendar.MONTH, dateJson.getInt("mon") - 1);

        final Iterator<String> iter = jsonObject.keys();
        while (iter.hasNext()) {
            final String s = iter.next();
            try {
                if (!s.equals("date") && !s.equals("precipsource") && !s.equals("meanwdire")) {
                    //entityManager.createNativeQuery("ALTER TABLE public.weather_daily_summary ADD "+s+" NUMERIC NULL;").executeUpdate();

                    final Method method = getMethod(dailySummaryDomain.getClass(), s);

                    if (method == null) {
                        continue;
                    }

                    Double value = null;
                    if (jsonObject.get(s) instanceof String) {
                        if (!((String) jsonObject.get(s)).isEmpty()) {
                            value = jsonObject.getDouble(s);
                        }
                    } else {
                        value = jsonObject.getDouble(s);
                    }
                    method.invoke(dailySummaryDomain, value);
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }

        dailySummaryDomain.setDate(dcalendar);
        dailySummaryDomain.setWeatherDomain(weatherDomain);
        entityManager.persist(dailySummaryDomain);
        return weatherDomain;
    }

    /**
     * Reflection for setting value by name of method.
     *
     * @param c Class ob object.
     * @param n Name of method.
     * @return Method or null.
     */
    private Method getMethod(final Class c, final String n) {
        for (Method method : c.getMethods()) {
            if (method.getName().toUpperCase().contains(("set" + n).toUpperCase())) {
                return method;
            }
        }
        return null;
    }

    @Override
    public WeatherDomain getWeatherByDateAndRegion(final Calendar calendar, final String region) throws Exception {
        WeatherDomain weatherDomain = getWeatherFromDatabase(calendar, region);
        if (weatherDomain == null) {
            weatherDomain = downloadAndSave(calendar, region);
        }
        return weatherDomain;

    }

    /**
     * Return weather from database. If database has not contain the specified weather It returns null.
     *
     * @param calendar Date of weather.
     * @param region   Region of weather.
     * @return WeatherDomain or null.
     */
    @SuppressWarnings("unchecked")
    private WeatherDomain getWeatherFromDatabase(final Calendar calendar, final String region) {
        final Query query = entityManager
                .createQuery("SELECT W FROM WeatherDomain W where date = ? and city = ?")
                .setParameter(1, new Timestamp(calendar.getTime().getTime() - TEMP_MOVE_BY_TIMEZONE_MILLISECONDS))
                .setParameter(2, region);
        final List<WeatherDomain> weatherDomainList = query.getResultList();
        if (weatherDomainList.size() > 0) {
            return weatherDomainList.get(0);
        }
        return null;
    }

    /**
     * Returns time of last request.
     *
     * @return calendar.
     */
    private Calendar getTimeOfLastRequest() {
        try {
            SettingsDomain currentMinute = entityManager.find(SettingsDomain.class, WEATHER_CURRENT_MINUTE_KEY);
            if (currentMinute == null) {
                return null;
            }
            final Calendar calendar = new GregorianCalendar();
            calendar.setTime(dateFormatForSettings.parse(currentMinute.getValue()));
            calendar.set(Calendar.SECOND, 0);
            calendar.set(Calendar.MILLISECOND, 0);
            return calendar;
        } catch (ParseException e) {
            return null;
        }
    }

    /**
     * Sets time of last request.
     */
    private void setTimeOfLastRequest() {
        SettingsDomain currentMinute = entityManager.find(SettingsDomain.class, WEATHER_CURRENT_MINUTE_KEY);
        if (currentMinute == null) {
            currentMinute = new SettingsDomain();
            currentMinute.setKey(WEATHER_CURRENT_MINUTE_KEY);
        }
        final Calendar calendar = new GregorianCalendar();
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        currentMinute.setValue(dateFormatForSettings.format(calendar.getTime()));
        entityManager.persist(currentMinute);

        updateMinute(calendar);
        updateDay(calendar);

    }

    private void updateDay(final Calendar calendar) {
        Calendar last = getTimeOfLastRequest();
        calendar.set(Calendar.HOUR, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.MILLISECOND, 0);

        last.set(Calendar.HOUR, 0);
        last.set(Calendar.MINUTE, 0);
        last.set(Calendar.MILLISECOND, 0);

        if (last.compareTo(calendar) == 0) {
            // Обновляем счетчик
        } else {
            // Сбрасываем счетчик
        }
    }

    private void updateMinute(final Calendar calendar) {
        Calendar last = getTimeOfLastRequest();
        calendar.set(Calendar.HOUR, 0);
        calendar.set(Calendar.MINUTE, 0);


        last.set(Calendar.HOUR, 0);
        last.set(Calendar.MINUTE, 0);

    }

    /**
     * ddd.
     *
     * @return calendar.
     */
    private Calendar getCurrentRunningDay() {
        try {
            SettingsDomain currentMinute = entityManager.find(SettingsDomain.class, "weather_per_day");
            Calendar calendar = new GregorianCalendar();
            if (currentMinute == null) {
                currentMinute = new SettingsDomain();
                currentMinute.setKey("weather_per_day");
                calendar.set(Calendar.SECOND, 0);
                calendar.set(Calendar.MILLISECOND, 0);
                currentMinute.setValue(dateFormatForSettings.format(calendar.getTime()));
                entityManager.persist(currentMinute);
            }
            calendar.setTime(dateFormatForSettings.parse(currentMinute.getValue()));
            calendar.set(Calendar.SECOND, 0);
            calendar.set(Calendar.MILLISECOND, 0);
            return calendar;
        } catch (ParseException e) {
            return null;
        }
    }

    /**
     * ss.
     */
    private void setCurrentRunningMinute() {
        SettingsDomain currentMinute = entityManager.find(SettingsDomain.class, "weather_current_minute");
        Calendar calendar = new GregorianCalendar();
        if (currentMinute == null) {
            currentMinute = new SettingsDomain();
            currentMinute.setKey("weather_current_minute");
        }
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        currentMinute.setValue(dateFormatForSettings.format(calendar.getTime()));
        entityManager.persist(currentMinute);
    }

    /**
     * sss.
     */
    private void setCurrentRunningDay() {
        SettingsDomain currentMinute = entityManager.find(SettingsDomain.class, "weather_current_day");
        Calendar calendar = new GregorianCalendar();
        if (currentMinute == null) {
            currentMinute = new SettingsDomain();
            currentMinute.setKey("weather_current_day");
        }
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        currentMinute.setValue(dateFormatForSettings.format(calendar.getTime()));
        entityManager.persist(currentMinute);
    }

    /**
     * sss.
     *
     * @return int.
     */
    private Integer getRequestsMadePerMinute() {
        SettingsDomain requestsPerDay = entityManager.find(SettingsDomain.class, "weather_per_minute");
        if (requestsPerDay == null) {
            requestsPerDay = new SettingsDomain();
            requestsPerDay.setKey("weather_per_minute");
            requestsPerDay.setValue("0");
            entityManager.persist(requestsPerDay);
        }
        return Integer.parseInt(requestsPerDay.getValue());
    }

    /**
     * sss.
     *
     * @return int.
     */
    private Integer getRequestsMadePerDay() {
        SettingsDomain requestsPerDay = entityManager.find(SettingsDomain.class, "weather_per_day");
        if (requestsPerDay == null) {
            requestsPerDay = new SettingsDomain();
            requestsPerDay.setKey("weather_per_day");
            requestsPerDay.setValue("0");
            entityManager.persist(requestsPerDay);
        }
        return Integer.parseInt(requestsPerDay.getValue());
    }
}
