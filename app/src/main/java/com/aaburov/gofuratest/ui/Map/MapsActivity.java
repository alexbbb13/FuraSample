package com.aaburov.gofuratest.ui.Map;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.aaburov.gofuratest.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.maps.android.clustering.ClusterManager;

import java.util.Iterator;
import java.util.List;

import pojo.MapPoint;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback, MapContract.View {

    private GoogleMap mMap;
    private ClusterManager<MarkerItem> mClusterManager;
    MapContract.Presenter presenter;

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
        setUpClusterer(mMap);
        presenter = new MapPresenter();
        presenter.startPresenting(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        if(null!=presenter) presenter.stopPresenting();
    }

    @Override
    public void displayMarkers(Iterator<MapPoint> markers) {
        if(null!=mClusterManager) while (markers.hasNext()) {
            MapPoint m = markers.next();
            mClusterManager.addItem(new MarkerItem(m.getLat(),m.getLng(),m.getName(),m.getCategoryId()));
        }
    }

    @Override
    public void initCamera() {
        mMap.moveCamera(CameraUpdateFactory.newLatLng(new LatLng(55.751244, 37.618423)));
    }

    private void setUpClusterer(GoogleMap map) {
        mClusterManager = new ClusterManager(this, map);
        map.setOnCameraIdleListener(mClusterManager);
        map.setOnMarkerClickListener(mClusterManager);
    }



}
