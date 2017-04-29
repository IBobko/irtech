package ru.irtech.engine;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.remoting.rmi.RmiServiceExporter;
import org.springframework.stereotype.Component;

/**
 * @author Igor Bobko <limit-speed@yandex.ru>.
 */
@Component
@DependsOn("a11")
public class N extends RmiServiceExporter {
    /**
     * PORT.
     */
    private static final int PORT = 1199;
    /**
     *  constructor.
     * @param a11 service.
     */
    public N(@Autowired final AImpl a11) {

        setServiceName("a11");
        setService(a11);
        setServiceInterface(A.class);
        setRegistryPort(PORT);

    }
}
