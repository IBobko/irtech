package ru.irtech.dao.Scheduler;

import ru.irtech.dao.Utility.SchedulerTableRequestSchema;
import ru.irtech.dao.Utility.SchedulerType;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.sql.SQLException;

/**
 * Created by Iggytoto on 12.07.2017.
 */
public class ScheduledTask extends Thread {

    /**
     * Table name to fill.
     */
    private final String key;

    /**
     * Table schema.
     */
    private final SchedulerTableRequestSchema schema;

    /**
     * Db controller.
     */
    private final PostgreSqlDatabaseController controller;

    /**
     * C-tor.
     *
     * @param key
     * @param schema
     * @param controller
     */
    public ScheduledTask(final String key, final SchedulerTableRequestSchema schema, PostgreSqlDatabaseController controller) {
        this.key = key;
        this.schema = schema;
        this.controller = controller;
    }

    /**
     * Main runnner.
     */
    @Override
    public void run() {

        try {
            if (controller.isTableExists(key)) {
                return;
            }

            PostgreSqlColumnType[] cTypes = new PostgreSqlColumnType[schema.getResultStructure().length];
            String[] cNames = new String[schema.getResultStructure().length];

            for (int i = 0; i < schema.getResultStructure().length; i++) {
                switch (schema.getResultStructure()[i]) {
                    case INTEGER:
                        cTypes[i] = PostgreSqlColumnType.integer;
                        cNames[i] = PostgreSqlColumnType.integer.toString();
                        break;
                    case DOUBLE:
                        cTypes[i] = PostgreSqlColumnType.doublePrecision;
                        cNames[i] = PostgreSqlColumnType.doublePrecision.toString();
                        break;
                    case STRING:
                        cTypes[i] = PostgreSqlColumnType.string;
                        cNames[i] = PostgreSqlColumnType.string.toString();
                        break;
                    case DATE:
                        new NotImplementedException().printStackTrace();
                        return;
                }
            }

            controller.createTable(key, cTypes, cNames);

            controller.executeScriptAndDeliverResultsTo(schema.getSqlQuery(), schema.getKey(), cTypes, cNames);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
