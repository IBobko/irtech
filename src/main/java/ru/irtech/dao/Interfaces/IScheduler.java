package ru.irtech.dao.Interfaces;

import ru.irtech.dao.Utility.SchedulerAlreadyRequestedException;
import ru.irtech.dao.Utility.SchedulerNoDataYetException;
import ru.irtech.dao.Utility.SchedulerTableNotFoundException;
import ru.irtech.dao.Utility.SchedulerTableRequestSchema;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Iggytoto on 21.06.2017.
 * <p>
 * Scheduler interface.
 * <p>
 * The main idea is to provide single point of data mining results to access. We are requesting results data here
 * by the given key, we are expecting that we know what type of data is related to each key, because we should define
 * it earlier. The Scheduler should throw exception in case if the given key is not presented in the system. In other
 * case it should return a list of object that represents the data, the requesting entity after should cast this objects
 * to known data type in order to use it.
 */
public interface IScheduler {

    /**
     * Main data access method.
     * <p>
     * This method is returning a set of requested earlier entities.
     *
     * @param key    -   data access key, a string that represents data access to one or the other set of data.
     * @param schema -   data schema, an entity which represents sql query and the expecting result structure.
     * @return List of data entities according to the schema.
     * @throws SchedulerTableNotFoundException in case if the requested key is not presented in the database.
     * @throws SchedulerNoDataYetException     in case  data is not received yet.
     */
    List<Object[]> getDataEntities(final String key, final SchedulerTableRequestSchema schema) throws SchedulerTableNotFoundException, SchedulerNoDataYetException, ClassNotFoundException, SQLException;

    /**
     * Data request method.
     *
     * @param key    -   data access key.
     * @param schema -   data schema, an entity which represents sql query and the expecting result structure.
     * @throws SchedulerAlreadyRequestedException in case when key is presented but result is not done yet.
     */
    void queueRequest(final String key, final SchedulerTableRequestSchema schema) throws SchedulerAlreadyRequestedException, ClassNotFoundException, SQLException;


}
