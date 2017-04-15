package ru.irtech.analysis.OutliersAndExtremes;

import javafx.util.Pair;
import weka.core.Instance;
import weka.core.Instances;
import weka.core.converters.ConverterUtils;
import weka.filters.unsupervised.attribute.InterquartileRange;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Iggytoto on 15.04.2017.
 */
public class InterquartileRangeProcessor implements IOutlierProcessor {
    /**
     * Parse input method
     *
     * @param csvInputFile  target .csv file with input data
     * @param idIndex       entity index id that should be counted as entity reference
     * @param targetColumns target columns to search on
     * @return Pair of integer arrays that contains indexes of entities that are <Outliers, Extreme values>
     */
    @Override
    public Pair<List<Integer>, List<Integer>> parseOutliersAndExtremes(String csvInputFile, Integer idIndex
            , Integer[] targetColumns) {
        List<Integer> outliers = new ArrayList<>();
        List<Integer> extremes = new ArrayList<>();
        Pair<List<Integer>, List<Integer>> result = new Pair<>(outliers, extremes);
        try {

            InterquartileRange filter = new InterquartileRange();

            ConverterUtils.DataSource source = new ConverterUtils.DataSource(csvInputFile);
            Instances data = source.getDataSet();
            filter.setInputFormat(data);

            String indexes = "";

            for (int i = 0; i < targetColumns.length; i++) {
                if(i == targetColumns.length - 1){
                    indexes += targetColumns[i];
                }
                else {
                    indexes += targetColumns[i] + ",";
                }
            }

            filter.setOptions(new String[]{"-R", indexes, "-O", "3.0", "-E", "6.0"});

            Instances data2 = filter.useFilter(data, filter);

            for (int i = 0;i < data2.size();i++ ) {
                Instance inst = data2.get(i);
                if(inst.value(inst.numAttributes() -1) == 1d){
                    extremes.add((int) inst.value(idIndex));
                }
                if(inst.value(inst.numAttributes() -2) == 1d){
                    outliers.add((int) inst.value(idIndex));
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            return result;
        }
    }
}
