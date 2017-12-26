package com.aaburov.gofuratest.ui.Map;

import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.maps.android.clustering.ClusterItem;

/**
 * Created by alex on 26.12.17.
 */

public class MarkerItem implements ClusterItem {
    private final LatLng mPosition;
    private String title;
    private int type;

    public MarkerItem(double lat, double lng, String title, int type) {
        mPosition = new LatLng(lat, lng);
        this.title = title;
        this.type = type;
    }

    @Override
    public LatLng getPosition() {
        return mPosition;
    }


    public String getTitle() {
        return title;
    }

    public BitmapDescriptor getIcon(){
        switch (type){
            case 1:
                return BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE);
            case 2:
                return BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE);
            case 3:
                return BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_CYAN);
        }
        return BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED);
    }

}