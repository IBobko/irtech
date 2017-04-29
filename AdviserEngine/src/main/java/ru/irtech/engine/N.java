package ru.irtech.engine;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.remoting.rmi.RmiServiceExporter;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

/**
 * @author Igor Bobko <limit-speed@yandex.ru>.
 */
@Component
@DependsOn("a11")
public class N extends RmiServiceExporter {




    public N(@Autowired AImpl a11) {

        setServiceName("a11");
        setService(a11);
        setServiceInterface(A.class);
        setRegistryPort(1199);

    }
}