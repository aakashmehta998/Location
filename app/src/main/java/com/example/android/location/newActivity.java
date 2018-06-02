package com.example.android.location;

import android.graphics.Camera;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class newActivity extends AppCompatActivity implements OnMapReadyCallback{

    GoogleMap m_map;
    boolean mapReady;
    MarkerOptions kankaria;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);
        Button seattle_button = findViewById(R.id.seattle_button);

        View.OnClickListener seattleListner = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mapReady)
                {
                    LatLng seattle = new LatLng(23.0225,72.5714);
                    CameraPosition target= CameraPosition.builder().target(seattle).zoom(12).build();
                   // m_map.moveCamera(CameraUpdateFactoy.newCameraPosition(target));
                    m_map.animateCamera(CameraUpdateFactory.newCameraPosition(target),4000,null);
                    LatLng kankaria1 = new LatLng(23.0063,72.6026);
                     kankaria = new MarkerOptions().position(kankaria1).title("Kankaria Lake");
                     m_map.addMarker(kankaria);
                }

            }
        };
        seattle_button.setOnClickListener(seattleListner);
       /* Button satelite_button = findViewById(R.id.satelite_button);
        View.OnClickListener sateliteListner = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mapReady)
                    m_map.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
            }

        };
        satelite_button.setOnClickListener(sateliteListner);
        Button hybrid_button = findViewById(R.id.hybrid_button);
        View.OnClickListener hybridListner = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mapReady)
                    m_map.setMapType(GoogleMap.MAP_TYPE_HYBRID);
            }
        };
        hybrid_button.setOnClickListener(hybridListner);*/

        MapFragment mapFragment = (MapFragment) getFragmentManager().findFragmentById(R.id.map_fragment2);
        mapFragment.getMapAsync(this);


    }
    public void onMapReady(GoogleMap gogleMap)
    {
        m_map=gogleMap;

     //   m_map.addMarker(kankaria);
        mapReady=true;
    }

}