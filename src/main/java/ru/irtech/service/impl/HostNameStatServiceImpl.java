package ru.irtech.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.irtech.dao.HostNameStatRepository;
import ru.irtech.domain.HostnameStatDomain;
import ru.irtech.service.HostNameStatService;

/**
 * @author Igor Bobko <limit-speed@yandex.ru>.
 */
@Service
public class HostNameStatServiceImpl implements HostNameStatService {
    /**
     * This is the dao of hostname_state domain.
     */
    private HostNameStatRepository hostNameStatRepository;

    private HostNameStatRepository getHostNameStatRepository() {
        return hostNameStatRepository;
    }

    @Autowired
    private void setHostNameStatRepository(final HostNameStatRepository hostNameStatRepository) {
        this.hostNameStatRepository = hostNameStatRepository;
    }

    @Override
    public HostnameStatDomain save(final HostnameStatDomain domain) {
        return getHostNameStatRepository().save(domain);
    }
}
