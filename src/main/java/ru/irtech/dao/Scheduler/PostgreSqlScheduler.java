package ru.irtech.dao.Scheduler;

import ru.irtech.dao.Interfaces.IScheduler;
import ru.irtech.dao.Utility.*;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Iggytoto on 24.06.2017.
 */
public final class PostgreSqlScheduler implements IScheduler {

    /**
     * scheduler instances.
     */
    private static Map<PostgreSqlDatabaseController, PostgreSqlScheduler> map = new HashMap<>();

    /**
     * TODO transfer to config
     * Db host.
     */
    private static final String HOST_ADDRESS = "188.130.155.86";

    /**
     * TODO transfer to config
     * Db port.
     */
    private static final String HOST_PORT = "5432";

    /**
     * TODO transfer to config
     * Db login.
     */
    private static final String LOGIN = "postgres";

    /**
     * TODO transfer to config
     * Db pass.
     */
    private static final String PASSWORD = "yOklqXf4";

    /**
     * Sql db controller.
     */
    private final PostgreSqlDatabaseController dbController;

    /**
     * Synchronization object.
     */
    private static final Object LOCKER = new Object();

    /**
     * Private constructor - Singleton requirement.
     *
     * @param controller - db controller.
     */
    private PostgreSqlScheduler(final PostgreSqlDatabaseController controller) {
        dbController = controller;
    }

    /**
     * Singleton implementation.
     *
     * @param controller db controller.
     * @return PostgreSqlScheduler instance.
     */
    public static PostgreSqlScheduler getInstance(final PostgreSqlDatabaseController controller) {

        synchronized (LOCKER) {
            //double check that
            if (map.getOrDefault(controller, null) == null) {
                map.put(controller, new PostgreSqlScheduler(controller));
            }
        }

        return map.get(controller);
    }

    @Override
    public List<Object[]> getDataEntities(final String key, final SchedulerTableRequestSchema schema) throws Exception {
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
     * @param types schedulertypes.
     * @return columntypes.
     * @throws Exception in some ways.
     */
    private PostgreSqlColumnType[] convertStructure(final SchedulerType[] types) throws Exception {
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
                default:
                    throw new Exception("Not implemented yet");
            }
        }
        return result;
    }

    /**
     * Converts structure to naming.
     *
     * @param types types.
     * @return string array.
     * @throws Exception in some ways.
     */
    private String[] convertStructureToNames(final SchedulerType[] types) throws Exception {
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
                default:
                    throw new Exception("Not implemented yet");

            }
        }
        return result;
    }
}
