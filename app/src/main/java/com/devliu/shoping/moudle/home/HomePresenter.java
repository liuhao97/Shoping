package com.devliu.shoping.moudle.home;

import com.devliu.shoping.entities.home.DataBean;
import com.devliu.shoping.entities.home.HomeResponse;
import com.devliu.shoping.mvp.BasePresenterImpl;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * MVPPlugin
 *  邮箱 784787081@qq.com
 */

public class HomePresenter
        extends BasePresenterImpl<HomeContract.View>
        implements HomeContract.Presenter{

    private HomeReposity homeReposity = new HomeReposity();
    private Disposable disposable;

    @Override
    public void loadData() {

        homeReposity.getJsonData()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<HomeResponse>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        disposable = d;
                    }

                    @Override
                    public void onNext(HomeResponse homeResponse) {
                        DataBean data = homeResponse.getData();
                        mView.loadTopBanner(data.getAd1());
                        mView.loadActionGrid(data.getAd5());
                        mView.loadSellerList(data.getBestSellers());
                        mView.loadActiveBanner(data.getActivityInfo().getActivityInfoList());
                        mView.loadSubjectList(data.getSubjects());
                        mView.loadDefaultGrid(data.getDefaultGoodsList());
                    }

                    @Override
                    public void onError(Throwable e) {
                        mView.loadFail();
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
