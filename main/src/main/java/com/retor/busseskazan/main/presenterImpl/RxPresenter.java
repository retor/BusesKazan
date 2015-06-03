package com.retor.busseskazan.main.presenterImpl;

import android.app.ProgressDialog;
import android.support.v4.app.FragmentActivity;
import com.retor.busseskazan.main.DialogsBuilder;
import com.retor.busseskazan.main.IPresenter;
import com.retor.busseskazan.main.IView;
import com.retor.busseskazan.main.R;
import com.retor.busseskazan.main.viewImpl.SpinnerViewImpl;
import model.IModel;
import modelImpl.RxModel;
import modelImpl.beans.Bus;
import rx.Observable;
import rx.Observer;
import rx.android.app.AppObservable;
import rx.schedulers.Schedulers;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by retor on 03.06.2015.
 */
public class RxPresenter implements IPresenter, Observer<List<Bus>> {
    private static final long serialVersionUID = -1257896432102569879L;
    private IModel<Observable<List<Bus>>> rxmodel;
    private FragmentActivity activity;
    private String mainUrl;
    private IView<List<Bus>> spinnerView;
    private List<Bus> busses;
    private ProgressDialog pd;

    public RxPresenter(FragmentActivity activity) {
        this.activity = activity;
        this.rxmodel = new RxModel();
        this.mainUrl = activity.getResources().getString(R.string.baseUrl);
        this.spinnerView = new SpinnerViewImpl(activity);
        pd = DialogsBuilder.createProgress(activity, "Loading...");
    }

    @Override
    public void loadItems() {
        pd.show();
        Observable<List<Bus>> ob = AppObservable.bindActivity(activity, rxmodel.getData(mainUrl)).subscribeOn(Schedulers.io());
        ob.buffer(3);
        ob.subscribe(this);
    }

    private void fillViews() {
        spinnerView.newData(busses);
    }

    @Override
    public void onCompleted() {
        pd.dismiss();
        fillViews();
    }

    @Override
    public void onError(Throwable e) {
        pd.dismiss();
        DialogsBuilder.createAlert(activity, e.getLocalizedMessage()).show();
    }

    @Override
    public void onNext(List<Bus> buslist) {
        this.busses = new ArrayList<Bus>(buslist);
    }
}
