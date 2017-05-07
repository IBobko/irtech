package ru.irtech.filter;

import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/**
 * Created by Iggytoto on 02.04.2017.
 */
public class AdvisorCorsFilter extends CorsFilter {

    /**
     * Cors *.
     */
    public AdvisorCorsFilter() {
        super(configurationSource());
    }

    /**
     * CORS allowed all.
     *
     * @return current CORS configuration.
     */
    private static UrlBasedCorsConfigurationSource configurationSource() {
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);
        config.addAllowedOrigin("*");
        config.addAllowedHeader("*");
        config.addAllowedMethod("*");
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", config);
        return source;
    }
}
