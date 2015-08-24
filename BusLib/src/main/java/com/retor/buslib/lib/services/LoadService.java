package com.retor.buslib.lib.services;

import com.squareup.okhttp.OkHttpClient;

import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import retrofit.RequestInterceptor;
import retrofit.RestAdapter;
import retrofit.client.OkClient;

/**
 * Created by retor on 13.08.2015.
 */
public class LoadService implements ServiceCreator {
    private OkHttpClient okHttpClient;

    @Inject
    public LoadService(final OkHttpClient okHttpClient) {
        okHttpClient.setConnectTimeout(5000, TimeUnit.MILLISECONDS);
        okHttpClient.setRetryOnConnectionFailure(true);
        this.okHttpClient = okHttpClient;
    }

    @Override
    public <S> S createService(final Class<S> serviceClass) {
        RestAdapter.Builder builder = new RestAdapter.Builder()
                .setEndpoint("http://data.kzn.ru:8082/api/v0")
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .setClient(new OkClient(okHttpClient))
                .setRequestInterceptor(new RequestInterceptor() {
                    @Override
                    public void intercept(RequestFacade request) {
                        request.addHeader("Accept", "application/json");
                    }
                });
        RestAdapter adapter = builder.build();
        return adapter.create(serviceClass);
    }
}
