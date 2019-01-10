package com.example.xiangmu.myapplication.http;

import com.example.xiangmu.myapplication.beans.WeiXinBean;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * @packge: com.example.xiangmu.myapplication.http
 * @filename:WeixinServer
 * @date :${DATA} 19:09
 */
public interface WeixinServer {
    String  HOST="http://api.tianapi.com/";
    @GET("wxnew")
    Observable<WeiXinBean>getWeiXinList(@Query("key") String key, @Query("num") int num, @Query("page") int page);
    @GET("wxnew")
    Observable<WeiXinBean>getWeiXinListSearch(@Query("key") String key, @Query("num") int num, @Query("page") int pgge, @Query("word") String word);

}
