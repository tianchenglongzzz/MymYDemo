package com.example.xiangmu.myapplication.module;

import android.util.Log;

import com.example.xiangmu.myapplication.base.module.HttpFinshCallback;
import com.example.xiangmu.myapplication.beans.GanHuoWenZhangBean;
import com.example.xiangmu.myapplication.beans.ganhuo.MeiZhIShuiJiBean;

import com.example.xiangmu.myapplication.http.BaseObserver;

import com.example.xiangmu.myapplication.http.GankManager;
import com.example.xiangmu.myapplication.utils.RxUtils;

import java.util.List;


/**
 * @packge: com.example.xiangmu.myapplication.module
 * @filename:GankModel
 * @date :${DATA} 13:52
 */
public class GankModel {
    public  interface  MeiNVRandomCallBack extends HttpFinshCallback {

          void   setMeiNvList(MeiZhIShuiJiBean bean);
          void    seiWenZHnaglist(GanHuoWenZhangBean bean);
          void     setQueryGank(GanHuoWenZhangBean bean);
    }
    public  void  getMeiZhIShuiJiBean(final MeiNVRandomCallBack meiNVRandomCallBack, int i){
         meiNVRandomCallBack.shetShowProgressbar();
        GankManager.getGankServer().getMeiZhIShuiJiBean(i).compose(RxUtils.<MeiZhIShuiJiBean>rxObserableSchedulerHelper()).subscribe(new BaseObserver<MeiZhIShuiJiBean>(meiNVRandomCallBack) {
            @Override
            public void onNext(MeiZhIShuiJiBean value) {
                  meiNVRandomCallBack.setMeiNvList(value);
            }
        });
    }
    public  void  getWenZhangBean(final MeiNVRandomCallBack meiNVRandomCallBack, String tech, int num, int page){
        meiNVRandomCallBack.shetShowProgressbar();
        GankManager.getGankServer().getGanhuoWenZhangList(tech,num,page).compose(RxUtils.<GanHuoWenZhangBean>rxObserableSchedulerHelper()).subscribe(new BaseObserver<GanHuoWenZhangBean>(meiNVRandomCallBack) {
            @Override
            public void onNext(GanHuoWenZhangBean value) {
                Log.d("show","我拿到数据拉");

                    meiNVRandomCallBack.seiWenZHnaglist(value);
            }
        });
    }
    public  void  getQueryGank(String query, String type, int num , int page, final MeiNVRandomCallBack meiNVRandomCallBack){
        GankManager.getGankServer().getSearchList(query,type,num,page).compose(RxUtils.<GanHuoWenZhangBean>rxObserableSchedulerHelper()).subscribe(new BaseObserver<GanHuoWenZhangBean>(meiNVRandomCallBack) {
            @Override
            public void onNext(GanHuoWenZhangBean value) {
                   meiNVRandomCallBack.setQueryGank(value);
            }
        });
    }

}
