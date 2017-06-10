package ru.irtech.dao.AnalysisDataAcess.Importers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Iggytoto on 16.04.2017.
 * Base importer class
 */
abstract class BaseImporter implements ICsvImporter {
    /**
     * Method that returns connection to database.
     *
     * @param databaseName database name to connect to
     * @return java.sql.Connection instance or NULL if something bad happened
     */
    Connection getConnection(final String databaseName) {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(
                    "jdbc:postgresql://188.130.155.86:5432/" + databaseName, "postgres", "yOklqXf4");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
