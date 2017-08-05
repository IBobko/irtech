package ru.irtech.dao.AnalysisDataAcess.Importers;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by Iggytoto on 16.04.2017.
 * Interface that represents database importer that results with a reference on a .csv file.
 */
public interface ICsvImporter {
    /**
     * Method that imports data from given database into csv file.
     * @param databaseName database name to connect to.
     * @param file file to write
     * @return csv file name
     */
    String importData(File file, String databaseName) throws IOException;
}
