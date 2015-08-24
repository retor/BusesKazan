package com.retor.busseskazan.main.view.impl;

import android.os.SystemClock;
import android.support.v4.app.Fragment;
import android.view.animation.BounceInterpolator;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.retor.busseskazan.main.view.interfaces.MapView;

import java.util.List;

/**
 * Created by retor on 19.08.2015.
 */
public class MapViewImpl implements MapView {
    private GoogleMap map;
    private boolean isEnable = false;

    @Override
    public void fillMap(final List<MarkerOptions> data) {
        fill(data);
        if (isEnable)
            setupMyPosition();
    }

    @Override
    public void withMyPosition(final boolean isLocationEnable) {
        this.isEnable = isLocationEnable;
    }

    @Override
    public void setFragmentManager(final Fragment fragment) {
        setUpMapIfNeeded(fragment);
/*        if (map == null) {
            Log.d("MapView", "No map or Google Service is old");
        }*/
    }

    private void setUpMapIfNeeded(final Fragment fragment) {
        map = ((SupportMapFragment) fragment).getMap();
        if (map != null) {
            map.setMyLocationEnabled(true);
        }
    }

    private void fill(List<MarkerOptions> data) {
        map.clear();
        for (MarkerOptions m : data) {
            Marker marker = map.addMarker(m);
            if (data.size() < 30)
                dropPinEffect(marker);
            else
                map.addMarker(m);
        }
    }

    private void dropPinEffect(final Marker marker) {
        // Handler allows us to repeat a code block after a specified delay
        final android.os.Handler handler = new android.os.Handler();
        final long start = SystemClock.uptimeMillis();
        final long duration = 1200;
        // Use the bounce interpolator
        final android.view.animation.Interpolator interpolator =
                new BounceInterpolator();
        // Animate marker with a bounce updating its position every 15ms
        handler.post(new Runnable() {
            @Override
            public void run() {
                long elapsed = SystemClock.uptimeMillis() - start;
                // Calculate t for bounce based on elapsed time
                float t = Math.max(
                        1 - interpolator.getInterpolation((float) elapsed
                                / duration), 0);
                // Set the anchor
                marker.setAnchor(0.5f, 1.0f + 5 * t);

                if (t > 0.0) {
                    // Post this event again 15ms from now.
                    handler.postDelayed(this, 15);
                } else { // done elapsing, show window
                    marker.showInfoWindow();
                }
            }
        });
    }

    private void setupMyPosition() {
        if (map.isMyLocationEnabled() && map.getMyLocation() != null) {
            CameraUpdate camera = CameraUpdateFactory.newLatLngZoom(new LatLng(map.getMyLocation().getLatitude(), map.getMyLocation().getLongitude()), 10);
            map.moveCamera(camera);
        }
    }
}
