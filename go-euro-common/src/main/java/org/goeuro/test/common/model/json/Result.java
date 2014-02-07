package org.goeuro.test.common.model.json;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Nikola.Ivanov on 2/6/14.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Result {

    private String _type;
    private Integer _id;
    private String name;
    private String type;
    @JsonProperty("geo_position")
    private GeoPosition geoPosition;

    public String get_type() {
        return _type;
    }

    public void set_type(String _type) {
        this._type = _type;
    }

    public Integer get_id() {
        return _id;
    }

    public void set_id(Integer _id) {
        this._id = _id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public GeoPosition getGeoPosition() {
        return geoPosition;
    }

    public void setGeoPosition(GeoPosition geoPosition) {
        this.geoPosition = geoPosition;
    }

    @Override
    public String toString() {
        return "Result{" +
                "_type='" + _type + '\'' +
                ", _id=" + _id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", geoPosition=" + geoPosition +
                '}';
    }
}
