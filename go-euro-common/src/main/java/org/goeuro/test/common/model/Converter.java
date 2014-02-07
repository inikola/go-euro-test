package org.goeuro.test.common.model;

import org.goeuro.test.common.model.csv.Row;

import java.util.List;

/**
 * Created by Nikola.Ivanov on 2/6/14.
 */
public interface Converter<From,To extends Row> {

    To convertFrom(From from);

    List<To> convertFromList(List<From> fromList);

}
