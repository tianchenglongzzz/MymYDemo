package com.example.xiangmu.myapplication.activity.v2ex;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.xiangmu.myapplication.R;
import com.example.xiangmu.myapplication.base.activity.SimpleActivity;

import butterknife.BindView;

public class RepliesActivity extends SimpleActivity {

     @BindView(R.id.xiangqing_toobar)
    Toolbar mToolbar;
    @Override
    public void viewCreated(View view) {
        super.viewCreated(view);
        setTooBar(mToolbar,"节点导航");


    }

    @Override
    protected void initData() {

    }

    @Override
    protected int createLayoutId() {
        return R.layout.activity_replies;
    }
}
