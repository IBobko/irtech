package ru.irtech.service;

import ru.irtech.domain.HostnameStatDomain;

/**
 * @author Igor Bobko <limit-speed@yandex.ru>.
 */

public interface HostNameStatService {
    /**
     * Persists object in database.
     *
     * @param domain object for persistence,
     * @return Persisted object.
     */
    HostnameStatDomain save(final HostnameStatDomain domain);
}
