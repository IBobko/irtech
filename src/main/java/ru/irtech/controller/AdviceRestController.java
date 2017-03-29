package ru.irtech.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.irtech.domain.RecommendationDomain;
import ru.irtech.service.RecommendationService;

/**
 * @author Igor Bobko <limit-speed@yandex.ru>.
 */
@RestController
@RequestMapping("/rest-advice")
public class AdviceRestController {

    /**
     * Service of recommendation.
     */
    private RecommendationService recommendationService;

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
