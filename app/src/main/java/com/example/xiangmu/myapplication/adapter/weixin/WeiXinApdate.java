package com.example.xiangmu.myapplication.adapter.weixin;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.xiangmu.myapplication.R;
import com.example.xiangmu.myapplication.beans.WeiXinBean;
import com.example.xiangmu.myapplication.utils.ImgUtis;
import com.facebook.drawee.view.SimpleDraweeView;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @packge: com.example.xiangmu.myapplication.adapter.weixin
 * @filename:WeiXinApdate
 * @date :${DATA} 20:02
 */
public class WeiXinApdate extends XRecyclerView.Adapter {
    private final ArrayList<WeiXinBean.NewslistBean> beans;
    private Context mContext;

    public WeiXinApdate(ArrayList<WeiXinBean.NewslistBean> beans) {
         this.beans=beans;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        mContext = parent.getContext();
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_weixin, null);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
       ViewHolder viewHolder= (ViewHolder)holder;
        ImgUtis.setFace(beans.get(position).getPicUrl(),viewHolder.mImgWeixin,mContext);
        viewHolder.mTvtitleWeixin.setText(beans.get(position).getTitle());
        viewHolder.mNameWeixin.setText(beans.get(position).getDescription());
        viewHolder.mRqiWeixin.setText(beans.get(position).getCtime());
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mOnItemCick.onClick(beans.get(position).getUrl(),
                        beans.get(position).getTitle(),beans.get(position).getPicUrl());
            }
        });


    }

    @Override
    public int getItemCount() {
        return beans.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.img_weixin)
        SimpleDraweeView mImgWeixin;
        @BindView(R.id.tvtitle_weixin)
        TextView mTvtitleWeixin;
        @BindView(R.id.name_weixin)
        TextView mNameWeixin;
        @BindView(R.id.rqi_weixin)
        TextView mRqiWeixin;

        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
    onItemCick  mOnItemCick;

    public void setOnItemCick(onItemCick onItemCick) {
        mOnItemCick = onItemCick;
    }

 public    interface  onItemCick{
        void  onClick(String url,String title,String img);
    }
}
