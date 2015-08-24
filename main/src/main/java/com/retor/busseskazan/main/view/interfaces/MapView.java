package com.retor.busseskazan.main.view.interfaces;

import android.support.v4.app.Fragment;

import com.google.android.gms.maps.model.MarkerOptions;
import com.retor.buslib.lib.model.BusModel;

import java.util.List;

/**
 * Created by retor on 19.08.2015.
 */
public interface MapView {
    void fillMap(List<MarkerOptions> list);

    void withMyPosition(boolean isLocationEnable);

    void setFragmentManager(Fragment manager);
}
