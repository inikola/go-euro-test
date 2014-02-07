package org.goeuro.test.common.model.json;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by Nikola.Ivanov on 2/6/14.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class GeoPosition {

    private Double latitude;
    private Double longitude;

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    @Override
    public String toString() {
        return "GeoPosition{" +
                "latitude=" + latitude +
                ", longitude=" + longitude +
                '}';
    }
}
