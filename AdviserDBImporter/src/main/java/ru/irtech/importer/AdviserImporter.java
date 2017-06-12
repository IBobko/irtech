package ru.irtech.importer;

import org.apache.commons.lang.StringUtils;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.io.IOException;
import java.nio.file.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.*;

/**
 * @author Igor Bobko <limit-speed@yandex.ru>.
 */

public class AdviserImporter {
    /**
     * 100%.
     */
    private static final int PERCENT_100 = 100;

    /**
     * The maximal amount of threads. It must be no more than postgres allows connections.
     */
    private static final Integer MAX_THREADS = 800;

    /**
     * The time for the thread waiting.
     */
    private static final Integer TIME_FOR_WAIT = 500;

    /**
     * The path to the error file.
     */
    private static final Path ERRORS_FILE = Paths.get("./errors.txt");

    /**
     * Properties with database connection data.
     */
    private static Properties properties = new Properties();

    /**
     * Amount of bytes which already are performed.
     */
    private volatile Long alreadyDoneBytes = 0L;

    /**
     * Tables which is not existed in database.
     */
    private String[] lackOfTables = {"SG_ST_VARIANTS",
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

    /**
     * List of active threads.
     */
    private List<Future<Long>> futures = new CopyOnWriteArrayList<>();

    public static Properties getProperties() {
        return properties;
    }

    /**
     * The starting method.
     *
     * @param args The first parameter is the directory path with the database dump.
     * @throws IOException .
     * @throws SQLException .
     * @throws InterruptedException .
     */
    public static void main(final String[] args) throws IOException, SQLException, InterruptedException {
        if (args.length < 1) {
            System.out.println("Data folder is not specified.");
        }
        getProperties().load(AdviserImporter.class.getClassLoader().getResourceAsStream("config.properties"));
        final AdviserImporter importer = new AdviserImporter();
        importer.startLoading(args[0]);
    }

    /**
     * Returns new instance of DriverManagerDataSource.
     *
     * @return DriverManagerDataSource.
     */
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
     * Appends message to the end of the errors file.
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

    /**
     * The starting job.
     *
     * @param pathToDump Folder with CVS files.
     * @throws SQLException .
     * @throws IOException .
     * @throws InterruptedException .
     */
    private void startLoading(final String pathToDump) throws SQLException, IOException, InterruptedException {
        startLogging();
        final Path rootPath = Paths.get(pathToDump);
        long times = System.currentTimeMillis();
        long totalSize = 0;

        if (Files.isDirectory(rootPath)) {
            try (final DirectoryStream<Path> stream = Files.newDirectoryStream(rootPath)) {
                final List<Path> paths = new ArrayList<>();
                final ExecutorService executorService = Executors.newCachedThreadPool();
                final ExecutorService executorServiceForDb = Executors.newFixedThreadPool(MAX_THREADS);
                long totalFileSize = 0;
                for (final Path path : stream) {
                    //if (!lackOfTables.contains(path.getFileName().toString().toUpperCase())) {
                    if (!path.getFileName().toString().toUpperCase().equals("QUERIES") &&
                        !path.getFileName().toString().toUpperCase().equals("OBJPROPS")
                            ) {
                        paths.add(path);
                        long fileSize = Files.size(path);
                        totalFileSize += fileSize;
                    }
                }
                final long finalTotalFileSize = totalFileSize;

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
                                final Future<Long> future = executorServiceForDb.submit(loaderThread);
                                futures.add(future);

                                final List<Future<Long>> futuresTemp = new ArrayList<>();
                                futuresTemp.addAll(futures);
                                for (final Future<Long> futureTemp : futuresTemp) {
                                    if (futureTemp.isDone() || futureTemp.isCancelled()) {
                                        alreadyDoneBytes += futureTemp.get();
                                        futures.remove(futureTemp);
                                        System.out.println("Already done: " + (alreadyDoneBytes * PERCENT_100 / finalTotalFileSize) + "% or Made " + alreadyDoneBytes + " from " + finalTotalFileSize);
                                    }
                                }
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    });
                }
                executorService.shutdown();
                while (futures.size() != 0) {
                    final List<Future<Long>> futuresTemp = new ArrayList<>();
                    futuresTemp.addAll(futures);
                    for (final Future<Long> future : futuresTemp) {
                        if (future.isDone() || future.isCancelled()) {
                            futures.remove(future);
                            try {
                                alreadyDoneBytes += future.get();
                                System.out.println("Already done: " + (alreadyDoneBytes * PERCENT_100 / finalTotalFileSize) + "% or Made " + alreadyDoneBytes + " from " + finalTotalFileSize);
                            } catch (ExecutionException e) {
                                e.printStackTrace();
                            }
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

    /**
     * Truncates the table.
     *
     * @param tableName The table name.
     * @throws SQLException .
     */
    private void truncateTable(final String tableName) throws SQLException {
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


    private boolean checkThatTableExists(final String tableName) throws SQLException {
        final Connection connection = getDriverManagerDataSource().getConnection();
        final PreparedStatement statement = connection.prepareStatement(" select * from information_schema.tables where table_schema = 'public' and table_name = ?");
        statement.setString(1,tableName);
        ResultSet rs = statement.executeQuery();
        return rs.next();
    }

    private void createTable(String fileName) throws IOException {
        DividerIntoParts dividerIntoParts = new DividerIntoParts(Paths.get(fileName));
        ArrayList<String> t = new ArrayList<>();
        t.addAll(dividerIntoParts.getColumns());
        t.remove(0);
        String sql = "CREATE TABLE " + dividerIntoParts.getTableName() + " (" + StringUtils.join(t," VARCHAR(255),") + " VARCHAR(255));";
    }
}
