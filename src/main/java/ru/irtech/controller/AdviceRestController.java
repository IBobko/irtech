package ru.irtech.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.irtech.domain.RecommendationDomain;
import ru.irtech.service.RecommendationService;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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
