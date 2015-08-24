package com.retor.busseskazan.main.view.di;

import com.retor.busseskazan.main.view.interfaces.MapView;
import com.retor.busseskazan.main.view.interfaces.ProgressView;
import com.retor.busseskazan.main.view.interfaces.ChoicerView;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by retor on 19.08.2015.
 */
@Singleton
@Component(
        modules = {ViewModule.class})
public interface ViewComponent {
    ProgressView PROGRESS_VIEW();
    ChoicerView SPINNER_VIEW();
    MapView MAP_VIEW();
}
