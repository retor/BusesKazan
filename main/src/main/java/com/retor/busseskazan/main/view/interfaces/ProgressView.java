package com.retor.busseskazan.main.view.interfaces;

import android.content.Context;

/**
 * Created by retor on 13.08.2015.
 */
public interface ProgressView {
    void initContext(Context context);

    void showProgress();

    void closeProgress();

    void showError(String msg);
}
