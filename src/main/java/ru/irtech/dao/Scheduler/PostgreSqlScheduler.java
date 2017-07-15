package ru.irtech.dao.Scheduler;

import ru.irtech.dao.AnalysisDataAcess.DataBaseList;
import ru.irtech.dao.Interfaces.IScheduler;
import ru.irtech.dao.Utility.*;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Iggytoto on 24.06.2017.
 */
public class PostgreSqlScheduler implements IScheduler {

    /**
     * scheduler instances.
     */
    private static Map<PostgreSqlDatabaseController, PostgreSqlScheduler> map = new HashMap<>();

    /**
     * TODO transfer to config
     * Db host.
     */
    private final static String HOST_ADDRESS = "188.130.155.86";

    /**
     * TODO transfer to config
     * Db port.
     */
    private final static String HOST_PORT = "5432";

    /**
     * TODO transfer to config
     * Db login.
     */
    private final static String LOGIN = "postgres";

    /**
     * TODO transfer to config
     * Db pass.
     */
    private final static String PASSWORD = "yOklqXf4";

    /**
     * Sql db controller.
     */
    private final PostgreSqlDatabaseController dbController;

    /**
     * Synchronization object
     */
    private static final Object locker = new Object();

    /**
     * Private constructor - Singleton requirement
     */
    private PostgreSqlScheduler(PostgreSqlDatabaseController controller) {
        dbController = controller;
    }

    /**
     * Singleton implementation.
     *
     * @return PostgreSqlScheduler instance.
     */
    public static PostgreSqlScheduler getInstance(PostgreSqlDatabaseController controller) {

        synchronized (locker) {
            //double check that
            if (map.getOrDefault(controller, null) == null) {
                map.put(controller, new PostgreSqlScheduler(controller));
            }
        }

        return map.get(controller);
    }

    @Override
    public List<Object[]> getDataEntities(final String key, final SchedulerTableRequestSchema schema) throws SchedulerTableNotFoundException, SchedulerNoDataYetException, ClassNotFoundException, SQLException {
        if (dbController.isTableExists(key)) {
            if (dbController.tableHasData(key)) {
                return dbController.executeScriptAndDeliverResults(schema.getSqlQuery(), convertStructure(schema.getResultStructure()));
            } else {
                throw new SchedulerNoDataYetException();
            }
        } else {
            throw new SchedulerTableNotFoundException();
        }
    }

    @Override
    public void queueRequest(final String key, final SchedulerTableRequestSchema schema) throws SchedulerAlreadyRequestedException, ClassNotFoundException, SQLException {
        if (dbController.isTableExists(key)) {
            throw new SchedulerAlreadyRequestedException();
        }
        ScheduledTask task = new ScheduledTask(key, schema, dbController);
        new Thread(task).start();
    }

    /**
     * Creating the table columns structure.
     *
     * @return
     */
    private PostgreSqlColumnType[] convertStructure(final SchedulerType[] types) {
        PostgreSqlColumnType[] result = new PostgreSqlColumnType[types.length];

        for (int i = 0; i < types.length; i++) {
            switch (types[i]) {
                case INTEGER:
                    result[i] = PostgreSqlColumnType.integer;
                    break;
                case DOUBLE:
                    result[i] = PostgreSqlColumnType.doublePrecision;
                    break;
                case STRING:
                    result[i] = PostgreSqlColumnType.string;
                    break;
                case DATE:
                    throw new NotImplementedException();
            }
        }
        return result;
    }

    /**
     * Converts structure to naming.
     *
     * @param types types
     * @return string array.
     */
    private String[] convertStructureToNames(final SchedulerType[] types) {
        String[] result = new String[types.length];

        for (int i = 0; i < types.length; i++) {
            switch (types[i]) {
                case INTEGER:
                    result[i] = "int";
                    break;
                case DOUBLE:
                    result[i] = "double";
                    break;
                case STRING:
                    result[i] = "str";
                    break;
                case DATE:
                    throw new NotImplementedException();
            }
        }
        return result;
    }
}
