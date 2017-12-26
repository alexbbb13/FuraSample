package dependencies;

import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.StrictMode;
import android.support.annotation.NonNull;


import com.aaburov.gofuratest.BuildConfig;

import javax.inject.Inject;

import network.Api;


public class FuraApplication extends Application {

    public static AppComponent appComponent;

    @Inject
    Api api;


    @Override
    public void onCreate() {
        super.onCreate();
        appComponent = DaggerAppComponent.builder().build();
    }



    @NonNull
    public static AppComponent getComponent() {
        return appComponent;
    }

}
