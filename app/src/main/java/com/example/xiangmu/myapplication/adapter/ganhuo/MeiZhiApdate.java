package com.example.xiangmu.myapplication.adapter.ganhuo;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.request.transition.Transition;
import com.example.xiangmu.myapplication.R;
import com.example.xiangmu.myapplication.activity.ganhuo.FuliActivity;
import com.example.xiangmu.myapplication.activity.ganhuo.GanActivity;
import com.example.xiangmu.myapplication.app.MyApp;
import com.example.xiangmu.myapplication.beans.DailyListBean;
import com.example.xiangmu.myapplication.beans.GanHuoWenZhangBean;
import com.example.xiangmu.myapplication.beans.ganhuo.MeiZhIShuiJiBean;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.internal.Utils;

/**
 * @packge: com.example.xiangmu.myapplication.adapter.ganhuo
 * @filename:MeiZhiApdate
 * @date :${DATA} 12:09
 */
public class MeiZhiApdate extends XRecyclerView.Adapter {

     private  HashMap<Integer,Integer>heightArray=new HashMap<>();
    private static final String TAG = "MeiZhiApdate";
    private final List<GanHuoWenZhangBean.ResultsBean> mStories;
    private final FragmentActivity mFragmentActivity;

    public MeiZhiApdate(ArrayList<GanHuoWenZhangBean.ResultsBean> stories, FragmentActivity activity) {
        mStories = stories;
        mFragmentActivity = activity;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(mFragmentActivity).inflate(R.layout.item_fuli, null);
        MyViewHouder houder = new MyViewHouder(inflate);
        return houder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        final MyViewHouder myViewHouder = (MyViewHouder) holder;
        RequestOptions options = new RequestOptions();
        options.placeholder(R.drawable.ic_launcher_background);
        options.error(R.mipmap.bg_error);
        if (heightArray.get(position) == null){
            Glide.with(mFragmentActivity)
                    .asBitmap()
                    .load(mStories.get(position).getUrl())
                    .into(new SimpleTarget<Bitmap>(Target.SIZE_ORIGINAL, Target.SIZE_ORIGINAL) {

                        @Override
                        public void onResourceReady(@NonNull Bitmap resource, @Nullable Transition<? super Bitmap> transition) {
                            int height = resource.getHeight(); //获取bitmap信息，可赋值给外部变量操作，也可在此时行操作。
                            resource.getWidth();
                           ViewGroup.LayoutParams layoutParams =  myViewHouder.mImageView.getLayoutParams();
                            layoutParams.height = height/3;
                            myViewHouder.mImageView.setLayoutParams(layoutParams);
                            heightArray.put(position,height);
                        }

                    });
        }else {
            int height = heightArray.get(position);
            ViewGroup.LayoutParams layoutParams =myViewHouder.mImageView.getLayoutParams();
            layoutParams.height = height/3;
          myViewHouder.mImageView.setLayoutParams(layoutParams);
        }

        Glide.with(mFragmentActivity)
                .load(mStories.get(position).getUrl())
                .into(myViewHouder.mImageView);

      //  Glide.with(mFragmentActivity).asBitmap().load(myViewHouder.mImageView);
              myViewHouder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mFragmentActivity, FuliActivity.class);
                intent.putExtra("name",mStories.get(position).getUrl());
                mFragmentActivity.startActivity(intent);
            }
        });
    }



    @Override
    public int getItemCount() {
        return mStories.size();
    }
    class  MyViewHouder extends RecyclerView.ViewHolder {
        ImageView mImageView;

        public MyViewHouder(View itemView) {
            super(itemView);
            mImageView=itemView.findViewById(R.id.fu_li_img);
        }
    }

}
