package ru.irtech.analysis.OutliersAndExtremes;



import ru.irtech.analysis.Pair;

import java.util.List;

/**
 * Created by Iggytoto on 15.04.2017.
 * Processor that counts correlations on .csv input file
 */
public interface IOutlierProcessor {
    /**
     * Parse input method.
     * @param csvInputFile target .csv file with input data
     * @param idIndex entity index id that should be counted as entity reference
     * @param targetColumns target columns to search on
     * @return Pair of integer arrays that contains indexes of entities that are <Outliers, Extreme values>
     */
    Pair<List<Integer>, List<Integer>> parseOutliersAndExtremes(String csvInputFile, Integer idIndex, Integer[] targetColumns);
}
