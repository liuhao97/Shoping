package com.devliu.shoping.config;

import com.devliu.shoping.model.entities.HomeResponse;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by liuhao
 * on 2017/4/17
 * use to :
 */

public interface ShopApi {

    @GET("home?random=84831&encode=9dd34239798e8cb22bf99a75d1882447")
    Observable<HomeResponse> getHome();

}
