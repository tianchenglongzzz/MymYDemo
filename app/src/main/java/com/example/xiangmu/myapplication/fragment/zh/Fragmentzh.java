package com.example.xiangmu.myapplication.fragment.zh;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;

import com.example.xiangmu.myapplication.R;
import com.example.xiangmu.myapplication.adapter.v2ex.ApdateV2EX;
import com.example.xiangmu.myapplication.base.fragment.BaseFragment;
import com.example.xiangmu.myapplication.beans.ShuJuZhiHuiBean;
import com.example.xiangmu.myapplication.presenter.SJ.SJPersenter;
import com.example.xiangmu.myapplication.view.SJView;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;

import butterknife.BindView;

/**
 * A simple {@link Fragment} subclass.
 */
public class Fragmentzh extends BaseFragment <SJView,SJPersenter<SJView>> implements SJView{

    @BindView(R.id.sj_xr)
    XRecyclerView mXRecyclerView;

    private String mName;
    private int page=1;
    private ArrayList<ShuJuZhiHuiBean.RESULTBean.NewsListBean> mResultBeans;
    private ApdateV2EX mApdateV2EX;


    public Fragmentzh() {
        // Required empty public constructor
    }

    @Override
    public void initFrementApdate() {
        super.initFrementApdate();
        Bundle arguments = getArguments();
        mName = arguments.getString("name");
        mResultBeans = new ArrayList<>();
        mApdateV2EX = new ApdateV2EX(mResultBeans,getActivity());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        mXRecyclerView.setLayoutManager(linearLayoutManager);
        mXRecyclerView.setAdapter(mApdateV2EX);
        mXRecyclerView.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                 page=1;
                 mResultBeans.clear();
                initData();
                mXRecyclerView.refreshComplete();
            }

            @Override
            public void onLoadMore() {

                    page++;
                    initData();
                    mXRecyclerView.loadMoreComplete();
            }
        });

    }

    @Override
    public SJPersenter<SJView> ctreatePresrnter() {
        return new SJPersenter<>();
    }

    @Override
    public int getViewLayout() {
        return R.layout.fragment_shujuz_item;
    }

    @Override
    public void initData() {
        if (perstrnter!=null) {
            perstrnter.getSjuzihui(mName, this.page);
        }
    }

    @Override
    public void showError(String err) {

    }
    @Override
    public void showSJBean(ShuJuZhiHuiBean shuJuZhiHuiBean) {
        mResultBeans.addAll(shuJuZhiHuiBean.getRESULT().getNewsList());
        mApdateV2EX.notifyDataSetChanged();
    }
}
