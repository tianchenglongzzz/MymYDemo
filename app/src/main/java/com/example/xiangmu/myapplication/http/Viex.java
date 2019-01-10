package com.example.xiangmu.myapplication.http;

import com.example.xiangmu.myapplication.beans.NodeBean;
import com.example.xiangmu.myapplication.beans.NodeListBean;
import com.example.xiangmu.myapplication.beans.RepliesListBean;

import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * @packge: com.example.xiangmu.myapplication.http
 * @filename:Viex
 * @date :${DATA} 22:09
 */
public interface Viex {
  String HOST = "https://www.v2ex.com/";
  String TAB_HOST = "https://www.v2ex.com/?tab=";
  String REPLIES_URL = "https://www.v2ex.com/t/";
  // Observable<>
  /**
   * 获取节点信息
   * @return
   */
  @GET("/api/nodes/show.json")
  Observable<NodeBean> getNodeInfo(@Query("name") String name);

  /**
   * 获取主题列表
   * @return
   */
  @GET("/api/topics/show.json")
  Observable<List<NodeListBean>> getTopicList(@Query("node_name") String name);

  /**
   * 获取主题信息
   * @return
   */
  @GET("/api/topics/show.json")
  Observable<List<NodeListBean>> getTopicInfo(@Query("id") String id);

  /**
   * 获取主题回复
   * @return
   */
  @GET("/api/replies/show.json")
  Observable<List<RepliesListBean>> getRepliesList(@Query("topic_id") String id);
}
