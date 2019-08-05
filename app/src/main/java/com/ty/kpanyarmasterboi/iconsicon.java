package com.ty.kpanyarmasterboi;

public class iconsicon {

    private String nama;
    private double lat,lng;
    MapFragment mapFragment;
    private String suri;
    private String uri;


    public iconsicon(String nama, double lat, double lng, MapFragment mapFragment, String suri, String uri) {
        this.nama = nama;
        this.lat = lat;
        this.lng = lng;
        this.mapFragment = mapFragment;
        this.suri = suri;
        this.uri = uri;
    }
    public iconsicon(){}

    String getUri(){
        return this.uri;
    }
    void setUri(){
        this.uri = "https://firebasestorage.googleapis.com/v0/b/reference-unity-247807.appspot.com/o/icons%2Fanchor.png?alt=media&token=f98f28b0-346e-4dbc-98d6-6aff21f86e24";
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
}
