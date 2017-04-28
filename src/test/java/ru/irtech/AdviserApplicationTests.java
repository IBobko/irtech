package ru.irtech;


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
     * Path to database dump.
     */
    private static final String PATH_TO_DUMP = "/root/data_files";


    @Test
    public void contextLoads() throws SQLException, IOException {

        final DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl("jdbc:postgresql://innsgo.ru:5432/irtech_data");
        dataSource.setUsername("postgres");
        dataSource.setPassword("yOklqXf4");

        final Connection connection = dataSource.getConnection();

        final Statement statement = connection.createStatement();

        String text = "Log of file\n";

        final Path errorsFile = Paths.get("./errors.txt");
        Files.write(errorsFile, text.getBytes(), StandardOpenOption.CREATE, StandardOpenOption.WRITE, StandardOpenOption.TRUNCATE_EXISTING);

        final Path rootPath = Paths.get(PATH_TO_DUMP);

        if (Files.isDirectory(rootPath)) {
            try (final DirectoryStream<Path> stream = Files.newDirectoryStream(rootPath)) {
                for (final Path path : stream) {
                    if (Files.isRegularFile(path)) {

                        try {
                            statement.execute("TRUNCATE TABLE " + path.getFileName());
                        } catch (Exception e) {
                            String message = path.getFileName() + " : " + e.getMessage() + "\n";
                            Files.write(errorsFile, message.getBytes(), StandardOpenOption.CREATE, StandardOpenOption.WRITE, StandardOpenOption.APPEND);
                            System.out.println(e.getMessage());
                            continue;
                        }

                        String[] columns;

                        final InputStream inputStream = new FileInputStream(path.toString());
                        final Reader inputStreamReader = new InputStreamReader(inputStream, "UTF-8");


                        try (BufferedReader br = new BufferedReader(inputStreamReader)) {

                            String sCurrentLine = br.readLine();
                            String sql;
                            if (sCurrentLine != null) {
                                columns = sCurrentLine.split(";");
                            } else {
                                continue;
                            }

                            final List<String> columnsArray = Arrays.asList(columns).subList(1, columns.length);
                            sql = "INSERT INTO " + path.getFileName() + " (" + StringUtils.join(columnsArray, ",") + ")";

                            int currentLine = 0;
                            while ((sCurrentLine = br.readLine()) != null) {
                                currentLine++;
                                String s = sql;

                                s = s + " VALUES (";

                                String[] a = sCurrentLine.split(";");

                                ArrayList<String> c2 = new ArrayList<>();
                                for (int i = 1; i < a.length; i++) {

                                    SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
//
                                    try {
                                        Date d = sdf.parse((a[i]));
                                        SimpleDateFormat psdd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                                        a[i] = psdd.format(d);
                                    } catch (ParseException e) {
                                        //e.printStackTrace();
                                    }

                                    if (a[i].equals("")) {
                                        a[i] = "null";
                                    } else {
                                        a[i] = "'" + a[i] + "'";
                                    }

                                    c2.add(a[i].replace(",", "."));
                                }

                                s = s + StringUtils.join(c2, ",") + ")";

                                System.out.println(s);

                                try {
                                    statement.execute(s);
                                } catch (Exception e) {
                                    String message = path.getFileName() + " : Line: " + currentLine + "; " + e.getMessage() + "\n";
                                    Files.write(errorsFile, message.getBytes(), StandardOpenOption.CREATE, StandardOpenOption.WRITE, StandardOpenOption.APPEND);
                                    System.out.println(e.getMessage());
                                }
                            }
                        }
                    }
                }
            } catch (IOException e) {
                Files.write(errorsFile, e.getMessage().getBytes(), StandardOpenOption.CREATE, StandardOpenOption.WRITE, StandardOpenOption.APPEND);
                throw new RuntimeException(e);
            }
        }

        statement.close();
        connection.close();

    }

}
