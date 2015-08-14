package com.retor.buslib.lib.methods;

import com.retor.buslib.lib.model.BusModel;

import java.util.List;

import retrofit.http.GET;
import retrofit.http.Headers;
import rx.Observable;

/**
 * Created by retor on 13.08.2015.
 */
public interface LoadMethod {
    @GET("/dynamic_datasets/bus.json")
    @Headers({"Content-Type: application/json"})
    Observable<List<BusModel>> getAllBusses();
}
