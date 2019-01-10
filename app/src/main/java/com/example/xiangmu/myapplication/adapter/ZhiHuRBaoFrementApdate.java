package com.example.xiangmu.myapplication.adapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.xiangmu.myapplication.fragment.ZhiHuRBFramment;

import java.util.ArrayList;

/**
 * @packge: com.example.xiangmu.myapplication.adapter
 * @filename:ZhiHuFrementApdate
 * @date :${DATA} 19:37
 */
public class ZhiHuRBaoFrementApdate  extends FragmentStatePagerAdapter {
    private final ArrayList<String> item;
    private final ArrayList<Fragment> zhiHuRBFramments;

    public ZhiHuRBaoFrementApdate(FragmentManager fm, ArrayList<String> strings, ArrayList<Fragment> zhiHuRBFramments) {
        super(fm);
        this.item=strings;
        this.zhiHuRBFramments=zhiHuRBFramments;
    }

    @Override
    public Fragment getItem(int position) {
        return zhiHuRBFramments.get(position);
    }

    @Override
    public int getCount() {
        return zhiHuRBFramments.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return item.get(position);
    }
}
