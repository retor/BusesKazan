package com.retor.busseskazan.main.di.presenter;

import android.content.Context;

import com.retor.buslib.lib.LoaderApi;
import com.retor.busseskazan.main.interactors.MapInteractor;
import com.retor.busseskazan.main.interactors.SpinnerInteractor;
import com.retor.busseskazan.main.presenter.Presenter;
import com.retor.busseskazan.main.presenter.PresenterImpl;
import com.retor.busseskazan.main.view.View;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by retor on 13.08.2015.
 */
@Module
public class PresenterModule {
    @Provides
    @Singleton
    public Presenter providesPresenter(LoaderApi api, View view, Context context, SpinnerInteractor spinnerInteractor, MapInteractor mapInteractor) {
        return new PresenterImpl(api, view, context, spinnerInteractor, mapInteractor);
    }
}
