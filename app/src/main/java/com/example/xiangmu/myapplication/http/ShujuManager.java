package com.example.xiangmu.myapplication.http;

import com.example.xiangmu.myapplication.beans.ShuJuZhiHuiBean;
import com.example.xiangmu.myapplication.beans.XiangQingBean;

import io.reactivex.Observable;

/**
 * @packge: com.example.xiangmu.myapplication.http
 * @filename:ShujuManager
 * @date :${DATA} 10:03
 */
public class ShujuManager {
    private  static  ShuJUServer sShuJUServer;
    public static  ShuJUServer getShuJUServer(){
        if (sShuJUServer==null){
            synchronized (ShujuManager.class){
                if (sShuJUServer==null){
                    sShuJUServer=HttpManager.getInstance().getServer(ShuJUServer.HOST,ShuJUServer.class);
                }
            }
        }

        return sShuJUServer;

    }
    public Observable<ShuJuZhiHuiBean> getshujuzhihuiLIST(String categor,int page){
     return      sShuJUServer.getShujulist(categor,page);

    }
    public Observable<XiangQingBean> getshujuzhihuiLIST(String appay,String  id){
        return      sShuJUServer.geiXiangQing(appay,id);

    }


}
