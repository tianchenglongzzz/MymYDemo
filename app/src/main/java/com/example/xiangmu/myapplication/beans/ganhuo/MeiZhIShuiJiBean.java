package com.example.xiangmu.myapplication.beans.ganhuo;

import java.util.List;

/**
 * @packge: com.example.xiangmu.myapplication.beans.ganhuo
 * @filename:ganben
 * @date :${DATA} 11:35
 */
public class MeiZhIShuiJiBean {

    /**
     * error : false
     * results : [{"_id":"5b233551421aa92a5abcd36e","createdAt":"2018-06-15T11:41:05.571Z","desc":"Android手机端崩溃日志记录。","images":["http://img.gank.io/0add1cda-d44b-4430-aa74-a8074bd23613"],"publishedAt":"2018-06-15T00:00:00.0Z","source":"chrome","type":"Android","url":"https://github.com/simplepeng/SpiderMan","used":true,"who":"lijinshanmx"}]
     */

    private boolean error;
    private List<ResultsBean> results;

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public List<ResultsBean> getResults() {
        return results;
    }

    public void setResults(List<ResultsBean> results) {
        this.results = results;
    }

    public static class ResultsBean {
        /**
         * _id : 5b233551421aa92a5abcd36e
         * createdAt : 2018-06-15T11:41:05.571Z
         * desc : Android手机端崩溃日志记录。
         * images : ["http://img.gank.io/0add1cda-d44b-4430-aa74-a8074bd23613"]
         * publishedAt : 2018-06-15T00:00:00.0Z
         * source : chrome
         * type : Android
         * url : https://github.com/simplepeng/SpiderMan
         * used : true
         * who : lijinshanmx
         */

        private String _id;
        private String createdAt;
        private String desc;
        private String publishedAt;
        private String source;
        private String type;
        private String url;
        private boolean used;
        private String who;
        private List<String> images;

        public String get_id() {
            return _id;
        }

        public void set_id(String _id) {
            this._id = _id;
        }

        public String getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(String createdAt) {
            this.createdAt = createdAt;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public String getPublishedAt() {
            return publishedAt;
        }

        public void setPublishedAt(String publishedAt) {
            this.publishedAt = publishedAt;
        }

        public String getSource() {
            return source;
        }

        public void setSource(String source) {
            this.source = source;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public boolean isUsed() {
            return used;
        }

        public void setUsed(boolean used) {
            this.used = used;
        }

        public String getWho() {
            return who;
        }

        public void setWho(String who) {
            this.who = who;
        }

        public List<String> getImages() {
            return images;
        }

        public void setImages(List<String> images) {
            this.images = images;
        }
    }
}
