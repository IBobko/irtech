package ru.irtech;


import org.apache.commons.lang.StringEscapeUtils;
import org.junit.Test;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.thymeleaf.util.StringUtils;

import java.io.*;
import java.nio.file.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

//@RunWith(SpringRunner.class)
//@SpringBootTest
public class AdviserApplicationTests {

    /**
     * Path to errors file.
     */
    final static private Path ERRORS_FILE = Paths.get("./errors.txt");

    /**
     * Path to database dump.
     */
    private static final String PATH_TO_DUMP = "/root/data_files";
    //private static final String PATH_TO_DUMP = "/home/igor/irtech/asdsa";

    /**
     * Append message to the end of the errors file.
     *
     * @param text Message for appending.
     */
    private void appendToErrorsFile(final String text) {
        try {
            Files.write(ERRORS_FILE, text.getBytes(), StandardOpenOption.CREATE, StandardOpenOption.WRITE, StandardOpenOption.APPEND);
            System.out.println(text);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //@Test
    public void contextLoads() throws SQLException, IOException {
        final DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl("jdbc:postgresql://innsgo.ru:5432/irtech_data_test");
        dataSource.setUsername("postgres");
        dataSource.setPassword("yOklqXf4");

        final Connection connection = dataSource.getConnection();

        final Statement statement = connection.createStatement();

        //File file = new File("/home/igor/irtech/data.sql");
        File file = new File("/root/data.sql");
        if (!file.exists()) {
            if (!file.createNewFile()){
                return;
            }
        }
        FileOutputStream fop = new FileOutputStream(file);

        String text = "Log of file\n";

        Files.write(ERRORS_FILE, text.getBytes(), StandardOpenOption.CREATE, StandardOpenOption.WRITE, StandardOpenOption.TRUNCATE_EXISTING);

        final Path rootPath = Paths.get(PATH_TO_DUMP);

        if (Files.isDirectory(rootPath)) {
            try (final DirectoryStream<Path> stream = Files.newDirectoryStream(rootPath)) {
                for (final Path path : stream) {
                    //loadingData(path, statement);
                    loadingDataToFile(path,fop);
                }
            } catch (IOException e) {
                appendToErrorsFile(e.getMessage());
                throw new RuntimeException(e);
            }
        }

        statement.close();
        connection.close();
    }

    /**
     *  Parsing one file.
     *
     * @param path Path to file.
     * @param statement SQL Connection;
     * @throws FileNotFoundException if found not exists.
     * @throws UnsupportedEncodingException if Encoding do not supported.
     */
    private void loadingData(final Path path, final Statement statement) throws FileNotFoundException, UnsupportedEncodingException {
        if (Files.isRegularFile(path)) {
            final String tableName = path.getFileName().toString();
            try {
                statement.execute("TRUNCATE TABLE " + tableName);
            } catch (Exception e) {
                final String message = tableName + " : " + e.getMessage() + "\n";
                appendToErrorsFile(message);
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
                System.out.println(sql);

                int currentLine = 0;
                while ((sCurrentLine = br.readLine()) != null) {
                    currentLine++;
                    final StringBuilder executedString = new StringBuilder(sql);
                    try {
                        final List<String> tmpArgumentsArray = formingArgumentsArray(sCurrentLine);
                        executedString.append("(").append(StringUtils.join(tmpArgumentsArray, ",")).append(");");
                        statement.execute(executedString.toString());
                    } catch (Exception e) {
                        String message = tableName + " : Line: " + currentLine + "; " + e.getMessage() + "\n";
                        appendToErrorsFile(message);
                    }
                }

            } catch (IOException e) {
                appendToErrorsFile(e.getMessage());
            }

        }

    }

    /**
     *  Parsing one file.
     *
     * @param path Path to file.
     * @param fop SQL Connection;
     * @throws FileNotFoundException if found not exists.
     * @throws UnsupportedEncodingException if Encoding do not supported.
     */
    private void loadingDataToFile(final Path path, final FileOutputStream fop) throws FileNotFoundException, UnsupportedEncodingException {
        if (Files.isRegularFile(path)) {
            final String tableName = path.getFileName().toString();

            try {
                fop.write(("TRUNCATE TABLE " + tableName + ";\n").getBytes());

                fop.flush();
            } catch (Exception e) {
                final String message = tableName + " : " + e.getMessage() + "\n";
                appendToErrorsFile(message);
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
                String sql = "\nINSERT INTO " + tableName + " (" + StringUtils.join(columnsArray, ",") + ")" + " VALUES ";
                System.out.println(sql);

                int currentLine = 0;
                while ((sCurrentLine = br.readLine()) != null) {
                    currentLine++;
                    final StringBuilder executedString = new StringBuilder(sql);
                    try {
                        final List<String> tmpArgumentsArray = formingArgumentsArray(sCurrentLine);
                        executedString.append("(").append(StringUtils.join(tmpArgumentsArray, ",")).append(");\n");
                        fop.write(executedString.toString().getBytes());
                    } catch (Exception e) {
                        String message = tableName + " : Line: " + currentLine + "; " + e.getMessage() + "\n";
                        appendToErrorsFile(message);
                    }
                }
            } catch (IOException e) {
                appendToErrorsFile(e.getMessage());
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
        } catch (final ParseException ignored) {}

        if (value.equals("")) {
            value = "null";
        } else {
            value = StringEscapeUtils.escapeSql(value);
            value = "'" + value + "'";
        }
        return value.replace(",", ".");
    }

    /**
     *  This function forms array with correct values for forming of SQL.
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
            result.set(i,formingValue(result.get(i)));
        }
        return result;
    }

}
