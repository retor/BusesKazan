package com.retor.busseskazan.main.presenter.impl;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;

import com.retor.buslib.lib.model.BusModel;
import com.retor.busseskazan.main.R;
import com.retor.busseskazan.main.app.MainApplication;
import com.retor.busseskazan.main.presenter.serviceprovider.ServiceProvider;
import com.retor.busseskazan.main.presenter.interactors.Interactor;
import com.retor.busseskazan.main.presenter.interfaces.LoaderCallback;
import com.retor.busseskazan.main.presenter.interfaces.OnSelectedCallback;
import com.retor.busseskazan.main.presenter.interfaces.Presenter;
import com.retor.busseskazan.main.utils.ListUtils;
import com.retor.busseskazan.main.utils.MapUtils;
import com.retor.busseskazan.main.view.interfaces.ChoicerView;
import com.retor.busseskazan.main.view.interfaces.MapView;
import com.retor.busseskazan.main.view.interfaces.ProgressView;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.ButterKnife;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by retor on 20.08.2015.
 */
public class PresenterImpl extends Presenter<List<BusModel>> implements OnSelectedCallback, LoaderCallback {

    @Inject
    protected ChoicerView choicerView;
    @Inject
    protected MapView mapView;
    @Inject
    protected ProgressView progressView;
    @Inject
    protected ServiceProvider servicesProvider;
    @Inject
    protected Interactor<List<BusModel>> interactor;
    private boolean inAction = false;

    @Inject
    public PresenterImpl(MainApplication application) {
        application.getComponent().inject(this);
        choicerView.setCallBack(this);
    }

    //Observer part
    @Override
    public void onCompleted() {
        inAction = false;
    }

    @Override
    public void onError(Throwable e) {
        progressView.closeProgress();
        progressView.showError(e.getLocalizedMessage());
    }

    @Override
    public void onNext(List<BusModel> busModels) {
        progressView.closeProgress();
        choicerView.fillList(ListUtils.getBusNumbers(busModels));
        if (servicesProvider.isLocationEnabled())
            mapView.withMyPosition(servicesProvider.isLocationEnabled());
    }
    ///

    @Override
    public void onNumberSelected(String number) {
        mapView.fillMap(MapUtils.pinList(getBusModels(number)));
        if (servicesProvider.isLocationEnabled())
            mapView.withMyPosition(servicesProvider.isLocationEnabled());
    }

    @Nullable
    private List<BusModel> getBusModels(final String num) {
        if (!interactor.getData().getValue().isEmpty())
            if (num.equals("all")) {
                return interactor.getData().getValue();
            } else {
                List<BusModel> out = new ArrayList<BusModel>();
                for (BusModel b : interactor.getData().getValue()) {
                    if (b.getData().getMarsh().equals(num))
                        out.add(b);
                }
                return out;
            }
        throw new NullPointerException("opps null array");
    }

    @Override
    public void onCreated(Activity activity, Bundle savedState) {
        choicerView.restoreState(savedState);
    }

    private void initViews(Activity activity) {
        progressView.initContext(activity);
        Fragment mapFragment = ((FragmentActivity) activity).getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.setRetainInstance(true);
        mapView.setFragmentManager(mapFragment);
        ButterKnife.bind(choicerView, activity);
    }

    @Override
    public void onResume(Activity activity) {
        initViews(activity);
        doRequest();
    }

    private void doRequest() {
        if (servicesProvider.isNetworkConnected()) {
            if (!inAction) {
                progressView.showProgress();
                inAction = true;
                interactor.getData().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(this);
            }
        } else {
            progressView.showError("No internet connection");
        }
    }

    @Override
    public void onDestroy() {
        ButterKnife.unbind(choicerView);
    }

    @Override
    public void onSave(Bundle outState) {
        choicerView.saveState(outState);
    }

    @Override
    public void onRestore(Bundle savedState) {
        choicerView.restoreState(savedState);
    }
}
