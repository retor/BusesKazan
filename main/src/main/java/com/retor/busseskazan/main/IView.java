package com.retor.busseskazan.main;

import java.io.Serializable;

/**
 * Created by retor on 03.06.2015.
 */
public interface IView<T> extends Serializable {
    void newData(T data);
}
