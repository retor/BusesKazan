package com.retor.busseskazan.main.view.impl;

/**
 * Created by retor on 19.08.2015.
 */
public class SpinnerViewImpl{ //implements ChoicerView {
    /*@Bind(R.id.spinner)
    Spinner spinner;
    private ArrayAdapter<String> adapter;
    private OnSelectedCallback callback;
    private int lastNumber = 0;

    @Override
    public void setCallBack(final OnSelectedCallback callBack) {
        this.callback = callBack;
    }

    @OnItemSelected(R.id.spinner)
    protected void onItemSelected(final AdapterView<?> parent, final int position) {
        lastNumber = position;
        callback.onNumberSelected(parent.getItemAtPosition(position).toString());
    }

    @Override
    public void fillList(final List<BusModel> data) {
        if (adapter == null) {
            this.adapter = new ArrayAdapter<String>(spinner.getContext(), android.R.layout.simple_spinner_item);
            fill(data);
            initSpinner(adapter);
        } else {
            initSpinner(adapter);
        }
    }

    @Override
    public void saveState(final Bundle outState) {
        outState.putParcelable("spinner", spinner.onSaveInstanceState());
    }

    @Override
    public void restoreState(@Nullable final Bundle savedState) {
        if (savedState != null && savedState.containsKey("spinner") && spinner != null)
            spinner.onRestoreInstanceState(savedState.getParcelable("spinner"));
    }

    private void initSpinner(ArrayAdapter<String> adapter) {
        adapter.setDropDownViewResource(android.R.layout.simple_list_item_1);
        spinner.setAdapter(adapter);
        spinner.setEnabled(true);
        spinner.setPrompt("Bus number");
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            spinner.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        }
        spinner.setSelection(lastNumber);
    }

    private void fill(final List<BusModel> data) {
        adapter.clear();
        adapter.addAll(getBusNumbers(data));
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
    }*/
}
