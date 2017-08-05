package ru.irtech.dao.AnalysisDataAcess.Importers.FakeTestData;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import ru.irtech.dao.AnalysisDataAcess.Importers.ICsvImporter;

import java.io.*;
import java.util.*;

/**
 * Created by Iggytoto on 05.08.2017.
 */
public class StudentsTermsYearlyFakeGenerator implements ICsvImporter {

    public static StudentsTermsYearlyFakeGenerator getGenerator() {
        return new StudentsTermsYearlyFakeGenerator();
    }

    AbstractMap<Integer, List<Double>> studentPeriodGradeMap;
    AbstractMap<Integer, List<Double>> studentYearlyGradeMap;
    AbstractMap<Integer, List<Integer>> studentRelationsMap;
    List<Integer> studentIds;

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

    @Override
    public String importData(File file, String databaseName) throws IOException {

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

    private List<Double> generateRandomIntegers(double max, double min, int count) {
        Random r = new Random();

        List<Double> result = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            result.add(r.nextDouble() * (max - min) + min);
        }
        return result;
    }

    private List<Integer> generateRandomDoubles(int max, int min, int count) {
        Random r = new Random();

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            result.add(r.nextInt((max - min) + min));
        }
        return result;
    }

    private Double countAverage(List<Double> soruce) {
        Double sum = 0d;
        for (Double d : soruce) {
            sum += d;
        }
        return sum / soruce.size();
    }

}