package com.retor.buslib.lib.di;

import com.retor.buslib.lib.services.LoadService;
import com.retor.buslib.lib.services.ServiceCreator;
import com.squareup.okhttp.OkHttpClient;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by retor on 13.08.2015.
 */
@Module
public class LoaderModule {
    @Provides
    @Singleton
    OkHttpClient providesClient() {
        return new OkHttpClient();
    }

    @Provides
    @Singleton
    ServiceCreator providesServiceCreator(LoadService service) {
        return service;
    }
}
