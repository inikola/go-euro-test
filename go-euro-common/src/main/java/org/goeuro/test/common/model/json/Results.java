package org.goeuro.test.common.model.json;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

/**
 * Created by Nikola.Ivanov on 2/6/14.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Results {

    private List<Result> results;

    public List<Result> getResults() {
        return results;
    }


    public void setResults(List<Result> results) {
        this.results = results;
    }



}
