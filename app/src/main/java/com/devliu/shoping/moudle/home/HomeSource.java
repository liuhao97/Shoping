package com.devliu.shoping.moudle.home;

import io.reactivex.Observable;

/**
 * Created by liuhao
 * on 2017/4/19
 * use to :
 */

public interface HomeSource <T>{

    Observable<T> getJsonData();

}
