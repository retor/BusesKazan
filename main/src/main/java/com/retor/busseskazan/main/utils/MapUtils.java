package com.retor.busseskazan.main.utils;

import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.retor.buslib.lib.model.BusModel;
import com.retor.busseskazan.main.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by retor on 24.08.2015.
 */
public class MapUtils {
    public static List<MarkerOptions> pinList(List<BusModel> data) {
        List<MarkerOptions> out = new ArrayList<MarkerOptions>();
        for (BusModel b : data) {
            MarkerOptions marker = new MarkerOptions();
            marker.icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_bus));
            marker.position(new LatLng(b.getData().getLatitude(), b.getData().getLongitude()));
            marker.title(String.valueOf("Marshrut: " + b.getData().getMarsh() + " Speed: " + b.getData().getSpeed()));
            out.add(marker);
        }
        return out;
    }
}
