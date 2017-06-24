package ru.irtech.dao.Scheduler;

import ru.irtech.dao.Interfaces.IScheduler;
import ru.irtech.dao.Utility.SchedulerAlreadyRequestedException;
import ru.irtech.dao.Utility.SchedulerNoDataYetException;
import ru.irtech.dao.Utility.SchedulerTableNotFoundException;
import ru.irtech.dao.Utility.SchedulerTableRequestSchema;

import java.util.List;

/**
 * Created by Iggytoto on 24.06.2017.
 */
public class PostgreSqlScheduler implements IScheduler {

    /**
     * Synchronization object
     */
    private static final Object locker = new Object();

    /**
     * Private instance field
     */
    private static PostgreSqlScheduler instance;

    /**
     * Private constructor - Singleton requirement
     */
    private PostgreSqlScheduler() {
    }

    /**
     * Singleton implementation.
     * @return PostgreSqlScheduler instance.
     */
    public static PostgreSqlScheduler getInstance() {
        if (instance == null) {
            synchronized (locker) {
                //double check that
                if (instance == null) {
                    instance = new PostgreSqlScheduler();
                }
            }
        }
        return instance;
    }

    /**
     * Method required to preload initial state of singleton. Should be used when application loading.
     */
    public static void initializeSingleton(){
        PostgreSqlScheduler.getInstance();
    }


    @Override
    public List<Object> getDataEntities(String key) throws SchedulerTableNotFoundException, SchedulerNoDataYetException {
        return null;
    }

    @Override
    public void queueRequest(String key, SchedulerTableRequestSchema schema) throws SchedulerAlreadyRequestedException {

    }


}
