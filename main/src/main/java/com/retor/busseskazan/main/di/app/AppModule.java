package com.retor.busseskazan.main.di.app;

import android.app.Application;
import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by retor on 13.08.2015.
 */
@Module
public class AppModule {
    private Application application;

    public AppModule(final Application application) {
        this.application = application;
    }

    @Provides
    @Singleton
    public Application providesApplication() {
        return application;
    }

    @Provides
    public Context providesContext() {
        return application.getApplicationContext();
    }
}
