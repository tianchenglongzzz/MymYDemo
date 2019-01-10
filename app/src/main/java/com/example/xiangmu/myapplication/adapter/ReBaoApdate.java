package com.example.xiangmu.myapplication.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.xiangmu.myapplication.R;
import com.example.xiangmu.myapplication.activity.StartActivity;
import com.example.xiangmu.myapplication.adapter.vp.BannnerApdate;
import com.example.xiangmu.myapplication.app.MyApp;
import com.example.xiangmu.myapplication.base.activity.zhihu.ZhiHuDataActivity;
import com.example.xiangmu.myapplication.beans.DailyListBean;

import com.example.xiangmu.myapplication.utils.ImgUtis;
import com.facebook.drawee.view.SimpleDraweeView;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.listener.OnBannerListener;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.L;

/**
 * @packge: com.example.xiangmu.myapplication.adapter
 * @filename:ReBaoApdate
 * @date :${DATA} 15:21
 */
public class ReBaoApdate extends XRecyclerView.Adapter {
    int i = 0;
    boolean b;
    private final List<DailyListBean.StoriesBean> mStories;
    private Context mContext;
    private final List<DailyListBean.TopStoriesBean> mTop_stories;
    private int mPagerCurrentItem;

    public ReBaoApdate(DailyListBean dailyListBean) {
        mStories = dailyListBean.getStories();
        mTop_stories = dailyListBean.getTop_stories();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        mContext = parent.getContext();
        if (viewType == -1) {
            View view = LayoutInflater.from(mContext).inflate(R.layout.item_top, null);
            ViewHolderTop holderTop = new ViewHolderTop(view);
            return holderTop;
        } else if (viewType == 0) {
            View view = LayoutInflater.from(mContext).inflate(R.layout.item_bottom, null);
            ViewHolderBootom viewHolder = new ViewHolderBootom(view);
            return  viewHolder;
        } else {
            View view = LayoutInflater.from(mContext).inflate(R.layout.item_chent, null);
            ViewHolderChent viewHolderChent = new ViewHolderChent(view);
            return viewHolderChent;
        }

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        int viewType = getItemViewType(position);
        if (viewType == -1) {
            final ViewHolderTop viewHolderTop= (ViewHolderTop) holder;
            ArrayList<View> views = new ArrayList<>();

            for (int i = 0; i <mTop_stories.size(); i++) {

                View inflate = LayoutInflater.from(mContext).inflate(R.layout.v_p, null);
                SimpleDraweeView imageView=inflate.findViewById(R.id.vp_img);
                ImgUtis.setFace(mTop_stories.get(i).getImage(),imageView,mContext);
              TextView textView = inflate.findViewById(R.id.vp_tv);
              if (mStories.get(i).getTitle()!=null) {
                  textView.setText(mStories.get(i).getTitle());
              }
                views.add(inflate);
            }
            BannnerApdate bannnerApdate = new BannnerApdate(views,mTop_stories);
            viewHolderTop.mViewPager.setAdapter(bannnerApdate);
            setBanner(viewHolderTop);


        } else if (viewType == 0) {
            ViewHolderBootom viewHolderBootom= (ViewHolderBootom) holder;
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(mContext);
            ReWenApdate reWenApdate = new ReWenApdate(mStories);
            viewHolderBootom.mXrRewen.setLayoutManager(linearLayoutManager);
            viewHolderBootom.mXrRewen.setAdapter(reWenApdate);

        } else {

            ViewHolderChent chent=(ViewHolderChent)holder;
        }
    }

    private void setBanner(final ViewHolderTop viewHolderTop) {
        new Thread(new Runnable() {



            @Override
            public void run() {

                while (true) {
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if (!b) {
                        i++;
                        if (i == mStories.size() - 1) {
                            b = true;
                            viewHolderTop.mViewPager.post(new Runnable() {
                                @Override
                                public void run() {
                                    viewHolderTop.mViewPager.setCurrentItem(i);
                                }
                            });
                        }
                    } else {
                        i--;
                        if (i == 0) {
                            b = false;
                            viewHolderTop.mViewPager.post(new Runnable() {
                                @Override
                                public void run() {
                                    viewHolderTop.mViewPager.setCurrentItem(i);

                                }
                            });
                        }
                    }
                    viewHolderTop.mViewPager.post(new Runnable() {
                        @Override
                        public void run() {
                            viewHolderTop.mViewPager.setCurrentItem(i);
                            viewHolderTop.mViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {



                                @Override
                                public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {


                                }
                                @Override
                                public void onPageSelected(int position) {
                                    i = position;
                                }
                                @Override
                                public void onPageScrollStateChanged(int state) {
                                       if (state==1){
                                           mPagerCurrentItem = viewHolderTop.mViewPager.getCurrentItem();
                                       }
                                }
                            });
                        }
                    });


                }

            }
        }).start();
    }

    @Override
    public int getItemCount() {
        return 3;
    }

    @Override
    public int getItemViewType(int position) {
        if (position -1 == -1) {
            return -1;
        } else if (position -1==1 ) {
            return 0;

        } else {
            return 1;
        }

    }

    class ViewHolderTop extends ReWenApdate.ViewHolder {

        ViewPager mViewPager;

        ViewHolderTop(View view) {
            super(view);
            mViewPager=view.findViewById(R.id.re_vp);
        }
    }

    class ViewHolderChent extends ReWenApdate.ViewHolder {

        ViewHolderChent(View view) {
            super(view);

        }
    }

    static class ViewHolderBootom extends ReWenApdate.ViewHolder {

        XRecyclerView mXrRewen;

        ViewHolderBootom(View view) {
            super(view);
           mXrRewen=view.findViewById(R.id.xr_rewen);
        }
    }
}
