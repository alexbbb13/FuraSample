package network.response;

import java.util.List;

import pojo.MapPoint;

/**
 * Created by alex on 26.12.17.
 */

public class PlacesResponse {

    int pageSize;
    List<MapPoint> data;

    public List<MapPoint> getData() {
        return data;
    }
}
