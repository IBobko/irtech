package ru.irtech.dao.Scheduler;

import ru.irtech.dao.AnalysisDataAcess.DataBaseList;
import ru.irtech.dao.Interfaces.IScheduler;
import ru.irtech.dao.Utility.SchedulerAlreadyRequestedException;
import ru.irtech.dao.Utility.SchedulerNoDataYetException;
import ru.irtech.dao.Utility.SchedulerTableNotFoundException;
import ru.irtech.dao.Utility.SchedulerTableRequestSchema;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Iggytoto on 24.06.2017.
 */
public class PostgreSqlScheduler implements IScheduler {

    /**
     * TODO transfer to config
     * Db host.
     */
    protected final static String HOST_ADDRESS = "188.130.155.86";

    /**
     * TODO transfer to config
     * Db port.
     */
    protected final static String HOST_PORT = "5432";

    /**
     * TODO transfer to config
     * Db login.
     */
    protected final static String LOGIN = "postgres";

    /**
     * TODO transfer to config
     * Db pass.
     */
    protected final static String PASSWORD = "yOklqXf4";

    /**
     * Sql db controller.
     */
    private final PostgreSqlDatabaseController dbController;

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
        dbController = new PostgreSqlDatabaseController(HOST_ADDRESS, HOST_PORT, DataBaseList.getDataBases().get(0), LOGIN, PASSWORD);
    }

    /**
     * Singleton implementation.
     *
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
    public static void initializeSingleton() {
        PostgreSqlScheduler.getInstance();
    }


    @Override
    public List<Object> getDataEntities(final String key, final SchedulerTableRequestSchema schema) throws SchedulerTableNotFoundException, SchedulerNoDataYetException, ClassNotFoundException, SQLException {
        if (dbController.isTableExists(key)) {
            if (dbController.tableHasData(key)) {
                //TODO QUERY DATA AND RETURN
                return null;
            } else {
                throw new SchedulerNoDataYetException();
            }
        } else {
            throw new SchedulerNoDataYetException();
        }
    }

    @Override
    public void queueRequest(final String key, final SchedulerTableRequestSchema schema) throws SchedulerAlreadyRequestedException, ClassNotFoundException, SQLException {
        if (dbController.isTableExists(key)) {
            if (!dbController.tableHasData(key)) {
                throw new SchedulerAlreadyRequestedException();
            }
            ScheduledTask task = new ScheduledTask(key, schema, dbController);
            task.start();
        }
    }
}
