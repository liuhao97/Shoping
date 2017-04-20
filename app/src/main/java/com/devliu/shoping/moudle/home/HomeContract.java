package com.devliu.shoping.moudle.home;

import com.devliu.shoping.entities.home.ActivityInfoListBean;
import com.devliu.shoping.entities.home.Ad1Bean;
import com.devliu.shoping.entities.home.Ad5Bean;
import com.devliu.shoping.entities.home.BestSellersBean;
import com.devliu.shoping.entities.home.DefaultGoodsListBean;
import com.devliu.shoping.entities.home.SubjectsBean;
import com.devliu.shoping.mvp.BasePresenter;
import com.devliu.shoping.mvp.BaseView;

import java.util.List;

/**
 * MVPPlugin
 *  邮箱 784787081@qq.com
 */

public class HomeContract {
    interface View extends BaseView {
        void loadTopBanner(List<Ad1Bean> ad1Beans);

        void loadActionGrid(List<Ad5Bean> ad5Beans);

        void loadSellerList(List<BestSellersBean> SellersBeans);

        void loadActiveBanner(List<ActivityInfoListBean> infoBeans);

        void loadSubjectList(List<SubjectsBean> subjectBeans);

        void loadDefaultGrid(List<DefaultGoodsListBean> defaultBeans);

        void loadFail();
    }

    interface  Presenter extends BasePresenter<View> {

        void loadData();

        void unSubscribe();
        
    }
}
