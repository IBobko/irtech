package ru.irtech.importer;

import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author Igor Bobko <limit-speed@yandex.ru>.
 */

public class AdviserImporter {
    private static final Integer MAX_THREADS = 800;
    private static final Integer TIME_FOR_WAIT = 500;
    /**
     * The path to the error file.
     */
    final static private Path ERRORS_FILE = Paths.get("./errors.txt");
    private static volatile Long ALREADY_DONE_BYTES = 0L;
    private static Properties properties = new Properties();

    static {
        System.setProperty("org.apache.commons.logging.Log",
                "org.apache.commons.logging.impl.NoOpLog");
    }

    private String[] LACK_OF_TABLES = {"SG_ST_VARIANTS",
            "GETPOSTYPES",
            "GETCOMMONSCHOOLTERMS",
            "SGGHours",
            "YEAR_TEACHER_SUBJ",
            "SG_GRADES",
            "SG_CLASSES_TERMS",
            "STUDENTS_EDUC_RANGES",
            "UserParamValues",
            "GETSTAFFINFO",
            "GET_CURICULUM_BY_SUBJGROUPS",
            "GET_MOV_EOS_DOU_EX",
            "GET_STUDENTSCLASSES",
            "CLS_ST_VARIANTS",
            "STUDENTS_YEARS_CATEGORIES_2",
            "STUDENTS_YEARS_CATEGORIES",
            "INDICATORS_RELATIONS_ALL",
            "GET_SY_CLASSESGRADES",
            "SG_TEACHERS",
            "SG_ST_VARIANTS_UNION",
            "CSGHours",
            "GETYEARTOTALS",
            "StudentsRanges",
            "ST_IUPGRADES_VARIANTS",
            "sysdiagrams",
            "EM_PROVINCES",
            "FOUNDERS_WITH_PARENTS",
            "STUDENTS_SCHOOLS_CATEGORIES",
            "GET_NUMBER_OF_STUDENTS_UDOD",
            "UserParamItems",
            "CLS_ST_VARIANTS_CLASSIC",
            "YEAR_TEACHER_ClASSES",
            "CSG_GRADES",
            "SGHours",
            "REVISIONSYEARSSECTIONS",
            "USER_YEAR_PARAMETERS",
            "UserParamDates",
            "EM_DISTRICTS",
            "GET_PARENTPAY_DEBT",
            "ST_GRADES_VARIANTS",
            "YEAR_TEACHER_GRADES",
            "STUDENTS_DATERANGES_CATEGORIES",
            "STAFFTERMSUMS",
            "GET_CUR_HOURS_BY_CLASS",
            "TOTALS_AND_LAST_TERM_YEARTOTALS",
            "SGG_CLASSES_TERMS_STUDENTS",
            "EM_CITIES",
            "INDICATORS_RELATIONS_ROOTS",
            "SG_TEACHERS_TERMS",
            "ISG_GRADES",
            "SG_CLASSES",
            "SG_ACTIVITIES_GRADINGSYSTEMS",
            "SGG_ST_VARIANTS_IUP"};
    private List<Future> futures = new CopyOnWriteArrayList<>();

    private static Properties getProperties() {
        return properties;
    }

    /**
     * The start method.
     *
     * @param args The first parameter is the directory path with the database dump.
     * @throws IOException  .
     * @throws SQLException .
     */
    public static void main(String[] args) throws IOException, SQLException, InterruptedException, URISyntaxException {
        if (args.length < 1) {
            System.out.println("Data folder is not specified.");
        }
        getProperties().load(AdviserImporter.class.getClassLoader().getResourceAsStream("config.properties"));
        final AdviserImporter importer = new AdviserImporter();
        importer.startLoading(args[0]);
    }

    static DriverManagerDataSource getDriverManagerDataSource() {
        final DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(getProperties().getProperty("db.driver"));
        dataSource.setUrl(getProperties().getProperty("db.url"));
        dataSource.setUsername(getProperties().getProperty("db.user"));
        dataSource.setPassword(getProperties().getProperty("db.password"));
        return dataSource;
    }

    /**
     * The initializing of the logging file.
     *
     * @throws IOException .
     */
    private void startLogging() throws IOException {
        final String text = "Log of file\n";
        Files.write(ERRORS_FILE, text.getBytes(), StandardOpenOption.CREATE, StandardOpenOption.WRITE, StandardOpenOption.TRUNCATE_EXISTING);
    }

    /**
     * Append message to the end of the errors file.
     *
     * @param text Message for appending.
     */
    @SuppressWarnings("unused")
    private void appendToErrorsFile(final String text) {
        try {
            Files.write(ERRORS_FILE, text.getBytes(), StandardOpenOption.CREATE, StandardOpenOption.WRITE, StandardOpenOption.APPEND);
            System.out.println(text);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void startLoading(String pathToDump) throws SQLException, IOException, InterruptedException {
        startLogging();
        final Path rootPath = Paths.get(pathToDump);
        long times = System.currentTimeMillis();
        long totalSize = 0;

        final List<String> lackOfTables = Arrays.asList(LACK_OF_TABLES);
        for (int i = 0; i < lackOfTables.size(); i++) {
            lackOfTables.set(i, lackOfTables.get(i).toUpperCase());
        }

        if (Files.isDirectory(rootPath)) {
            try (final DirectoryStream<Path> stream = Files.newDirectoryStream(rootPath)) {
                final List<Path> paths = new ArrayList<>();
                final ExecutorService executorService = Executors.newCachedThreadPool();
                final ExecutorService executorServiceForDb = Executors.newFixedThreadPool(MAX_THREADS);
                long totalFileSize = 0;
                for (final Path path : stream) {
                    if (!lackOfTables.contains(path.getFileName().toString().toUpperCase())) {
                        paths.add(path);
                        long fileSize = Files.size(path);
                        totalFileSize += fileSize;
                    }
                }
                final long TOTAL_FILE_SIZE = totalFileSize;

                for (final Path path : paths) {
                    totalSize += Files.size(path);
                    truncateTable(path.getFileName().toString());
                    executorService.submit(() -> {
                        final DividerIntoParts dividerIntoParts;
                        try {
                            dividerIntoParts = new DividerIntoParts(path);
                        } catch (IOException e) {
                            return;
                        }
                        for (int i = 0; i < dividerIntoParts.getSize(); i++) {
                            final Integer currentIndex = i;
                            try {
                                final LoaderThread loaderThread = new LoaderThread(path, dividerIntoParts.getPart(currentIndex));
                                final Future future = executorServiceForDb.submit(loaderThread);
                                futures.add(future);

                                final List<Future> futures_temp = new ArrayList<>();
                                futures_temp.addAll(futures);
                                for (final Future future_temp : futures_temp) {
                                    if (future_temp.isDone() || future_temp.isCancelled()) {
                                        ALREADY_DONE_BYTES += (Long) future_temp.get();
                                        futures.remove(future_temp);
                                        System.out.println("Already done: " + (ALREADY_DONE_BYTES * 100 / TOTAL_FILE_SIZE) + "% or Made " + ALREADY_DONE_BYTES + " from " + TOTAL_FILE_SIZE);
                                    }
                                }
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    });
                }
                executorService.shutdown();
                final List<Future> futures_temp = new ArrayList<>();
                futures_temp.addAll(futures);
                while (futures_temp.size() != 0) {
                    for (final Future future : futures) {
                        if (future.isDone() || future.isCancelled()) {
                            futures_temp.remove(future);
                        }
                    }
                    Thread.sleep(TIME_FOR_WAIT);
                }
                executorServiceForDb.shutdown();

                System.out.println("Done");
                System.out.println("Time:" + (System.currentTimeMillis() - times));
                System.out.println("Size:" + totalSize + " bytes");
            }
        }
    }

    private void truncateTable(String tableName) throws SQLException {
        final Connection connection = getDriverManagerDataSource().getConnection();
        final Statement statement = connection.createStatement();
        try {
            statement.execute("TRUNCATE TABLE " + tableName);
        } catch (Exception e) {
            final String message = tableName + " : " + e.getMessage() + "\n";
            System.out.println(message);
            //appendToErrorsFile(message);
        } finally {
            statement.close();
            connection.close();
        }
    }
}