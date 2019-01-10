package com.example.xiangmu.myapplication.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.view.menu.MenuView;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.xiangmu.myapplication.R;
import com.example.xiangmu.myapplication.activity.zhihu.SectionActivity;
import com.example.xiangmu.myapplication.adapter.SectionListApdate;
import com.example.xiangmu.myapplication.base.fragment.BaseFragment;
import com.example.xiangmu.myapplication.base.prensenter.BaserPresrnter;
import com.example.xiangmu.myapplication.beans.SectionListBean;
import com.example.xiangmu.myapplication.presenter.zhihu.SectionPresenter;
import com.example.xiangmu.myapplication.utils.CircularAnimUtil;
import com.example.xiangmu.myapplication.view.ZhiZuViewTow;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.logging.Logger;

import butterknife.BindView;

/**
 * A simple {@link Fragment} subclass.
 */
public class SectionFragment extends BaseFragment<ZhiZuViewTow,SectionPresenter<ZhiZuViewTow>>implements ZhiZuViewTow  {

  @BindView(R.id.section_rx)
    XRecyclerView mXRecyclerView;
    private static SectionListApdate mApdate;
    private ArrayList<SectionListBean.DataBean> mDataBeans;

    public SectionFragment() {
        // Required empty public constructor
    }


    @Override
    public SectionPresenter ctreatePresrnter() {
        return new SectionPresenter();
    }

    @Override
    public int getViewLayout() {
        return R.layout.fragment_section;
    }

    @Override
    public void initData() {
        if (perstrnter!=null&&mXRecyclerView!=null){
        mDataBeans = new ArrayList<>();
        mApdate=new SectionListApdate(mDataBeans);
        GridLayoutManager manager = new GridLayoutManager(getContext(),2);
        mXRecyclerView.setLayoutManager(manager);
        mXRecyclerView.setAdapter(mApdate);




            perstrnter.getSectionListBean();
        }
       setItemClick();
    }


    public void setItemClick() {

        Log.d("TAG","===============>");
        mApdate.setSItemClick(new SectionListApdate.SItemClick() {
            @Override
            public void setclick(int id, String title) {
                Intent intent = new Intent(getContext(), SectionActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("title",title);
                bundle.putInt("id",id);
                intent.putExtra("bun",bundle);
                startActivity(intent);

            }
        });
    }

    @Override
    public void show(SectionListBean sectionListBean) {

        mDataBeans.addAll(sectionListBean.getData());
        mApdate.notifyDataSetChanged();



    }


   /* @Override
    public void setclick(int id, String title) {
        Intent intent = new Intent(getContext(), SectionActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("title",title);
        bundle.putInt("id",id);
        intent.putExtra("bun",bundle);
        startActivity(intent);
    }*/
}
