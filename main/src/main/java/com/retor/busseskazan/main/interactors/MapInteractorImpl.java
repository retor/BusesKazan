package com.retor.busseskazan.main.interactors;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.retor.buslib.lib.model.BusModel;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by retor on 14.08.2015.
 */
public class MapInteractorImpl implements MapInteractor {
    @Inject
    protected GoogleMap map;
    private boolean isEnable = false;

    public MapInteractorImpl(final GoogleMap map) {
        this.map = map;
    }

    @Override
    public void fillMap(final List<BusModel> data) {
        fill(data);
        if (isEnable)
            setupMyPosition();
    }

    @Override
    public void withMyPosition(final boolean isLocationEnable) {
        this.isEnable = isLocationEnable;
    }

    private void fill(List<BusModel> data) {
        map.clear();
        for (BusModel b : data) {
            MarkerOptions marker = new MarkerOptions();
            marker.position(new LatLng(b.getData().getLatitude(), b.getData().getLongitude()));
            marker.title(String.valueOf("Marshrut: " + b.getData().getMarsh() + " Speed: " + b.getData().getSpeed()));
            map.addMarker(marker);
        }
    }

    private void setupMyPosition() {
        if (map.isMyLocationEnabled() && map.getMyLocation() != null) {
            CameraUpdate camera = CameraUpdateFactory.newLatLngZoom(new LatLng(map.getMyLocation().getLatitude(), map.getMyLocation().getLongitude()), 10);
            map.moveCamera(camera);
        }
    }

}
