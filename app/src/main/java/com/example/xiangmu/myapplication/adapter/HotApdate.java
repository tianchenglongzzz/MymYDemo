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
import com.example.xiangmu.myapplication.beans.HotListBean;
import com.example.xiangmu.myapplication.beans.SectionListBean;
import com.example.xiangmu.myapplication.utils.ImgUtis;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @packge: com.example.xiangmu.myapplication.adapter
 * @filename:SectionListApdate
 * @date :${DATA} 16:57
 */
public class HotApdate extends XRecyclerView.Adapter {


    private final List<HotListBean.RecentBean> data;
    private Context mContext;

    public HotApdate(List<HotListBean.RecentBean> data) {
        this.data = data;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        mContext = parent.getContext();
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_hot, null);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        ViewHolder holder1 = (ViewHolder) holder;
        ImgUtis.setimg(data.get(position).getThumbnail(),mContext,holder1.mHotImg);
        holder1.mTvHot.setText(data.get(position).getTitle());
        holder1.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext,ZhiHuDataActivity.class);
                intent.putExtra("id",data.get(position).getNews_id());
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }






    class ViewHolder extends ReWenApdate.ViewHolder {
        @BindView(R.id.hot_img)
        ImageView mHotImg;
        @BindView(R.id.tv_hot)
        TextView mTvHot;

        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
