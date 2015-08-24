package com.retor.busseskazan.main.utils;

import com.retor.buslib.lib.model.BusModel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by retor on 24.08.2015.
 */
public class ListUtils {
    public static List<String> getBusNumbers(List<BusModel> data) {
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
