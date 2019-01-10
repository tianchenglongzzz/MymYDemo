package com.example.xiangmu.myapplication.adapter.vp;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;

import com.example.xiangmu.myapplication.base.activity.zhihu.ZhiHuDataActivity;
import com.example.xiangmu.myapplication.beans.DailyListBean;

import java.util.ArrayList;
import java.util.List;

/**
 * @packge: com.example.xiangmu.myapplication.adapter.vp
 * @filename:BannnerApdate
 * @date :${DATA} 8:59
 */
public class BannnerApdate extends PagerAdapter {


    private  List<DailyListBean.TopStoriesBean> to_stirues;
    private  ArrayList<View> views;

    public BannnerApdate(ArrayList<View> views, List<DailyListBean.TopStoriesBean> top_stories) {
           this.to_stirues=top_stories;
          this.views=views;
    }

    @Override
    public int getCount() {
        return views.size();
    }

    /**
     * 判断是否使用缓存, 如果返回的是true, 使用缓存. 不去调用instantiateItem方法创建一个新的对象
     */
    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view==object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull final ViewGroup container, final int position) {
        View view = views.get(position);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(container.getContext(), ZhiHuDataActivity.class);
                intent.putExtra("id",to_stirues.get(position).getId());
                container.getContext().startActivity(intent);
            }
        });
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView(views.get(position));
    }
}
