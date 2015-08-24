package com.retor.busseskazan.main.presenter.interfaces;

import android.app.Activity;
import android.os.Bundle;

import rx.Subscriber;

/**
 * Created by retor on 13.08.2015.
 */
public abstract class Presenter<T> extends Subscriber<T> {

    public abstract void onCreated(Activity activity, Bundle savedState);

    public abstract void onResume(Activity activity);

    public abstract void onDestroy();

    public abstract void onSave(Bundle outState);

    public abstract void onRestore(Bundle savedState);
}
