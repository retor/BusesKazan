package com.retor.busseskazan.main.presenter;

import android.app.Activity;

/**
 * Created by retor on 13.08.2015.
 */
public interface Presenter {
    void getData(Activity activity);

    void onNumberSelected(String number);
}
