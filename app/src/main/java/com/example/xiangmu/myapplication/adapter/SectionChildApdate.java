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
import com.example.xiangmu.myapplication.beans.SectionChildListBean;
import com.example.xiangmu.myapplication.utils.ImgUtis;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @packge: com.example.xiangmu.myapplication.adapter
 * @filename:SectionChildApdate
 * @date :${DATA} 16:51
 */
public class SectionChildApdate extends XRecyclerView.Adapter {
    private final ArrayList<SectionChildListBean.StoriesBean> storiesBeans;
    private Context mContext;

    public SectionChildApdate(ArrayList<SectionChildListBean.StoriesBean> storiesBeans) {
        this.storiesBeans = storiesBeans;

    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        mContext = parent.getContext();
        View view = LayoutInflater.from(mContext).inflate(R.layout.iem_sectionchild, null);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        ViewHolder holder1 = (ViewHolder) holder;
        ImgUtis.setimg(storiesBeans.get(position).getImages().get(0),mContext,holder1.mChilImg);
        holder1.mChilTv.setText(storiesBeans.get(position).getTitle());
        holder1.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext,ZhiHuDataActivity.class);
                intent.putExtra("id",storiesBeans.get(position).getId());
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return storiesBeans.size();
    }



    class ViewHolder  extends ReWenApdate.ViewHolder {
        @BindView(R.id.chil_img)
        ImageView mChilImg;
        @BindView(R.id.chil_tv)
        TextView mChilTv;

        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
