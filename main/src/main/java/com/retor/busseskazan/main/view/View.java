package com.retor.busseskazan.main.view;

/**
 * Created by retor on 13.08.2015.
 */
public interface View {
    void showProgress();

    void closeProgress();

    void showError(String msg);
}
