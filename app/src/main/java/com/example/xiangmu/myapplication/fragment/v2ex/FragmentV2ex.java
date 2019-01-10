package com.example.xiangmu.myapplication.fragment.v2ex;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.xiangmu.myapplication.R;
import com.example.xiangmu.myapplication.adapter.v2ex.TocApdate;
import com.example.xiangmu.myapplication.base.fragment.BaseFragment;
import com.example.xiangmu.myapplication.beans.TopicListBean;
import com.example.xiangmu.myapplication.presenter.SJ.SJPersenter;
import com.example.xiangmu.myapplication.presenter.v2ex.Vpersenter;
import com.example.xiangmu.myapplication.view.v2exView;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;

import butterknife.BindView;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentV2ex extends BaseFragment<v2exView,Vpersenter<v2exView>> implements v2exView{
     @BindView(R.id.v2ex_re)
    XRecyclerView mXRecyclerView;
    private String mName;

    @Override
    public void initFrementApdate() {
        super.initFrementApdate();
        Bundle bundle = getArguments();
        mName = bundle.getString("name");
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public Vpersenter ctreatePresrnter() {
        return new Vpersenter();
    }

    @Override
    public int getViewLayout() {
        return R.layout.fragment_fragment_v2ex;
    }

    @Override
    public void initData() {
        if (perstrnter!=null) {
            perstrnter.getTpcBean(mName);
        }
        }



    @Override
    public void showv2ex(final ArrayList<TopicListBean> tocBean) {
                Log.e("========",tocBean+"");
                TocApdate tocApdate = new TocApdate(tocBean,getActivity());
                if (mXRecyclerView!=null) {
                    mXRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
                    mXRecyclerView.setAdapter(tocApdate);
                }
            }





}
