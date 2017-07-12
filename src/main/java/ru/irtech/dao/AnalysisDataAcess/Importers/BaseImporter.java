package ru.irtech.dao.AnalysisDataAcess.Importers;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Iggytoto on 16.04.2017.
 * Base importer class
 */
abstract class BaseImporter {

    /**
     * SQL folder path.
     */
    protected static final String SQL_FOLDER_PATH = "src/main/java/ru/irtech/dao/AnalysisDataAcess/Importers/SqlScripts/";

    /**
     * Method that returns connection to database.
     *
     * @param databaseName database name to connect to.
     * @return java.sql.Connection instance or NULL if something bad happened.
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
                    //TODO TO CONFIGURATION
                    "jdbc:postgresql://188.130.155.86:5432/" + databaseName, "postgres", "yOklqXf4");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    /**
     * Method that reads all file data to single string.
     * In this class it should be applied only to sql load to string.
     *
     * @param path     path to file.
     * @param encoding encoding.
     * @return complete file in one string.
     * @throws IOException when had it.
     */
    protected String readSql(final String path, final Charset encoding)
            throws IOException {
        byte[] encoded = Files.readAllBytes(Paths.get(SQL_FOLDER_PATH + path));
        return new String(encoded, encoding);
    }
}
