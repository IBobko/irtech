package ru.irtech.dao.Scheduler;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.SQLException;

/**
 * Created by Iggytoto on 26.06.2017.
 * Class that implements fail testing for the createTable method of PostgreSqlDataBaseControllerConstructorFalseTest
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class PostgreSqlDataBaseControllerCreateTableNegativeTest extends PostgreSqlDataBaseControllerTest{

    /**
     * False table name as parameter reaction testing.
     */
    @Test
    public void blankTableNameTest() throws SQLException {
        PostgreSqlDatabaseController dbController = new PostgreSqlDatabaseController(HOST_ADDRESS, HOST_PORT, DATABASE_NAME, LOGIN, PASSWORD);
        try {
            dbController.createTable("", testColumnTypes, testColumnNames);
        } catch (IllegalArgumentException e) {
            Assert.assertTrue(true);
            return;
        } catch (ClassNotFoundException e) {
            Assert.fail();
        }
        Assert.fail();
    }

    /**
     * False columnTypes and columnNames as parameter reaction testing.
     */
    @Test
    public void nullsAsColumnValues() throws SQLException {
        PostgreSqlDatabaseController dbController = new PostgreSqlDatabaseController(HOST_ADDRESS, HOST_PORT, DATABASE_NAME, LOGIN, PASSWORD);
        try {
            dbController.createTable("SomeTableName", null, null);
        } catch (IllegalArgumentException e) {
            Assert.assertTrue(true);
            return;
        } catch (ClassNotFoundException e) {
            Assert.fail();
        }
        Assert.fail();
    }

    /**
     * False columnTypes and columnNames as parameter reaction testing.
     */
    @Test
    public void emptyArraysAsColumnValues() throws SQLException {
        PostgreSqlDatabaseController dbController = new PostgreSqlDatabaseController(HOST_ADDRESS, HOST_PORT, DATABASE_NAME, LOGIN, PASSWORD);
        try {
            dbController.createTable("SomeTableName", new PostgreSqlColumnType[0], new String[0]);
        } catch (IllegalArgumentException e) {
            Assert.assertTrue(true);
            return;
        } catch (ClassNotFoundException e) {
            Assert.fail();
        }
        Assert.fail();
    }
}
