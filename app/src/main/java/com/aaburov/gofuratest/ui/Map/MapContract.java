package com.aaburov.gofuratest.ui.Map;

import com.google.android.gms.maps.model.Marker;

import java.util.Iterator;
import java.util.List;

import pojo.MapPoint;

/**
 * Created by alex on 25.12.17.
 */

public interface MapContract {

    public interface Presenter {
        void startPresenting(MapContract.View view);
        void stopPresenting();
    }

    public interface View {
        void displayMarkers(Iterator<MapPoint> markers);
        void initCamera();
    }
}
