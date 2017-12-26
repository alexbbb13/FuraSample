package com.aaburov.gofuratest.ui.Map;

import android.os.Handler;
import android.os.Looper;

import javax.inject.Inject;

import network.Api;


/**
 * Created by alex on 25.12.17.
 */

public class MapPresenter implements MapContract.Presenter {

    MapContract.View view;
    @Inject
    Api api;

    @Override
    public void startPresenting(MapContract.View view) {
        this.view = view;
        if(!MapModel.getInstance().isEmpty()) updateView();
        else api.getAllPoints(1)
                .subscribe(placesResponse -> {
                    MapModel.getInstance().setMarkers(placesResponse.getData());
                    view.initCamera();
                    updateView();
                });
    }

    @Override
    public void stopPresenting() {
        this.view = null;
    }

    private void updateView(){
        view.displayMarkers(MapModel.getInstance().getMarkers());
    }


}
