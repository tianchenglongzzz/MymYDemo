package com.example.xiangmu.myapplication.activity.weixin;

import android.content.ClipData;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebView;
import android.webkit.WebViewClient;


import com.example.xiangmu.myapplication.R;
import com.example.xiangmu.myapplication.app.MyApp;
import com.example.xiangmu.myapplication.base.activity.BaseActivity;
import com.example.xiangmu.myapplication.base.activity.SimpleActivity;
import com.example.xiangmu.myapplication.base.prensenter.BaserPresrnter;
import com.example.xiangmu.myapplication.greendao.ScBean;

import java.util.List;

import butterknife.BindView;

public class WeiXinActivity extends SimpleActivity {
    private  final  String NAME="微信";

    @BindView(R.id.toobar_weixinweb)
    Toolbar mToolbar;
    @BindView(R.id.wei_web)
    WebView mWebView;
    private String mUrl;
    private String mTitle;
    private String mImg;
    private boolean mB;


    @Override
    public void getIntgentData() {
        Intent intent = getIntent();
        mUrl = intent.getStringExtra("url");
        mTitle = intent.getStringExtra("title");
        mImg = intent.getStringExtra("img");

        setTooBar(mToolbar, mTitle);
        mWebView.setWebViewClient(new WebViewClient());
        mWebView.loadUrl(mUrl);

    }



    @Override
    protected void initData() {

    }

    @Override
    protected int createLayoutId() {
        return R.layout.activity_wei_xin;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
     getMenuInflater().inflate(R.menu.toobar_menu_weixin,menu);
           return  true;
    }
   @Override
    public boolean onPrepareOptionsMenu(Menu menu) {

        List<ScBean> list = MyApp.getSession().getScBeanDao().loadAll();
        mB = false;
        for (int i = 0; i <list.size() ; i++) {
            if (list.get(i).getTitle()!=null&&list.get(i).getTitle().equals(mTitle)){
                mB=true;
            }
        }
        if (!mB) {
            menu.getItem(0).setIcon(R.mipmap.ic_toolbar_like_n);
        }else {
            menu.getItem(0).setIcon(R.mipmap.ic_toolbar_like_p);
        }
        return super.onCreateOptionsMenu(menu);
    }


  @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.action_like:
                if (mB){
                    List<ScBean> scBeans = MyApp.getSession().getScBeanDao().loadAll();
                    for (int i = 0; i <scBeans.size() ; i++) {
                        if (scBeans.get(i).getTitle().equals(mTitle)){
                              MyApp.getSession().getScBeanDao().delete(scBeans.get(i));
                        }
                    }
                    item.setIcon(R.mipmap.ic_toolbar_like_n);
                    mB=false;
                }else {
                    MyApp.getSession().getScBeanDao().insert(new ScBean(null,mTitle,0,mUrl,NAME,mImg));
                    mB=true;
                    item.setIcon(R.mipmap.ic_toolbar_like_p);
                }
                 break;
            case  R.id.action_copy:
                ClipData text = ClipData.newPlainText("TEXT", mUrl);
                break;

        }
        return super.onOptionsItemSelected(item);
    }
}
