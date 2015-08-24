package com.retor.busseskazan.main.view.impl;

import android.app.ProgressDialog;
import android.content.Context;
import android.support.v7.app.AlertDialog;

import com.retor.busseskazan.main.view.interfaces.ProgressView;

import javax.inject.Inject;

/**
 * Created by retor on 20.08.2015.
 */
public class ProgressViewImpl implements ProgressView {

    private Context context;
    private ProgressDialog progressDialog;

    private void initProgress() {
        this.progressDialog = new ProgressDialog(context);
        progressDialog.setTitle("Loading");
        progressDialog.setMessage("Loading...");
        progressDialog.setCancelable(false);
    }

    @Override
    public void initContext(Context context) {
        this.context = context;
        initProgress();
    }

    @Override
    public void showProgress() {
        if (progressDialog != null && !progressDialog.isShowing())
            progressDialog.show();
    }

    @Override
    public void closeProgress() {
        if (progressDialog.isShowing())
            progressDialog.dismiss();
    }

    @Override
    public void showError(final String msg) {
        showAlert(msg);
    }

    private void showAlert(String msg) {
        new AlertDialog.Builder(context).setMessage(msg).create().show();
    }
}
