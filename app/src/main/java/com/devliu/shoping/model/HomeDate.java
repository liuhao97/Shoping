package com.devliu.shoping.model;

import com.devliu.shoping.model.entities.HomeResponse;
import com.devliu.shoping.net.ShopClient;

import io.reactivex.Observable;

/**
 * Created by liuhao
 * on 2017/4/17
 * use to :
 */

public class HomeDate implements JsonSource<HomeResponse> {
    @Override
    public Observable<HomeResponse> getJsonData() {
        return ShopClient.getShopApi().getHome();
    }
}
