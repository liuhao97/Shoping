package com.devliu.shoping.model.entities;

import java.util.List;

/**
 * Created by liuhao
 * on 2017/4/19
 * use to :
 */

public class BestSellersBean {
    private String id;
    private String name;
    private String descript;
    private String state;
    private int show_number;
    private String begin_date;
    private String end_date;
    private List<GoodsListBeanX> goodsList;
    private List<String> goodsIdsList;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescript() {
        return descript;
    }

    public void setDescript(String descript) {
        this.descript = descript;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getShow_number() {
        return show_number;
    }

    public void setShow_number(int show_number) {
        this.show_number = show_number;
    }

    public String getBegin_date() {
        return begin_date;
    }

    public void setBegin_date(String begin_date) {
        this.begin_date = begin_date;
    }

    public String getEnd_date() {
        return end_date;
    }

    public void setEnd_date(String end_date) {
        this.end_date = end_date;
    }

    public List<GoodsListBeanX> getGoodsList() {
        return goodsList;
    }

    public void setGoodsList(List<GoodsListBeanX> goodsList) {
        this.goodsList = goodsList;
    }

    public List<String> getGoodsIdsList() {
        return goodsIdsList;
    }

    public void setGoodsIdsList(List<String> goodsIdsList) {
        this.goodsIdsList = goodsIdsList;
    }
}
