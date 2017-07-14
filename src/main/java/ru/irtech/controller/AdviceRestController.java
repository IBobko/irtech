package ru.irtech.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.thymeleaf.util.StringUtils;
import ru.irtech.domain.RecommendationDomain;
import ru.irtech.service.RecommendationService;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.*;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * @author Igor Bobko <limit-speed@yandex.ru>.
 */
@RestController
@RequestMapping("/rest-advice")
public class AdviceRestController {

    /**
     * Path to database dump.
     */
    private static final String PATH_TO_DUMP = "/home/igor/irtech/asdsa";

    /**
     * This is used for database manipulations.
     */
    @PersistenceContext
    private EntityManager entityManager;
    /**
     * Service of recommendation.
     */
    private RecommendationService recommendationService;

    public EntityManager getEntityManager() {
        return entityManager;
    }

    private RecommendationService getRecommendationService() {
        return recommendationService;
    }

    @Autowired
    public void setRecommendationService(final RecommendationService recommendationService) {
        this.recommendationService = recommendationService;
    }

    /**
     * Test.
     *
     * @return Test data.
     */
    @RequestMapping("")
    public RecommendationDomain greeting() {
        return getRecommendationService().getAny();
    }

}
