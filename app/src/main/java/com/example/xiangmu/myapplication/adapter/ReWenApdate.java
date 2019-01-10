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
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
/*import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;*/
import com.example.xiangmu.myapplication.R;
import com.example.xiangmu.myapplication.activity.zhihu.CalendarActivity;
import com.example.xiangmu.myapplication.base.activity.zhihu.ZhiHuDataActivity;
import com.example.xiangmu.myapplication.beans.DailyListBean;
import com.example.xiangmu.myapplication.utils.ImgUtis;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.List;
import java.util.logging.Logger;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @packge: com.example.xiangmu.myapplication.adapter
 * @filename:ReWenApdate
 * @date :${DATA} 10:50
 */
public class ReWenApdate extends XRecyclerView.Adapter {

    private final List<DailyListBean.StoriesBean> stories;
    private Context mContext;

    public ReWenApdate(List<DailyListBean.StoriesBean> stories) {
          this.stories=stories;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        mContext = parent.getContext();
        View inflate = LayoutInflater.from(mContext).inflate(R.layout.item_rewen, null);
        ViewHolder holder = new ViewHolder(inflate);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        ViewHolder holder1 = (ViewHolder) holder;
        Log.e("tag",holder1.mImgImgrewen+""+holder1.mTvImgrewen+""+stories.get(position).getImages().get(0));

        ImgUtis.setimg(stories.get(position).getImages().get(0),mContext,holder1.mImgImgrewen);
        holder1.mTvImgrewen.setText(stories.get(position).getTitle());
        holder1.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext,ZhiHuDataActivity.class);
                intent.putExtra("id",stories.get(position).getId());
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return stories.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        ImageView mImgImgrewen;

        TextView mTvImgrewen;

        ViewHolder(View view) {
            super(view);
            mImgImgrewen=view.findViewById(R.id.img_imgrewen);
            mTvImgrewen=view.findViewById(R.id.tv_imgrewen);
        }
    }
}
