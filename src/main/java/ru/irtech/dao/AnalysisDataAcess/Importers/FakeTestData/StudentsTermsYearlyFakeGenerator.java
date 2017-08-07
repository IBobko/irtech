package ru.irtech.dao.AnalysisDataAcess.Importers.FakeTestData;

import ru.irtech.dao.AnalysisDataAcess.Importers.ICsvImporter;

import java.io.*;
import java.util.*;

/**
 * Created by Iggytoto on 05.08.2017.
 */
public class StudentsTermsYearlyFakeGenerator implements ICsvImporter {
    /**
     * .
     */
    private AbstractMap<Integer, List<Double>> studentPeriodGradeMap;
    /**
     * .
     */
    private AbstractMap<Integer, List<Double>> studentYearlyGradeMap;
    /**
     * .
     */
    private AbstractMap<Integer, List<Integer>> studentRelationsMap;
    /**
     * .
     */
    private List<Integer> studentIds;
    /**
     * .
     */
    public StudentsTermsYearlyFakeGenerator() {
        Random r = new Random();
        studentPeriodGradeMap = new HashMap<>();
        studentIds = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            studentPeriodGradeMap.put(i, generateRandomIntegers(1000, 0, 100));
            studentIds.add(i);
        }
        studentYearlyGradeMap = new HashMap<>();
        for (int i = 0; i < 1000; i++) {
            studentYearlyGradeMap.put(i, generateRandomIntegers(1000, 0, 25));
        }
        studentRelationsMap = new HashMap<>();
        for (int i = 0; i < 1000; i++) {
            studentRelationsMap.put(i, generateRandomDoubles(2, 0, r.nextInt(3)));
        }
    }

    public static StudentsTermsYearlyFakeGenerator getGenerator() {
        return new StudentsTermsYearlyFakeGenerator();
    }

    @Override
    public String importData(final File file, final String databaseName) throws IOException {

        FileOutputStream fos = new FileOutputStream(file);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));

        for (int studentId : studentIds) {
            if (!studentPeriodGradeMap.containsKey(studentId)
                    || !studentYearlyGradeMap.containsKey(studentId)
                    || !studentRelationsMap.containsKey(studentId)) {
                continue;
            }

            bw.write(studentId + "," + countAverage(studentPeriodGradeMap.get(studentId)) + "," + countAverage(studentYearlyGradeMap.get(studentId))
                    + "," + (studentRelationsMap.get(studentId).size() >= 2 ? "True" : "False"));
            bw.newLine();
        }
        bw.close();

        return file.getPath();
    }

    /**
     * Generates list of random integers.
     *
     * @param max value.
     * @param min value.
     * @param count value.
     * @return list.
     */
    private List<Double> generateRandomIntegers(final double max, final double min, final int count) {
        final Random r = new Random();
        final List<Double> result = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            result.add(r.nextDouble() * (max - min) + min);
        }
        return result;
    }

    /**
     * Generates list of random doubles.
     *
     * @param max value.
     * @param min value.
     * @param count value.
     * @return list.
     */
    private List<Integer> generateRandomDoubles(final int max, final int min, final int count) {
        Random r = new Random();

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            result.add(r.nextInt((max - min) + min));
        }
        return result;
    }

    /**
     * Calculation mean value.
     * @param source .
     * @return mean value.
     */
    private Double countAverage(final List<Double> source) {
        Double sum = 0d;
        for (Double d : source) {
            sum += d;
        }
        return sum / source.size();
    }

}
