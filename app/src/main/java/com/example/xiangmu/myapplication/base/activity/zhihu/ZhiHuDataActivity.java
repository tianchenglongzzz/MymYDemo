package com.example.xiangmu.myapplication.base.activity.zhihu;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.example.xiangmu.myapplication.R;
import com.example.xiangmu.myapplication.activity.zhihu.CommentsActivity;
import com.example.xiangmu.myapplication.app.MyApp;
import com.example.xiangmu.myapplication.base.activity.BaseActivity;
import com.example.xiangmu.myapplication.beans.DailyListBean;
import com.example.xiangmu.myapplication.beans.DetailExtraBean;
import com.example.xiangmu.myapplication.beans.ZhihuDetailBean;
import com.example.xiangmu.myapplication.greendao.ScBean;
import com.example.xiangmu.myapplication.presenter.zhihu.XiangQingPresenter;
import com.example.xiangmu.myapplication.utils.HtmlUtil;
import com.example.xiangmu.myapplication.utils.ImgUtis;
import com.example.xiangmu.myapplication.view.XiangQingView;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class ZhiHuDataActivity extends BaseActivity<XiangQingView, XiangQingPresenter<XiangQingView>> implements XiangQingView {
    private  static final String NAME="知乎";
    @BindView(R.id.tv_name_xiangqing)
    TextView mTextView;
    @BindView(R.id.img_ToolbarLayout)
    SimpleDraweeView mImageView;
    @BindView(R.id.toolbar_view)
    Toolbar mToolbar;
    @BindView(R.id.app_bar)
    AppBarLayout mAppBar;
    @BindView(R.id.web_web)
    WebView mWebWeb;
    @BindView(R.id.fab_zhi_hu)
    FloatingActionButton mFab;
    @BindView(R.id.tv_detail_bottom_like)
    TextView mTvDetailBottomLike;
    @BindView(R.id.tv_detail_bottom_comment)
    TextView mTvDetailBottomComment;
    @BindView(R.id.tv_detail_bottom_share)
    TextView mTvDetailBottomshare;
    @BindView(R.id.frment_zhu_hu_data)
    FrameLayout mFrameLayout;
    @BindView(R.id.NestrdScrollview_zhihu)
    NestedScrollView mNestedScrollView;
    private DailyListBean.TopStoriesBean mStoriesBean;
    private int mId;
    private int mComments;
    private int[] mInts;
    private String title;
    private boolean mB;
    private boolean mv;
    private ZhihuDetailBean zhihuDetailBean;
    boolean isBottomShow;


    @Override
    protected XiangQingPresenter createPresenter() {
        return new XiangQingPresenter();
    }

    @Override
    protected void initData() {
        Log.e("TAG",mId+"");
        presenter.getDetailExtraBean(mId);
        presenter.getZhihuDetailBean(mId);
    }

       @RequiresApi(api = Build.VERSION_CODES.M)
       @Override
    public void viewCreated(View view) {
        super.viewCreated(view);
        mNestedScrollView.setOnScrollChangeListener(new View.OnScrollChangeListener() {
            @Override
            public void onScrollChange(View v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {

                Log.e("TAG",scrollX+"========"+scrollY+"=========="+oldScrollY);
                if(scrollY - oldScrollY > 0 && isBottomShow) {
                    //下移隐藏
                    isBottomShow = false;
                    mFrameLayout.animate().translationY(mFrameLayout.getHeight());
                } else if(scrollY - oldScrollY < 0 && !isBottomShow){
                    //上移出现
                    isBottomShow = true;
                    mFrameLayout.animate().translationY(0);
                }
            }

        });

    }

    private void initShouChang() {
        List<ScBean> scBeans = MyApp.getSession().getScBeanDao().loadAll();
        mB = false;
        for (int i = 0; i <scBeans.size() ; i++) {
               if (scBeans.get(i).getTitle()!=null&&scBeans.get(i).getTitle().equals(zhihuDetailBean.getTitle())){
                   mB =true;
               }
        }
        if (mB){
             mv=true;
            mFab.setImageResource(R.mipmap.ic_toolbar_like_p);
        }else {
            mv=false;
            mFab.setImageResource(R.mipmap.ic_toolbar_like_n);

        }

    }

    @Override
    public void getIntgentData() {
        super.getIntgentData();
        Intent intent = getIntent();
        mId = intent.getIntExtra("id", 0);


    }

    @Override
    protected int createLayoutId() {
        return R.layout.activity_zhi_hu_data;
    }

    @Override
    public void show(ZhihuDetailBean zhihuDetailBean) {
        Log.e("==========","adsadasd");
        ImgUtis.setFace(zhihuDetailBean.getImage(),mImageView,this);
        setTooBar(mToolbar, zhihuDetailBean.getTitle());
        mWebWeb.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });
        String htmlData = HtmlUtil.createHtmlData(zhihuDetailBean.getBody(), zhihuDetailBean.getCss(), zhihuDetailBean.getJs());
        mWebWeb.loadData(htmlData, HtmlUtil.MIME_TYPE, HtmlUtil.ENCODING);

        mTextView.setText(zhihuDetailBean.getImage_source());
        this.zhihuDetailBean=zhihuDetailBean;
        initShouChang();


    }

    @Override
    public void showDetailExtraBean(DetailExtraBean data) {
        Log.e("==========","adsadasd");
        mComments = data.getComments();
        mTvDetailBottomComment.setText(data.getComments()+"条评论");
          mTvDetailBottomLike.setText(data.getPopularity()+"个赞");
        mInts = new int[2];
       mInts[0]=data.getLong_comments();
       mInts[1]=data.getShort_comments();

    }
    @OnClick(R.id.tv_detail_bottom_comment)
    public   void  pingLun(){
        Intent intent = new Intent(this,CommentsActivity.class);
          intent.putExtra("id",mId);
         intent.putExtra("P",mComments);
         intent.putExtra("c",mInts);
         startActivity(intent);
    }
    @OnClick(R.id.fab_zhi_hu)
    public  void  shouChang(){
         if (mv){
             mFab.setImageResource(R.mipmap.ic_toolbar_like_n);
             List<ScBean> scBeans = MyApp.getSession().getScBeanDao().loadAll();
             for (int i = 0; i <scBeans.size() ; i++) {
                   if (scBeans.get(i).getTitle()!=null&&scBeans.get(i).getTitle().equals(zhihuDetailBean.getTitle())){
                           MyApp.getSession().getScBeanDao().delete(scBeans.get(i));
                   }
             }
             mv=false;
         }else{

             mv=true;
             mFab.setImageResource(R.mipmap.ic_toolbar_like_p);
             MyApp.getSession().getScBeanDao().insert(new ScBean(null,zhihuDetailBean.getTitle(),mId,null,NAME,zhihuDetailBean.getImage()));
         }



}
    }
