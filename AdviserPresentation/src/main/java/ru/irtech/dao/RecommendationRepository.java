package ru.irtech.dao;

import org.springframework.data.repository.CrudRepository;
import ru.irtech.domain.RecommendationDomain;

/**
 * @author Igor Bobko <limit-speed@yandex.ru>.
 */
public interface RecommendationRepository extends CrudRepository<RecommendationDomain, Integer> {
}
