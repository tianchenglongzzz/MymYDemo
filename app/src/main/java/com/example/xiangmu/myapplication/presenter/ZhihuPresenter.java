package com.example.xiangmu.myapplication.presenter;

import android.util.Log;

import com.example.xiangmu.myapplication.base.prensenter.IBasePresenter;
import com.example.xiangmu.myapplication.beans.DailyBeforeListBean;
import com.example.xiangmu.myapplication.beans.DailyListBean;
import com.example.xiangmu.myapplication.beans.SectionListBean;
import com.example.xiangmu.myapplication.module.ZhihuModle;
import com.example.xiangmu.myapplication.view.ZhiZuView;

/**
 * @packge: com.example.xiangmu.myapplication.presenter
 * @filename:ZhihuPresenter
 * @date :${DATA} 18:38
 */
public class ZhihuPresenter<V extends ZhiZuView>extends IBasePresenter<V>implements ZhihuModle.ZhihuCallback {
    private static final String TAG = "ZhihuPresenter";
    private ZhihuModle mZhihuModle= new ZhihuModle();
    public  void getDailyListBean(){
        if (mview!=null){
            mZhihuModle.getDailyListBean(this);
    }
    }
    @Override
    public void setDailyListBean(DailyListBean data) {
          if (mview!=null){
              mview.show(data);
          }
    }
    public  void  getDailyBeforeListBean(String data){
         mZhihuModle.DailyBeforeListBean(this,data);
    }
    @Override
    public void setDailyBeforeListBean(DailyBeforeListBean dataBe) {
            mview.showBefore(dataBe);
    }


}
