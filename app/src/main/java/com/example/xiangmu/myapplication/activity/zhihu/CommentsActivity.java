package com.example.xiangmu.myapplication.activity.zhihu;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;


import com.example.xiangmu.myapplication.R;
import com.example.xiangmu.myapplication.base.activity.BaseActivity;
import com.example.xiangmu.myapplication.base.prensenter.BaserPresrnter;
import com.example.xiangmu.myapplication.fragment.zhihupinglun.LongFragment;
import com.example.xiangmu.myapplication.fragment.zhihupinglun.StortFragment;

import java.util.ArrayList;

import butterknife.BindView;

public class CommentsActivity extends BaseActivity{

@BindView(R.id.toobar_comments)
Toolbar mToolbar;
    private int mId;
    private int mP;
    @BindView(R.id.tab_layout)
    TabLayout tab_layout;
    @BindView(R.id.Comments_vp)
    ViewPager mViewPager;
    private int[] mCs;


    @Override
    public void viewCreated(View view) {
        super.viewCreated(view);
        getIntgentData();
        setTooBar(mToolbar,mP+"条评论");
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new StortFragment(mId));
        fragments.add(new LongFragment(mId));
        ArrayList<String> strings = new ArrayList<>();

            Log.e("TAG",mCs+"");

        strings.add("短评论"+"（"+mCs[0]+"）");
        strings.add("长评论"+"（"+mCs[1]+"）");
        CommentsApdateVp commentsApdate = new CommentsApdateVp(getSupportFragmentManager(), fragments, strings);
        mViewPager.setAdapter(commentsApdate);
        tab_layout.setupWithViewPager(mViewPager);



    }

    @Override
    public void getIntgentData() {
        super.getIntgentData();
        Intent intent = getIntent();
        mId = intent.getIntExtra("id", 0);
        mP = intent.getIntExtra("P", 0);
        mCs = intent.getIntArrayExtra("c");
    }

    @Override
    protected void initData() {

    }

    @Override
    protected int createLayoutId() {
        return R.layout.activity_comments;
    }

    @Override
    protected BaserPresrnter createPresenter() {
        return null;
    }
}
