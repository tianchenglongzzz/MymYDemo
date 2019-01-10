package com.example.xiangmu.myapplication.base.activity;

import android.icu.util.ValueIterator;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.xiangmu.myapplication.R;
import com.example.xiangmu.myapplication.base.module.HttpFinshCallback;
import com.example.xiangmu.myapplication.base.prensenter.BaserPresrnter;
import com.example.xiangmu.myapplication.base.view.BaseView;

/**
 * @packge: com.example.xiangmu.myapplication.base.activity
 * @filename:BaseActivity
 * @date :${DATA} 16:44
 */
public abstract class BaseActivity <V,P extends BaserPresrnter<V>> extends SimpleActivity implements BaseView{
   public  P presenter;
 private View mView1;
    private LinearLayout mLinearLayout;
    private ProgressBar mProgressBar;

    @Override
    public void viewCreated(View view) {
        super.viewCreated(view);
     mView1 = View.inflate(this, R.layout.progressbar_layout, (ViewGroup) view);
        mLinearLayout = mView1.findViewById(R.id.fl_progressBar);
        mProgressBar=mView1.findViewById(R.id.progressBar);

        presenter=createPresenter();
        if (presenter!=null){
            presenter.attachView((V) this);
        }
    }

        //创建子类的P层对象
    protected abstract P createPresenter();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(presenter!=null){
            presenter.detachView();
            presenter=null;
        }
    }

    @Override
    public void showError(String err) {
        mLinearLayout.setVisibility(View.GONE);
        mProgressBar.setVisibility(View.GONE);
        Toast.makeText(this,err,Toast.LENGTH_SHORT).show();

    }

    @Override
    public void showProgessbar() {
   mLinearLayout.setVisibility(View.VISIBLE);
          mProgressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgressbar() {
    mLinearLayout.setVisibility(View.GONE);
        mProgressBar.setVisibility(View.GONE);
    }
}
