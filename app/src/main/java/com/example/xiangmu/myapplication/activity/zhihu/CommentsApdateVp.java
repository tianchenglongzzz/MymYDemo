package com.example.xiangmu.myapplication.activity.zhihu;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.xiangmu.myapplication.adapter.CommentsApdate;

import java.util.ArrayList;

/**
 * @packge: com.example.xiangmu.myapplication.activity.zhihu
 * @filename:CommentsApdateVp
 * @date :${DATA} 10:06
 */
class CommentsApdateVp extends FragmentStatePagerAdapter {
    private final ArrayList<String> item;
    private  ArrayList<Fragment> fragement;

    public CommentsApdateVp(FragmentManager supportFragmentManager, ArrayList<Fragment> fragments, ArrayList<String> strings) {
        super(supportFragmentManager);
        this.fragement=fragments;
        this.item=strings;
    }

    @Override
    public Fragment getItem(int position) {
        return fragement.get(position);
    }

    @Override
    public int getCount() {
        return fragement.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return item.get(position);
    }
}
