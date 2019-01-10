package com.example.xiangmu.myapplication.http;

import com.example.xiangmu.myapplication.beans.ShuJuZhiHuiBean;
import com.example.xiangmu.myapplication.beans.XiangQingBean;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * @packge: com.example.xiangmu.myapplication.http
 * @filename:ShuJUServer
 * @date :${DATA} 22:48
 */
public interface ShuJUServer {
        String HOST="http://api.shujuzhihui.cn/api/news/";
        @GET("list?appKey=54cfa75fa4d44834857cd9b4813a221f")
        io.reactivex.Observable<ShuJuZhiHuiBean> getShujulist(@Query("category") String categor,@Query("page")int page);

         @GET("detail")
        Observable<XiangQingBean>geiXiangQing(@Query("appKey")String appy,@Query("newsId") String id);
}
