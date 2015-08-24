package com.retor.busseskazan.main.presenter.di;


import com.retor.busseskazan.main.presenter.impl.PresenterImpl;
import com.retor.busseskazan.main.presenter.interfaces.Presenter;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by retor on 19.08.2015.
 */
@Module
public class PresentersModule {

    @Provides
    @Singleton
    public Presenter providesPresenter(PresenterImpl presenter){
        return presenter;
    }

}
