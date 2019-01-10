package com.example.xiangmu.myapplication.module;

import com.example.xiangmu.myapplication.base.activity.zhihu.ZhiHuDataActivity;
import com.example.xiangmu.myapplication.base.module.HttpFinshCallback;
import com.example.xiangmu.myapplication.beans.CommentBean;
import com.example.xiangmu.myapplication.beans.DailyBeforeListBean;
import com.example.xiangmu.myapplication.beans.DailyListBean;
import com.example.xiangmu.myapplication.beans.DetailExtraBean;
import com.example.xiangmu.myapplication.beans.HotListBean;
import com.example.xiangmu.myapplication.beans.SectionChildListBean;
import com.example.xiangmu.myapplication.beans.SectionListBean;
import com.example.xiangmu.myapplication.beans.ZhihuDetailBean;
import com.example.xiangmu.myapplication.http.BaseObserver;
import com.example.xiangmu.myapplication.http.MyServer;
import com.example.xiangmu.myapplication.http.ZhihuManager;
import com.example.xiangmu.myapplication.utils.RxUtils;

import io.reactivex.Observable;
import io.reactivex.ObservableTransformer;
import io.reactivex.Observer;

/**
 * @packge: com.example.xiangmu.myapplication.module
 * @filename:ZhihuModle
 * @date :${DATA} 18:42
 */
public class ZhihuModle {
    public  interface  HotCallback extends HttpFinshCallback{
        void   setHotListBean(HotListBean data);

    }
    public  interface  CommenCallback extends HttpFinshCallback{
         void setCommenLongCallback(CommentBean commentBean);
         void setCommenStortCallback(CommentBean commentBean);
    }
    public  void  getCommenLongBean(final CommenCallback commenCallback, int id){
          commenCallback.shetShowProgressbar();
          ZhihuManager.getMyServer().getLongCommentInfo(id).compose(RxUtils.<CommentBean>rxObserableSchedulerHelper()).subscribe(new BaseObserver<CommentBean>(commenCallback) {

              @Override
              public void onNext(CommentBean value) {
                  commenCallback.setHideProgressbar();
                      commenCallback.setCommenLongCallback(value);
              }
          });


    }

     public  interface  ZhihuCallback extends HttpFinshCallback{
         void   setDailyListBean(DailyListBean data);
         void   setDailyBeforeListBean(DailyBeforeListBean dataBe);

     }
    public  void  getCommenStortBean(final CommenCallback commenCallback, int id) {
        commenCallback.shetShowProgressbar();
        ZhihuManager.getMyServer().getShortCommentInfo(id).compose(RxUtils.<CommentBean>rxObserableSchedulerHelper()).subscribe(new BaseObserver<CommentBean>(commenCallback) {
            @Override
            public void onNext(CommentBean value) {
                 commenCallback.setHideProgressbar();
                commenCallback.setCommenStortCallback(value);
            }
        });
    }
     public interface  XiangQingCallback extends  HttpFinshCallback{
          void  setZhihuDetailBean(ZhihuDetailBean zhihuDetailBean);
         void   setDetailExtraBean(DetailExtraBean data);
     }
     public  interface SectionChildCallBack extends  HttpFinshCallback{
          void  setSectionChildListBean(SectionChildListBean dataBean);
     }
    public  interface  SectionCallback extends HttpFinshCallback{

        void   setSectionListBean(SectionListBean data);
    }

    public  void    getDetailExtraBean(final XiangQingCallback xiangQingCallback, int id){
           xiangQingCallback.shetShowProgressbar();
      ZhihuManager.getMyServer().getDetailExtraInfo(id).compose(RxUtils.<DetailExtraBean>rxObserableSchedulerHelper()).subscribe(new BaseObserver<DetailExtraBean>(xiangQingCallback) {
          @Override
          public void onNext(DetailExtraBean value) {
               xiangQingCallback.setDetailExtraBean(value);
          }
      });

    }
    public  void   DailyBeforeListBean(final  ZhihuCallback zhihuCallback,String data){
        zhihuCallback.shetShowProgressbar();
        ZhihuManager.getMyServer().getDailyBeforeList(data).compose(RxUtils.<DailyBeforeListBean>rxObserableSchedulerHelper()).subscribe(new BaseObserver<DailyBeforeListBean>(zhihuCallback) {
            @Override
            public void onNext(DailyBeforeListBean value) {
                zhihuCallback.setDailyBeforeListBean(value);
            }
        });

    }
    public  void   getZhihuDetailBean(final  XiangQingCallback xiangQingCallback,int id){
        xiangQingCallback.shetShowProgressbar();
        ZhihuManager.getMyServer().getDetailInfo(id).compose(RxUtils.<ZhihuDetailBean>rxObserableSchedulerHelper()).subscribe(new BaseObserver<ZhihuDetailBean>(xiangQingCallback) {
            @Override
            public void onNext(ZhihuDetailBean value) {
                  xiangQingCallback.setZhihuDetailBean(value);
            }
        });
    }
     public  void   getDailyListBean(final ZhihuCallback zhihuCallback){
         zhihuCallback.shetShowProgressbar();
         ZhihuManager.getMyServer().getDailyList().compose(RxUtils.<DailyListBean>rxObserableSchedulerHelper()).subscribe(new BaseObserver<DailyListBean>(zhihuCallback) {
             @Override
             public void onNext(DailyListBean value) {
                       zhihuCallback.setDailyListBean(value);
             }
         });

     }
    public  void   getSectionListBean(final  SectionCallback sectionCallback){
        sectionCallback.shetShowProgressbar();
        ZhihuManager.getMyServer().getSectionList().compose(RxUtils.<SectionListBean>rxObserableSchedulerHelper()).subscribe(new BaseObserver<SectionListBean>(sectionCallback){

            @Override
            public void onNext(SectionListBean value) {
                sectionCallback.setSectionListBean(value);
            }
        } );
        }
    public  void   getHotListBean(final HotCallback hotCallback){
        hotCallback.shetShowProgressbar();
        ZhihuManager.getMyServer().getHotList().compose(RxUtils.<HotListBean>rxObserableSchedulerHelper()).subscribe(new BaseObserver<HotListBean>(hotCallback) {
            @Override
            public void onNext(HotListBean value) {
                  hotCallback.setHotListBean(value);
            }
        });
    }
    public  void   getSectionChildListBean(final SectionChildCallBack sectionChildCallBack,int id){
       sectionChildCallBack.shetShowProgressbar();
        ZhihuManager.getMyServer().getSectionChildList(id).compose(RxUtils.<SectionChildListBean>rxObserableSchedulerHelper()).subscribe(new BaseObserver<SectionChildListBean>(sectionChildCallBack) {
            @Override
            public void onNext(SectionChildListBean value) {
                        sectionChildCallBack.setSectionChildListBean(value);
            }

        });
        //额外信信息

    }




}

