package com.example.xiangmu.myapplication.http;


import com.example.xiangmu.myapplication.beans.CommentBean;
import com.example.xiangmu.myapplication.beans.DailyBeforeListBean;
import com.example.xiangmu.myapplication.beans.DailyListBean;
import com.example.xiangmu.myapplication.beans.DetailExtraBean;
import com.example.xiangmu.myapplication.beans.HotListBean;
import com.example.xiangmu.myapplication.beans.SectionChildListBean;
import com.example.xiangmu.myapplication.beans.SectionListBean;
import com.example.xiangmu.myapplication.beans.ZhihuDetailBean;

import io.reactivex.Observable;

/**
 * @packge: com.example.xiangmu.myapplication.http
 * @filename:ZhihuManager
 * @date :${DATA} 17:16
 */
public class ZhihuManager  {
    private   static  MyServer sMyServer;

    public  static  MyServer getMyServer(){
        if (sMyServer ==null){
            synchronized (MyServer.class){
                if (sMyServer==null){
                    sMyServer=HttpManager.getInstance().getServer(MyServer.Host,MyServer.class);
                }
            }
        }
        return  sMyServer;
    }
  protected Observable<DailyListBean> getDailyList(){
        return  sMyServer.getDailyList();

  }
  protected Observable<SectionListBean> getSectionList(){

        return  sMyServer.getSectionList();
  }
    protected Observable<HotListBean> getHotListBean(){

        return  sMyServer.getHotList();
    }
    private  Observable<DailyBeforeListBean>getDailyBeforeList(String data){
        return  sMyServer.getDailyBeforeList(data);
    }
    private Observable<SectionChildListBean> getSectionChildList(int id){
        return  sMyServer.getSectionChildList(id);
    }
    private  Observable<ZhihuDetailBean> getZhihuDetaillsit(int id){
        return  sMyServer.getDetailInfo(id);
    }
    private  Observable<DetailExtraBean> getDetailExtraBean(int id){
        return  sMyServer.getDetailExtraInfo(id);
    }
    private  Observable<CommentBean> getCommentstoryBean(int id){
        return  sMyServer.getLongCommentInfo(id);
    }
    private  Observable<CommentBean> getCommentLongBean(int id){
        return  sMyServer.getLongCommentInfo(id);
    }
}
