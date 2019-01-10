package com.example.xiangmu.myapplication.fragment.man;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.xiangmu.myapplication.R;
import com.example.xiangmu.myapplication.adapter.ZhiHuRBaoFrementApdate;
import com.example.xiangmu.myapplication.base.fragment.BaseFragment;
import com.example.xiangmu.myapplication.base.fragment.SimpeFragment;
import com.example.xiangmu.myapplication.base.prensenter.BaserPresrnter;
import com.example.xiangmu.myapplication.fragment.ganhuo.AndroidFragment;
import com.example.xiangmu.myapplication.fragment.ganhuo.FulIFragment;
import com.example.xiangmu.myapplication.fragment.ganhuo.HJCFragment;
import com.example.xiangmu.myapplication.fragment.ganhuo.IOSFragement;

import java.util.ArrayList;

import butterknife.BindView;

/**
 * @packge: com.example.xiangmu.myapplication.fragment.man
 * @filename:GanHoFrement
 * @date :${DATA} 11:11
 */
public class GanHoFrement extends SimpeFragment {
    @BindView(R.id.tab_ganhuo)
    TabLayout mTabGanhuo;
    @BindView(R.id.vp_ganhuo)
    ViewPager mViewPager;
    private ArrayList<Fragment> mFragments;

    @Override
    public BaserPresrnter ctreatePresrnter() {
        return null;
    }

    @Override
    public void initFrementApdate() {
        super.initFrementApdate();
        ArrayList<String> strings = new ArrayList<>();
        strings.add("ANDROID");
        strings.add("IOS");
        strings.add("前端");
        strings.add("福利");
        mFragments = new ArrayList<>();
        mFragments.add(new AndroidFragment());
        mFragments.add(new IOSFragement());
        mFragments.add(new HJCFragment());
        mFragments.add(new FulIFragment());
        ZhiHuRBaoFrementApdate zhiHuRBaoFrementApdate = new ZhiHuRBaoFrementApdate(getFragmentManager(), strings, mFragments);
         mViewPager.setAdapter(zhiHuRBaoFrementApdate);
         mTabGanhuo.setupWithViewPager(mViewPager);
    }

    @Override
    public int getViewLayout() {
        return R.layout.frment_ganhuo;
    }

    @Override
    public void initData() {

    }
  public void  setQuery(final String query){

      int currentItem = mViewPager.getCurrentItem();
      if (mFragments.get(currentItem)instanceof AndroidFragment){
          AndroidFragment androidFragment= (AndroidFragment) mFragments.get(currentItem);
          androidFragment.setQuery(query);
      }else if (mFragments.get(currentItem)instanceof IOSFragement){
          IOSFragement androidFragment= (IOSFragement) mFragments.get(currentItem);
          androidFragment.setQuery(query);

      }else if (mFragments.get(currentItem)instanceof HJCFragment){
          HJCFragment androidFragment= (HJCFragment) mFragments.get(currentItem);
          androidFragment.setQuery(query);

      }

  }



}
