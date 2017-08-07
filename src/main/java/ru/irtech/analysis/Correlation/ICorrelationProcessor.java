package ru.irtech.analysis.Correlation;

import java.util.Dictionary;

/**
 * Created by Iggytoto on 15.04.2017.
 * Processor that counts correlations on .csv input file
 */
public interface ICorrelationProcessor {
    /**
     * Main processing method.
     * @param csvFileName input path to .csv file
     * @param classColumnIndex index of column that points on the class
     * @param targetColumnIndex indexes of column that points on the target attribute
     * @return Dictionary that contains pairs index -> correlation value.
     */
    Dictionary<Integer, Double> parseCorrelation(final String csvFileName, final Integer classColumnIndex,
                                                 final Integer[] targetColumnIndex);
}
