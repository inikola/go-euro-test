package org.goeuro.test.common.model.utils;

import org.supercsv.cellprocessor.constraint.NotNull;
import org.supercsv.cellprocessor.constraint.UniqueHashCode;
import org.supercsv.cellprocessor.ift.CellProcessor;

/**
 * Created by Nikola.Ivanov on 2/6/14.
 */
public class CsvUtility {


    private CsvUtility() {
        //no instantiation allowed
    }

    public static CellProcessor[] getCellProcessor() {
        final CellProcessor[] processors = new CellProcessor[]{
                new NotNull(),
                new UniqueHashCode(),
                new NotNull(),
                new NotNull(),
                new NotNull(),
                new NotNull()
        };

        return processors;
    }

    public static final String[] getGoEuroHeader(){

        return new String[]{"_type","_id","name","type","latitude","longitude"};
    }
}
