package com.retor.busseskazan.main.di.view;

import com.retor.busseskazan.main.view.View;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by retor on 13.08.2015.
 */
@Module
public class ViewModule {
    private View mainView;

    public ViewModule(final View mainView) {
        this.mainView = mainView;
    }

    @Provides
    @Singleton
    public View providesView() {
        return mainView;
    }
}
