package com.example.xiangmu.myapplication.activity.zhihu;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

import com.example.xiangmu.myapplication.R;
import com.example.xiangmu.myapplication.adapter.SectionChildApdate;
import com.example.xiangmu.myapplication.base.activity.BaseActivity;
import com.example.xiangmu.myapplication.beans.SectionChildListBean;
import com.example.xiangmu.myapplication.presenter.zhihu.SectionChildListPresenter;
import com.example.xiangmu.myapplication.view.SectionChildListView;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;

import butterknife.BindView;

/**
 * @packge: com.example.xiangmu.myapplication.activity.zhihu
 * @filename:SectionActivity
 * @date :${DATA} 8:42
 */
public class SectionActivity extends BaseActivity<SectionChildListView,SectionChildListPresenter<SectionChildListView>> implements SectionChildListView {
    @BindView(R.id.section_toobar)
    Toolbar mToolbar;
    private String mTitle;
    private int mId;
    @BindView(R.id.chil_rx)
     XRecyclerView mXRecyclerView;
    private SectionChildApdate mSectionChildApdate;
    private ArrayList<SectionChildListBean.StoriesBean> mStoriesBeans;

    @Override
    public void viewCreated(View view) {
        super.viewCreated(view);
        setTooBar(mToolbar,mTitle);
        mStoriesBeans = new ArrayList<>();
        mSectionChildApdate = new SectionChildApdate(mStoriesBeans);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        mXRecyclerView.setLayoutManager(manager);
        mXRecyclerView.setAdapter(mSectionChildApdate);


    }

    @Override
    protected SectionChildListPresenter createPresenter() {
        return new SectionChildListPresenter();
    }
    @Override
    public void getIntgentData() {
        super.getIntgentData();
        Intent intent = getIntent();
        Bundle bun = intent.getBundleExtra("bun");
        mTitle = bun.getString("title");
        mId = bun.getInt("id");

    }

    @Override
    protected void initData() {
         presenter.getSectionChildListBean(mId);
    }

    @Override
    protected int createLayoutId() {
        return R.layout.activity_section;
    }

    @Override
    public void show(SectionChildListBean sectionChildListBean) {
        Log.d("TAG",sectionChildListBean+"");
         mStoriesBeans.addAll(sectionChildListBean.getStories());
         mSectionChildApdate.notifyDataSetChanged();
    }
}
