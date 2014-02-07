package org.goeuro.test.services;

import org.goeuro.test.common.model.csv.GoEuroRow;
import org.goeuro.test.common.model.csv.Row;
import org.goeuro.test.common.model.exceptions.FileIOException;
import org.goeuro.test.common.model.utils.CsvUtility;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 * Service for writing data into files in CSV format
 *
 * Created by Nikola.Ivanov on 2/6/14.
 */
public class CsvWriterService implements CsvWriter<GoEuroRow>{


    private static final Logger LOG = LoggerFactory.getLogger(CsvWriterService.class);
    public static final String DEFAULT_FILE = CsvWriterService.class.getProtectionDomain().getCodeSource().getLocation().getPath() + "/results.csv";

    private String file;
    private CsvPreference preference;

    public CsvWriterService() {
       this(DEFAULT_FILE,CsvPreference.STANDARD_PREFERENCE);
    }

    public CsvWriterService(final CsvPreference preference) throws IOException {
        this(DEFAULT_FILE,CsvPreference.STANDARD_PREFERENCE);
    }

    public CsvWriterService(final String file) {
        this(file,CsvPreference.STANDARD_PREFERENCE);
    }

    public CsvWriterService(final String file, final CsvPreference preference) {
        this.file = file;
        this.preference = preference;
    }

    @Override
    public void writeRowsToFile(final List<GoEuroRow> rows){
        ICsvBeanWriter csvWriter = null ;
        try{

            csvWriter = new CsvBeanWriter(new FileWriter(this.file),this.preference);
            csvWriter.writeHeader(CsvUtility.getGoEuroHeader());
            for(GoEuroRow row: rows){
                csvWriter.write(row, CsvUtility.getGoEuroHeader(),CsvUtility.getCellProcessor());
            }
            LOG.info("{} results were saved in the file", rows.size());
        } catch (IOException e) {
            LOG.error("Rows cannot be saved",e);
        }finally {
            if( csvWriter != null){
                try {
                    csvWriter.close();
                } catch (IOException e) {
                    LOG.error("Something bad happened. The file writer cannot be closed",e);
                }
            }
        }

    }


}
