package com.example.xiangmu.myapplication.http;

import com.example.xiangmu.myapplication.beans.DailyListBean;
import com.example.xiangmu.myapplication.beans.WeiXinBean;

import io.reactivex.Observable;
import retrofit2.http.Query;

/**
 * @packge: com.example.xiangmu.myapplication.http
 * @filename:WeixinManger
 * @date :${DATA} 19:25
 */
public class WeixinManger {
    private  static WeixinServer mWeixinServer;

    public  static  WeixinServer getWeixinManger(){
                  if (mWeixinServer==null){
                      synchronized (WeixinManger.class){
                          if (mWeixinServer==null){
                              mWeixinServer=HttpManager.getInstance().getServer(WeixinServer.HOST,WeixinServer.class);
                          }


                      }


                  }
                  return  mWeixinServer;
    }
    protected Observable<WeiXinBean> getWeinXinList(String key, int num,int page){
        return  mWeixinServer.getWeiXinList(key,num,page);

    }
    public  Observable<WeiXinBean>getWinXInSearchList(String key,int num,int page,String world){
        return  mWeixinServer.getWeiXinListSearch(key,num,page,world);
    }
}
