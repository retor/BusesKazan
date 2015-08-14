package com.retor.busseskazan.main.interactors;

import com.retor.buslib.lib.model.BusModel;

import java.util.List;

/**
 * Created by retor on 14.08.2015.
 */
public interface MapInteractor {
    void fillMap(List<BusModel> list);

    void withMyPosition(boolean isLocationEnable);
}
