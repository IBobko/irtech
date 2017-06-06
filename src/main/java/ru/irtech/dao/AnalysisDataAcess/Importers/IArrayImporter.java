package ru.irtech.dao.AnalysisDataAcess.Importers;

/**
 * Created by Iggytoto on 06.06.2017.
 *
 * Generic interface of T to implement the data importer
 */
public interface IArrayImporter<T> {
    /**
     * Method that returns array of T
     *
     * @param databaseName database name to import from
     * @return
     */
    T[] importData(String databaseName);
}
