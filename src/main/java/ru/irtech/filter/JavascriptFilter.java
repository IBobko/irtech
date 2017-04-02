package ru.irtech.filter;

import org.apache.catalina.connector.RequestFacade;
import ru.irtech.domain.HostnameStatDomain;
import ru.irtech.service.HostNameStatService;

import javax.servlet.*;
import java.io.IOException;
import java.util.GregorianCalendar;

/**
 * @author Igor Bobko <limit-speed@yandex.ru>.
 */

public class JavascriptFilter implements Filter {
    /**
     * Service of hostname statistics.
     */
    private HostNameStatService hostNameStatService;

    /**
     * @param hostNameStatService Service of hostname statistics.
     */
    public JavascriptFilter(final HostNameStatService hostNameStatService) {
        this.hostNameStatService = hostNameStatService;
    }

    private HostNameStatService getHostNameStatService() {
        return hostNameStatService;
    }

    @Override
    public void init(final FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(final ServletRequest servletRequest, final ServletResponse servletResponse, final FilterChain filterChain) throws IOException, ServletException {
        if (((RequestFacade) servletRequest).getRequestURI().contains("adviser.js")) {
            final HostnameStatDomain domain = new HostnameStatDomain();
            domain.setHostname(((RequestFacade) servletRequest).getHeader("referer"));
            domain.setTime(new GregorianCalendar());

            String ipAddress = ((RequestFacade) servletRequest).getHeader("X-FORWARDED-FOR");
            if (ipAddress == null) {
                ipAddress = servletRequest.getRemoteAddr();
            }
            domain.setUserIp(ipAddress);
            getHostNameStatService().save(domain);
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
