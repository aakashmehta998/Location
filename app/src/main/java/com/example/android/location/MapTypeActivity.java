package com.example.android.location;

import android.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;

public class MapTypeActivity extends AppCompatActivity implements OnMapReadyCallback {

    GoogleMap m_map;
    boolean mapReady=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map_type);

        Button map_button = findViewById(R.id.map_button);

        View.OnClickListener mapListner = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mapReady)
                    m_map.setMapType(GoogleMap.MAP_TYPE_NORMAL);
            }
        };
        map_button.setOnClickListener(mapListner);
        Button satelite_button = findViewById(R.id.satelite_button);
        View.OnClickListener sateliteListner=new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mapReady)
                    m_map.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
            }

            };
        satelite_button.setOnClickListener(sateliteListner);
        Button hybrid_button = findViewById(R.id.hybrid_button);
        View.OnClickListener hybridListner = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mapReady)
                    m_map.setMapType(GoogleMap.MAP_TYPE_HYBRID);
            }
        };
        hybrid_button.setOnClickListener(hybridListner);

        MapFragment mapFragment=(MapFragment) getFragmentManager().findFragmentById(R.id.map_fragment);
        mapFragment.getMapAsync(this);


    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mapReady=true;
        m_map=googleMap;
        LatLng ahm = new LatLng(23.0225,72.5714);
        CameraPosition target= CameraPosition.builder().target(ahm).zoom(12).build();
        m_map.moveCamera(CameraUpdateFactory.newCameraPosition(target));
    }
}
