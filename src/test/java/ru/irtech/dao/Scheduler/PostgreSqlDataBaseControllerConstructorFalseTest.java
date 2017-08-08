package ru.irtech.dao.Scheduler;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.SQLException;

/**
 * Created by Iggytoto on 25.06.2017.
 * Class that implements fail testing for the constructor of PostgreSqlDataBaseControllerConstructorFalseTest
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class PostgreSqlDataBaseControllerConstructorFalseTest extends PostgreSqlDataBaseControllerTest{

    /**
     * False host testing during constructor value injection.
     */
    @Test
    public void hostTest() {
        PostgreSqlDatabaseController dbController = new PostgreSqlDatabaseController("127.0.0.3", HOST_PORT, DATABASE_NAME, LOGIN, PASSWORD);
        try {
            dbController.createTable("tablename", testColumnTypes, testColumnNames);
        } catch (SQLException e) {
            Assert.assertTrue(true);
            return;
        } catch (ClassNotFoundException e) {
            Assert.fail();
        }
        Assert.fail();
    }

    /**
     * False port testing during constructor value injection.
     */
    @Test
    public void portTest() {
        PostgreSqlDatabaseController dbController = new PostgreSqlDatabaseController(HOST_ADDRESS, "-33", DATABASE_NAME, LOGIN, PASSWORD);
        try {
            dbController.createTable("tablename", testColumnTypes, testColumnNames);
        } catch (SQLException e) {
            Assert.assertTrue(true);
            return;
        } catch (ClassNotFoundException e) {
            Assert.fail();
        }
        Assert.fail();
    }

    /**
     * False database name testing during constructor value injection.
     */
    @Test
    public void dbNameTest() {
        PostgreSqlDatabaseController dbController = new PostgreSqlDatabaseController(HOST_ADDRESS, HOST_PORT, "SomeUnknownDatabase", LOGIN, PASSWORD);
        try {
            dbController.createTable("tablename", testColumnTypes, testColumnNames);
        } catch (SQLException e) {
            Assert.assertTrue(true);
            return;
        } catch (ClassNotFoundException e) {
            Assert.fail();
        }
        Assert.fail();
    }

    /**
     * False login name testing during constructor value injection.
     */
    @Test
    public void loginTest() {
        PostgreSqlDatabaseController dbController = new PostgreSqlDatabaseController(HOST_ADDRESS, HOST_PORT, DATABASE_NAME, "SomeUnknownLogin", PASSWORD);
        try {
            dbController.createTable("tablename", testColumnTypes, testColumnNames);
        } catch (SQLException e) {
            Assert.assertTrue(true);
            return;
        } catch (ClassNotFoundException e) {
            Assert.fail();
        }
        Assert.fail();
    }

    /**
     * False login name testing during constructor value injection.
     */
    @Test
    public void passwordTest() {
        PostgreSqlDatabaseController dbController = new PostgreSqlDatabaseController(HOST_ADDRESS, HOST_PORT, DATABASE_NAME, LOGIN, "SomeUnknownPassword");
        try {
            dbController.createTable("tablename", testColumnTypes, testColumnNames);
        } catch (SQLException e) {
            Assert.assertTrue(true);
            return;
        } catch (ClassNotFoundException e) {
            Assert.fail();
        }
        Assert.fail();
    }
}
