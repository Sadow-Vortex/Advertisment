package com.begin.advertisement;
import jakarta.persistence.Embeddable;

@Embeddable
public class Location {
    private double longitude;
    private double latitude;
    public Location() {}
    public Location(double longitude, double latitude) {
        this.longitude = longitude;
        this.latitude = latitude;
    }
    public double getLongitude() {
        return longitude;
    }
    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
    public double getLatitude() {
        return latitude;
    }
    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }
}
