package com.example.xiangmu.myapplication.adapter.v2ex;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.xiangmu.myapplication.R;
import com.example.xiangmu.myapplication.activity.SJXqActivity;
import com.example.xiangmu.myapplication.app.MyApp;
import com.example.xiangmu.myapplication.beans.ShuJuZhiHuiBean;
import com.example.xiangmu.myapplication.greendao.ScBean;
import com.example.xiangmu.myapplication.utils.ImgUtis;
import com.facebook.drawee.view.SimpleDraweeView;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @packge: com.example.xiangmu.myapplication.adapter.v2ex
 * @filename:ApdateV2EX
 * @date :${DATA} 10:24
 */
public class ApdateV2EX extends XRecyclerView.Adapter {

    private final ArrayList<ShuJuZhiHuiBean.RESULTBean.NewsListBean> mResultBeans;
    private final FragmentActivity mActivity;

    public ApdateV2EX(ArrayList<ShuJuZhiHuiBean.RESULTBean.NewsListBean> listbean, FragmentActivity activity) {
        mResultBeans = listbean;
        mActivity = activity;

    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(mActivity).inflate(R.layout.vex_item, null);

        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        ViewHolder viewHolder= (ViewHolder)holder;
        ImgUtis.setFace(mResultBeans.get(position).getNewsImg(),viewHolder.mImgSj,mActivity);
        viewHolder.mTvSjTitle.setText(mResultBeans.get(position).getTitle());
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mActivity, SJXqActivity.class);
                intent.putExtra("name",mResultBeans.get(position).getNewsId());
                intent.putExtra("img",mResultBeans.get(position).getNewsImg());
                mActivity.startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return mResultBeans.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.img_sj)
        SimpleDraweeView mImgSj;
        @BindView(R.id.tv_sj_title)
        TextView mTvSjTitle;


        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

}
