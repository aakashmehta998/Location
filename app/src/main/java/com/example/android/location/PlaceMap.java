package com.example.android.location;

import android.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.ui.PlaceAutocompleteFragment;
import com.google.android.gms.location.places.ui.PlaceSelectionListener;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolygonOptions;
import com.google.android.gms.maps.model.PolylineOptions;

public class PlaceMap extends AppCompatActivity implements PlaceSelectionListener,OnMapReadyCallback{
    GoogleMap m_map;
    boolean flag=false;
    Marker sourceMarker;
    Marker destinationMarker;
    int flag1=1;
    int flag3=0;
    int flag4=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place_map);
        MapFragment mapFragment = (MapFragment) getFragmentManager().findFragmentById(R.id.map_fragment3);
        mapFragment.getMapAsync(this);
        PlaceAutocompleteFragment sourceFragment = (PlaceAutocompleteFragment) getFragmentManager().findFragmentById(R.id.source_place_fragment);
        Log.v("checkHere","before listner Source");
        sourceFragment.setOnPlaceSelectedListener(this);
        Log.v("checkHere","after listner Source");
        sourceFragment.setHint("Search source place");
        PlaceAutocompleteFragment destinationFragment = (PlaceAutocompleteFragment) getFragmentManager().findFragmentById(R.id.destination_place_fragment);
        Log.v("checkHere","before listner Destination");
        destinationFragment.setOnPlaceSelectedListener(this);
        Log.v("checkHere","afeter listner Destination");
        destinationFragment.setHint("Search Destination place");
    }

    @Override
    public void onPlaceSelected(Place place) {
        LatLng source=null;
        LatLng destination=null;
        if(flag1==1) {
            if(flag3==1)
            {
                sourceMarker.remove();
            }
                source = place.getLatLng();
                CameraPosition target = CameraPosition.builder().target(source).zoom(21).build();
                m_map.animateCamera(CameraUpdateFactory.newCameraPosition(target), null);
                MarkerOptions source1 = new MarkerOptions().position(source).title(place.getName().toString());
            Log.v("checkHere","in source");
                sourceMarker = m_map.addMarker(source1);
                flag3 = 1;
                flag1=0;

        }
        else {
           if(flag4==1)
            {
                destinationMarker.remove();
            }
             destination = place.getLatLng();
            CameraPosition target = CameraPosition.builder().target(destination).zoom(17).build();
            m_map.animateCamera(CameraUpdateFactory.newCameraPosition(target), null);
            MarkerOptions dest1 = new MarkerOptions().position(destination).title(place.getName().toString());
            Log.v("checkHere","in destination");
            destinationMarker=m_map.addMarker(dest1);
            flag4=1;
            flag1=1;
        }
    }

    @Override
    public void onError(Status status) {

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        m_map=googleMap;
        flag=true;
    }
}
