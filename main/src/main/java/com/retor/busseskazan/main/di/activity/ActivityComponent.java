package com.retor.busseskazan.main.di.activity;

import android.content.Context;

import com.retor.buslib.lib.LoaderApi;
import com.retor.busseskazan.main.MapsActivity;
import com.retor.busseskazan.main.di.ApiModule;
import com.retor.busseskazan.main.di.app.AppModule;
import com.retor.busseskazan.main.di.interactors.ForInteractorsModule;
import com.retor.busseskazan.main.di.interactors.InteractorsComponent;
import com.retor.busseskazan.main.di.interactors.InteractorsModule;
import com.retor.busseskazan.main.di.presenter.PresenterModule;
import com.retor.busseskazan.main.di.view.ViewModule;
import com.retor.busseskazan.main.presenter.Presenter;
import com.retor.busseskazan.main.view.View;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by retor on 13.08.2015.
 */
@Singleton
@Component(modules = {PresenterModule.class, InteractorsModule.class, ForInteractorsModule.class},
dependencies = {AppModule.class, ViewModule.class, ApiModule.class})
public interface ActivityComponent extends InteractorsComponent{
    void inject(MapsActivity activity);
    void inject(Presenter presenter);

    Presenter PRESENTER();
    View VIEW();
    LoaderApi LOADER_API();
    Context CONTEXT();
}
