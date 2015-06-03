package com.retor.busseskazan.main.viewImpl;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.retor.busseskazan.main.IView;
import modelImpl.beans.Bus;

import java.util.List;

/**
 * Created by retor on 03.06.2015.
 */
public class MapViewImpl implements IView<List<Bus>> {
    private GoogleMap map;

    public MapViewImpl(GoogleMap map) {
        this.map = map;
    }

    @Override
    public void newData(List<Bus> data) {
        fillMap(data);
    }

    private void setupMyPosition() {
        if (map.isMyLocationEnabled() && map.getMyLocation() != null) {
            CameraUpdate camera = CameraUpdateFactory.newLatLngZoom(new LatLng(map.getMyLocation().getLatitude(), map.getMyLocation().getLongitude()), 14);
            map.moveCamera(camera);
        }
    }

    private void fillMap(List<Bus> data) {
        map.clear();
        setupMyPosition();
        for (Bus b : data) {
            MarkerOptions marker = new MarkerOptions();
            marker.position(new LatLng(b.getData().getLatitude(), b.getData().getLongitude()));
            marker.title(String.valueOf("Marshrut: " + b.getData().getMarsh() + " Speed: " + b.getData().getSpeed()));
            map.addMarker(marker);
        }
    }
}
