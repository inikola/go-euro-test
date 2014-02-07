package org.goeuro.test;

import org.goeuro.test.common.model.InputValidator;
import org.goeuro.test.common.model.json.Results;
import org.goeuro.test.facade.GoEuroFacade;
import org.goeuro.test.services.GoEuroService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 *
 */
public class Main {

    private static final Logger LOG = LoggerFactory.getLogger(Main.class);

    public static void main(String []args){
        InputValidator.validateInput(args);
        LOG.info("----------------------- Start Fetching Data ---------------------------------------");
        GoEuroFacade goEuroFacade = new GoEuroFacade();
        goEuroFacade.saveResults(args[0]);



    }

}
