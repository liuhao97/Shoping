package com.devliu.shoping.moudle.home;

import com.devliu.shoping.config.ShopClient;
import com.devliu.shoping.entities.home.HomeResponse;

import io.reactivex.Observable;

/**
 * Created by liuhao
 * on 2017/4/19
 * use to :
 */

public class HomeReposity implements HomeSource<HomeResponse> {

    @Override
    public Observable<HomeResponse> getJsonData() {
        return ShopClient.getShopApi().getHome();
    }

}
