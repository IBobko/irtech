package ru.irtech.engine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

/**
 * Main StartPoint of application.
 *
 * @author Igor Bobko <limit-speed@yandex.ru>.
 */
@SpringBootApplication
public class EngineApplication {

    /**
     * Application starts with this function.
     *
     * @param args Command line arguments.
     */
    public static void main(final String[] args) {
        SpringApplication.run(EngineApplication.class, args);
    }


    /**
     * This is primary datasource with adviser data.
     *
     * @return primary datasource.
     */
    @Bean
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource primaryDataSource() {
        return DataSourceBuilder.create().build();
    }


}
