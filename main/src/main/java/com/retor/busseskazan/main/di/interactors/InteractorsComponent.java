package com.retor.busseskazan.main.di.interactors;

import android.widget.Spinner;

import com.google.android.gms.maps.GoogleMap;
import com.retor.busseskazan.main.interactors.MapInteractor;
import com.retor.busseskazan.main.interactors.SpinnerInteractor;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by retor on 14.08.2015.
 */
@Singleton
@Component(modules = {InteractorsModule.class},
        dependencies = {ForInteractorsModule.class})
public interface InteractorsComponent {
    void inject(MapInteractor mapInteractor);

    void inject(SpinnerInteractor spinnerInteractor);

    Spinner SPINNER();

    GoogleMap GOOGLE_MAP();

    MapInteractor MAP_INTERACTOR();

    SpinnerInteractor SPINNER_INTERACTOR();
}
