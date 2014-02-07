package org.goeuro.test.common.model;

import org.goeuro.test.common.model.csv.GoEuroRow;
import org.goeuro.test.common.model.json.Result;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nikola.Ivanov on 2/7/14.
 */
public class GoEuroRowConvertor implements Converter<Result,GoEuroRow> {
    @Override
    public GoEuroRow convertFrom(Result result) {

        return new GoEuroRow(result.get_type(),result.get_id(),result.getName(),result.getType(),result.getGeoPosition().getLatitude(),result.getGeoPosition().getLongitude());
    }

    @Override
    public List<GoEuroRow> convertFromList(List<Result> results) {
        List<GoEuroRow> rows = new ArrayList<GoEuroRow>();
        for(Result result: results){
            rows.add(convertFrom(result));
        }
        return rows;
    }

}
