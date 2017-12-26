package pojo;

import com.google.gson.annotations.SerializedName;

import io.realm.RealmObject;

/**
 * Created by alex on 26.12.17.
 */

public class MapPoint extends RealmObject{
         private int id;
         private String name;
         private float lat;
         private float lng;
         private int categoryId;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public float getLat() {
        return lat;
    }

    public float getLng() {
        return lng;
    }

    public int getCategoryId() {
        return categoryId;
    }


}
