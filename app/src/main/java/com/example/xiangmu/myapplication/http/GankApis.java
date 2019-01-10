package com.example.xiangmu.myapplication.http;


import com.example.xiangmu.myapplication.beans.GanHuoWenZhangBean;
import com.example.xiangmu.myapplication.beans.ganhuo.MeiZhIShuiJiBean;

import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by codeest on 16/8/19.
 */

public interface GankApis {

    String HOST = "http://gank.io/api/";
   //随机妹子
    @GET("random/data/福利/{num}")
    Observable<MeiZhIShuiJiBean>getMeiZhIShuiJiBean(@Path("num")int random);
   //技术文章
    @GET("data/{tech}/{num}/{page}")
    Observable<GanHuoWenZhangBean>getGanhuoWenZhangList(@Path("tech") String tech,@Path("num") int num,@Path("page")int page);
    //搜索
    @GET("search/query/{query}/category/{type}/count/{count}/page/{page}")
    Observable<GanHuoWenZhangBean> getSearchList(@Path("query") String query,@Path("type") String type,@Path("count") int num,@Path("page") int page);

}
