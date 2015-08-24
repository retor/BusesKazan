package com.retor.busseskazan.main;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.retor.busseskazan.main.app.MainApplication;
import com.retor.busseskazan.main.presenter.interfaces.Presenter;

import javax.inject.Inject;

public class MapsActivity extends FragmentActivity {
    @Inject
    protected Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        ((MainApplication) getApplication()).getComponent().inject(this);
        presenter.onCreated(this, savedInstanceState);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.onDestroy();
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.onResume(this);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        presenter.onRestore(savedInstanceState);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        presenter.onSave(outState);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        getApplication().onTerminate();
        finishActivity(0);
    }
}
