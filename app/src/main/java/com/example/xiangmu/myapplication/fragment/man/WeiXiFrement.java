package com.example.xiangmu.myapplication.fragment.man;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;

import com.example.xiangmu.myapplication.R;
import com.example.xiangmu.myapplication.activity.weixin.WeiXinActivity;
import com.example.xiangmu.myapplication.adapter.weixin.WeiXinApdate;
import com.example.xiangmu.myapplication.base.fragment.BaseFragment;
import com.example.xiangmu.myapplication.base.prensenter.BaserPresrnter;
import com.example.xiangmu.myapplication.beans.WeiXinBean;
import com.example.xiangmu.myapplication.presenter.weixin.WeiXinPresenter;
import com.example.xiangmu.myapplication.view.weixin.WeiXinView;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.Random;

import butterknife.BindView;

/**
 * @packge: com.example.xiangmu.myapplication.fragment.man
 * @filename:WeiXiFrement
 * @date :${DATA} 11:10
 */
public class WeiXiFrement extends BaseFragment<WeiXinView,WeiXinPresenter<WeiXinView>> implements WeiXinView{
    private  static  int mint=1;
    @BindView(R.id.xr_weixin)
    XRecyclerView mXRecyclerViewWeixin;
    private WeiXinApdate mWeiXinApdate;
    private LinearLayoutManager mManager;
    private ArrayList<WeiXinBean.NewslistBean> mBeans;

    @Override
    public void initFrementApdate() {
        super.initFrementApdate();
        mBeans = new ArrayList<>();
        mWeiXinApdate = new WeiXinApdate(mBeans);
        mManager = new LinearLayoutManager(getContext());
        mXRecyclerViewWeixin.setLayoutManager(mManager);
        mXRecyclerViewWeixin.setAdapter(mWeiXinApdate);
        mXRecyclerViewWeixin.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                mBeans.clear();
                mint=1;
                initData();
                mXRecyclerViewWeixin.refreshComplete();
            }

            @Override
            public void onLoadMore() {
                Log.e("========","adsadsa");
                perstrnter.getWeinBean("52b7ec3471ac3bec6846577e79f20e4c",/*(new Random().nextInt(10)+5)*/10,mint++);
                mXRecyclerViewWeixin.loadMoreComplete();
            }
        });
            mWeiXinApdate.setOnItemCick(new WeiXinApdate.onItemCick() {
                @Override
                public void onClick(String url, String title,String img) {
                    Intent intent = new Intent(getContext(),WeiXinActivity.class);
                    intent.putExtra("title",title);
                    intent.putExtra("url",url);
                    intent.putExtra("img",img);
                    startActivity(intent);
                }
            });
    }
    public void setQuery(String query){
         mBeans.clear();
         perstrnter.getWeinQueryBean("52b7ec3471ac3bec6846577e79f20e4c",10,mint,query);
    }
    @Override
    public WeiXinPresenter ctreatePresrnter() {
        return new WeiXinPresenter();
    }

    @Override
    public int getViewLayout() {
        return R.layout.fragment_weixin;
    }

    @Override
    public void initData() {
          perstrnter.getWeinBean("52b7ec3471ac3bec6846577e79f20e4c",/*(new Random().nextInt(10)+5)*/10,mint);
    }

    @Override
    public void show(WeiXinBean weiXinBean) {
//         Log.e("TAG+NULL",weiXinBean+""+mBeans.get(0));
            mBeans.addAll(weiXinBean.getNewslist());
            mWeiXinApdate.notifyDataSetChanged();

    }


}
