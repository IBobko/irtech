package ru.irtech.dao;

import org.springframework.data.repository.CrudRepository;
import ru.irtech.domain.HostnameStatDomain;

/**
 * @author Igor Bobko <limit-speed@yandex.ru>.
 */
public interface HostNameStatRepository extends CrudRepository<HostnameStatDomain, Integer> {
}


