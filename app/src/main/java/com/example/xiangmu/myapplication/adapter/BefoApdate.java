package com.example.xiangmu.myapplication.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.xiangmu.myapplication.R;
import com.example.xiangmu.myapplication.base.activity.zhihu.ZhiHuDataActivity;
import com.example.xiangmu.myapplication.beans.DailyBeforeListBean;
import com.example.xiangmu.myapplication.utils.ImgUtis;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import retrofit2.http.PUT;

/**
 * @packge: com.example.xiangmu.myapplication.adapter
 * @filename:BefoApdate
 * @date :${DATA} 15:16
 */
public class BefoApdate extends XRecyclerView.Adapter {


    private final ArrayList<DailyBeforeListBean.StoriesBean> storiesBeans;
    private Context mContext;
    private long  data;

    public BefoApdate(ArrayList<DailyBeforeListBean.StoriesBean> storiesBeans,long data) {
         this.storiesBeans=storiesBeans;
         this.data=data;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        mContext = parent.getContext();
        if (viewType==0){
            View view = LayoutInflater.from(mContext).inflate(R.layout.item_guoqutv, null);
            MyViewHolder holder = new MyViewHolder(view);
            return  holder;
        }else {
            View view = LayoutInflater.from(mContext).inflate(R.layout.item_gouquitem, null);
            MyViewHolderTow holderTow = new MyViewHolderTow(view);
            return  holderTow;
        }



    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        int itemViewType = getItemViewType(position);
        if (itemViewType==0){
      MyViewHolder myViewHolder=(MyViewHolder)holder;
        myViewHolder.tv.setText(data+"");
        }else {
            MyViewHolderTow myViewHolder=(MyViewHolderTow)holder;

            ImgUtis.setimg(storiesBeans.get(position).getImages().get(0),mContext,myViewHolder.img);
            myViewHolder.tv.setText(storiesBeans.get(position).getTitle());
            myViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(mContext,ZhiHuDataActivity.class);
                    intent.putExtra("id",storiesBeans.get(position).getId());
                    mContext.startActivity(intent);
                }
            });

        }

    }

    @Override
    public int getItemCount() {
        return storiesBeans.size();
    }

    @Override
    public int getItemViewType(int position) {
          if (position==0){
              return  0;
          }else {
              return  1;
          }


    }
    class  MyViewHolder extends RecyclerView.ViewHolder{
        TextView tv;

        public MyViewHolder(View itemView) {
            super(itemView);
            tv=itemView.findViewById(R.id.tv_guoqu);
        }
    }
    class  MyViewHolderTow extends RecyclerView.ViewHolder{
        TextView tv;
        ImageView img;
        public MyViewHolderTow(View itemView) {
            super(itemView);
            tv=itemView.findViewById(R.id.tv_yihou);
            img=itemView.findViewById(R.id.img_yihou);
        }
    }

}
