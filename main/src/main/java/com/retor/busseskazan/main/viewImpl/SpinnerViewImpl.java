package com.retor.busseskazan.main.viewImpl;

import android.os.Build;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;
import com.google.android.gms.maps.SupportMapFragment;
import com.retor.busseskazan.main.IView;
import com.retor.busseskazan.main.R;
import modelImpl.beans.Bus;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by retor on 03.06.2015.
 */
public class SpinnerViewImpl implements IView<List<Bus>> {
    private Spinner spinner;
    private IView<List<Bus>> mapView;
    private int lastNumber;

    public SpinnerViewImpl(FragmentActivity activity) {
        this.spinner = (Spinner) activity.findViewById(R.id.spinner);
        this.mapView = new MapViewImpl(((SupportMapFragment) activity.getSupportFragmentManager().findFragmentById(R.id.map))
                .getMap());
    }

    @Override
    public void newData(List<Bus> data) {
        fillSpinner(data);
    }

    private void fillSpinner(final List<Bus> data) {
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(spinner.getContext(), android.R.layout.simple_spinner_item, getBusNumbers(data));
        adapter.setDropDownViewResource(android.R.layout.simple_list_item_1);
        spinner.setAdapter(adapter);
        spinner.setEnabled(true);
        spinner.setPrompt("Bus number");
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            spinner.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        }
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String tmp = parent.getItemAtPosition(position).toString();
                if (tmp.equals("all")) {
                    mapView.newData(data);
                } else {
                    mapView.newData(getMarshrut(tmp, data));
                    lastNumber = position;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast tt = Toast.makeText(parent.getContext(), "Nothing selected", Toast.LENGTH_SHORT);
                tt.setGravity(78, 56, 195);
                tt.show();
            }
        });
        if (lastNumber > 0 && spinner.getCount() >= lastNumber)
            spinner.setSelection(lastNumber);
    }

    private List<String> getBusNumbers(List<Bus> data) {
        List<String> out = new ArrayList<String>();
        if (data != null) {
            for (Bus b : data) {
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

    public List<Bus> getMarshrut(String number, List<Bus> data) throws NullPointerException {
        List<Bus> out = new ArrayList<Bus>();
        for (Bus b : data) {
            if (b.getData().getMarsh().equals(number))
                out.add(b);
        }
        return out;
    }
}
