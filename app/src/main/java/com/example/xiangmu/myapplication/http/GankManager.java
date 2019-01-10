package com.example.xiangmu.myapplication.http;


import com.example.xiangmu.myapplication.beans.GanHuoWenZhangBean;
import com.example.xiangmu.myapplication.beans.ganhuo.MeiZhIShuiJiBean;

import java.util.List;

import io.reactivex.Observable;

/**
 * @packge: com.example.xiangmu.myapplication.http
 * @filename:ZhihuManager
 * @date :${DATA} 17:16
 */
public class GankManager {
    private   static  GankApis sankApis;

    public  static  GankApis getGankServer(){
        if (sankApis ==null){
            synchronized (MyServer.class){
                if (sankApis==null){
                    sankApis=HttpManager.getInstance().getServer(GankApis.HOST,GankApis.class);
                }
            }
        }
        return  sankApis;
    }


}
