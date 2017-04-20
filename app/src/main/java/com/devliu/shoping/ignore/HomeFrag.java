package com.devliu.shoping.ignore;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.devliu.shoping.R;
import com.devliu.shoping.entities.home.HomeResponse;
import com.devliu.shoping.utils.PicassoLoader;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;

import java.util.List;

/**
 * Created by liuhao
 * on 2017/4/18
 * use to :
 */

public class HomeFrag extends Fragment
        implements JsonContract.ViewCallBack<HomeResponse>{

    private List images;


    private JsonContract.Presenter mPresenter;
    private Banner topBanner;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View contentView = inflater.inflate(R.layout.home_frag, null);

        initViews(contentView);

        loadData();

        return contentView;
    }

    private void loadData() {
        mPresenter = new HomePresenter();
        mPresenter.setViewCallBack(this);
        mPresenter.getResponse();
    }

    private void initViews(View content) {
        topBanner = (Banner) content.findViewById(R.id.home_top_banner);
        topBanner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE)
                //设置图片加载器
                .setImageLoader(new PicassoLoader())
                //设置轮播时间
                .setDelayTime(3000)
                //banner设置方法全部调用完毕时最后调用
                .setBannerStyle(BannerConfig.NOT_INDICATOR);

    }

    @Override
    public void onStart() {
        super.onStart();
        topBanner.startAutoPlay();
    }

    @Override
    public void onStop() {
        super.onStop();
        topBanner.stopAutoPlay();
        mPresenter.unSubscribe();
    }

    @Override
    public void onShowData(HomeResponse response) {

    }

    @Override
    public void onFail() {

    }
}
