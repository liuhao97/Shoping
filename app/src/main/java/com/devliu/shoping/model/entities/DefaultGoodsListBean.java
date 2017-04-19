package com.devliu.shoping.model.entities;

/**
 * Created by liuhao
 * on 2017/4/19
 * use to :
 */

public class DefaultGoodsListBean {
    private String id;
    private String goods_name;
    private double shop_price;
    private double market_price;
    private String goods_img;
    private boolean reservable;
    private String efficacy;
    private int stock_number;
    private int restrict_purchase_num;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGoods_name() {
        return goods_name;
    }

    public void setGoods_name(String goods_name) {
        this.goods_name = goods_name;
    }

    public double getShop_price() {
        return shop_price;
    }

    public void setShop_price(double shop_price) {
        this.shop_price = shop_price;
    }

    public double getMarket_price() {
        return market_price;
    }

    public void setMarket_price(double market_price) {
        this.market_price = market_price;
    }

    public String getGoods_img() {
        return goods_img;
    }

    public void setGoods_img(String goods_img) {
        this.goods_img = goods_img;
    }

    public boolean isReservable() {
        return reservable;
    }

    public void setReservable(boolean reservable) {
        this.reservable = reservable;
    }

    public String getEfficacy() {
        return efficacy;
    }

    public void setEfficacy(String efficacy) {
        this.efficacy = efficacy;
    }

    public int getStock_number() {
        return stock_number;
    }

    public void setStock_number(int stock_number) {
        this.stock_number = stock_number;
    }

    public int getRestrict_purchase_num() {
        return restrict_purchase_num;
    }

    public void setRestrict_purchase_num(int restrict_purchase_num) {
        this.restrict_purchase_num = restrict_purchase_num;
    }
}
