package com.example.xiangmu.myapplication.base.activity;

import android.app.Activity;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.xiangmu.myapplication.utils.Windowuyilrs;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * @packge: com.example.xiangmu.myapplication.base.activity
 * @filename:SimpleActivity
 * @date :${DATA} 16:37
 */
public abstract class SimpleActivity extends AppCompatActivity {
    public Activity mActivity;
    private Unbinder binds;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ViewGroup view = (ViewGroup) LayoutInflater.from(this).inflate(createLayoutId(), null);
        setContentView(view);
        binds=ButterKnife.bind(this);
        getIntgentData();
        viewCreated(view);
        initData();

        mActivity=this;
    }

    public void viewCreated(View view) {


    }


    public  void setTooBar(Toolbar toobar,String string){
          toobar.setTitle(string);
        setSupportActionBar(toobar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        toobar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
     public void getIntgentData(){

     }


    
    protected  abstract  void  initData();
     //初始化布局
    protected abstract   int createLayoutId();


    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (binds!=null){
            binds.unbind();
            binds=null;
        }

    }

    public  void setTooBatNight(){

    };
}
