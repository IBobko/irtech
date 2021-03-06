package ru.irtech.dao.Scheduler;

import java.sql.*;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;

/**
 * Created by Iggytoto on 24.06.2017.
 * <p>
 * Class that represents entity that can operate database structure. Create, delete and query tables.
 */
public class PostgreSqlDatabaseController {

    /**
     * Query string.
     */
    private static final String CHECK_TABLE_QUERY = "SELECT * FROM @TABLENAME LIMIT 1";

    /**
     * Tablename token to search and replace it.
     */
    private static final String TABLENAME_TOKEN = "@TABLENAME";

    /**
     * count query string.
     */
    private static final String CHECL_TABLE_ROWS = "SELECT COUNT(*) FROM @TABLENAME LIMIT 1";

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
     * All values are not null.
     *
     * @param name        Table name.
     * @param columnTypes Column types.
     * @param columnNames Column names.
     * @throws SQLException           in case of something is wrong during the script execution.
     * @throws ClassNotFoundException in case if postgresql jdbc driver is not found.
     */
    public void createTable(final String name, final PostgreSqlColumnType[] columnTypes, final String[] columnNames) throws SQLException, ClassNotFoundException {
        if (name.isEmpty() || columnNames == null || columnTypes == null || columnNames.length == 0 || columnTypes.length == 0 || columnNames.length != columnTypes.length) {
            throw new IllegalArgumentException("Column names and types array should be equal range and both should not be empty or null. Also table name should not be empty");
        }

        StringBuilder sb = new StringBuilder();

        sb.append("CREATE TABLE " + name + " (");
        for (int i = 0; i < columnNames.length; i++) {
            sb.append(columnNames[i] + " " + parseColumnType(columnTypes[i]));
            sb.append(" not null");
            if (i != columnNames.length - 1) {
                sb.append(",");
            }
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
        st.execute(script);

        st.close();
    }

    /**
     * Executes script on given connection.
     *
     * @param script     script.
     * @param connection connection.
     * @throws SQLException if something bad happens.
     */
    private void executeScript(final String script, final Connection connection) throws SQLException {
        Statement st = connection.createStatement();
        st.execute(script);

        st.close();
    }

    /**
     * Runs the script and puts the result in given table by given columns and given names.
     *
     * @param script      Script to execute.
     * @param tableName   Table to insert the results.
     * @param columnTypes Resulting database column types.
     * @param columnNames Resulting database column names.
     * @throws SQLException           In case if something happens inside database.
     * @throws ClassNotFoundException in case of postgresql jdbc driver not found.
     * @throws Exception              in some other ways.
     */
    public void executeScriptAndDeliverResultsTo(final String script, final String tableName, final PostgreSqlColumnType[] columnTypes, final String[] columnNames) throws Exception {
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
                        values[i] = rs.getInt(i + 1);
                        break;
                    case doublePrecision:
                        values[i] = rs.getDouble(i + 1);
                        break;
                    case string:
                        values[i] = rs.getString(i + 1);
                        break;
                    default:
                        throw new Exception("Not implemented yet.");
                }
            }

            StringBuilder sb = new StringBuilder();
            sb.append("INSERT INTO " + tableName + " (");
            for (int i = 0; i < columnNames.length; i++) {
                sb.append("\"" + columnNames[i] + "\"");
                if (i != values.length - 1) {
                    sb.append(",");
                }
            }
            sb.append(") VALUES (");

            for (int i = 0; i < values.length; i++) {
                if (columnTypes[i] == PostgreSqlColumnType.string) {
                    sb.append("\'");
                }
                sb.append(values[i].toString());
                if (columnTypes[i] == PostgreSqlColumnType.string) {
                    sb.append("\'");
                }
                if (i != values.length - 1) {
                    sb.append(",");
                }
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
            case string:
                return "text";
            default:
                throw new IllegalArgumentException("Cannot convert:" + value + "to valid postgresql type.");
        }
    }

    /**
     * Checks if table exists in database.
     *
     * @param tableName tablename to check.
     * @return boolean answer.
     * @throws ClassNotFoundException in case there is no pgsql driver.
     */
    public boolean isTableExists(final String tableName) throws ClassNotFoundException {
        try {
            executeScript(CHECK_TABLE_QUERY.replace(TABLENAME_TOKEN, tableName));
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Checks if table has data.
     *
     * @param tableName tablename to check.
     * @return True or false. xD
     * @throws SQLException           in case something bad happens.
     * @throws ClassNotFoundException in case there is no pgsql driver.
     */
    public boolean tableHasData(final String tableName) throws SQLException, ClassNotFoundException {
        Connection connection = getConnection();

        Statement st = connection.createStatement();
        ResultSet rs = st.executeQuery(CHECL_TABLE_ROWS.replace(TABLENAME_TOKEN, tableName));

        rs.next();
        int count = rs.getInt(1);

        rs.close();
        st.close();

        if (count == 0) {
            return false;
        }
        return true;
    }

    /**
     * Method that executes script and returns rows as results.
     *
     * @param script          sql script
     * @param resultStructure result structure
     * @return list of rows
     * @throws SQLException           in case something bad happens.
     * @throws ClassNotFoundException in case there is no pgsql driver.
     * @throws Exception              in some other ways.
     */
    public List<Object[]> executeScriptAndDeliverResults(final String script, final PostgreSqlColumnType[] resultStructure) throws Exception {
        Connection connection = getConnection();

        Statement st = connection.createStatement();
        ResultSet rs = st.executeQuery(script);

        List<Object[]> rowsList = new ArrayList<>();

        while (rs.next()) {
            Object[] row = new Object[resultStructure.length];

            for (int i = 0; i < resultStructure.length; i++) {
                switch (resultStructure[i]) {
                    case integer:
                        row[i] = rs.getInt(i + 1);
                        break;
                    case doublePrecision:
                        row[i] = rs.getDouble(i + 1);
                        break;
                    case string:
                        row[i] = rs.getString(i + 1);
                        break;
                    default:
                        throw new Exception("Not Implemented yet.");
                }
            }

            rowsList.add(row);

        }
        return rowsList;
    }
}
