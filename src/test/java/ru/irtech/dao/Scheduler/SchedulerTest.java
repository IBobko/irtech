package ru.irtech.dao.Scheduler;

import org.junit.Assert;
import org.junit.Test;
import ru.irtech.dao.Utility.*;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Iggytoto on 15.07.2017.
 */
public class SchedulerTest {

    /**
     * Scheduler test key.
     */
    private final static String TEST_KEY = "TEST_KEY";

    /**
     * test sql.
     */
    private final static String TEST_QUERY = "SELECT testint,teststr FROM test_data_table";

    @Test
    public void SchedulerPositiveTest() throws Exception {

        PostgreSqlDatabaseController controller = getTestController();

        try {
            controller.dropTable(TEST_KEY);
        } catch (Exception e) {
            //its ok
        }
        PostgreSqlScheduler scheduler = PostgreSqlScheduler.getInstance(controller);

        SchedulerType[] structure = new SchedulerType[]{SchedulerType.INTEGER, SchedulerType.STRING};

        SchedulerTableRequestSchema schema = new SchedulerTableRequestSchema(TEST_QUERY, TEST_KEY, structure);

        //there is no taks yet so if should give exception.
        try {
            scheduler.getDataEntities(TEST_KEY, schema);
        } catch (SchedulerTableNotFoundException e) {
            //ITS OK
        } catch (SchedulerNoDataYetException e) {
            Assert.fail();
        } catch (ClassNotFoundException e) {
            Assert.fail();
        } catch (SQLException e) {
            Assert.fail();
        }

        try {
            scheduler.queueRequest(TEST_KEY, schema);
        } catch (SchedulerAlreadyRequestedException e) {
            Assert.fail();
        } catch (ClassNotFoundException e) {
            Assert.fail();
        } catch (SQLException e) {
            Assert.fail();
        }

        try {
            scheduler.queueRequest(TEST_KEY, schema);
        } catch (SchedulerAlreadyRequestedException e) {
            //ITS OK
        } catch (ClassNotFoundException e) {
            Assert.fail();
        } catch (SQLException e) {
            Assert.fail();
        }


        Thread.sleep(1000);

        try {
            List<Object[]> restult = scheduler.getDataEntities(TEST_KEY, schema);
            Assert.assertTrue(restult.size() != 0);
        } catch (ClassNotFoundException e) {
            Assert.fail();
        } catch (SQLException e) {
            Assert.fail();
        } catch (SchedulerTableNotFoundException e) {
            Assert.fail();
        } catch (SchedulerNoDataYetException e) {
            //could be ok
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
