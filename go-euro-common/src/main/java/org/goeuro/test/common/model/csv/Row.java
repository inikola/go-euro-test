package org.goeuro.test.common.model.csv;

/**
 * Created by Nikola.Ivanov on 2/6/14.
 */
public class Row {

    private String _type;
    private Integer _id;

    public Row(String _type, Integer _id) {
        this._type = _type;
        this._id = _id;
    }

    public String get_type() {
        return _type;
    }

    public Integer get_id() {
        return _id;
    }

}
