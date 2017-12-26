package com.aaburov.gofuratest.ui.Map;

import java.util.Iterator;
import java.util.List;

import javax.inject.Inject;

import dependencies.FuraApplication;
import io.realm.Realm;
import io.realm.RealmResults;
import pojo.MapPoint;

/**
 * Created by alex on 26.12.17.
 */

public class MapModel {
    private static final MapModel ourInstance = new MapModel();

    @Inject
    Realm realm;

    static MapModel getInstance() {
        return ourInstance;
    }

    private MapModel() {
    }

    public void setMarkers(List<MapPoint> data) {
        realm.beginTransaction();
        realm.copyToRealm(data);
        realm.commitTransaction();
    }

    public Iterator<MapPoint> getMarkers() {
        RealmResults<MapPoint> markers = realm.allObjects(MapPoint.class);
        return markers.iterator();
    }

    public boolean isEmpty(){
        RealmResults<MapPoint> markers = realm.allObjects(MapPoint.class);
        if(null==markers) return true;
        return (markers.size()>0? false:true);
    }
}
