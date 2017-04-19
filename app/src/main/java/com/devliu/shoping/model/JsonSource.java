package com.devliu.shoping.model;

import io.reactivex.Observable;

/**
 * Created by liuhao
 * on 2017/4/17
 * use to :
 */

public interface JsonSource <T>{

    Observable<T> getJsonData();

}
