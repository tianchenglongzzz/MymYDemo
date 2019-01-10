package com.example.xiangmu.myapplication.fragment;


import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import com.example.xiangmu.myapplication.R;
import com.example.xiangmu.myapplication.adapter.ZhiHuRBaoFrementApdate;
import com.example.xiangmu.myapplication.base.fragment.BaseFragment;
import com.example.xiangmu.myapplication.base.fragment.SimpeFragment;
import com.example.xiangmu.myapplication.presenter.ZhihuPresenter;
import com.example.xiangmu.myapplication.view.ZhiZuView;

import java.util.ArrayList;

import butterknife.BindView;

/**
 * A simple {@link Fragment} subclass.
 */
public class ZhiHuFragment extends SimpeFragment {

  @BindView(R.id.tab_zhihurbao)
    TabLayout mTabLayout;
  @BindView(R.id.vp_zhihurbao)
    ViewPager mViewPager;
  private static ArrayList<Fragment> mFragments;
  private static ArrayList<String> mStrings;

  public ZhiHuFragment() {
        // Required empty public constructor
    }



  @Override
  public void initFrementApdate() {
    super.initFrementApdate();
    //初始化一个集合
    mStrings = new ArrayList<>();
    mStrings.add("日报");
    mStrings.add("主题");
    mStrings.add("专栏");
    mStrings.add("热门");
    mFragments = new ArrayList<>();
    mFragments.add(new ZhiHuRBFramment());
    mFragments.add(new ThemeFragment());
    mFragments.add(new SectionFragment());
    mFragments.add(new HotFragment());
    ZhiHuRBaoFrementApdate zhiHuRBaoFrementApdate = new ZhiHuRBaoFrementApdate(getFragmentManager(), mStrings, mFragments);
    mViewPager.setAdapter(zhiHuRBaoFrementApdate);
    mTabLayout.setupWithViewPager(mViewPager);
  }


    @Override
    public int getViewLayout() {
        return R.layout.fragment_zhi_hu;
    }

    @Override
    public void initData() {

    }

    @Override
    public ZhihuPresenter<ZhiZuView> ctreatePresrnter() {
        return new ZhihuPresenter();
    }

}
