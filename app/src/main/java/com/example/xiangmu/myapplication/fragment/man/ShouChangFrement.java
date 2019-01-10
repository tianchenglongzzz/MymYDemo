package com.example.xiangmu.myapplication.fragment.man;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;

import com.example.xiangmu.myapplication.R;
import com.example.xiangmu.myapplication.adapter.CollectAdapter;
import com.example.xiangmu.myapplication.app.MyApp;
import com.example.xiangmu.myapplication.base.fragment.BaseFragment;
import com.example.xiangmu.myapplication.base.fragment.SimpeFragment;
import com.example.xiangmu.myapplication.base.prensenter.BaserPresrnter;
import com.example.xiangmu.myapplication.greendao.ScBean;
import com.yanzhenjie.recyclerview.swipe.SwipeMenuRecyclerView;
import com.yanzhenjie.recyclerview.swipe.touch.OnItemMoveListener;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * @packge: com.example.xiangmu.myapplication.fragment.man
 * @filename:ShouChangFrement
 * @date :${DATA} 11:12
 */
public class ShouChangFrement extends SimpeFragment {
    @BindView(R.id.swipe_collect)
    SwipeMenuRecyclerView mSwipeMenuRecyclerView;
    private CollectAdapter mCollectAdapter;
    private ArrayList<ScBean> mScBeans1;

    @Override
    public BaserPresrnter ctreatePresrnter() {
        return null;
    }

    @Override
    public void onStart() {
        super.onStart();
        if (MyApp.getSession()!=null&&MyApp.getSession().getScBeanDao()!=null) {
            final List<ScBean> scBeans = MyApp.getSession().getScBeanDao().loadAll();
            Log.e("taggggggggggggg",scBeans.size()+"");
            mScBeans1 = new ArrayList<>();
            mScBeans1.addAll(scBeans);
            LinearLayoutManager manager = new LinearLayoutManager(getContext());
            mCollectAdapter = new CollectAdapter(mScBeans1, getActivity());
            mSwipeMenuRecyclerView.setLayoutManager(manager);
            mSwipeMenuRecyclerView.setAdapter(mCollectAdapter);
            mSwipeMenuRecyclerView.setItemViewSwipeEnabled(true);
            mSwipeMenuRecyclerView.setOnItemMoveListener(new OnItemMoveListener() {
                @Override
                public boolean onItemMove(int fromPosition, int toPosition) {
                    return false;
                }

                @Override
                public void onItemDismiss(int position) {
                       MyApp.getSession().getScBeanDao().delete(mScBeans1.get(position));
                      mScBeans1.remove(position);
                      mCollectAdapter.notifyDataSetChanged();
                }
            });
        }

    }

    @Override
    public void initFrementApdate() {
        super.initFrementApdate();

    }

    @Override
    public int getViewLayout() {
        return R.layout.fragment_shouchang;
    }



    @Override
    public void initData() {

    }

}
