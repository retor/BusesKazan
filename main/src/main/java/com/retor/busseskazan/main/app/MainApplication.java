package com.retor.busseskazan.main.app;

import android.app.Application;

import com.retor.busseskazan.main.di.app.AppModule;
import com.retor.busseskazan.main.di.app.ApplicationComponent;
import com.retor.busseskazan.main.di.app.DaggerApplicationComponent;

/**
 * Created by retor on 17.08.2015.
 */
public class MainApplication extends Application{
    private ApplicationComponent component;

    @Override
    public void onCreate() {
        super.onCreate();
        createAndInject();
    }

    private void createAndInject() {
        this.component = DaggerApplicationComponent.builder()
                .appModule(new AppModule(this))
                .build();
    }

    public ApplicationComponent getComponent(){
        if (component==null)
            createAndInject();
        return component;
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        component = null;
        System.exit(1);
    }
}
