package com.retor.busseskazan.main.di;

import com.retor.buslib.lib.LoaderApi;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by retor on 13.08.2015.
 */
@Module
public class ApiModule {
    @Provides
    @Singleton
    public LoaderApi providesApi() {
        return new LoaderApi();
    }
}
