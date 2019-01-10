package com.example.xiangmu.myapplication.adapter.v2ex;

import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.xiangmu.myapplication.R;
import com.example.xiangmu.myapplication.beans.TopicListBean;
import com.example.xiangmu.myapplication.utils.ImgUtis;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @packge: com.example.xiangmu.myapplication.adapter.v2ex
 * @filename:TocApdate
 * @date :${DATA} 12:28
 */
public class TocApdate extends XRecyclerView.Adapter {

    private static final String TAG ="TocApdate" ;
    private final ArrayList<TopicListBean> mTocBean;
    private final FragmentActivity mActivity;

    public TocApdate(ArrayList<TopicListBean> tocBean, FragmentActivity activity) {
        mTocBean = tocBean;
        mActivity = activity;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mActivity).inflate(R.layout.item_vex, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
                    ViewHolder viewHolder= (ViewHolder) holder;
        ImgUtis.setimg(mTocBean.get(position).getImgUrl(),mActivity,viewHolder.mV2exImg);
        viewHolder.mVName.setText(mTocBean.get(position).getName());
        viewHolder.mVTime.setText(mTocBean.get(position).getUpdateTime());
        viewHolder.mVXiaoxi.setText(mTocBean.get(position).getCommentNum()+"");
        viewHolder.mVNei.setText(mTocBean.get(position).getTitle());

    }

    @Override
    public int getItemCount() {
        return mTocBean.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.v2ex_img)
        ImageView mV2exImg;
        @BindView(R.id.v_name)
        TextView mVName;
        @BindView(R.id.v_time)
        TextView mVTime;
        @BindView(R.id.v_type)
        TextView mVType;
        @BindView(R.id.v_xiaoxi)
        TextView mVXiaoxi;
        @BindView(R.id.v_nei)
        TextView mVNei;

        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
