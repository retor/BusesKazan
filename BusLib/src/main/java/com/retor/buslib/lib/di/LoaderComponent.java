package com.retor.buslib.lib.di;

import com.retor.buslib.lib.LoaderApi;
import com.retor.buslib.lib.services.ServiceCreator;
import com.squareup.okhttp.OkHttpClient;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by retor on 13.08.2015.
 */
@Singleton
@Component(modules = LoaderModule.class)
public interface LoaderComponent {
    void inject(LoaderApi api);

    OkHttpClient OK_HTTP_CLIENT();
    ServiceCreator SERVICE_CREATOR();
}
