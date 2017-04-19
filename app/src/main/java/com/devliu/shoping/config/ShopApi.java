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

    @GET("news/latest")
    Observable<HomeResponse> getHome();

}
