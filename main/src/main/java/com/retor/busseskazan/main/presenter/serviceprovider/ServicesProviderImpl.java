package com.retor.busseskazan.main.presenter.serviceprovider;

import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import javax.inject.Inject;

/**
 * Created by retor on 20.08.2015.
 */
public class ServicesProviderImpl implements ServiceProvider {
    private ConnectivityManager networkManager;
    private LocationManager locationManager;

    @Inject
    public ServicesProviderImpl(ConnectivityManager networkManager, LocationManager locationManager) {
        this.networkManager = networkManager;
        this.locationManager = locationManager;
    }

    public boolean isNetworkConnected() {
        NetworkInfo ni = networkManager.getActiveNetworkInfo();
        return ni != null && ni.isConnected();
    }

    public boolean isLocationEnabled() {
        return !(!locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER) &&
                !locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER) &&
                !locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER));
    }
}
