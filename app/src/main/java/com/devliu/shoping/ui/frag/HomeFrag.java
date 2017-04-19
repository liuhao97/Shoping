package com.devliu.shoping.ui.frag;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.devliu.shoping.R;
import com.devliu.shoping.model.entities.HomeResponse;
import com.devliu.shoping.presenter.HomePresenter;
import com.devliu.shoping.presenter.JsonContract;

/**
 * Created by liuhao
 * on 2017/4/18
 * use to :
 */

public class HomeFrag extends Fragment
        implements JsonContract.ViewCallBack<HomeResponse>{

    private JsonContract.Presenter mPresenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View contentView = inflater.inflate(R.layout.home_frag, null);

        initViews();

        loadData();

        return contentView;
    }

    private void loadData() {
        mPresenter = new HomePresenter();
        mPresenter.setViewCallBack(this);
        mPresenter.getResponse();
    }

    private void initViews() {

    }

    @Override
    public void onStop() {
        super.onStop();
        mPresenter.unSubscribe();
    }

    @Override
    public void onShowData(HomeResponse response) {

    }

    @Override
    public void onFail() {

    }
}
