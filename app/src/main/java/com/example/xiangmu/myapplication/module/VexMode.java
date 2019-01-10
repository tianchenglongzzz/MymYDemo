package com.example.xiangmu.myapplication.module;

import com.example.xiangmu.myapplication.adapter.ganhuo.AndroidApdate;
import com.example.xiangmu.myapplication.base.module.HttpFinshCallback;
import com.example.xiangmu.myapplication.beans.TopicListBean;
import com.example.xiangmu.myapplication.http.Viex;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import io.reactivex.schedulers.Schedulers;

/**
 * @packge: com.example.xiangmu.myapplication.module
 * @filename:VexMode
 * @date :${DATA} 12:01
 */
public class VexMode {
 public    interface  TocCallBack extends HttpFinshCallback{
        void setTocBean( ArrayList<TopicListBean> tocBean);
    }

    public void   getTocBeanvoid(final TocCallBack tocCallBack, final String s) {
     tocCallBack.shetShowProgressbar();
        Flowable.just(Viex.TAB_HOST+s)
                .subscribeOn(Schedulers.io())
                .map(new Function<String, Document>() {
            @Override
            public Document apply(String s) throws Exception {
                Connection conn = Jsoup.connect(s).timeout(10000);
                conn.header("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
                conn.header("Accept-Encoding", "gzip, deflate, sdch");
                conn.header("Accept-Language", "zh-CN,zh;q=0.8");
                conn.header("User-Agent", "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/55.0.2883.87 Safari/537.36");
                return conn.get();


            }
        }).map(new Function<Document, List<TopicListBean>>() {
            @Override
            public List<TopicListBean> apply(Document document) throws Exception {
                return paresHtml(document);
            }
        }).observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer<List<TopicListBean>>() {
            @Override
            public void accept(List<TopicListBean> topicListBeans) throws Exception {
                tocCallBack.setHideProgressbar();
                tocCallBack.setTocBean((ArrayList<TopicListBean>) topicListBeans);
            }
        });


    }


    private ArrayList<TopicListBean> paresHtml(Document document) {
        ArrayList<TopicListBean>topicListBeans=new ArrayList<>();
        Elements select = document.select("div.cell.item");
        for (int i = 0; i <select.size() ; i++) {
            Elements titleElements = select.get(i).select("div.cell.item table tr td span.item_title > a");   //标题
            Elements imgElements = select.get(i).select("div.cell.item table tr td img.avatar");              //头像
            Elements nodeElements = select.get(i).select("div.cell.item table tr span.small.fade a.node");    //节点
            Elements commentElements = select.get(i).select("div.cell.item table tr a.count_livid");          //评论数
            Elements nameElements = select.get(i).select("div.cell.item table tr span.small.fade strong a");  //作者 & 最后回复
            Elements timeElements = select.get(i).select("div.cell.item table tr span.small.fade");
            TopicListBean bean = new TopicListBean();

            if (titleElements.size() > 0) {
                bean.setTitle(titleElements.get(0).text());
                bean.setTopicId(parseId(titleElements.get(0).attr("href")));
            }
            if (imgElements.size() > 0) {
                bean.setImgUrl(parseImg(imgElements.get(0).attr("src")));
            }
            if (nodeElements.size() > 0) {
                bean.setNode(nodeElements.get(0).text());
            }
            if (nameElements.size() > 0) {
                bean.setName(nameElements.get(0).text());
            }
            //存在没有 最后回复者、评论数、更新时间的情况
            if (nameElements.size() > 1) {
                bean.setLastUser(nameElements.get(1).text());
            }
            if (commentElements.size() > 0) {
                bean.setCommentNum(Integer.valueOf(commentElements.get(0).text()));
            }
            if (timeElements.size() > 1) {
                bean.setUpdateTime(parseTime(timeElements.get(1).text()));
            }
            topicListBeans.add(bean);
        }

             return  topicListBeans;
    }
    private String parseId(String str) {
        int idEnd = str.indexOf("#");
        return str.substring(3, idEnd);
    }

    private String parseTime(String str) {
        int timeEnd = str.indexOf("  •");
        if (timeEnd == -1) {
            return str;
        }
        return str.substring(0, timeEnd);
    }

    public static String parseImg(String str) {
        return "http:" + str;
    }
}
