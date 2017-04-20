package com.devliu.shoping.entities.home;

import java.util.List;

/**
 * Created by liuhao
 * on 2017/4/19
 * use to :
 */

public class SubjectsBean {
    private String id;
    private String title;
    private String detail;
    private String image;
    private String start_time;
    private String end_time;
    private int show_number;
    private String state;
    private int sort;
    private List<GoodsListBean> goodsList;
    private List<String> goodsIdsList;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getStart_time() {
        return start_time;
    }

    public void setStart_time(String start_time) {
        this.start_time = start_time;
    }

    public String getEnd_time() {
        return end_time;
    }

    public void setEnd_time(String end_time) {
        this.end_time = end_time;
    }

    public int getShow_number() {
        return show_number;
    }

    public void setShow_number(int show_number) {
        this.show_number = show_number;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getSort() {
        return sort;
    }

    public void setSort(int sort) {
        this.sort = sort;
    }

    public List<GoodsListBean> getGoodsList() {
        return goodsList;
    }

    public void setGoodsList(List<GoodsListBean> goodsList) {
        this.goodsList = goodsList;
    }

    public List<String> getGoodsIdsList() {
        return goodsIdsList;
    }

    public void setGoodsIdsList(List<String> goodsIdsList) {
        this.goodsIdsList = goodsIdsList;
    }
}
