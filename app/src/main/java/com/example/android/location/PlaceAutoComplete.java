package com.example.android.location;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.ui.PlaceAutocompleteFragment;
import com.google.android.gms.location.places.ui.PlaceSelectionListener;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;

public class PlaceAutoComplete extends AppCompatActivity implements PlaceSelectionListener{
    TextView place_name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place_auto_complete);
         place_name=findViewById(R.id.place_name);
        PlaceAutocompleteFragment placeAutocompleteFragment =(PlaceAutocompleteFragment) getFragmentManager().findFragmentById(R.id.place_fragment);
        placeAutocompleteFragment.setOnPlaceSelectedListener(this);
        placeAutocompleteFragment.setHint("Serch place");

    }

    @Override
    public void onPlaceSelected(Place place) {
        LatLng loc = place.getLatLng();
        CameraPosition target= CameraPosition.builder().target(loc).zoom(21).build();


    }

    @Override
    public void onError(Status status) {
        Toast.makeText(this,"Place selection failed",Toast.LENGTH_LONG);
    }
}
