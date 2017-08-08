package ru.irtech.dao.Utility;

/**
 * Created by Iggytoto on 21.06.2017.
 * <p>
 * Class that represents table request schema for the scheduler.
 */
public class SchedulerTableRequestSchema {

    /**
     * Sql qurey that should be executed on irtech dump of data.
     */
    private final String sqlQuery;

    /**
     * Task access key.
     */
    private final String key;

    /**
     * Resulting data structure.
     */
    private final SchedulerType[] resultStructure;

    /**
     * C-tor.
     *
     * @param sqlQuery        -   Sql query to acess the data in irtech dump.
     * @param key             -   Task data access key.
     * @param resultStructure -   Resulting data structure.
     */
    public SchedulerTableRequestSchema(final String sqlQuery, final String key, final SchedulerType[] resultStructure) {
        this.sqlQuery = sqlQuery;
        this.key = key;
        this.resultStructure = resultStructure;
    }

    /**
     * @return Requested data columns structure.
     */
    public SchedulerType[] getResultStructure() {
        return resultStructure;
    }

    /**
     * @return Sql query.
     */
    public String getSqlQuery() {
        return sqlQuery;
    }

    /**
     * @return Data access key.
     */
    public String getKey() {
        return key;
    }
}
