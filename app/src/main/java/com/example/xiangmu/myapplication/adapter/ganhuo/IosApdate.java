package com.example.xiangmu.myapplication.adapter.ganhuo;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.xiangmu.myapplication.R;
import com.example.xiangmu.myapplication.activity.ganhuo.GanActivity;
import com.example.xiangmu.myapplication.beans.GanHuoWenZhangBean;
import com.example.xiangmu.myapplication.beans.ganhuo.MeiZhIShuiJiBean;
import com.example.xiangmu.myapplication.view.GanHuoView;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;

/**
 * @packge: com.example.xiangmu.myapplication.adapter.ganhuo
 * @filename:IosApdate
 * @date :${DATA} 15:21
 */
public class IosApdate  extends XRecyclerView.Adapter {
    private Context mContext;

    private final ArrayList<GanHuoWenZhangBean.ResultsBean> mGanHuoWenZhangBeans;

    public IosApdate(ArrayList<GanHuoWenZhangBean.ResultsBean> ganHuoWenZhangBeans) {
        mGanHuoWenZhangBeans = ganHuoWenZhangBeans;

    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        mContext = parent.getContext();
        View inflate = LayoutInflater.from(mContext).inflate(R.layout.item_ios_item, null);
        ViewHolder holder = new ViewHolder(inflate);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
       ViewHolder viewHolder= (ViewHolder) holder;
        viewHolder.mAndTvname.setText(mGanHuoWenZhangBeans.get(position).getWho());
        viewHolder.mAndTvtime.setText(mGanHuoWenZhangBeans.get(position).getPublishedAt().substring(0,9));
        viewHolder.mTvTxtGAndroid.setText(mGanHuoWenZhangBeans.get(position).getDesc());
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, GanActivity.class);
                intent.putExtra("name",mGanHuoWenZhangBeans.get(position).getUrl());
                intent.putExtra("title",mGanHuoWenZhangBeans.get(position).getDesc());
                intent.putExtra("img",R.mipmap.ic_ios);
                mContext.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return mGanHuoWenZhangBeans.size();
    }

    public void addAll(ArrayList<GanHuoWenZhangBean.ResultsBean> ganHuoWenZhangBeans) {
        mGanHuoWenZhangBeans.addAll(ganHuoWenZhangBeans);
        notifyDataSetChanged();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        TextView mTvTxtGAndroid;

        TextView mAndTvname;

        TextView mAndTvtime;

        ViewHolder(View view) {
            super(view);
            mTvTxtGAndroid=view.findViewById(R.id.tv_txt_g_ios);
            mAndTvname=view.findViewById(R.id.ios_tvname);
            mAndTvtime=view.findViewById(R.id.ios_tvtime);

        }
    }
}
