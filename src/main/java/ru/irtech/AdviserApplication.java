package ru.irtech;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.scheduling.annotation.EnableScheduling;
import ru.irtech.filter.AdvisorCorsFilter;
import ru.irtech.filter.JavascriptFilter;
import ru.irtech.service.HostNameStatService;

import javax.servlet.DispatcherType;
import javax.sql.DataSource;

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
     * @param hostNameStatService Service of hostname statistics.
     * @return New FilterRegistrationBean with new Filter.
     */
    @Bean
    @Autowired
    public FilterRegistrationBean myFilterRegistration(final HostNameStatService hostNameStatService) {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setDispatcherTypes(DispatcherType.REQUEST);
        registration.setFilter(new AdvisorCorsFilter());
        registration.setFilter(new JavascriptFilter(hostNameStatService));
        return registration;
    }


    /**
     * This is primary datasource with adviser data.
     *
     * @return primary datasource.
     */
    @Bean
    //@Primary
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource primaryDataSource() {
        return DataSourceBuilder.create().build();
    }

    /**
     * This is datasource with gained data.
     *
     * @return gained data datasource.
     */
    //@Bean
    //@ConfigurationProperties(prefix = "spring.dataDatasource")
    //public DataSource secondaryDataSource() {
    //   return DataSourceBuilder.create().build();
    //}

    /**
     * This is transaction manager for primary datasource.
     *
     * @return Transaction manager.
     */
    @Bean
    public DataSourceTransactionManager transactionManager() {
        return new DataSourceTransactionManager(primaryDataSource());
    }

    /**
     * This is transaction manager for gained data datasource.
     *
     * @return Transaction manager.
     */
   /* @Bean("adviserTx")
    public DataSourceTransactionManager adviserTx() {
        return new DataSourceTransactionManager(primaryDataSource());
    }*/

}

