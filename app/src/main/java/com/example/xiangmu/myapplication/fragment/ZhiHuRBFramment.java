package com.example.xiangmu.myapplication.fragment;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.xiangmu.myapplication.R;
import com.example.xiangmu.myapplication.activity.zhihu.CalendarActivity;
import com.example.xiangmu.myapplication.adapter.BefoApdate;
import com.example.xiangmu.myapplication.adapter.ReBaoApdate;
import com.example.xiangmu.myapplication.adapter.ReWenApdate;
import com.example.xiangmu.myapplication.adapter.ZhiHuRBaoFrementApdate;
import com.example.xiangmu.myapplication.base.fragment.BaseFragment;
import com.example.xiangmu.myapplication.beans.DailyBeforeListBean;
import com.example.xiangmu.myapplication.beans.DailyListBean;
import com.example.xiangmu.myapplication.presenter.ZhihuPresenter;
import com.example.xiangmu.myapplication.utils.CircularAnimUtil;
import com.example.xiangmu.myapplication.view.ZhiZuView;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.loader.ImageLoader;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Timer;

import butterknife.BindView;
import butterknife.OnClick;
import butterknife.Optional;

/**
 * @packge: com.example.xiangmu.myapplication.fragment
 * @filename:ZhiHuRBFramment
 * @date :${DATA} 19:43
 */
@SuppressLint("ValidFragment")
public class ZhiHuRBFramment extends BaseFragment<ZhiZuView,ZhihuPresenter<ZhiZuView>> implements ZhiZuView {


    private static final String TAG = "ZhiHuRBFramment";
    private String mName;
    @BindView(R.id.frment_rbao)
    XRecyclerView mXRecyclerView;
    @BindView(R.id.frment_guowangshuju)
    XRecyclerView mXRecyclerView2;
    @BindView(R.id.fab_calender)
    FloatingActionButton cfab;
    /*
    *
    * */

    public ZhiHuRBFramment() {
    }
     @OnClick(R.id.fab_calender)
     public  void startCalender(){
         Intent intent = new Intent();
         intent.setClass(getContext(),CalendarActivity.class);
         CircularAnimUtil.startActivity(mActivity,intent,cfab,R.color.fab_bg);

     }
    @Override
    public ZhihuPresenter<ZhiZuView> ctreatePresrnter() {
        return new ZhihuPresenter<>();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e(TAG, "onCreate: " );
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //initData();


    }

    @Override
    public int getViewLayout() {

            return  R.layout.zhihurbao_layout;

    }

    @Override
    public void initData() {
       /* if (mWindow!=null&&mXRecyclerView!=null) {

            mWindow.showAtLocation(mXRecyclerView, Gravity.CENTER, 0, 0);
        }*/
        Log.e(TAG, "initData: ");
            perstrnter.getDailyListBean();
    }

    @Override
    public void show(DailyListBean dailyListBean) {
        Log.e("============+",dailyListBean+"");
        ReBaoApdate reBaoApdate = new ReBaoApdate(dailyListBean);
        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        if (mXRecyclerView!=null) {
            mXRecyclerView.setLayoutManager(manager);
            mXRecyclerView.setAdapter(reBaoApdate);
        }
    }

    @Override
    public void showBefore(DailyBeforeListBean dataBe) {
         perstrnter.setHideProgressbar();
        mXRecyclerView2.setVisibility(View.VISIBLE);

        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        mXRecyclerView2.setLayoutManager(manager);
        BefoApdate befoApdate = new BefoApdate((ArrayList<DailyBeforeListBean.StoriesBean>) dataBe.getStories(),new Long(dataBe.getDate()));
        mXRecyclerView2.setAdapter(befoApdate);
    }

    @Subscribe(threadMode = ThreadMode.MAIN,sticky = true)
     public  void  getdate(String timer){
        String replace = getSystemTimer();
        Log.e("Date",timer);
        if (!timer.equals(replace)) {
            mXRecyclerView.setVisibility(View.GONE);
            perstrnter.getDailyBeforeListBean(timer);
        }else {
            mXRecyclerView2.setVisibility(View.GONE);
            mXRecyclerView.setVisibility(View.VISIBLE);
        }
    }

    @NonNull
    private String getSystemTimer() {
        long time=System.currentTimeMillis();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date(time);
        String format = sdf.format(date);
        String[] split = format.split(" ");
        String st=split[0];
        String replace = st.replace("-", "");
        st.replace("-", "");
        return replace;
    }

    @Override
    public void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    public void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);

    }
}
