package ru.irtech.analysis.Correlation;

import java.util.Dictionary;
import java.util.Hashtable;
import java.util.Random;

/**
 * Created by Iggytoto on 05.08.2017.
 */
public class FakeCorrelationProcessor implements ICorrelationProcessor {
    @Override
    public Dictionary<Integer, Double> parseCorrelation(final String csvFileName, final Integer classColumnIndex, final Integer[] targetColumnIndex) {
        Dictionary<Integer, Double> result = new Hashtable<>();
        Random r = new Random();
        result.put(1, r.nextDouble() * 2 - 1);
        result.put(2, r.nextDouble() * 2 - 1);

        return result;
    }
}
