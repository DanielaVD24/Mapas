package com.danidatos.mapas;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback, GoogleMap.OnMapClickListener {

    EditText txtLatitud, txtLongitud;

    GoogleMap mMap, mMap2, mMap3, mMap4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        SupportMapFragment mapFragment2 = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map2);
        SupportMapFragment mapFragment3 = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map3);
        SupportMapFragment mapFragment4 = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map4);
        mapFragment.getMapAsync(this);
        mapFragment2.getMapAsync(this);
        mapFragment3.getMapAsync(this);
        mapFragment4.getMapAsync(this);
    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        mMap = googleMap;
        mMap2 = googleMap;
        mMap3 = googleMap;
        mMap4 = googleMap;

        this.mMap.setOnMapClickListener(this);
        this.mMap2.setOnMapClickListener(this);
        this.mMap3.setOnMapClickListener(this);
        this.mMap4.setOnMapClickListener(this);

        LatLng mexico = new LatLng(19.3906594,-99.3084248);
        LatLng tijuana = new LatLng(32.4572038,-117.0340565);
        LatLng nuevoLeon = new LatLng(25.6489844,-100.4741522);
        LatLng tlaxcala = new LatLng(19.4173438,-98.4972509);
        mMap.addMarker(new MarkerOptions().position(mexico).title("Mexico"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(mexico));

        mMap2.addMarker(new MarkerOptions().position(tijuana).title("Tijuana"));
        mMap2.moveCamera(CameraUpdateFactory.newLatLng(tijuana));

        mMap3.addMarker(new MarkerOptions().position(nuevoLeon).title("Nuevo Leon"));
        mMap3.moveCamera(CameraUpdateFactory.newLatLng(nuevoLeon));

        mMap4.addMarker(new MarkerOptions().position(tlaxcala).title("Tlaxcala"));
        mMap4.moveCamera(CameraUpdateFactory.newLatLng(tlaxcala));
    }

    @Override
    public void onMapClick(@NonNull LatLng latLng) {
        txtLatitud.setText(""+latLng.latitude);
        txtLongitud.setText(""+latLng.longitude);
    }
}