package ru.irtech;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import ru.irtech.filter.JavascriptFilter;
import ru.irtech.service.HostNameStatService;

import javax.servlet.DispatcherType;

/**
 * Main class of Application which starts first.
 */
@SpringBootApplication
@EnableScheduling
public class AdviserApplication {
    /**
     * The main function which executes when application is started.
     *
     * @param args Arguments of command line.
     */
    public static void main(final String[] args) {
        SpringApplication.run(AdviserApplication.class, args);
    }

    /**
     * Registration of filter which tracks of Javascript's treatment.
     *
     * @return New FilterRegistrationBean with new Filter.
     */
    @Bean
    @Autowired
    public FilterRegistrationBean myFilterRegistration(final HostNameStatService hostNameStatService) {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setDispatcherTypes(DispatcherType.REQUEST);
        registration.setFilter(new JavascriptFilter(hostNameStatService));
        return registration;
    }
}
