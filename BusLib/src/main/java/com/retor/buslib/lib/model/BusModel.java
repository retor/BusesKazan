package com.retor.buslib.lib.model;

/**
 * Created by retor on 13.08.2015.
 */
public class BusModel {
    private String updated_at;
    private Bus data;

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(final String updated_at) {
        this.updated_at = updated_at;
    }

    public Bus getData() {
        return data;
    }

    public void setData(final Bus data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "BusModel{" +
                "updated_at='" + updated_at + '\'' +
                ", data=" + data +
                '}';
    }
}
