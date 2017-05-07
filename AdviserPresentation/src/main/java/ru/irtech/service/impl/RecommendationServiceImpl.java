package ru.irtech.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.irtech.dao.RecommendationRepository;
import ru.irtech.domain.RecommendationDomain;
import ru.irtech.service.RecommendationService;

/**
 * @author Igor Bobko <limit-speed@yandex.ru>.
 */
@Service
public class RecommendationServiceImpl implements RecommendationService {
    /**
     * This is dao for recommendation domain.
     */
    private RecommendationRepository recommendationRepository;

    private RecommendationRepository getRecommendationRepository() {
        return recommendationRepository;
    }

    @Autowired
    public void setRecommendationRepository(final RecommendationRepository recommendationRepository) {
        this.recommendationRepository = recommendationRepository;
    }

    public RecommendationDomain getAny() {
        return getRecommendationRepository().findOne(1);
    }
}
