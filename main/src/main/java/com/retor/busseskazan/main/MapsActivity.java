package com.retor.busseskazan.main;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AlertDialog;
import android.widget.AdapterView;
import android.widget.Spinner;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.retor.busseskazan.main.di.ApiModule;
import com.retor.busseskazan.main.di.activity.DaggerActivityComponent;
import com.retor.busseskazan.main.di.app.AppModule;
import com.retor.busseskazan.main.di.interactors.ForInteractorsModule;
import com.retor.busseskazan.main.di.interactors.InteractorsModule;
import com.retor.busseskazan.main.di.presenter.PresenterModule;
import com.retor.busseskazan.main.di.view.ViewModule;
import com.retor.busseskazan.main.presenter.Presenter;
import com.retor.busseskazan.main.view.View;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnItemSelected;

public class MapsActivity extends FragmentActivity implements View {

    private GoogleMap mMap; // Might be null if Google Play services APK is not available.
    private ProgressDialog progressDialog;
    private int spinPos;

    @Inject
    protected Presenter presenter;
    @Bind(R.id.spinner)
    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        setUpMapIfNeeded();
        ButterKnife.bind(this);
        if (savedInstanceState != null) {
            spinner.setSelection(savedInstanceState.getInt("position"));
        }
        if (mMap != null) {
            begin();
        } else {
            showAlert("No map or Google Service is old");
        }
    }

    private void begin() {
        injectThis();
        initProgress();
        getSupportFragmentManager().findFragmentById(R.id.map).setRetainInstance(true);
        presenter.getData(this);
    }

    private void initProgress() {
        this.progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("Loading");
        progressDialog.setMessage("Loading...");
        progressDialog.setCancelable(false);
    }

    private void injectThis() {
        DaggerActivityComponent.builder()
                .appModule(new AppModule(getApplication()))
                .forInteractorsModule(new ForInteractorsModule(spinner, mMap))
                .interactorsModule(new InteractorsModule())
                .apiModule(new ApiModule())
                .viewModule(new ViewModule(this))
                .presenterModule(new PresenterModule())
                .build()
                .inject(this);
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

    @OnItemSelected(R.id.spinner)
    protected void onItemSelected(final AdapterView<?> parent, final int position) {
        String tmp = parent.getItemAtPosition(position).toString();
        presenter.onNumberSelected(tmp);
        spinPos = position;
    }

    private void showAlert(String msg) {
        new AlertDialog.Builder(this).setMessage(msg).create().show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        setUpMapIfNeeded();
    }

    private void setUpMapIfNeeded() {
        // Do a null check to confirm that we have not already instantiated the map.
        if (mMap == null) {
            // Try to obtain the map from the SupportMapFragment.
            mMap = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map))
                    .getMap();
            // Check if we were successful in obtaining the map.
            if (mMap != null) {
                mMap.setMyLocationEnabled(true);
            }
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("position", spinPos);
    }
}
