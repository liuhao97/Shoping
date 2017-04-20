package com.devliu.shoping.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.devliu.shoping.R;
import com.devliu.shoping.entities.home.GoodsListBeanX;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by liuhao
 * on 2017/4/20
 * use to :
 */

public class SellerInnerListAdapter
        extends RecyclerView.Adapter<SellerInnerListAdapter.SellerInnerListHolder>{
    private Context context;
    private List<GoodsListBeanX> innerList;

    public SellerInnerListAdapter(Context context, List<GoodsListBeanX> innerList) {
        this.context = context;
        this.innerList = innerList;
    }

    @Override
    public SellerInnerListHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View contentView = LayoutInflater.from(context)
                .inflate(R.layout.home_seller_inner_list_item, parent, false);
        return new SellerInnerListHolder(contentView);
    }

    @Override
    public void onBindViewHolder(SellerInnerListHolder holder, int position) {
        GoodsListBeanX innerGood = innerList.get(position);
        Picasso.with(context).load(innerGood.getGoods_img()).into(holder.iv);
        holder.desc.setText(innerGood.getGoods_name());
        holder.shop.setText("¥ " + innerGood.getShop_price());
        holder.market.setText("¥ " + innerGood.getMarket_price());
    }

    @Override
    public int getItemCount() {
        return innerList.size();
    }

    class SellerInnerListHolder extends RecyclerView.ViewHolder{
        ImageView iv;
        TextView desc;
        TextView shop;
        TextView market;

        public SellerInnerListHolder(View itemView) {
            super(itemView);
            iv = (ImageView)itemView.findViewById(R.id.iv_seller_inner_list);
            desc = (TextView)itemView.findViewById(R.id.tv_seller_inner_list);
            shop = (TextView)itemView.findViewById(R.id.tv_shop_seller_inner_list);
            market = (TextView)itemView.findViewById(R.id.tv_market_seller_inner_list);
        }
    }
}
