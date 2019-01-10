package com.example.xiangmu.myapplication.activity.ganhuo;

import android.content.Intent;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;




import com.example.xiangmu.myapplication.R;
import com.example.xiangmu.myapplication.app.MyApp;
import com.example.xiangmu.myapplication.base.activity.SimpleActivity;
import com.example.xiangmu.myapplication.greendao.ScBean;
import com.tencent.smtt.export.external.interfaces.SslError;
import com.tencent.smtt.export.external.interfaces.SslErrorHandler;
import com.tencent.smtt.sdk.WebSettings;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.WebViewClient;

import java.util.List;

import butterknife.BindView;

public class GanActivity extends SimpleActivity {
    private final String NAME = "干货";
    @BindView(R.id.wbe_gan)
    WebView mGanWeb;
    @BindView(R.id.g_toobar)
    Toolbar mToolbar;
    private String mNaem;
    private String mTitle;
    private boolean mB;
    private int mImg;

    @Override
    public void viewCreated(View view) {
        super.viewCreated(view);
        Intent intent = getIntent();
        mNaem = intent.getStringExtra("name");
        mTitle = intent.getStringExtra("title");
        mImg = intent.getIntExtra("img", 0);
        setTooBar(mToolbar, mTitle);
        WebSettings settings = mGanWeb.getSettings();

        settings.setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
        settings.setJavaScriptEnabled(true);
        settings.setDomStorageEnabled(true);
        mGanWeb.setWebViewClient(new WebViewClient(){
           @Override
           public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
                  sslErrorHandler.proceed();

           }
       });
        Log.e("======",mNaem);
        mGanWeb.loadUrl(mNaem);

    }

    @Override
    protected void initData() {

    }

    @Override
    protected int createLayoutId() {
        return R.layout.activity_gan;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toobar_menu_weixin, menu);
        return true;
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {

        List<ScBean> list = MyApp.getSession().getScBeanDao().loadAll();
        mB = false;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getTitle()!=null&&list.get(i).getTitle().equals(mTitle)) {
                mB = true;
            }
        }
        if (!mB) {
            menu.getItem(0).setIcon(R.mipmap.ic_toolbar_like_n);
        } else {
            menu.getItem(0).setIcon(R.mipmap.ic_toolbar_like_p);
        }
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_like:
                if (mB) {
                    List<ScBean> scBeans = MyApp.getSession().getScBeanDao().loadAll();
                    for (int i = 0; i < scBeans.size(); i++) {
                        if (scBeans.get(i).getTitle().equals(mTitle)) {
                            MyApp.getSession().getScBeanDao().delete(scBeans.get(i));
                        }
                    }
                    item.setIcon(R.mipmap.ic_toolbar_like_n);
                    mB = false;
                } else {
                    MyApp.getSession().getScBeanDao().insert(new ScBean(null, mTitle,mImg,mNaem, NAME,null));
                    mB = true;
                    item.setIcon(R.mipmap.ic_toolbar_like_p);
                }
                break;

        }
        return super.onOptionsItemSelected(item);
    }
}