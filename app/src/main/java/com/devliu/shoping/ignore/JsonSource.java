package com.devliu.shoping.ignore;

import io.reactivex.Observable;

/**
 * Created by liuhao
 * on 2017/4/17
 * use to :
 */

public interface JsonSource <T>{

    Observable<T> getJsonData();

}
