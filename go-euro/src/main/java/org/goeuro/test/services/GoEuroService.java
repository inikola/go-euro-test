package org.goeuro.test.services;

import org.goeuro.test.common.model.json.Results;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

/**
* Implements api.goeuro.com endpoint.
 *
*/
public class GoEuroService {
    private static final Logger LOGGER = LoggerFactory.getLogger(GoEuroService.class);
    private RestTemplate restTemplate;
    private static final String URL = "https://api.goeuro.com/api/v1/suggest/position/en/name/";


    /**
     *
     */
    public GoEuroService(){
        HttpComponentsClientHttpRequestFactory httpComponentsClientHttpRequestFactory = new HttpComponentsClientHttpRequestFactory();
        this.restTemplate = new RestTemplate(httpComponentsClientHttpRequestFactory);
    }

    /**
     *Fetch results from an endpoint for a given query.
     *
     *
     * @param query any string
     * @return Results object containing list of Result
     */
    public Results getResultsPositions(final String query){
        String url = URL + query;
        LOGGER.info(url);
        return restTemplate.getForObject(url,Results.class);
    }

}
