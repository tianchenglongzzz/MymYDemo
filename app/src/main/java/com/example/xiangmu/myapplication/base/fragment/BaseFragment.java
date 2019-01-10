package com.example.xiangmu.myapplication.base.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.xiangmu.myapplication.R;
import com.example.xiangmu.myapplication.base.prensenter.BaserPresrnter;
import com.example.xiangmu.myapplication.base.view.BaseView;

import org.greenrobot.eventbus.EventBus;

import butterknife.BindView;

/**
 * @packge: com.example.xiangmu.myapplication.base.fragment
 * @filename:BaseFragment
 * @date :${DATA} 9:32
 */
public abstract class BaseFragment<V,P extends BaserPresrnter<V>> extends SimpeFragment implements BaseView {
    private static final String TAG = "BaseFragment";
    public P  perstrnter;
    private View mView1;
  public ProgressBar  mProgressBar;

    private LinearLayout mLinearLayout;



    @Override
    public void vieJinDuTiaoView(View view) {
        super.vieJinDuTiaoView(view);
        mView1 = LayoutInflater.from(getContext()).inflate(R.layout.progressbar_layout, (ViewGroup) view, true);
        mProgressBar=mView1.findViewById(R.id.progressBar);
        mLinearLayout=mView1.findViewById(R.id.fl_progressBar);
        mLinearLayout.setVisibility(View.GONE);
        mLinearLayout.setVisibility(View.GONE);
        perstrnter=ctreatePresrnter();
        if (perstrnter!=null) {
            perstrnter.attachView((V) this);
        }
    }

    public abstract  P  ctreatePresrnter();

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (perstrnter!=null){
            perstrnter.detachView();
            perstrnter=null;
        }


    }

    @Override
    public void hideProgressbar() {
        Log.e(TAG, "hideProgressbar: ");
        mLinearLayout.setVisibility(View.GONE);
        mProgressBar.setVisibility(View.GONE);
    }

    @Override
    public void showProgessbar() {
         mLinearLayout.setVisibility(View.VISIBLE);
        mProgressBar.setVisibility(View.VISIBLE);

    }

    @Override
    public void showError(String err) {
        if (err!=null) {
            Toast.makeText(getContext(), err, Toast.LENGTH_SHORT).show();
        }
    }
}
