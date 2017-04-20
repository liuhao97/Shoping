package com.devliu.shoping.entities.home;

import java.util.List;

/**
 * Created by liuhao
 * on 2017/4/19
 * use to :
 */

public class DataBean {
    private ActivityInfoBean activityInfo;
    private boolean creditRecived;
    private List<SubjectsBean> subjects;
    private List<BestSellersBean> bestSellers;
    private List<Ad1Bean> ad1;
    private List<Ad5Bean> ad5;
    private List<DefaultGoodsListBean> defaultGoodsList;

    public ActivityInfoBean getActivityInfo() {
        return activityInfo;
    }

    public void setActivityInfo(ActivityInfoBean activityInfo) {
        this.activityInfo = activityInfo;
    }

    public boolean isCreditRecived() {
        return creditRecived;
    }

    public void setCreditRecived(boolean creditRecived) {
        this.creditRecived = creditRecived;
    }

    public List<SubjectsBean> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<SubjectsBean> subjects) {
        this.subjects = subjects;
    }

    public List<BestSellersBean> getBestSellers() {
        return bestSellers;
    }

    public void setBestSellers(List<BestSellersBean> bestSellers) {
        this.bestSellers = bestSellers;
    }

    public List<Ad1Bean> getAd1() {
        return ad1;
    }

    public void setAd1(List<Ad1Bean> ad1) {
        this.ad1 = ad1;
    }

    public List<Ad5Bean> getAd5() {
        return ad5;
    }

    public void setAd5(List<Ad5Bean> ad5) {
        this.ad5 = ad5;
    }

    public List<DefaultGoodsListBean> getDefaultGoodsList() {
        return defaultGoodsList;
    }

    public void setDefaultGoodsList(List<DefaultGoodsListBean> defaultGoodsList) {
        this.defaultGoodsList = defaultGoodsList;
    }
}
