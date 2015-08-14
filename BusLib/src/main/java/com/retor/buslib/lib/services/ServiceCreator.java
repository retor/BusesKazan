package com.retor.buslib.lib.services;

/**
 * Created by retor on 02.08.2015.
 */
public interface ServiceCreator {
    <S> S createService(Class<S> serviceClass);
}
