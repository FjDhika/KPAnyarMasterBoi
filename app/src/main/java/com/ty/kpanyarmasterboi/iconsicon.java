package com.ty.kpanyarmasterboi;

import android.media.MediaPlayer;

public class iconsicon {

    private String nama;
    private int icons;
    private double lat,lng;
    public MapFragment mapFragment;
    public String suri;
    private String uri;

    public iconsicon(){

    }
    public iconsicon(double lat, double lng, String nama, String suri){
        this.lat = lat;
        this.lng = lng;
        this.nama = nama;
        this.suri = suri;
    }

    public String getUri(){
        return this.uri;
    }
    public void setUri(String uri){
        this.uri = uri;
    }

    public String getSuri() {
        return suri;
    }
    public void setSuri(String suri) {
        this.suri = suri;
    }

    public double getLng() {
        return lng;
    }
    public void setLng(double lng) {
        this.lng = lng;
    }

    public double getLat() {
        return lat;
    }
    public void setLat(double lat) {
        this.lat = lat;
    }

    public String getNama() {
        return nama;
    }
    public void setNama(String nama) {
        this.nama = nama;
    }
}
