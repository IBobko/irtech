package ru.irtech.dao.Examples;

import ru.irtech.dao.Interfaces.IScheduler;
import ru.irtech.dao.Utility.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Iggytoto on 21.06.2017.
 * <p>
 * Current class is represents IScheduler future usage example. This is not working and should not be.
 */
public class SchedulerUsageExample {

    /**
     * Data key format example.
     */
    private static final String DATA_KEY = "someColumn1_someColumn2";

    /**
     * Schema.
     */
    private static final SchedulerTableRequestSchema SCHEMA = new SchedulerTableRequestSchema("Select * from SomeTable",
            DATA_KEY, new SchedulerType[]{SchedulerType.INTEGER, SchedulerType.STRING, SchedulerType.DOUBLE});

    /**
     * Main example method.
     */
    public List<Object> getAnalysisData() throws SQLException, ClassNotFoundException {
        IScheduler scheduler = null; // here should be new ConcreteScheduler;
        List<Object> results = new ArrayList() {
        };

        try {
            scheduler.getDataEntities(DATA_KEY, SCHEMA);
        } catch (SchedulerTableNotFoundException e) {
            try {
                scheduler.queueRequest(DATA_KEY, SCHEMA);
            } catch (SchedulerAlreadyRequestedException e1) {
                // TODO THROW EXCEPTION THAT DATA NOT READY YET THAT CALLING CONTROLLER COULD RETURN MESSAGE TO VIEW.
            }
        } catch (SchedulerNoDataYetException e) {
            //TODO SAME HERE
        }

        return results;
    }
}
