package ru.irtech.analysis.Correlation;

import weka.attributeSelection.CorrelationAttributeEval;
import weka.core.Instances;
import weka.core.converters.ConverterUtils;

import java.util.Dictionary;
import java.util.Hashtable;

/**
 * Created by Iggytoto on 15.04.2017.
 * Correlation processor that uses Pearsons corellation method for processing
 */
public class PearsonsCorrelationProcessor implements ICorrelationProcessor {
    /**
     * Process the data
     *
     * @param csvFileName       input path to .csv file
     * @param classColumnIndex  index of column that points on the class
     * @param targetColumnIndex indexes of column that points on the target attribute
     * @return
     */
    @Override
    public Dictionary<Integer, Double> parseCorrelation(String csvFileName, Integer classColumnIndex
            , Integer[] targetColumnIndex) {
        Dictionary<Integer, Double> result = new Hashtable<>();
        try {
            ConverterUtils.DataSource source = new ConverterUtils.DataSource(csvFileName);
            Instances data = source.getDataSet();

            data.setClassIndex(classColumnIndex);

            CorrelationAttributeEval ceval = new CorrelationAttributeEval();
            ceval.buildEvaluator(data);

            for (Integer i : targetColumnIndex) {
                result.put(i, ceval.evaluateAttribute(i));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage()); //TODO Implement Logger
        } finally {
            return result;
        }
    }
}
