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
    public final static String HOST_ADDRESS = "188.130.155.86";

    /**
     * Test port.
     */
    public final static String HOST_PORT = "5432";

    /**
     * Test db name.
     */
    public final static String DATABASE_NAME = "Test_database";

    /**
     * Test login.
     */
    public final static String LOGIN = "postgres";

    /**
     * Test pass.
     */
    public final static String PASSWORD = "yOklqXf4";

    /**
     * Test set of columnTypes.
     */
    protected final PostgreSqlColumnType[] testColumnTypes = new PostgreSqlColumnType[]{PostgreSqlColumnType.integer, PostgreSqlColumnType.doublePrecision, PostgreSqlColumnType.string};

    /**
     * Test set of columnNames.
     */
    protected final String[] testColumnNames = new String[]{"someId", "someDouble", "someString"};

}
