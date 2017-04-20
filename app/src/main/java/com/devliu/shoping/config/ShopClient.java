package com.devliu.shoping.config;

import com.devliu.shoping.app.CustomApplication;
import com.devliu.shoping.utils.NetUtils;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.CacheControl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by liuhao
 * on 2017/4/17
 * use to :
 */

public class ShopClient {

    private static final int DEFAULT_TIMEOUT = 10;
    private static final int CACHE_SIZE = 10 * 1024 * 1024;

    private static final GsonConverterFactory gsonConverter = GsonConverterFactory.create();
    private static final RxJava2CallAdapterFactory callAdapter = RxJava2CallAdapterFactory.create();
    private static final File cacheFile = new File(
            CustomApplication.getAppContext().getCacheDir(), "okHttpCache");

    private static final Interceptor cacheInterceptor = new Interceptor() {
        @Override
        public Response intercept(Chain chain) throws IOException {
            Request request = chain.request();
            if (!NetUtils.isConnected(CustomApplication.getAppContext())) {
                request = request.newBuilder()
                        .cacheControl(CacheControl.FORCE_CACHE)
                        .build();
            }

            Response originalResponse = chain.proceed(request);
            if (NetUtils.isConnected(CustomApplication.getAppContext())) {
                int maxAge = 60;
                return originalResponse.newBuilder()
                        .removeHeader("Cache-Control")
                        .header("Cache-Control", "public, max-age=" + maxAge)
                        .build();
            } else {
                return originalResponse.newBuilder()
                        .header("Cache-Control", CacheControl.FORCE_CACHE.toString())
                        .build();
            }
        }
    };


    public static ShopApi getShopApi() {
        String baseUrl = "http://m.yunifang.com/yunifang/mobile/";

        OkHttpClient httpClient = new OkHttpClient.Builder()
                .connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
                .readTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
                .writeTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
                .cache(new Cache(cacheFile, CACHE_SIZE))
                .addNetworkInterceptor(cacheInterceptor)
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .client(httpClient)
                .baseUrl(baseUrl)
                .addCallAdapterFactory(callAdapter)
                .addConverterFactory(gsonConverter)
                .build();

        return retrofit.create(ShopApi.class);
    }

}
