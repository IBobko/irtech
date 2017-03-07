package ru.irtech.filter;

import org.apache.catalina.connector.RequestFacade;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author Igor Bobko <limit-speed@yandex.ru>.
 */

public class JavascriptFilter implements Filter {

    @Override
    public void init(final FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(final ServletRequest servletRequest, final ServletResponse servletResponse, final FilterChain filterChain) throws IOException, ServletException {
        if (((RequestFacade) servletRequest).getRequestURI().contains("adviser.js")) {
            System.out.println("hello");
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
