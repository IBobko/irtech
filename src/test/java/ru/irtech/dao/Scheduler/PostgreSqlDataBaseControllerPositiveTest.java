package ru.irtech.dao.Scheduler;

import org.junit.Assert;
import org.junit.Test;


import java.util.List;

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
     * Positive create delete table testing.
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

    /**
     * Positive querying table testing.
     
    public void runQueryWithResults() {
        PostgreSqlDatabaseController dbController = new PostgreSqlDatabaseController(HOST_ADDRESS, HOST_PORT, DATABASE_NAME, LOGIN, PASSWORD);

        try {
            // we suppose that there not empty table test_table
            dbController.executeScriptAndDeliverResultsTo("Select * from test_table", "test_table",
                    new PostgreSqlColumnType[]{PostgreSqlColumnType.integer, PostgreSqlColumnType.doublePrecision, PostgreSqlColumnType.string},
                    new String[]{"testId", "testDouble", "testString"});
        } catch (Exception e) {
            Assert.fail();
        }
        Assert.assertTrue(true);
    }
*/
    @Test
    public void runQueryWithResults2() {
        PostgreSqlDatabaseController dbController = new PostgreSqlDatabaseController(HOST_ADDRESS, HOST_PORT, DATABASE_NAME, LOGIN, PASSWORD);

        try {
            // we suppose that there not empty table test_table
            List<Object[]> result = dbController.executeScriptAndDeliverResults("Select testint,teststr from test_data_table",
                    new PostgreSqlColumnType[]{PostgreSqlColumnType.integer, PostgreSqlColumnType.string});
            Assert.assertTrue(result.size() == 4);
        } catch (Exception e) {
            Assert.fail();
        }
    }

}
