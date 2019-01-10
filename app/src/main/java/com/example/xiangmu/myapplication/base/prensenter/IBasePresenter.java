package com.example.xiangmu.myapplication.base.prensenter;

import android.util.Log;
import android.widget.Toast;

import com.example.xiangmu.myapplication.base.module.HttpFinshCallback;
import com.example.xiangmu.myapplication.base.view.BaseView;

import java.lang.ref.WeakReference;

/**
 * @packge: com.example.xiangmu.myapplication.base.prensenter
 * @filename:IBasePresenter
 * @date :${DATA} 15:47
 */
public class IBasePresenter<V extends BaseView> implements BaserPresrnter<V>,HttpFinshCallback {
    private static final String TAG ="IBasePresenter" ;
    //弱引用
    public WeakReference<V> mWeakReference;
    public  V mview;
    @Override
    public void attachView(V v) {
          //绑定
          //第一步先做出一个软引用
           mWeakReference=new WeakReference<V>(v);
           //把弱引用绑定到mview上
           mview=mWeakReference.get();
    }

    @Override
    public void detachView() {
           if(mWeakReference!=null&& mWeakReference.get()!=null){
               //释放调引用对对象
               //避免内存溢出
                mWeakReference.clear();
                mWeakReference=null;

           }
    }

    @Override
    public void shetShowProgressbar() {
        Log.e(TAG, "shetShowProgressbar: " );
        mview.showProgessbar();
    }

    @Override
    public void setHideProgressbar() {
          mview.hideProgressbar();
    }

    @Override
    public void setError(String error) {
        mview.showError(error);
    }
}
