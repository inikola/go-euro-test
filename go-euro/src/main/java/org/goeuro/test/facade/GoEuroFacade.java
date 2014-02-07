package org.goeuro.test.facade;

import org.goeuro.test.common.model.GoEuroRowConvertor;
import org.goeuro.test.common.model.csv.GoEuroRow;
import org.goeuro.test.common.model.exceptions.EmptyResultsExcpetion;
import org.goeuro.test.common.model.json.Result;
import org.goeuro.test.common.model.json.Results;
import org.goeuro.test.services.CsvWriter;
import org.goeuro.test.services.CsvWriterService;
import org.goeuro.test.services.GoEuroService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nikola.Ivanov on 2/7/14.
 */
public class GoEuroFacade {

    private static final Logger LOG = LoggerFactory.getLogger(GoEuroFacade.class);
    private GoEuroService goEuroService;
    private CsvWriter csvWriter;
    private GoEuroRowConvertor goEuroRowConvertor;


    public GoEuroFacade(final String file){
        this.goEuroService = new GoEuroService();
        this.csvWriter = new CsvWriterService(file);
        this.goEuroRowConvertor = new GoEuroRowConvertor();
    }

    public GoEuroFacade() {
        this.goEuroService = new GoEuroService();
        this.csvWriter = new CsvWriterService();
        this.goEuroRowConvertor = new GoEuroRowConvertor();
    }

    public GoEuroFacade(GoEuroService goEuroService,CsvWriter csvWriter,GoEuroRowConvertor goEuroRowConvertor){
        this.goEuroService = goEuroService;
        this.csvWriter = csvWriter;
        this.goEuroRowConvertor = goEuroRowConvertor;
    }

    /**
     * Fetch data from service for a given query.
     * If result is returned data will be saved to file in csv format.
     *
     * @param query ANY STRING
     * @thrown EmptyResultsExcpetion if there are no results matching the given criteria
     */
    public void saveResults(final String query){
        Results results = goEuroService.getResultsPositions(query);
        if(results.getResults() == null || results.getResults().isEmpty()){
            throw new EmptyResultsExcpetion("There where no results found matching the given query. Please try again");
        }
        csvWriter.writeRowsToFile(goEuroRowConvertor.convertFromList(results.getResults()));

    }

    public void setGoEuroService(GoEuroService goEuroService) {
        this.goEuroService = goEuroService;
    }

    public void setCsvWriter(CsvWriter csvWriter) {
        this.csvWriter = csvWriter;
    }
}
