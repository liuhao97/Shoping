package com.devliu.shoping.ignore;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.devliu.shoping.R;

/**
 * Created by liuhao
 * on 2017/4/18
 * use to :
 */

public class ShopFrag extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View contentView = inflater.inflate(R.layout.shop_frag, null);

        return contentView;
    }
}
