package com.retor.busseskazan.main.di.app;

import android.content.Context;
import android.location.LocationManager;
import android.net.ConnectivityManager;

import com.retor.buslib.lib.di.LoaderModule;
import com.retor.buslib.lib.model.BusModel;
import com.retor.busseskazan.main.app.MainApplication;
import com.retor.busseskazan.main.presenter.serviceprovider.ServiceProvider;
import com.retor.busseskazan.main.presenter.serviceprovider.ServicesProviderImpl;
import com.retor.busseskazan.main.presenter.interactors.Interactor;
import com.retor.busseskazan.main.presenter.interactors.InteractorImpl;

import java.util.List;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by retor on 13.08.2015.
 */
@Module(includes = LoaderModule.class)
public class AppModule {
    private MainApplication application;

    public AppModule(final MainApplication application) {
        this.application = application;
    }

    @Provides
    @Singleton
    public MainApplication providesApplication() {
        return application;
    }

    @Provides
    public Context providesContext() {
        return application;
    }

    @Provides
    @Singleton
    public ConnectivityManager providesConnectivityManager(){
        return ((ConnectivityManager) application.getSystemService(Context.CONNECTIVITY_SERVICE));
    }

    @Provides
    @Singleton
    public LocationManager providesLocationManager(){
        return (LocationManager) application.getSystemService(Context.LOCATION_SERVICE);
    }
    @Provides
    @Singleton
    public ServiceProvider provideServicesProvider(ServicesProviderImpl provider){
        return provider;
    }

    @Provides
    @Singleton
    public Interactor<List<BusModel>> providesInteractor(InteractorImpl interactor){
        return interactor;
    }
}
