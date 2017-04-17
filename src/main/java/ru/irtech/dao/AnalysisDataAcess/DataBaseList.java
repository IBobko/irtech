package ru.irtech.dao.AnalysisDataAcess;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Iggytoto on 16.04.2017.
 *
 */
public final class DataBaseList {
    /**
     * List of currently accessible databases with data.
     */
    private static List<String> dataBases = new ArrayList<String>() {
        {
            add("irtech_data");
        }
    };

    /**
     * Constructor must be private for utility classes.
     */
    private DataBaseList() {
    }

    public static List<String> getDataBases() {
        return dataBases;
    }
}
