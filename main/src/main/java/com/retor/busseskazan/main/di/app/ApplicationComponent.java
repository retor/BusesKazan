package com.retor.busseskazan.main.di.app;

import android.location.LocationManager;
import android.net.ConnectivityManager;

import com.retor.buslib.lib.LoaderApi;
import com.retor.buslib.lib.model.BusModel;
import com.retor.busseskazan.main.MapsActivity;
import com.retor.busseskazan.main.app.MainApplication;
import com.retor.busseskazan.main.presenter.serviceprovider.ServiceProvider;
import com.retor.busseskazan.main.presenter.di.PresentersModule;
import com.retor.busseskazan.main.presenter.impl.PresenterImpl;
import com.retor.busseskazan.main.presenter.interactors.Interactor;
import com.retor.busseskazan.main.presenter.interfaces.Presenter;
import com.retor.busseskazan.main.view.di.ViewModule;

import java.util.List;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by retor on 19.08.2015.
 */
@Component(
        modules = {AppModule.class, PresentersModule.class, ViewModule.class})
@Singleton
public interface ApplicationComponent {
    void inject(PresenterImpl presenter);
    void inject(MapsActivity activity);
    MainApplication MAIN_APPLICATION();
    ConnectivityManager CONNECTIVITY_MANAGER();
    LocationManager LOCATION_MANAGER();
    ServiceProvider SERVICE_PROVIDER();
    Interactor<List<BusModel>> INTERACTOR();
    Presenter PRESENTER();
    LoaderApi LOADER_API();
}
