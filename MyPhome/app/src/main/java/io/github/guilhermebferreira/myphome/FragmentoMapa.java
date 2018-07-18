package io.github.guilhermebferreira.myphome;

import android.location.LocationListener;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class FragmentoMapa extends Fragment implements OnMapReadyCallback, GoogleMap.OnMarkerClickListener {


    private GoogleMap mMap;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_mapa, container, false);


        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getActivity().getSupportFragmentManager()
                .findFragmentById(R.id.fragmento_mapa_map);
        mapFragment.getMapAsync(this);

        return view;
    }

    @Override
    public boolean onMarkerClick(Marker marker) {

        Log.i("INFO", "Pino clicado");
        return false;
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {


        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng tce = new LatLng(-10.177710, -48.332699);
        mMap.addMarker(new MarkerOptions().position(tce).title("TCE-TO"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(tce));

        mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);

        mMap.setOnMarkerClickListener(this);

        CameraUpdate zoom = CameraUpdateFactory.newLatLngZoom(tce, 15);
        mMap.moveCamera(zoom);

    }
}
