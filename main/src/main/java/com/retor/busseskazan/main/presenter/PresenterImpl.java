package com.retor.busseskazan.main.presenter;

import android.app.Activity;
import android.content.Context;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.retor.buslib.lib.LoaderApi;
import com.retor.buslib.lib.model.BusModel;
import com.retor.busseskazan.main.interactors.MapInteractor;
import com.retor.busseskazan.main.interactors.SpinnerInteractor;
import com.retor.busseskazan.main.view.View;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import rx.Observer;
import rx.android.app.AppObservable;
import rx.schedulers.Schedulers;

/**
 * Created by retor on 13.08.2015.
 */
public class PresenterImpl implements Presenter {
    @Inject
    protected LoaderApi api;
    @Inject
    protected View mainView;
    @Inject
    protected Context context;
    @Inject
    protected SpinnerInteractor spinnerInteractor;
    @Inject
    protected MapInteractor mapInteractor;

    private List<BusModel> busses;

    public PresenterImpl(final LoaderApi api, final View mainView, Context context, SpinnerInteractor spinnerInteractor, MapInteractor mapInteractor) {
        this.api = api;
        this.mainView = mainView;
        this.context = context;
        this.spinnerInteractor = spinnerInteractor;
        this.mapInteractor = mapInteractor;
    }

    @Override
    public void getData(Activity activity) {
        if (isNetworkConnected()) {
            request(activity);
        } else {
            mainView.showError("No internet connection");
        }
        if (isLocationEnabled())
            mapInteractor.withMyPosition(isLocationEnabled());
    }

    private void request(final Activity activity) {
        mainView.showProgress();
        AppObservable.bindActivity(activity, api.getBussesList()).subscribeOn(Schedulers.io()).subscribe(new Observer<List<BusModel>>() {
            @Override
            public void onCompleted() {
                spinnerInteractor.fillSpinner(busses);
                mainView.closeProgress();
            }

            @Override
            public void onError(final Throwable e) {
                mainView.showError(e.getLocalizedMessage());
            }

            @Override
            public void onNext(final List<BusModel> list) {
                busses = list;
            }
        });
    }

    @Override
    public void onNumberSelected(String num) {
        if (num.equals("all")) {
            mapInteractor.fillMap(busses);
        } else {
            List<BusModel> out = new ArrayList<BusModel>();
            for (BusModel b : busses) {
                if (b.getData().getMarsh().equals(num))
                    out.add(b);
            }
            mapInteractor.fillMap(out);
        }
    }

    private boolean isNetworkConnected() {
        NetworkInfo ni = ((ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE)).getActiveNetworkInfo();
        return ni != null && ni.isConnected();
    }

    private boolean isLocationEnabled() {
        LocationManager lm = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);
        return !(!lm.isProviderEnabled(LocationManager.NETWORK_PROVIDER) && !lm.isProviderEnabled(LocationManager.GPS_PROVIDER) && !lm.isProviderEnabled(LocationManager.GPS_PROVIDER));
    }
}
