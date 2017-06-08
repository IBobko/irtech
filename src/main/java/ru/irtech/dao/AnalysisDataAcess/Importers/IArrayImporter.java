package ru.irtech.dao.AnalysisDataAcess.Importers;

import java.util.Date;
import java.util.List;

/**
 * Created by Iggytoto on 06.06.2017.
 * <p>
 * Generic interface of T to implement the data importer
 *
 * @param <T> Data representation object
 */
public interface IArrayImporter<T> {
    /**
     * Method that returns array of T.
     *
     * @param databaseName database name to import from.
     * @return List of T
     */
    List<T> importAllData(final String databaseName);

    /**
     * Method that returns array of T in the given period.
     *
     * @param databaseName database name to import from.
     * @param dateFrom     from time.
     * @param dateTo       to time.
     * @return List of T
     */
    List<T> importData(final String databaseName, final Date dateFrom, final Date dateTo);
}
