package ru.irtech.dao.Scheduler;

import org.junit.Assert;
import org.junit.Test;
import ru.irtech.dao.Utility.SchedulerTableRequestSchema;
import ru.irtech.dao.Utility.SchedulerType;

import java.sql.SQLException;

/**
 * Created by Iggytoto on 14.07.2017.
 */
public class SchedulerTaskTest {

    /**
     * Test db name string.
     */
    private final static String TEST_DB_NAME = "JustTestDb";

    /**
     * test query.
     */
    private final static String TEST_SQL = "SELECT testint,teststr FROM test_data_table";

    /**
     * test key.
     */
    private final static String TEST_KEY = "test_key";

    @Test
    public void SchedulerSimplePositiveTest() throws InterruptedException {
        PostgreSqlDatabaseController controller = getTestController();

        SchedulerTableRequestSchema schema = new SchedulerTableRequestSchema(TEST_SQL, TEST_DB_NAME, new SchedulerType[]{SchedulerType.INTEGER, SchedulerType.STRING});

        try {
            controller.dropTable(TEST_DB_NAME);
        } catch (Exception e) {
            // just skip
        }

        ScheduledTask task = new ScheduledTask(TEST_DB_NAME, schema, controller);

        Thread t = new Thread(task);
        t.start();
        t.join();

        try {
            controller.dropTable(TEST_DB_NAME);
            Assert.assertTrue(true);
        } catch (SQLException e) {
            e.printStackTrace();
            Assert.fail();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            Assert.fail();
        }

    }

    /**
     * Returns test controller.
     *
     * @return
     */
    private PostgreSqlDatabaseController getTestController() {
        return new PostgreSqlDatabaseController(
                PostgreSqlDataBaseControllerTest.HOST_ADDRESS,
                PostgreSqlDataBaseControllerTest.HOST_PORT,
                PostgreSqlDataBaseControllerTest.DATABASE_NAME,
                PostgreSqlDataBaseControllerTest.LOGIN,
                PostgreSqlDataBaseControllerTest.PASSWORD);
    }
}
