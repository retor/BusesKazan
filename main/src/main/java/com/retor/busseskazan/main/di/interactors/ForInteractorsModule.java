package com.retor.busseskazan.main.di.interactors;

import android.widget.Spinner;

import com.google.android.gms.maps.GoogleMap;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by retor on 14.08.2015.
 */
@Module
public class ForInteractorsModule {
    private Spinner spinner;
    private GoogleMap map;

    public ForInteractorsModule(final Spinner spinner, GoogleMap map) {
        this.spinner = spinner;
        this.map = map;
    }

    @Provides
    @Singleton
    Spinner providesSpinner() {
        return spinner;
    }

    @Provides
    @Singleton
    GoogleMap providesMap() {
        return map;
    }
}
