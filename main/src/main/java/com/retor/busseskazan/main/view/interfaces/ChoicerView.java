package com.retor.busseskazan.main.view.interfaces;

import android.os.Bundle;

import com.retor.buslib.lib.model.BusModel;
import com.retor.busseskazan.main.presenter.interfaces.OnSelectedCallback;

import java.util.List;

/**
 * Created by retor on 19.08.2015.
 */
public interface ChoicerView {
    void fillList(List<String> list);

    void saveState(Bundle outState);

    void restoreState(Bundle savedState);

    void setCallBack(OnSelectedCallback callBack);
}
