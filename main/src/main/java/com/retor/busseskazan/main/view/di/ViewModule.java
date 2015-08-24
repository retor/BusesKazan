package com.retor.busseskazan.main.view.di;

import com.retor.busseskazan.main.view.impl.FabViewImpl;
import com.retor.busseskazan.main.view.impl.MapViewImpl;
import com.retor.busseskazan.main.view.impl.ProgressViewImpl;
import com.retor.busseskazan.main.view.interfaces.MapView;
import com.retor.busseskazan.main.view.interfaces.ProgressView;
import com.retor.busseskazan.main.view.interfaces.ChoicerView;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by retor on 19.08.2015.
 */
@Module
public class ViewModule {
    @Provides
    @Singleton
    public ChoicerView providesSpinnerView() {
//        return new SpinnerViewImpl();
        return new FabViewImpl();
    }

    @Provides
    @Singleton
    public MapView providesMapView() {
        return new MapViewImpl();
    }

    @Provides
    @Singleton
    public ProgressView providesProgressView(){
        return new ProgressViewImpl();
    }
}
