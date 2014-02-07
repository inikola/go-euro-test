package org.goeuro.test.services;

import org.goeuro.test.common.model.csv.Row;

import java.util.List;

/**
 * Created by Nikola.Ivanov on 2/7/14.
 */
public interface CsvWriter<T extends Row> {

    /**
     *  Serialize list of objects into file in csv format.
     *
     * @param rows
     */
    void writeRowsToFile(List<T> rows);
}
