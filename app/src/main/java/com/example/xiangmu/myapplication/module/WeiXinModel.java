package com.example.xiangmu.myapplication.module;

import com.example.xiangmu.myapplication.base.module.HttpFinshCallback;
import com.example.xiangmu.myapplication.beans.WeiXinBean;
import com.example.xiangmu.myapplication.http.BaseObserver;
import com.example.xiangmu.myapplication.http.WeixinManger;
import com.example.xiangmu.myapplication.utils.RxUtils;

/**
 * @packge: com.example.xiangmu.myapplication.module
 * @filename:WeiXinModel
 * @date :${DATA} 19:37
 */
public class WeiXinModel {
    public  interface  WeiXinCallBack extends HttpFinshCallback{

         void    setWinXinBean(WeiXinBean winXinBean);
    }


    public void getWeiXinben(final WeiXinCallBack weiXinCallBack, String key, int num, int page) {
        weiXinCallBack.shetShowProgressbar();
        WeixinManger.getWeixinManger().getWeiXinList(key, num, page).compose(RxUtils.<WeiXinBean>rxObserableSchedulerHelper()).subscribe(new BaseObserver<WeiXinBean>(weiXinCallBack) {
            @Override
            public void onNext(WeiXinBean value) {
                weiXinCallBack.setWinXinBean(value);
            }

        });

    }
    public void getWeiXinbenQuery(final WeiXinCallBack weiXinCallBack, String key, int num, int page,String query) {
          weiXinCallBack.shetShowProgressbar();
        WeixinManger.getWeixinManger().getWeiXinListSearch(key,num,page,query).compose(RxUtils.<WeiXinBean>rxObserableSchedulerHelper()).subscribe(new BaseObserver<WeiXinBean>(weiXinCallBack) {
            @Override
            public void onNext(WeiXinBean value) {
                  weiXinCallBack.setWinXinBean(value);
            }
        });

    }
}
