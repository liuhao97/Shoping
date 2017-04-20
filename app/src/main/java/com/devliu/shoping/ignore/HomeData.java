package com.devliu.shoping.ignore;

import com.devliu.shoping.entities.home.HomeResponse;
import com.devliu.shoping.config.ShopClient;

import io.reactivex.Observable;

/**
 * Created by liuhao
 * on 2017/4/17
 * use to :
 */

public class HomeData implements JsonSource<HomeResponse> {
    @Override
    public Observable<HomeResponse> getJsonData() {
        return ShopClient.getShopApi().getHome();
    }
}
