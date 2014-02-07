package org.goeuro.test.common.model.csv;

/**
 * Created by Nikola.Ivanov on 2/6/14.
 */
public class GoEuroRow extends Row{

    private String name;
    private String type;
    private Double latitude;
    private Double longitude;

    public GoEuroRow(String _type, Integer _id, String name, String type, Double latitude, Double longitude) {
        super(_type, _id);
        this.name = name;
        this.type = type;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }
}
