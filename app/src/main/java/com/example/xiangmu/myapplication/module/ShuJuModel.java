package com.example.xiangmu.myapplication.module;

import android.util.Log;

import com.example.xiangmu.myapplication.R;
import com.example.xiangmu.myapplication.base.module.HttpFinshCallback;
import com.example.xiangmu.myapplication.beans.ShuJuZhiHuiBean;
import com.example.xiangmu.myapplication.beans.XiangQingBean;
import com.example.xiangmu.myapplication.http.BaseObserver;
import com.example.xiangmu.myapplication.http.ShujuManager;
import com.example.xiangmu.myapplication.utils.RxUtils;
import com.example.xiangmu.myapplication.view.XiangQingView;

/**
 * @packge: com.example.xiangmu.myapplication.module
 * @filename:ShuJuModel
 * @date :${DATA} 10:08
 */
public class ShuJuModel {
    private static final String TAG = "ShuJuModel";

    public interface SJCallBack extends HttpFinshCallback {
        void setSJBean(ShuJuZhiHuiBean shuJuZhiHuiBean);

    }

    public interface XiangQingCallback extends HttpFinshCallback {
        void setSJBean(XiangQingBean xiangQingBean);

    }

    public void getSJBean(final SJCallBack sjCallBack, String s,int page) {
        Log.e(TAG, "getSJBean: " + s);
        sjCallBack.shetShowProgressbar();
        ShujuManager.getShuJUServer().getShujulist(s, page).compose(RxUtils.<ShuJuZhiHuiBean>rxObserableSchedulerHelper()).subscribe(new BaseObserver<ShuJuZhiHuiBean>(sjCallBack) {
            @Override
            public void onNext(ShuJuZhiHuiBean value) {
                sjCallBack.setSJBean(value);
            }
        });

    }
    public  void   getXqBean(final XiangQingCallback xiangQingCallback, String nodename){
        xiangQingCallback.shetShowProgressbar();
      Log.d("tag","zzzzzzzzzzz");
        ShujuManager.getShuJUServer().geiXiangQing("39078f11f35b4bfbb9faf752844421fd",nodename).compose(RxUtils.<XiangQingBean>rxObserableSchedulerHelper()).subscribe(new BaseObserver<XiangQingBean>(xiangQingCallback) {
            @Override
            public void onNext(XiangQingBean value) {
                xiangQingCallback.setSJBean(value);
            }
        });





        }






}
