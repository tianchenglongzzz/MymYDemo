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
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * @packge:
 * com.example.xiangmu.myapplication.http
 * @filename:MyServer
 * @date :${DATA} 11:08
 */
public interface MyServer {
    String Host="http://news-at.zhihu.com/api/4/";

    /**
     * 启动界面图片
     */
//    @GET("start-image/{res}")
//    Observable<WelcomeBean> getWelcomeInfo(@Path("res") String res);

    /**
     * 最新日报DailyListBean
     */
    @GET("news/latest")
    io.reactivex.Observable<DailyListBean> getDailyList();

    /**
     * 往期日报DailyBeforeListBean
     */
    @GET("news/before/{date}")
    Observable<DailyBeforeListBean> getDailyBeforeList(@Path("date") String date);

    /**
     * 主题日报ThemeListBean
     */
    @GET("themes")
    Observable<String> getThemeList();

    /**
     * 主题日报详情ThemeChildListBean
     */
    @GET("theme/{id}")
    Observable<SectionChildListBean> getThemeChildList(@Path("id") int id);

    /**
     * 专栏日报SectionListBean
     */
    @GET("sections")
    Observable<SectionListBean> getSectionList();

    /**
     * 专栏日报详情SectionChildListBean
     */
    @GET("section/{id}")
    Observable<SectionChildListBean> getSectionChildList(@Path("id") int id);

    /**
     * 热门日报HotListBean
     */
    @GET("news/hot")
    Observable<HotListBean> getHotList();

    /**
     * 日报详情ZhihuDetailBean
     */
    @GET("news/{id}")
    Observable<ZhihuDetailBean> getDetailInfo(@Path("id") int id);

    /**
     * 日报的额外信息DetailExtraBean
     */
    @GET("story-extra/{id}")
    Observable<DetailExtraBean> getDetailExtraInfo(@Path("id") int id);

    /**
     * 日报的长评论CommentBean
     */
    @GET("story/{id}/long-comments")
    Observable<CommentBean> getLongCommentInfo(@Path("id") int id);

    /**
     * 日报的短评论CommentBean
     */
    @GET("story/{id}/short-comments")
    Observable<CommentBean> getShortCommentInfo(@Path("id") int id);
}
