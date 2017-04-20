package com.devliu.shoping.adapter;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.devliu.shoping.R;
import com.devliu.shoping.entities.home.SubjectsBean;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by liuhao
 * on 2017/4/20
 * use to :
 */

public class SubjectListAdapter
        extends RecyclerView.Adapter<SubjectListAdapter.SubjectListHolder> {

    private Context context;
    private List<SubjectsBean> subjectList;

    public SubjectListAdapter(Context context, List<SubjectsBean> subjectList) {
        this.context = context;
        this.subjectList = subjectList;
    }

    @Override
    public SubjectListHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View contentView = LayoutInflater.from(context)
                .inflate(R.layout.home_subject_list_itm, parent, false);
        return new SubjectListHolder(contentView);
    }

    @Override
    public void onBindViewHolder(SubjectListHolder holder, int position) {
        SubjectsBean subject = subjectList.get(position);
        Picasso.with(context).load(subject.getImage()).into(holder.iv);
        LinearLayoutManager manager =
                new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false);
        holder.rv.setLayoutManager(manager);
        SubjectInnerListAdapter adapter =
                new SubjectInnerListAdapter(context, subject.getGoodsList());
        holder.rv.setAdapter(adapter);
    }

    @Override
    public int getItemCount() {
        return subjectList.size();
    }

    class SubjectListHolder extends RecyclerView.ViewHolder{
        ImageView iv;
        RecyclerView rv;

        public SubjectListHolder(View itemView) {
            super(itemView);
            iv = (ImageView)itemView.findViewById(R.id.iv_subject_list);
            rv = (RecyclerView)itemView.findViewById(R.id.rv_subject_inner_list);
        }
    }

}
