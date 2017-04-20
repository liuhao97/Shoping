package com.devliu.shoping.adapter;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.devliu.shoping.R;
import com.devliu.shoping.entities.home.BestSellersBean;

import java.util.List;

/**
 * Created by liuhao
 * on 2017/4/20
 * use to :
 */

public class SellerListAdapter extends RecyclerView.Adapter<SellerListAdapter.SellerListHolder>{
    private Context context;
    private List<BestSellersBean> sellersList;

    public SellerListAdapter(Context context, List<BestSellersBean> sellersList) {
        this.context = context;
        this.sellersList = sellersList;
    }

    @Override
    public SellerListHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View contentView = LayoutInflater.from(context)
                .inflate(R.layout.home_seller_list_itm, parent, false);
        return new SellerListHolder(contentView);
    }

    @Override
    public void onBindViewHolder(SellerListHolder holder, int position) {
        BestSellersBean seller = sellersList.get(position);
        holder.tv.setText(seller.getName());

        LinearLayoutManager innerListManager =
                new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false);
        holder.rv.setLayoutManager(innerListManager);
        SellerInnerListAdapter adapter = new SellerInnerListAdapter(context, seller.getGoodsList());
        holder.rv.setAdapter(adapter);
    }

    @Override
    public int getItemCount() {
        return sellersList.size();
    }

    class SellerListHolder extends RecyclerView.ViewHolder{
        TextView tv;
        RecyclerView rv;

        public SellerListHolder(View itemView) {
            super(itemView);
            tv = (TextView)itemView.findViewById(R.id.tv_seller_list);
            rv = (RecyclerView)itemView.findViewById(R.id.rv_seller_list);
        }
    }
}
