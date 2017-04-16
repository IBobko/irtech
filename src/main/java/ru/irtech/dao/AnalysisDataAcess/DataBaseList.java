package ru.irtech.dao.AnalysisDataAcess;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Iggytoto on 16.04.2017.
 */
public class DataBaseList {
    /**
     * List of currently accessible databases with data
     */
    public static List<String> dataBases = new ArrayList<String>(){
        {
            add("irtech_data");
        }
    };


}
