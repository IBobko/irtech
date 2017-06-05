package ru.irtech;

import org.apache.commons.lang.StringEscapeUtils;
import org.postgresql.util.PSQLException;
import org.postgresql.util.ServerErrorMessage;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
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

/**
 * @author Igor Bobko <limit-speed@yandex.ru>.
 */
public class LoaderThread implements Runnable {
    private final Path path;
    private Connection connection;
    private final PartOfFile partOfFile;

    LoaderThread(final Path path, final PartOfFile partOfFile) throws IOException {
        this.path = path;
        System.out.println(path.getFileName() + ". Part: " + partOfFile.getFrom() + " from " + Files.size(path));
        this.partOfFile = partOfFile;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " is started");
        try {
            final DriverManagerDataSource dataSource = new DriverManagerDataSource();
            dataSource.setDriverClassName("org.postgresql.Driver");
            dataSource.setUrl("jdbc:postgresql://localhost/irtech_test_data2");
            dataSource.setUsername("postgres");
            dataSource.setPassword("1");
            connection = dataSource.getConnection();
            loadingData();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " finished.");
    }

    /**
     * Parsing one file.
     *
     * @throws FileNotFoundException        if found not exists.
     * @throws UnsupportedEncodingException if Encoding do not supported.
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
                                            System.out.println(serverErrorMessage.getColumn());
                                            notNullColumns.add(i);
                                            break;
                                        }
                                    }
                                } else if (e.getSQLState().equals("42601")) {
                                    break;
                                } else if (e.getSQLState().equals("42804")) {
                                    break;
                                } else if (e.getSQLState().equals("22P02")) {
                                    break;
                                } else {
                                    e.printStackTrace();
                                    break;
                                }
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
     * @param value Original value which stored in CVS file.
     * @return Translated value or empty string if value is null.
     */
    private String formingValue(String value,boolean notNull) {
        if (value == null) return "";
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
     * @return Arrays of connect value for forming SQL or empty array if line is null.
     * @throws IndexOutOfBoundsException if String has an error.
     */
    private List<String> formingArgumentsArray(final String line,List<Integer> notNullColumns) throws IndexOutOfBoundsException {
        final List<String> result = new ArrayList<>();
        if (line == null) return result;
        final String[] arguments = line.split(";",-1);
        result.addAll(Arrays.asList(arguments));
        result.remove(0);
        for (int i = 0; i < result.size(); i++) {
            boolean notNull = false;
            if (notNullColumns.contains(i)) {
                notNull = true;
            }
            result.set(i, formingValue(result.get(i),notNull));
        }
        return result;
    }
}
