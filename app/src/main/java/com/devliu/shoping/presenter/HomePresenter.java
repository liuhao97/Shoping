package com.devliu.shoping.presenter;

import com.devliu.shoping.model.HomeData;
import com.devliu.shoping.model.entities.HomeResponse;
import com.devliu.shoping.ui.frag.HomeFrag;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by liuhao
 * on 2017/4/17
 * use to :
 */

public class HomePresenter implements JsonContract.Presenter<HomeFrag> {

    private HomeData homeDate;
    private HomeFrag viewCallBack;
    private Disposable disposable;

    public HomePresenter() {
        this.homeDate = new HomeData();
    }

    @Override
    public void setViewCallBack(HomeFrag viewCallBack) {
        this.viewCallBack = viewCallBack;
    }

    @Override
    public void getResponse() {
        homeDate.getJsonData()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<HomeResponse>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        disposable = d;
                    }

                    @Override
                    public void onNext(HomeResponse homeResponse) {
                        viewCallBack.onShowData(homeResponse);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }

    @Override
    public void unSubscribe() {
        disposable.dispose();
    }
}
