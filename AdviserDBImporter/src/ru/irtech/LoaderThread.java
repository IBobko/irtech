package ru.irtech;

import org.apache.commons.lang.StringEscapeUtils;
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
import java.util.concurrent.CountDownLatch;

/**
 * @author Igor Bobko <limit-speed@yandex.ru>.
 */
public class LoaderThread implements Runnable {
    private final CountDownLatch doneSignal;
    private Path path;
    private Connection connection;

    LoaderThread(CountDownLatch doneSignal, final Path path, final Connection connection) throws IOException {
        this.doneSignal = doneSignal;
        this.path = path;
        this.connection = connection;
        System.out.println(path.getFileName() + " " + Files.size(path));
    }

    private List<Long> divideIntoParts() throws IOException {
        final InputStream inputStreamReader = new FileInputStream(path.toString());
        long portion = 1000;
        final List<Long> positions = new ArrayList<>();
        long currentPosition = 0;

        main:
        while (inputStreamReader.skip(portion) == portion) {
            currentPosition += portion;
            while (true) {
                int r = inputStreamReader.read();
                if (r == -1) {
                    break main;
                }
                char c = (char) r;
                if (c == '\n') {
                    positions.add(currentPosition);
                    break;
                }
                currentPosition++;
            }
        }
        positions.forEach(System.out::println);
        return positions;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " is started");

        try {

            List<Long> positions = divideIntoParts();



            //loadingData();

        } catch (Exception e) {
            e.printStackTrace();


        }
        doneSignal.countDown();
    }

    /**
     * Parsing one file.
     *
     * @throws FileNotFoundException        if found not exists.
     * @throws UnsupportedEncodingException if Encoding do not supported.
     */
    private void loadingData() throws FileNotFoundException, UnsupportedEncodingException, SQLException {
        if (Files.isRegularFile(path)) {
            final Statement statement = connection.createStatement();
            final String tableName = path.getFileName().toString();
            try {
                statement.execute("TRUNCATE TABLE " + tableName);
            } catch (Exception e) {
                final String message = tableName + " : " + e.getMessage() + "\n";
                System.out.println(message);
                //appendToErrorsFile(message);
                return;
            }

            final InputStream inputStream = new FileInputStream(path.toString());


            final Reader inputStreamReader = new InputStreamReader(inputStream, "UTF-8");


            try (final BufferedReader br = new BufferedReader(inputStreamReader)) {
                final String[] columns;
                String sCurrentLine = br.readLine();
                if (sCurrentLine != null) {
                    columns = sCurrentLine.split(";");
                } else {
                    return;
                }

                final List<String> columnsArray = Arrays.asList(columns).subList(1, columns.length);
                String sql = "INSERT INTO " + tableName + " (" + StringUtils.join(columnsArray, ",") + ")";

                int currentLine = 0;
                int iter = 1;
                try {
                    while ((sCurrentLine = br.readLine()) != null) {
                        currentLine++;
                        final StringBuilder executedString = new StringBuilder(sql);

                        final List<String> tmpArgumentsArray = formingArgumentsArray(sCurrentLine);
                        executedString.append(" VALUES(").append(StringUtils.join(tmpArgumentsArray, ",")).append(");");
                        System.out.println(executedString.toString());

                        statement.addBatch(executedString.toString());

                        if (((double) currentLine / (double) 10 * (double) iter) > 1) {
                            statement.executeBatch();
                            iter++;
                            statement.clearBatch();
                        }

                    }
                } catch (Exception e) {
                    String message = tableName + " : Line: " + currentLine + "; " + e.getMessage() + "\n";
                    System.out.println(message);
                    //appendToErrorsFile(message);
                }


                statement.executeBatch();
                System.out.println("The end");

            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }

    /**
     * This function converts the value to SQL format and adds quotes if value is not empty and replaces value to null if so.
     *
     * @param value Original value which stored in CVS file.
     * @return Translated value or empty string if value is null.
     */
    private String formingValue(String value) {
        if (value == null) return "";
        try {
            final SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
            final Date date = sdf.parse(value);
            SimpleDateFormat simpleDateFormatOfDatabase = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            value = simpleDateFormatOfDatabase.format(date);
        } catch (final ParseException ignored) {
        }

        if (value.equals("")) {
            value = "null";
        } else {
            value = StringEscapeUtils.escapeSql(value);
            value = "'" + value + "'";
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
    private List<String> formingArgumentsArray(final String line) throws IndexOutOfBoundsException {
        final List<String> result = new ArrayList<>();
        if (line == null) return result;
        final String[] arguments = line.split(";");
        result.addAll(Arrays.asList(arguments));
        result.remove(0);
        if (line.endsWith(";")) {
            result.add("");
        }
        for (int i = 0; i < result.size(); i++) {
            result.set(i, formingValue(result.get(i)));
        }
        return result;
    }

}
