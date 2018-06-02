package com.example.android.location;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatTextView;
import android.util.Log;
import android.widget.TextView;

import com.google.android.gms.location.places.GeoDataClient;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.PlacesOptions;
import com.google.android.gms.location.places.internal.PlaceEntity;

import org.w3c.dom.Text;

public class PlaceDetails extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place_details);
        Intent intent = getIntent();
        String placeName1="DEmo";
        PlacesOptions myPlace = new PlacesOptions.Builder().build();
        placeName1 = intent.getStringExtra("placename");
        String placeAdrress = intent.getStringExtra("placeaddress");
        String placePhone = intent.getStringExtra("placephone");
        String placeWebsite =intent.getStringExtra("placewebsite");
        String placeRating = intent.getStringExtra("placerating");
        String placePrice = intent.getStringExtra("placeprice");
        Log.v("checkHere","Placedetails"+placeName1);
        TextView place_name_text = findViewById(R.id.place_name_text);
        TextView place_address_text = findViewById(R.id.place_address_text);
        TextView place_phone = findViewById(R.id.phone_number_text);
        TextView place_website = findViewById(R.id.website_text);
        TextView place_rating = findViewById(R.id.rating_text);
        TextView place_price = findViewById(R.id.price_text);
        place_address_text.setText(placeAdrress);
        place_name_text.setText(placeName1);
        place_phone.setText(placePhone);
        place_website.setText(placeWebsite);
        place_rating.setText(placeRating);
        place_price.setText(placePrice);
    }
}
