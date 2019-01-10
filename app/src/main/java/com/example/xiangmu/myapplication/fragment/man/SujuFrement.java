package com.example.xiangmu.myapplication.fragment.man;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.webkit.WebView;
import android.widget.ImageView;

import com.example.xiangmu.myapplication.R;
import com.example.xiangmu.myapplication.activity.sj.XuanZheActivity;
import com.example.xiangmu.myapplication.adapter.ZhiHuRBaoFrementApdate;
import com.example.xiangmu.myapplication.app.MyApp;
import com.example.xiangmu.myapplication.base.fragment.BaseFragment;
import com.example.xiangmu.myapplication.base.fragment.SimpeFragment;
import com.example.xiangmu.myapplication.base.prensenter.BaserPresrnter;
import com.example.xiangmu.myapplication.fragment.v2ex.FragmentV2ex;
import com.example.xiangmu.myapplication.fragment.zh.Fragmentzh;

import com.example.xiangmu.myapplication.greendao.dataBean;
import com.example.xiangmu.myapplication.utils.IndicatorLineUtil;
import com.example.xiangmu.myapplication.utils.WeiBeView;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * @packge: com.example.xiangmu.myapplication.fragment.man
 * @filename:SujuFrement
 * @date :${DATA} 11:11
 */
public class SujuFrement extends SimpeFragment {

     private  boolean F=true;
    private ArrayList<String> mStrings;
    private ArrayList<Fragment> mFragments;
    private ZhiHuRBaoFrementApdate mZhiHuRBaoFrementApdate;
    private SharedPreferences.Editor mEdit;
    private FragmentManager mFragmentManager;


    @Override
    public BaserPresrnter ctreatePresrnter() {
        return null;
    }
    @BindView(R.id.tab_zh)
    TabLayout mTabLayout;
    @BindView(R.id.vp_zh)
    ViewPager mViewPager;
    @BindView(R.id.img_zh)
    ImageView img;



    public static String[] typeStr = {"要闻", "财经", "娱乐", "体育", "房产","科技","数码","时尚","星座","游戏","文化","社会","教育"};
    @Override
    public void initFrementApdate() {
        super.initFrementApdate();
    }
    @Override
    public void onStart() {
        super.onStart();

        SharedPreferences name = getActivity().getSharedPreferences("name", Context.MODE_PRIVATE);
        boolean name1 = name.getBoolean("mpp", true);
    mFragmentManager=null;
        mFragmentManager = getFragmentManager();
        if (name1) {
           // Log.d("tag","================");
            mFragments = new ArrayList<>();
            mStrings = new ArrayList<>();
            MyApp.getSession().getDataBeanDao().deleteAll();
            mEdit = name.edit();
            mEdit.putBoolean("mpp",false);
            mEdit.commit();
            for (int i = 0; i <typeStr.length ; i++) {
                mStrings.add(typeStr[i]);
                addFrement(typeStr[i]);
                MyApp.getSession().getDataBeanDao().insert(new dataBean(null,typeStr[i],true));
            }
            setFrementApdater();

        }else {
            mStrings=new ArrayList<>();
            mFragments=new ArrayList<>();
            if (MyApp.getSession()!=null) {
                List<dataBean> dataBeans = MyApp.getSession().getDataBeanDao().loadAll();
                Log.d("tag", "================");
                for (int i = 0; i < dataBeans.size(); i++)
                    if (dataBeans.get(i).getState() != false) {
                        mStrings.add(dataBeans.get(i).getTitle());
                        addFrement(typeStr[i]);
                    }
                setFrementApdater();

            }
        }

    }

    private void addFrement(String value) {
        Fragmentzh fragmentzh = new Fragmentzh();
        Bundle bundle = new Bundle();
        bundle.putString("name", value);
        fragmentzh.setArguments(bundle);
        mFragments.add(fragmentzh);
    }

    private void setFrementApdater() {


                mZhiHuRBaoFrementApdate = new ZhiHuRBaoFrementApdate(getChildFragmentManager(), mStrings, mFragments);
                mViewPager.setAdapter(mZhiHuRBaoFrementApdate);
                mTabLayout.setupWithViewPager(mViewPager);




    }

    @OnClick(R.id.img_zh)
    public void getClick(){
        startActivity(new Intent(getContext(),XuanZheActivity.class));
    }
    @Override
    public int getViewLayout() {
        return R.layout.fragment_shuju;
    }

    @Override
    public void initData() {

    }

    @Override

    public void onDetach() {

        super.onDetach();

        try {

            Field childFragmentManager = Fragment.class.getDeclaredField("mChildFragmentManager");

            childFragmentManager.setAccessible(true);

            childFragmentManager.set(this, null);

        } catch (NoSuchFieldException e) {

            throw new RuntimeException(e);

        } catch (IllegalAccessException e) {

            throw new RuntimeException(e);

        }

    }




}
