package com.devliu.shoping.moudle.classify;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.devliu.shoping.R;
import com.devliu.shoping.mvp.MVPBaseFragment;

/**
 * MVPPlugin
 *  邮箱 784787081@qq.com
 */

public class ClassifyFragment
        extends MVPBaseFragment<ClassifyContract.View, ClassifyPresenter>
        implements ClassifyContract.View {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View contentView = inflater.inflate(R.layout.classify_frag, null);

        return contentView;
    }
}
