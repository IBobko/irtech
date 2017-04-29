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
    /**
     * MAX.
     */
    private static final int MAX = 1199;

    /**
     * EntityManager.
     */
    private EntityManager entityManager;

    private EntityManager getEntityManager() {
        return entityManager;
    }

    @PersistenceContext
    public void setEntityManager(final EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    /**
     * GET.
     * @return LIST.
     */
    @SuppressWarnings("unchecked")
    @Override
    public List<HostnameStatDomain> get() {
        return (List<HostnameStatDomain>) getEntityManager().createQuery("SELECT h FROM HostnameStatDomain h").setMaxResults(MAX).getResultList();
    }
}
