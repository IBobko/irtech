package ru.irtech.engine;

import org.springframework.stereotype.Component;

import ru.irtech.domain.HostnameStatDomain;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * @author Igor Bobko <limit-speed@yandex.ru>.
 */
@Component("a11")
public class AImpl implements A {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<HostnameStatDomain> get() {
        return (List<HostnameStatDomain> )entityManager.createQuery("SELECT h FROM HostnameStatDomain h").setMaxResults(10).getResultList();
    }
}
