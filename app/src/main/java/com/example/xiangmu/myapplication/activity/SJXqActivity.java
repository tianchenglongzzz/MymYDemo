package com.example.xiangmu.myapplication.activity;

import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;


import com.example.xiangmu.myapplication.R;
import com.example.xiangmu.myapplication.app.MyApp;
import com.example.xiangmu.myapplication.base.activity.BaseActivity;
import com.example.xiangmu.myapplication.beans.XiangQingBean;
import com.example.xiangmu.myapplication.greendao.ScBean;
import com.example.xiangmu.myapplication.presenter.SJ.XQPersenter;
import com.example.xiangmu.myapplication.view.SJXQView;

import java.util.List;

import butterknife.BindView;

public class SJXqActivity extends BaseActivity<SJXQView,XQPersenter<SJXQView>> implements SJXQView{
     private final   String NAME="数据智慧";
    @BindView(R.id.sjxq_bean)
    WebView mSjxqBean;
    @BindView(R.id.toobar_sjxq)
    Toolbar mToolbar;
    private String mName;
    private boolean mB;
    private String mTitle;
    private String mImg;

    @Override
    public void viewCreated(View view) {
        super.viewCreated(view);
        mSjxqBean.setWebViewClient(new WebViewClient());
        WebSettings settings = mSjxqBean.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setDefaultTextEncodingName("utf-8") ;
        mName = getIntent().getStringExtra("name");
        mImg = getIntent().getStringExtra("img");

        Log.e("TAG",mName);

    }

    @Override
    protected void initData() {

        presenter.getXiangQingBean(mName);

    }

    @Override
    protected int createLayoutId() {
        return R.layout.activity_sjxq;
    }

    @Override
    protected XQPersenter createPresenter() {
        return new XQPersenter();
    }




    @Override
    public void show(XiangQingBean shuJuZhiHuiBean) {
        Log.d("show","我拿到数据拉");
        mTitle = shuJuZhiHuiBean.getRESULT().getTitle();
        setTooBar(mToolbar,shuJuZhiHuiBean.getRESULT().getTitle());
        mSjxqBean.loadDataWithBaseURL(null,getHtmlData(shuJuZhiHuiBean.getRESULT().getContent()), "text/html",  "utf-8", null);
    }
    private String getHtmlData(String bodyHTML) {
        String head = "<head>"
                + "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0, user-scalable=no\"> "
                + "<style>img{max-width: 100%; width:auto; height:auto;}</style>"
                + "</head>";
        return "<html>" + head + "<body>" + bodyHTML + "</body></html>";
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
                        if (scBeans.get(i).getTitle()!=null&&scBeans.get(i).getTitle().equals(mTitle)){
                            MyApp.getSession().getScBeanDao().delete(scBeans.get(i));
                        }
                    }
                    item.setIcon(R.mipmap.ic_toolbar_like_n);
                    mB=false;
                }else {
                    MyApp.getSession().getScBeanDao().insert(new ScBean(null,mTitle,0,mName,NAME,mImg));
                    mB=true;
                    item.setIcon(R.mipmap.ic_toolbar_like_p);
                }
                break;

        }
        return super.onOptionsItemSelected(item);
    }
}
