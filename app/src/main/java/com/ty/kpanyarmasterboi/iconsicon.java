package com.ty.kpanyarmasterboi;

public class iconsicon {

    private String nama;
    private double lat,lng;
    MapFragment mapFragment;
    private String suri;
    private String uri;

    public iconsicon(){}

    public iconsicon(String nama, double lat, double lng, String suri, String uri) {
        this.nama = nama;
        this.lat = lat;
        this.lng = lng;
        this.suri = suri;
        this.uri = uri;
    }

    String getUri(){
        return this.uri;
    }

    String getSuri() {
        return suri;
    }

    double getLng() {
        return lng;
    }

    double getLat() {
        return lat;
    }

    String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    public void setSuri(String suri) {
        this.suri = suri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }
}
