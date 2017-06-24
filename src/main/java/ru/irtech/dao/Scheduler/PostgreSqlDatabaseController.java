package ru.irtech.dao.Scheduler;

import java.sql.*;
import java.util.Formatter;

/**
 * Created by Iggytoto on 24.06.2017.
 * <p>
 * Class that represents entity that can operate database structure. Create, delete and query tables.
 */
public class PostgreSqlDatabaseController {

    /**
     * Database server host.
     */
    private final String host;

    /**
     * Database name.
     */
    private final String dataBaseName;

    /**
     * Database login.
     */
    private final String login;

    /**
     * Database password.
     */
    private final String password;

    /**
     * Database port.
     */
    private final String port;

    /**
     * Main C-tor.
     *
     * @param host         Database host to connect to.
     * @param port         Database port to connect to.
     * @param databaseName Database name.
     * @param login        Login.
     * @param password     Password.
     */
    public PostgreSqlDatabaseController(final String host, final String port, final String databaseName, final String login, final String password) {
        this.host = host;
        this.port = port;
        this.dataBaseName = databaseName;
        this.login = login;
        this.password = password;
    }

    /**
     * Creates connection to the database.
     *
     * @return Connection instance.
     * @throws ClassNotFoundException In case if Postrgresql jdbc driver is not found.
     * @throws SQLException           If something is gone wrong during the connection.
     */
    private Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        Connection connection = null;
        connection = DriverManager.getConnection(getConnectionString(), this.login, this.password);
        return connection;
    }

    /**
     * Creates connection string from given credentials of this instance.
     *
     * @return postgresql jdbc connection string.
     */
    private String getConnectionString() {
        StringBuilder sb = new StringBuilder();
        Formatter f = new Formatter(sb);
        f.format("jdbc:postgresql://%1$s:%2$s/%3$s", this.host, this.port, this.dataBaseName);
        return sb.toString();
    }

    /**
     * Creates a table in the database with given name, schema and column names.
     * Primary key is always the first column.
     * All values are not null.
     *
     * @param name        Table name.
     * @param columnTypes Column types.
     * @param columnNames Column names.
     * @throws SQLException           in case of something is wrong during the script execution.
     * @throws ClassNotFoundException in case if postgresql jdbc driver is not found.
     */
    public void createTable(final String name, final PostgreSqlColumnType[] columnTypes, final String[] columnNames) throws SQLException, ClassNotFoundException {
        if (columnNames.length != columnTypes.length) {
            throw new IllegalArgumentException("Column names and types array should be equal range");
        }

        StringBuilder sb = new StringBuilder();

        sb.append("CREATE TABLE " + name + " (");
        for (int i = 0; i < columnNames.length; i++) {
            sb.append(columnNames[i] + " " + parseColumnType(columnTypes[i]));
            if (i == 0) {
                sb.append(" primary key");
            } else {
                sb.append(" not null");
            }

            sb.append(",");
        }
        sb.append(")");

        executeScript(sb.toString());
    }

    /**
     * Drops the given table.
     *
     * @param name table to drop.
     * @throws SQLException           in case of something is wrong during the script execution.
     * @throws ClassNotFoundException in case if postgresql jdbc driver is not found.
     */
    public void dropTable(final String name) throws SQLException, ClassNotFoundException {
        executeScript("DROP TABLE " + name);
    }

    /**
     * Executes given script on taget database.
     *
     * @param script script to execute.
     * @throws SQLException           In case if something happens inside database.
     * @throws ClassNotFoundException in case of postgresql jdbc driver not found.
     */
    private void executeScript(final String script) throws SQLException, ClassNotFoundException {
        Connection connection = getConnection();

        Statement st = connection.createStatement();
        st.executeQuery(script);

        st.close();
    }

    /**
     * Runs the script and puts the result in given table by given columns and given names.
     *
     * @param script       Script to execute.
     * @param databaseName Database to insert the results.
     * @param columnTypes  Resulting database column types.
     * @param columnNames  Resulting database column names.
     * @throws SQLException           In case if something happens inside database.
     * @throws ClassNotFoundException in case of postgresql jdbc driver not found.
     */
    public void executeScriptAndDeliverResultsTo(final String script, final String databaseName, final PostgreSqlColumnType[] columnTypes, final String[] columnNames) throws SQLException, ClassNotFoundException {
        if (columnNames.length != columnTypes.length) {
            throw new IllegalArgumentException("Column names and types array should be equal range");
        }
        Connection connection = getConnection();

        Statement st = connection.createStatement();
        ResultSet rs = st.executeQuery(script);
        while (rs.next()) {
            Object[] values = new Object[columnNames.length];
            for (int i = 0; i < columnNames.length; i++) {
                switch (columnTypes[i]) {
                    case integer:
                        values[i] = rs.getInt(i);
                    case doublePrecision:
                        values[i] = rs.getDouble(i);
                    case string10:
                    case string25:
                    case string100:
                        values[i] = rs.getString(i);
                }
            }

            StringBuilder sb = new StringBuilder();
            sb.append("INSERT INTO " + databaseName + "(");
            for (int i = 0; i < columnNames.length; i++) {
                sb.append(columnNames[i] + ",");
            }
            sb.append(") VALUES (");

            for (int i = 0; i < values.length; i++) {
                sb.append(values[i].toString() + ",");
            }
            sb.append(")");

            executeScript(sb.toString());
        }

        rs.close();
        st.close();
    }

    /**
     * Parses the value type to the correct type from postgresql.
     *
     * @param value given string.
     * @return valid postgresql type name.
     */
    private String parseColumnType(final PostgreSqlColumnType value) {
        switch (value) {
            case doublePrecision:
                return "real";
            case integer:
                return "integer";
            case string10:
                return "varchar(10)";
            case string25:
                return "varchar(25)";
            case string100:
                return "varchar(100)";
            default:
                throw new IllegalArgumentException("Cannot convert:" + value + "to valid postgresql type.");
        }
    }

}
