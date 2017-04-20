package com.devliu.shoping.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.devliu.shoping.R;
import com.devliu.shoping.entities.home.Ad5Bean;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by liuhao
 * on 2017/4/20
 * use to :
 */

public class ActionGridAdapter extends RecyclerView.Adapter<ActionGridAdapter.ActionGridHolder>{

    private Context context;
    private List<Ad5Bean> actionList;

    public ActionGridAdapter(Context context, List<Ad5Bean> actionList) {
        this.context = context;
        this.actionList = actionList;
    }

    @Override
    public ActionGridHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View contentView = LayoutInflater.from(context)
                .inflate(R.layout.home_action_grid_itm, parent, false);

        return new ActionGridHolder(contentView);
    }

    @Override
    public void onBindViewHolder(ActionGridHolder holder, int position) {
        Ad5Bean action = actionList.get(position);
        Picasso.with(context).load(action.getImage()).into(holder.iv);
        holder.tv.setText(action.getTitle());
    }

    @Override
    public int getItemCount() {
        return actionList.size();
    }

    class ActionGridHolder extends RecyclerView.ViewHolder{
        ImageView iv;
        TextView tv;

        public ActionGridHolder(View itemView) {
            super(itemView);
            iv = (ImageView) itemView.findViewById(R.id.iv_action_grid);
            tv = (TextView)itemView.findViewById(R.id.tv_action_grid);
        }
    }

}
