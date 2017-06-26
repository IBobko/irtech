package ru.irtech.dao.Scheduler;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Iggytoto on 26.06.2017.
 * Base PostgreSqlDataBaseController testing entity.
 */
public abstract class PostgreSqlDataBaseControllerTest {

    /**
     * Test host.
     */
    protected final static String HOST_ADDRESS = "188.130.155.86";

    /**
     * Test port.
     */
    protected final static String HOST_PORT = "5432";

    /**
     * Test db name.
     */
    protected final static String DATABASE_NAME = "Test_database";

    /**
     * Test login.
     */
    protected final static String LOGIN = "postgres";

    /**
     * Test pass.
     */
    protected final static String PASSWORD = "yOklqXf4";

    /**
     * Test set of columnTypes.
     */
    protected final PostgreSqlColumnType[] testColumnTypes = new PostgreSqlColumnType[]{PostgreSqlColumnType.integer, PostgreSqlColumnType.doublePrecision, PostgreSqlColumnType.string100};

    /**
     * Test set of columnNames.
     */
    protected final String[] testColumnNames = new String[]{"someId", "someDouble", "someString"};

}
