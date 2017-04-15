package ru.irtech;

import com.sun.deploy.util.StringUtils;
import org.junit.Test;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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

    @Test
    public void contextLoads() throws SQLException {

        final DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl("jdbc:postgresql://innsgo.ru:5432/irtech_data");
        dataSource.setUsername("postgres");
        dataSource.setPassword("yOklqXf4");

        final Connection connection = dataSource.getConnection();

        final Statement statement = connection.createStatement();

        final Path rootPath = Paths.get("/home/igor/irtech/asdsa");

        if (Files.isDirectory(rootPath)) {
            try (final DirectoryStream<Path> stream = Files.newDirectoryStream(rootPath)) {
                for (final Path path : stream) {
                    if (Files.isRegularFile(path)) {

                        try {
                            statement.execute("TRUNCATE TABLE " + path.getFileName());
                        } catch (Exception e) {
                        }

                        String[] columns;
                        BufferedReader br = new BufferedReader(
                                new FileReader(path.toString()));
                        String sCurrentLine = br.readLine();
                        String sql;
                        if (sCurrentLine != null) {
                            columns = sCurrentLine.split(";");
                        } else {
                            continue;
                        }

                        final List<String> columnsArray = Arrays.asList(columns).subList(1, columns.length);
                        sql = "INSERT INTO " + path.getFileName() + " (" + StringUtils.join(columnsArray, ",") + ")";

                        while ((sCurrentLine = br.readLine()) != null) {
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
                                // e.printStackTrace();
                            }
                        }
                    }
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }


    }

}
