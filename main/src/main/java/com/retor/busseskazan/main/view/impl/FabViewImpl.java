package com.retor.busseskazan.main.view.impl;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.widget.ArrayAdapter;

import com.retor.busseskazan.main.R;
import com.retor.busseskazan.main.presenter.interfaces.OnSelectedCallback;
import com.retor.busseskazan.main.view.interfaces.ChoicerView;

import java.util.List;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * Created by retor on 23.08.2015.
 */
public class FabViewImpl implements ChoicerView {
    @Bind(R.id.fab)
    FloatingActionButton floatingActionButton;
    private OnSelectedCallback callback;
    private Popup popup;
    private final String Bundle_TAG = "popup";
    private int lastPosition = 0;
    private boolean isSelected = false;

    @Override
    public void setCallBack(final OnSelectedCallback callBack) {
        this.callback = callBack;
    }

    @OnClick(R.id.fab)
    protected void click() {
        if (popup!=null && !popup.adapter.isEmpty())
            popup.dialogShow();
    }

    @Override
    public void fillList(List<String> list) {
        fill(list);
    }

    @Override
    public void saveState(final Bundle outState) {
//        outState.putBundle(Bundle_TAG, popup.saveState());
    }

    @Override
    public void restoreState(@Nullable final Bundle savedState) {
/*        if (popup!=null)
            popup.restoreState(savedState.getBundle(Bundle_TAG));*/
    }

    private void fill(final List<String> data) {
        popup = new Popup();
        popup.fill(data);
    }

    public class Popup implements DialogInterface.OnClickListener {
        AlertDialog alertDialog;
        ArrayAdapter<String> adapter;

        public Popup() {
            adapter = new ArrayAdapter<String>(floatingActionButton.getContext(), android.R.layout.simple_spinner_item);
            createDialog();
        }

        private void createDialog() {
            AlertDialog.Builder builder = new AlertDialog.Builder(floatingActionButton.getContext());
            alertDialog = builder.setSingleChoiceItems(adapter,
                    getSelectedItemPosition(), this).create();
        }

        public void fill(List<String> data) {
            adapter.clear();
            adapter.addAll(data);
            adapter.notifyDataSetInvalidated();
            alertDialog.getListView().invalidate();
            if (!isSelected)
                dialogShow();
        }

        public void dialogShow() {
            if (alertDialog != null && !alertDialog.isShowing())
                alertDialog.show();
        }

        private int getSelectedItemPosition() {
            return lastPosition;
        }

        private void setSelection(int position) {
            isSelected = true;
            lastPosition = position;
            callback.onNumberSelected(adapter.getItem(position));
        }

        @Override
        public void onClick(DialogInterface dialog, int which) {
            setSelection(which);
            dialog.dismiss();
        }

        public Bundle saveState() {
            return alertDialog.onSaveInstanceState();
        }

        public void restoreState(Bundle savedState) {
            if (alertDialog != null)
                alertDialog.onRestoreInstanceState(savedState);
        }
    }
}
