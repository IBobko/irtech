package ru.irtech.importer;

import org.apache.commons.lang.StringEscapeUtils;
import org.postgresql.util.PSQLException;
import org.postgresql.util.ServerErrorMessage;
import org.thymeleaf.util.StringUtils;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;

/**
 * @author Igor Bobko <limit-speed@yandex.ru>.
 */
public class LoaderThread implements Callable<Long> {
    /**
     * An instance of java.nio.file.Path that contains the path to the current file.
     */
    private final Path path;

    /**
     * The connection to database.
     */
    private Connection connection;

    /**
     * The part of file for performing.
     */
    private final PartOfFile partOfFile;

    /**
     * The constructor which initialize variables.
     *
     * @param path An instance of java.nio.file.Path that contains the path to the current file.
     * @param partOfFile The part of file for performing.
     */
    LoaderThread(final Path path, final PartOfFile partOfFile) {
        this.path = path;
        this.partOfFile = partOfFile;
    }

    /**
     * Inserts the interval of the file to the database.
     *
     * @throws IOException .
     * @throws SQLException .
     */
    private void loadingData() throws IOException, SQLException {
        if (Files.isRegularFile(path)) {
            try (final Statement statement = connection.createStatement()) {
                final String tableName = path.getFileName().toString();
                final Long to = partOfFile.getTo();
                final InputStream inputStream = new FileInputStream(path.toString());
                final Long from = inputStream.skip(partOfFile.getFrom());

                final Reader inputStreamReader = new InputStreamReader(inputStream, "UTF-8");

                final List<String> columnsArray = partOfFile.getColumns().subList(1, partOfFile.getColumns().size());
                final String sql = "INSERT INTO " + tableName + " (" + StringUtils.join(columnsArray, ",") + ")";
                List<Integer> notNullColumns = new ArrayList<>();
                try (final BufferedReader br = new BufferedReader(inputStreamReader)) {
                    String sCurrentLine;
                    long read = 0;
                    while ((sCurrentLine = br.readLine()) != null) {
                        read += sCurrentLine.getBytes().length + DividerIntoParts.NUMBER_BYTES_OF_END_OF_STRING;
                        if (to != null && read + from >= to) {
                            break;
                        }
                        while (true) {
                            final StringBuilder executedString = new StringBuilder(sql);
                            final List<String> tmpArgumentsArray = formingArgumentsArray(sCurrentLine, notNullColumns);
                            executedString.append(" VALUES(").append(StringUtils.join(tmpArgumentsArray, ",")).append(");");
                            try {
                                statement.execute(executedString.toString());
                                break;
                            } catch (PSQLException e) {
                                if (e.getSQLState().equals("42P01")) {
                                    return;
                                } else if (e.getSQLState().equals("23502")) {
                                    ServerErrorMessage serverErrorMessage = e.getServerErrorMessage();
                                    for (int i = 0; i < columnsArray.size(); i++) {
                                        if (columnsArray.get(i).equalsIgnoreCase(serverErrorMessage.getColumn())) {
                                            notNullColumns.add(i);
                                            break;
                                        }
                                    }
                                } else if (e.getSQLState().equals("42601")) {

                                } else if (e.getSQLState().equals("42804")) {

                                } else if (e.getSQLState().equals("22P02")) {

                                } else {

                                }
                                System.out.println(path.getFileName().toString());
                                e.printStackTrace();
                                if (!path.getFileName().toString().equalsIgnoreCase("LESSONS")&&
                                        !path.getFileName().toString().equalsIgnoreCase("EVENTS") && !path.getFileName().toString().equalsIgnoreCase("UNITS") &&
                                        !path.getFileName().toString().equalsIgnoreCase("SCHOOLDOCS") &&
                                        !path.getFileName().toString().equalsIgnoreCase("USERSPARAMETERS") && !path.getFileName().toString().equalsIgnoreCase("ADD_PROGRAMS")) {
                                    System.out.println();
                                }
                                break;
                            }
                        }
                    }
                } catch (Exception e) {
                    //String message = tableName + " : Line: " + currentLine + "; " + e.getMessage() + "\n";
                    //System.out.println(message);
                    //appendToErrorsFile(message);
                }
            } finally {
                connection.close();
            }
        }

    }

    /**
     * This function converts the value to SQL format and adds quotes if value is not empty and replaces value to null if so.
     *
     * @param v Original value which stored in CVS file.
     * @param notNull True if value must not be null.
     * @return Translated value or empty string if value is null.
     */
    private String formingValue(final String v, final boolean notNull) {
        if (v == null) {
            return "";
        }
        String value = v;
        try {
            final SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
            final Date date = sdf.parse(value);
            SimpleDateFormat simpleDateFormatOfDatabase = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            value = simpleDateFormatOfDatabase.format(date);
        } catch (final ParseException ignored) {
        }

        switch (value) {
            case "False":
                value = "0";
                break;
            case "True":
                value = "1";
                break;
            case "":
                if (notNull) {
                    value = "''";
                } else {
                    value = "null";
                }
                break;
            default:
                value = StringEscapeUtils.escapeSql(value);
                value = "'" + value + "'";
                break;
        }
        return value.replace(",", ".");
    }

    /**
     * This function forms array with correct values for forming of SQL.
     *
     * @param line Original line from CSV file.
     * @param notNullColumns List of not null columns.
     * @return Arrays of connect value for forming SQL or empty array if line is null.
     * @throws IndexOutOfBoundsException if String has an error.
     */
    private List<String> formingArgumentsArray(final String line, final List<Integer> notNullColumns) throws IndexOutOfBoundsException {
        final List<String> result = new ArrayList<>();
        if (line == null) {
            return result;
        }
        final String[] arguments = line.split(AdviserImporter.getProperties().getProperty("csv.delimiter"), -1);
        result.addAll(Arrays.asList(arguments));
        result.remove(0);
        for (int i = 0; i < result.size(); i++) {
            boolean notNull = false;
            if (notNullColumns.contains(i)) {
                notNull = true;
            }
            result.set(i, formingValue(result.get(i), notNull));
        }
        return result;
    }

    @Override
    public Long call() throws Exception {
        System.out.println(Thread.currentThread().getName() + " is started. The table is " + path.getFileName().toString());
        try {
            connection = AdviserImporter.getDriverManagerDataSource().getConnection();
            loadingData();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " finished. The table is " + path.getFileName().toString());
        long sizeOfFile = Files.size(path);
        if (partOfFile.getTo() == null) {
            return sizeOfFile - partOfFile.getFrom();
        }
        return partOfFile.getTo() - partOfFile.getFrom();
    }
}
