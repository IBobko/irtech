package ru.irtech.dao.Scheduler;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Iggytoto on 26.06.2017.
 * Class that implements positive testing for the droptable method of PostgreSqlDataBaseControllerConstructorFalseTest
 */
public class PostgreSqlDataBaseControllerPositiveTest extends PostgreSqlDataBaseControllerTest {

    /**
     * Some test table name.
     */
    private final static String TABLE_NAME = "SomeTableToCreateAndDrop";

    /**
     * False host testing during constructor value injection.
     */
    @Test
    public void createDropTableTest() {
        PostgreSqlDatabaseController dbController = new PostgreSqlDatabaseController(HOST_ADDRESS, HOST_PORT, DATABASE_NAME, LOGIN, PASSWORD);

        try {
            dbController.dropTable(TABLE_NAME);
            System.out.println("Test table was deleted.");
        } catch (Exception e) {
            //if there were no table, skip this one.
        }

        try {
            dbController.createTable(TABLE_NAME, testColumnTypes, testColumnNames);
            dbController.dropTable(TABLE_NAME);
            dbController.createTable(TABLE_NAME, testColumnTypes, testColumnNames);
            dbController.dropTable(TABLE_NAME);
        } catch (Exception e) {
            Assert.fail();
        } finally {
            try {
                dbController.dropTable(TABLE_NAME);
                System.out.println("Test table was deleted.");
            } catch (Exception e) {
                //if there were no table, skip this one.
            }
        }
        Assert.assertTrue(true);
    }
}
