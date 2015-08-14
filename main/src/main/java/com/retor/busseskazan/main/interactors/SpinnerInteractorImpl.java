package com.retor.busseskazan.main.interactors;

import android.os.Build;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.retor.buslib.lib.model.BusModel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.inject.Inject;

/**
 * Created by retor on 14.08.2015.
 */
public class SpinnerInteractorImpl implements SpinnerInteractor {
    @Inject
    protected Spinner spinner;
    private ArrayAdapter<String> adapter;
    private int lastNumber = 0;

    public SpinnerInteractorImpl(final Spinner spinner) {
        this.spinner = spinner;
        lastNumber = spinner.getSelectedItemPosition();
        initSpinner();
    }

    @Override
    public void fillSpinner(final List<BusModel> data) {
        fill(data);
    }

    private void initSpinner() {
        spinner.getSelectedItemPosition();
        this.adapter = new ArrayAdapter<String>(spinner.getContext(), android.R.layout.simple_spinner_item);
        spinner.setEnabled(true);
        spinner.setPrompt("Bus number");
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            spinner.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        }
        adapter.setDropDownViewResource(android.R.layout.simple_list_item_1);
        spinner.setAdapter(adapter);
    }

    private void fill(final List<BusModel> data) {
        adapter.clear();
        adapter.addAll(getBusNumbers(data));
        spinner.setSelection(lastNumber);
    }

    private List<String> getBusNumbers(List<BusModel> data) {
        List<String> out = new ArrayList<String>();
        if (data != null) {
            for (BusModel b : data) {
                if (!out.contains(b.getData().getMarsh()))
                    out.add(b.getData().getMarsh());
            }
            Collections.sort(out);
            if (out.contains("0"))
                out.remove("0");
            out.add(0, "all");
        }
        return out;
    }
}
