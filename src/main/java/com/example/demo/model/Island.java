package com.example.demo.model;

public class Island {

    private long id;
    private String name;
    private String pictureUrl;
    private double surface;
    private long inhabitants;
    private double latitude;
    private double longitude;
    private String country;

    public Island() {
    }

    public Island(String name, String pictureUrl, double surface, long inhabitants, double latitude, double longitude, String country) {
        this.name = name;
        this.pictureUrl = pictureUrl;
        this.surface = surface;
        this.inhabitants = inhabitants;
        this.latitude = latitude;
        this.longitude = longitude;
        this.country = country;
    }

    public Island(long id, String name, String pictureUrl, double surface, long inhabitants, double latitude, double longitude, String country) {
        this.id = id;
        this.name = name;
        this.pictureUrl = pictureUrl;
        this.surface = surface;
        this.inhabitants = inhabitants;
        this.latitude = latitude;
        this.longitude = longitude;
        this.country = country;
    }

    @Override
    public String toString() {
        return "Island{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", pictureUrl='" + pictureUrl + '\'' +
                ", surface=" + surface +
                ", inhabitants=" + inhabitants +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", country='" + country + '\'' +
                '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }

    public double getSurface() {
        return surface;
    }

    public void setSurface(double surface) {
        this.surface = surface;
    }

    public long getInhabitants() {
        return inhabitants;
    }

    public void setInhabitants(long inhabitants) {
        this.inhabitants = inhabitants;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
