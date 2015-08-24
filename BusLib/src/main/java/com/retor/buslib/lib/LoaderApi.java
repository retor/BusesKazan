package com.retor.buslib.lib;

import com.retor.buslib.lib.methods.LoadMethod;
import com.retor.buslib.lib.model.BusModel;
import com.retor.buslib.lib.services.ServiceCreator;

import java.util.List;

import javax.inject.Inject;

import rx.Observable;

/**
 * Created by retor on 13.08.2015.
 */
public class LoaderApi {
    private LoadMethod service;

    @Inject
    public LoaderApi(ServiceCreator creator) {
        this.service = creator.createService(LoadMethod.class);
    }

    public Observable<List<BusModel>> getBussesList() {
        return service.getAllBusses();
    }
}
