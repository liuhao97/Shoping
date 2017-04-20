package com.devliu.shoping.moudle.home;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.devliu.shoping.R;
import com.devliu.shoping.adapter.ActionGridAdapter;
import com.devliu.shoping.adapter.SellerListAdapter;
import com.devliu.shoping.adapter.SubjectListAdapter;
import com.devliu.shoping.entities.home.ActivityInfoListBean;
import com.devliu.shoping.entities.home.Ad1Bean;
import com.devliu.shoping.entities.home.Ad5Bean;
import com.devliu.shoping.entities.home.BestSellersBean;
import com.devliu.shoping.entities.home.DefaultGoodsListBean;
import com.devliu.shoping.entities.home.SubjectsBean;
import com.devliu.shoping.mvp.MVPBaseFragment;
import com.devliu.shoping.utils.PicassoLoader;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;

import java.util.ArrayList;
import java.util.List;

/**
 * MVPPlugin
 * 邮箱 784787081@qq.com
 */

public class HomeFragment
        extends MVPBaseFragment<HomeContract.View, HomePresenter>
        implements HomeContract.View {

    private Banner topBanner;
    private RecyclerView actionGrid;
    private RecyclerView sellerList;
    private Banner activeBanner;
    private RecyclerView subjectList;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View contentView = inflater.inflate(R.layout.home_frag, null);

        initViews(contentView);

        mPresenter.loadData();

        return contentView;
    }

    private void initViews(View content) {
        topBanner = (Banner) content.findViewById(R.id.home_top_banner);
        actionGrid = (RecyclerView) content.findViewById(R.id.home_action_grid);
        sellerList = (RecyclerView) content.findViewById(R.id.home_seller_list);
        activeBanner = (Banner) content.findViewById(R.id.home_active_banner);
        subjectList = (RecyclerView) content.findViewById(R.id.home_subject_list);
    }

    @Override
    public void loadTopBanner(List<Ad1Bean> ad1Beans) {
        topBanner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE)
                //设置图片加载器
                .setImageLoader(new PicassoLoader())
                //设置轮播时间
                .setDelayTime(3000)
                //banner设置方法全部调用完毕时最后调用
                .setBannerStyle(BannerConfig.NOT_INDICATOR);

        List<String> topImages = new ArrayList<>();
        for (Ad1Bean ad1 : ad1Beans) {
            topImages.add(ad1.getImage());
        }
        topBanner.setImages(topImages).start();
    }

    @Override
    public void loadActionGrid(List<Ad5Bean> ad5Beans) {
        GridLayoutManager actionGridManager = new GridLayoutManager(getContext(), 4);
        actionGrid.setNestedScrollingEnabled(false);
        actionGrid.setLayoutManager(actionGridManager);
        ActionGridAdapter actionGridAdapter = new ActionGridAdapter(getContext(), ad5Beans);
        actionGrid.setAdapter(actionGridAdapter);
    }

    @Override
    public void loadSellerList(List<BestSellersBean> sellersBeans) {
        LinearLayoutManager sellerListManager =
                new LinearLayoutManager(getContext());
        sellerList.setNestedScrollingEnabled(false);
        sellerList.setLayoutManager(sellerListManager);
        SellerListAdapter sellerListAdapter = new SellerListAdapter(getContext(), sellersBeans);
        sellerList.setAdapter(sellerListAdapter);
    }

    @Override
    public void loadActiveBanner(List<ActivityInfoListBean> infoBeans) {
        activeBanner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE)
                //设置图片加载器
                .setImageLoader(new PicassoLoader())
                .setBannerStyle(BannerConfig.NOT_INDICATOR)
                .isAutoPlay(false)
                .setBannerAnimation(Transformer.DepthPage);

        List<String> images = new ArrayList<>();
        for (ActivityInfoListBean info : infoBeans) {
            images.add(info.getActivityImg());
        }
        activeBanner.setImages(images).start();
    }

    @Override
    public void loadSubjectList(List<SubjectsBean> subjectBeans) {
        LinearLayoutManager subjectListManager = new LinearLayoutManager(getContext());
        subjectList.setNestedScrollingEnabled(false);
        subjectList.setLayoutManager(subjectListManager);
        SubjectListAdapter adapter = new SubjectListAdapter(getContext(), subjectBeans);
        subjectList.setAdapter(adapter);
    }

    @Override
    public void loadDefaultGrid(List<DefaultGoodsListBean> defaultBeans) {

    }

    @Override
    public void loadFail() {
        Toast.makeText(getContext(), "网络请求失败", Toast.LENGTH_SHORT).show();
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
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mPresenter.unSubscribe();
    }
}
