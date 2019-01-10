package com.example.xiangmu.myapplication.adapter.ganhuo;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
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
 * @filename:AndroidApdate
 * @date :${DATA} 15:21
 */
public class AndroidApdate extends XRecyclerView.Adapter {
    private Context mContext;

    private  ArrayList<GanHuoWenZhangBean.ResultsBean> mGanHuoWenZhangBeans;

    public AndroidApdate(ArrayList<GanHuoWenZhangBean.ResultsBean> ganHuoWenZhangBeans) {
        mGanHuoWenZhangBeans = ganHuoWenZhangBeans;

    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
         mContext = parent.getContext();
         Log.e("NULL",mContext+"");
         View inflate = LayoutInflater.from(mContext).inflate(R.layout.item_android_item, null);
         ViewHolder viewHolder = new ViewHolder(inflate);
         return viewHolder;
     }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
            Log.e("TAG",holder+"");
            ViewHolder viewHolder= (ViewHolder) holder;
            Log.e("TAG",mGanHuoWenZhangBeans.get(position)+""+"======="+mGanHuoWenZhangBeans.get(position).getWho()+""+viewHolder.mAndTvname+""+viewHolder);
             viewHolder.mAndTvname.setText(mGanHuoWenZhangBeans.get(position).getWho());
        /*mGanHuoWenZhangBeans.get(position).getPublishedAt().substring(0, 9)*/
             viewHolder.mAndTvtime.setText(mGanHuoWenZhangBeans.get(position).getPublishedAt().substring(0, 9));
        /*mGanHuoWenZhangBeans.get(position).getDesc()*/
             viewHolder.mTvTxtGAndroid.setText(mGanHuoWenZhangBeans.get(position).getDesc());
        /*mGanHuoWenZhangBeans.get(position).getWho()*/
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, GanActivity.class);
                intent.putExtra("name",mGanHuoWenZhangBeans.get(position).getUrl());
                intent.putExtra("title",mGanHuoWenZhangBeans.get(position).getDesc());
                intent.putExtra("img",R.mipmap.ic_android);
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
    }


      class ViewHolder extends RecyclerView.ViewHolder {

        TextView mTvTxtGAndroid;

        TextView mAndTvname;

        TextView mAndTvtime;

        ViewHolder(View view) {
            super(view);
            Log.e("ViewHolder","======");
            mTvTxtGAndroid=view.findViewById(R.id.tv_txt_g_android);
            mAndTvtime=view.findViewById(R.id.and_tvt);
            mAndTvname=view.findViewById(R.id.and_tv);

        }
    }
}
