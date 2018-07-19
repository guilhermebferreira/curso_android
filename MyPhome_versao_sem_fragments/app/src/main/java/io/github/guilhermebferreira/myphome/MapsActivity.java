package io.github.guilhermebferreira.myphome;

import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.util.List;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback, GoogleMap.OnMarkerClickListener, LocationListener {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(-34, 151);
        LatLng tce = new LatLng(-10.177710, -48.332699);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        mMap.addMarker(new MarkerOptions().position(tce).title("TCE-TO"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(tce));

        mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);

        mMap.setOnMarkerClickListener(this);

        CameraUpdate zoom = CameraUpdateFactory.newLatLngZoom(tce, 15);
        mMap.moveCamera(zoom);

        mMap.setOnMapClickListener(new GoogleMap.OnMapClickListener()
        {
            @Override
            public void onMapClick(LatLng position)
            {

                mMap.addMarker(new MarkerOptions().position(position).title("Click location"));

                mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(position,8));
                Log.i("INFO", "Click position defined");
            }
        });
    }

    @Override
    public boolean onMarkerClick(Marker marker) {

        Log.i("INFO", "Pino clicado");
        getLatLongByEndereco();

        return true;
    }

    public void getLatLongByEndereco(){
        Geocoder coder = new Geocoder(this);

        try {
            List<Address> results = coder.getFromLocationName("TCE Tocantins", 1);
            double la = results.get(0).getLatitude();
            double lo = results.get(0).getLongitude();

            Log.i("INFO", "TCE em "+la+" "+lo);

        } catch (IOException e) {
            e.printStackTrace();
        } ;
    }

    @Override
    public void onLocationChanged(Location location) {

    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

    }
}
