package ru.irtech.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.thymeleaf.util.StringUtils;
import ru.irtech.domain.RecommendationDomain;
import ru.irtech.service.RecommendationService;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.*;
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

/**
 * @author Igor Bobko <limit-speed@yandex.ru>.
 */
@RestController
@RequestMapping("/rest-advice")
public class AdviceRestController {

    /**
     * Path to database dump.
     */
    private static final String PATH_TO_DUMP = "/home/igor/irtech/asdsa";

    /**
     * This is used for database manipulations.
     */
    @PersistenceContext
    private EntityManager entityManager;
    /**
     * Service of recommendation.
     */
    private RecommendationService recommendationService;

    public EntityManager getEntityManager() {
        return entityManager;
    }

    private RecommendationService getRecommendationService() {
        return recommendationService;
    }

    @Autowired
    public void setRecommendationService(final RecommendationService recommendationService) {
        this.recommendationService = recommendationService;
    }

    /**
     * Test.
     *
     * @return Test data.
     */
    @RequestMapping("")
    public RecommendationDomain greeting() {
        return getRecommendationService().getAny();
    }

    /**
     * This method loads data to database.
     *
     * @throws SQLException generated if database connection is failed.
     */
    @RequestMapping("/load-data")
    public void loadData() throws SQLException {

        final DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl("jdbc:postgresql://innsgo.ru:5432/irtech_data");
        dataSource.setUsername("postgres");
        dataSource.setPassword("yOklqXf4");

        final Connection connection = dataSource.getConnection();

        final Statement statement = connection.createStatement();

        final Path rootPath = Paths.get(PATH_TO_DUMP);

        if (Files.isDirectory(rootPath)) {
            try (final DirectoryStream<Path> stream = Files.newDirectoryStream(rootPath)) {
                for (final Path path : stream) {
                    if (Files.isRegularFile(path)) {

                        try {
                            statement.execute("TRUNCATE TABLE " + path.getFileName());
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
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
                                    System.out.println(e.getMessage());
                                }
                            }
                        }
                    }
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        statement.close();
        connection.close();
    }
}
