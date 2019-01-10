package com.example.xiangmu.myapplication.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.xiangmu.myapplication.R;
import com.example.xiangmu.myapplication.base.activity.SimpleActivity;
import com.example.xiangmu.myapplication.base.fragment.BaseFragment;
import com.example.xiangmu.myapplication.base.fragment.SimpeFragment;
import com.example.xiangmu.myapplication.base.prensenter.BaserPresrnter;
import com.example.xiangmu.myapplication.view.ZhiZuView;

/**
 * A simple {@link Fragment} subclass.
 */
public class ThemeFragment extends SimpeFragment {


    private static final String TAG = "ThemeFragment";

    public ThemeFragment() {
        // Required empty public constructor
    }


 

    @Override
    public int getViewLayout() {
        return R.layout.fragment_theme;
    }

    @Override
    public void initData() {

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e(TAG, "onCreate: ");
    }

    @Override
    public BaserPresrnter<ZhiZuView> ctreatePresrnter() {
        return null;
    }


}
