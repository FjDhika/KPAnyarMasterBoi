package com.ty.kpanyarmasterboi;


import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.Dash;
import com.google.android.gms.maps.model.Gap;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PatternItem;
import com.google.android.gms.maps.model.Polygon;
import com.google.android.gms.maps.model.PolygonOptions;
import com.ty.kpanyarmasterboi.polygonCoordinat.KpAnyarPolygon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class MapFragment extends Fragment implements OnMapReadyCallback {

    GoogleMap mMap;
    KpAnyarPolygon latLngs;
    private static final PatternItem dash = new Dash(20);
    private static final PatternItem gap = new Gap(10);
    private static final List<PatternItem> patternItems = Arrays.asList(dash,gap);

    public MapFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_map, container, false);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        SupportMapFragment mapFragment = (SupportMapFragment) getChildFragmentManager()
                .findFragmentById(R.id.map1);
        mapFragment.getMapAsync(this);
        latLngs = new KpAnyarPolygon();
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        /**
        *Google map Marker
         */
        LatLng kpAnyar = new LatLng(-8.160562, 114.2771345);
        MarkerOptions options = new MarkerOptions();
        options.position(kpAnyar).title("Kampung Anyar");

        /**
        *Google map Polygon
         */
        PolygonOptions polygonOptions = new PolygonOptions();
        polygonOptions.addAll(latLngs.getLatLngs());
        polygonOptions.clickable(false);
        polygonOptions.strokeWidth(3);
        polygonOptions.fillColor(0x33FF0000);
        polygonOptions.strokeColor(Color.RED);

        /**
         * Adding Marker and Polygon
         */
        googleMap.addMarker(options);
        googleMap.addPolygon(polygonOptions).setStrokePattern(patternItems);

        /**
         * Set map UI
         */
        mMap.setMinZoomPreference(13);
        //mMap.getUiSettings().setAllGesturesEnabled(false);
        mMap.moveCamera(CameraUpdateFactory.newLatLng(kpAnyar));
    }

    public void updateMap(double lat, double lng){
        mMap.clear();

        LatLng latlngs = new LatLng(lat,lng);
        MarkerOptions options = new MarkerOptions();
        options.position(latlngs);
        mMap.addMarker(options).setTitle("baru");
        mMap.animateCamera(CameraUpdateFactory.newLatLng(latlngs));
    }
}
