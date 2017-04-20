package com.devliu.shoping.entities.home;

import java.util.List;

/**
 * Created by liuhao
 * on 2017/4/19
 * use to :
 */

public class ActivityInfoBean {
    private String activityAreaDisplay;
    private List<ActivityInfoListBean> activityInfoList;

    public String getActivityAreaDisplay() {
        return activityAreaDisplay;
    }

    public void setActivityAreaDisplay(String activityAreaDisplay) {
        this.activityAreaDisplay = activityAreaDisplay;
    }

    public List<ActivityInfoListBean> getActivityInfoList() {
        return activityInfoList;
    }

    public void setActivityInfoList(List<ActivityInfoListBean> activityInfoList) {
        this.activityInfoList = activityInfoList;
    }
}
