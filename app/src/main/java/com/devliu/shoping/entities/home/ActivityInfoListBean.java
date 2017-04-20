package com.devliu.shoping.entities.home;

/**
 * Created by liuhao
 * on 2017/4/19
 * use to :
 */

public class ActivityInfoListBean {
    private String id;
    private String activityImg;
    private String activityType;
    private String activityData;
    private String activityDataDetail;
    private String activityAreaDisplay;
    private String countDownEnable;
    private int sort;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getActivityImg() {
        return activityImg;
    }

    public void setActivityImg(String activityImg) {
        this.activityImg = activityImg;
    }

    public String getActivityType() {
        return activityType;
    }

    public void setActivityType(String activityType) {
        this.activityType = activityType;
    }

    public String getActivityData() {
        return activityData;
    }

    public void setActivityData(String activityData) {
        this.activityData = activityData;
    }

    public String getActivityDataDetail() {
        return activityDataDetail;
    }

    public void setActivityDataDetail(String activityDataDetail) {
        this.activityDataDetail = activityDataDetail;
    }

    public String getActivityAreaDisplay() {
        return activityAreaDisplay;
    }

    public void setActivityAreaDisplay(String activityAreaDisplay) {
        this.activityAreaDisplay = activityAreaDisplay;
    }

    public String getCountDownEnable() {
        return countDownEnable;
    }

    public void setCountDownEnable(String countDownEnable) {
        this.countDownEnable = countDownEnable;
    }

    public int getSort() {
        return sort;
    }

    public void setSort(int sort) {
        this.sort = sort;
    }
}
