package com.retor.buslib.lib.di;

import com.retor.buslib.lib.LoaderApi;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by retor on 13.08.2015.
 */
@Singleton
@Component(modules = LoaderModule.class)
public interface LoaderComponent {
    LoaderApi LOADER_API();
}
