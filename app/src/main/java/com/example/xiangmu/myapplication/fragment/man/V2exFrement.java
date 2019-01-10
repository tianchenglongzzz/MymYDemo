package com.example.xiangmu.myapplication.fragment.man;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.widget.ImageView;

import com.example.xiangmu.myapplication.R;
import com.example.xiangmu.myapplication.adapter.ZhiHuRBaoFrementApdate;
import com.example.xiangmu.myapplication.base.fragment.BaseFragment;
import com.example.xiangmu.myapplication.base.prensenter.BaserPresrnter;
import com.example.xiangmu.myapplication.fragment.v2ex.FragmentV2ex;
import com.example.xiangmu.myapplication.utils.IndicatorLineUtil;

import java.util.ArrayList;

import butterknife.BindView;

/**
 * @packge: com.example.xiangmu.myapplication.fragment.man
 * @filename:V2exFrement
 * @date :${DATA} 11:11
 */
public class V2exFrement extends BaseFragment {
   @BindView(R.id.tab_v2ex)
    TabLayout mTabLayout;
   @BindView(R.id.vp_v2ex)
    ViewPager mViewPager;
   @BindView(R.id.img_v2ex)
    ImageView mImageView;
    public static String[] typeStr = {"技术", "创意", "好玩", "Apple", "酷工作", "交易", "城市", "问与答", "最热", "全部", "R2"};
    public static String[] type = {"tech", "creative", "play", "apple", "jobs", "deals", "city", "qna", "hot", "all", "r2"};


    @Override
    public void initFrementApdate() {
        super.initFrementApdate();
        ArrayList<Fragment> fragments = new ArrayList<>();
        ArrayList<String> strings = new ArrayList<>();
        for (int i = 0; i <type.length ; i++) {
            FragmentV2ex fragmentV2ex = new FragmentV2ex();
            Bundle bundle = new Bundle();
            bundle.putString("name",type[i]);
            fragmentV2ex.setArguments(bundle);

            fragments.add(fragmentV2ex);
            strings.add(typeStr[i]);
        }
        mTabLayout.post(new Runnable() {
            @Override
            public void run() {
                IndicatorLineUtil.setIndicator(mTabLayout,10,10);
            }
        });
        ZhiHuRBaoFrementApdate zhiHuRBaoFrementApdate = new ZhiHuRBaoFrementApdate(getFragmentManager(), strings, fragments);
        mViewPager.setAdapter(zhiHuRBaoFrementApdate);
        mTabLayout.setupWithViewPager(mViewPager);


    }

    @Override
    public BaserPresrnter ctreatePresrnter() {

         return null;
    }

    @Override
    public int getViewLayout() {
        return R.layout.fragment_vex;
    }

    @Override
    public void initData() {

    }

    @Override
    public void showError(String err) {

    }
}
