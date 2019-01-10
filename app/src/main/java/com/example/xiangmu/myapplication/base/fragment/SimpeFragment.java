package com.example.xiangmu.myapplication.base.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.PopupWindow;

import com.example.xiangmu.myapplication.R;
import com.example.xiangmu.myapplication.base.prensenter.BaserPresrnter;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import retrofit2.http.POST;

/**
 * @packge: com.example.xiangmu.myapplication.base.fragment
 * @filename:SimpeFragment
 * @date :${DATA} 9:36
 */
public abstract class SimpeFragment extends Fragment {

    private static final String TAG = "tianchenglong";
    private Unbinder bind;
    private  boolean isVisibleView;
    private boolean isVisible;
    public Activity mActivity;





    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivity=getActivity();

    }



    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(getViewLayout(), null);
        vieJinDuTiaoView(view);

        return view;
    }

    public  void initFrementApdate(){

    }
    public  void  vieJinDuTiaoView(View view){

    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.e(TAG, "onViewCreated: 我走了这个方法" );
        this.bind = ButterKnife.bind(this,view);
        isVisibleView=true;
        mActivity=getActivity();
        //起始层
        initFrementApdate();
        initData();


    }




    protected  void getname(){

    }

    public abstract BaserPresrnter ctreatePresrnter();

    public abstract int  getViewLayout();
    public abstract void  initData();

    @Override
    public void onDestroyView() {

        if (bind!=null){
            bind.unbind();

        }
        super.onDestroyView();
    }
}
