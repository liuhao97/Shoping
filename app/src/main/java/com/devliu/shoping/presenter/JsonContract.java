package com.devliu.shoping.presenter;

/**
 * Created by liuhao
 * on 2017/4/17
 * use to :
 */

public interface JsonContract {

    public interface ViewCallBack<T> {

        void onShowData(T response);

        void onFail();

    }

    public interface Presenter {
        void setViewCallBack(ViewCallBack viewCallBack);

        void getResponse();

        void unSubscribe();
    }

}
