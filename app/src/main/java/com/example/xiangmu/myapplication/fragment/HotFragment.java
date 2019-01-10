package com.example.xiangmu.myapplication.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.xiangmu.myapplication.R;
import com.example.xiangmu.myapplication.adapter.HotApdate;
import com.example.xiangmu.myapplication.base.fragment.BaseFragment;
import com.example.xiangmu.myapplication.base.prensenter.BaserPresrnter;
import com.example.xiangmu.myapplication.beans.HotListBean;
import com.example.xiangmu.myapplication.presenter.zhihu.HotPresenter;
import com.example.xiangmu.myapplication.view.HotView;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import butterknife.BindView;

/**
 * A simple {@link Fragment} subclass.
 */
public class HotFragment extends BaseFragment<HotView,HotPresenter<HotView>> implements HotView {
    @BindView(R.id.hot_xre)
    XRecyclerView mXRecyclerView;

    public HotFragment() {
        // Required empty public constructor
    }


    @Override
    public int getViewLayout() {
        return R.layout.fragment_hot;
    }

    @Override
    public void initData() {

      if (perstrnter!=null) {
          perstrnter.getHotlist();
      }

    }

    @Override
    public HotPresenter ctreatePresrnter() {
        return new HotPresenter();
    }

    @Override
    public void show(HotListBean hotListBean) {

        HotApdate apdate = new HotApdate(hotListBean.getRecent());
        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        if (mXRecyclerView!=null) {
            mXRecyclerView.setLayoutManager(manager);
            mXRecyclerView.setAdapter(apdate);
        }

    }

   }
