package com.example.xiangmu.myapplication.http;

import android.util.Log;

import com.example.xiangmu.myapplication.base.module.HttpFinshCallback;
import com.example.xiangmu.myapplication.module.ZhihuModle;

import java.util.logging.Logger;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import retrofit2.HttpException;

/**
 * @packge: com.example.xiangmu.myapplication.http
 * @filename:BaseObserver
 * @date :${DATA} 14:58
 */
public abstract class BaseObserver<T> implements Observer<T> {
    private static final String TAG = "BaseObserver";
    //回调结果处理
    private HttpFinshCallback httpFinshCallback;

    public BaseObserver(HttpFinshCallback httpFinshCallback) {
        this.httpFinshCallback = httpFinshCallback;
    }
    //管理内存和网络请求
    CompositeDisposable mCompositeDisposable=new CompositeDisposable();




    @Override
    public  void  onSubscribe(Disposable d){
        mCompositeDisposable.add(d);
    }
    @Override
    public void onError(Throwable e){
         if (mCompositeDisposable!=null){
             mCompositeDisposable.clear();
         }
         if(httpFinshCallback!=null){
             if (e instanceof HttpException){
                 httpFinshCallback.setError("网络请求错误");
             }else {
                 httpFinshCallback.setError("其他请求错误");

             }
             if(e.getMessage()!=null) {
                 Log.e("tag", e.getMessage());
             }
           httpFinshCallback.setError(e.getMessage());
         }


    }

    @Override
    public void onComplete() {
        Log.e(TAG, "onComplete: ");
        if (mCompositeDisposable!=null){
            mCompositeDisposable.clear();
        }
        if (httpFinshCallback!=null){

            httpFinshCallback.setHideProgressbar();
        }
    }
}
