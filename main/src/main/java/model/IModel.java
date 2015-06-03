package model;

import java.io.Serializable;

/**
 * Created by retor on 03.06.2015.
 */
public interface IModel<T> extends Serializable {
    T getData(String patch);
}
