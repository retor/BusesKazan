package com.retor.busseskazan.main.di.interactors;

import android.widget.Spinner;

import com.google.android.gms.maps.GoogleMap;
import com.retor.busseskazan.main.interactors.MapInteractor;
import com.retor.busseskazan.main.interactors.MapInteractorImpl;
import com.retor.busseskazan.main.interactors.SpinnerInteractor;
import com.retor.busseskazan.main.interactors.SpinnerInteractorImpl;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by retor on 14.08.2015.
 */
@Module
public class InteractorsModule {

    @Provides
    @Singleton
    SpinnerInteractor providesSpinnerInteractor(Spinner spin) {
        return new SpinnerInteractorImpl(spin);
    }

    @Provides
    @Singleton
    MapInteractor providesMapInteractor(GoogleMap googleMap) {
        return new MapInteractorImpl(googleMap);
    }
}
