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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

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

    @Test
    public void contextLoads() throws SQLException, IOException {
        final DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl("jdbc:postgresql://innsgo.ru:5432/irtech_data_test");
        dataSource.setUsername("postgres");
        dataSource.setPassword("yOklqXf4");

        final Connection connection = dataSource.getConnection();

        final Statement statement = connection.createStatement();


        //loadingData(Paths.get(PATH_TO_DUMP + "/SENIORITIES" ),statement);



        String text = "Log of file\n";

        Files.write(ERRORS_FILE, text.getBytes(), StandardOpenOption.CREATE, StandardOpenOption.WRITE, StandardOpenOption.TRUNCATE_EXISTING);

        final Path rootPath = Paths.get(PATH_TO_DUMP);

        if (Files.isDirectory(rootPath)) {
            try (final DirectoryStream<Path> stream = Files.newDirectoryStream(rootPath)) {
                for (final Path path : stream) {
                    loadingData(path, statement);
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
                final String sql = "INSERT INTO " + tableName + " (" + StringUtils.join(columnsArray, ",") + ")";

                int currentLine = 0;
                while ((sCurrentLine = br.readLine()) != null) {
                    currentLine++;
                    final StringBuilder executedString = new StringBuilder(sql);

                    executedString.append(" VALUES (");

                    final String[] arguments = sCurrentLine.split(";");

                    final ArrayList<String> tmpArgumentsArray = new ArrayList<>();
                    tmpArgumentsArray.addAll(Arrays.asList(arguments));
                    tmpArgumentsArray.remove(0);

                    if (sCurrentLine.endsWith(";")) {
                        tmpArgumentsArray.add("");
                    }

                    for (int i = 0; i < tmpArgumentsArray.size(); i++) {
                        String value = tmpArgumentsArray.get(i);

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
                        value = value.replace(",", ".");
                        tmpArgumentsArray.set(i,value);
                    }

                    executedString.append(StringUtils.join(tmpArgumentsArray, ",")).append(")");

                    System.out.println(executedString);

                    try {
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

}
