package com.example.xiangmu.myapplication.beans;

import java.io.Serializable;
import java.util.List;

/**
 * @packge: com.example.xiangmu.myapplication.beans
 * @filename:DailyListBean
 * @date :${DATA} 11:42
 */
public class DailyListBean {

    /**
     * date : 20181221
     * stories : [{"images":["https://pic4.zhimg.com/v2-3c176bb7971bc83b6edbb2818c230993.jpg"],"type":0,"id":9704080,"ga_prefix":"122110","title":"坦格里安的领地这么小，为何失去了龙还能统治七大王国？"},{"images":["https://pic1.zhimg.com/v2-0bba438df616ee8effca2dfd3b465a0c.jpg"],"type":0,"id":9687601,"ga_prefix":"122109","title":"肥皂、洗手液和免洗手消毒液，到底哪个洗手最干净？"},{"images":["https://pic3.zhimg.com/v2-f0996911bcf1be72718cb2220434840a.jpg"],"type":0,"id":9704116,"ga_prefix":"122108","title":"一种名为特朗普的蚓螈，和一种名为特朗普的蛾子"},{"images":["https://pic1.zhimg.com/v2-8eb54ce7233135b616e9640fb68db580.jpg"],"type":0,"id":9704113,"ga_prefix":"122107","title":"经济危机时，娱乐业并没有更发达，反而是这帮人赚钱了"},{"images":["https://pic2.zhimg.com/v2-98ccac6bfc53864cfbe7cadf443ad3c5.jpg"],"type":0,"id":9704109,"ga_prefix":"122107","title":"谁杀死了 ofo？"},{"images":["https://pic1.zhimg.com/v2-8331c3bc257452deb5cc134b66de1e5c.jpg"],"type":0,"id":9704085,"ga_prefix":"122106","title":"瞎扯 · 如何正确地吐槽"}]
     * top_stories : [{"image":"https://pic1.zhimg.com/v2-6b817d4f56bb8fb9f5e8b185b4fe3a20.jpg","type":0,"id":9704113,"ga_prefix":"122107","title":"经济危机时，娱乐业并没有更发达，反而是这帮人赚钱了"},{"image":"https://pic4.zhimg.com/v2-10b3328530fab5cda1593ae306a9979b.jpg","type":0,"id":9704084,"ga_prefix":"122020","title":"为什么人类专门设定一个常数 ≈ 2.718281828？"},{"image":"https://pic3.zhimg.com/v2-774a42d1c0bd2bbec597ac0711b27522.jpg","type":0,"id":9704072,"ga_prefix":"122016","title":"「3+3」聘用制，淘汰率 97%，高校是在把青年教师当蛊养吗？"},{"image":"https://pic1.zhimg.com/v2-f60129dac68c6ed5e46280684649ef98.jpg","type":0,"id":9704021,"ga_prefix":"122007","title":"曾经仅次于诺基亚的手机大厂，彻底走到了这个尴尬的节点"},{"image":"https://pic3.zhimg.com/v2-6c1e0a5fe087dd4f8abeb14d6729681a.jpg","type":0,"id":9704006,"ga_prefix":"121919","title":"这篇胡说八道的《原生家庭理论都是胡说八道》，脸打得啪啪响"}]
     */

    private String date;
    private List<StoriesBean> stories;
    private List<TopStoriesBean> top_stories;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<StoriesBean> getStories() {
        return stories;
    }

    public void setStories(List<StoriesBean> stories) {
        this.stories = stories;
    }

    public List<TopStoriesBean> getTop_stories() {
        return top_stories;
    }

    public void setTop_stories(List<TopStoriesBean> top_stories) {
        this.top_stories = top_stories;
    }

    public static class StoriesBean implements Serializable {
        /**
         * images : ["https://pic4.zhimg.com/v2-3c176bb7971bc83b6edbb2818c230993.jpg"]
         * type : 0
         * id : 9704080
         * ga_prefix : 122110
         * title : 坦格里安的领地这么小，为何失去了龙还能统治七大王国？
         */

        private int type;
        private int id;
        private String ga_prefix;
        private String title;
        private List<String> images;

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getGa_prefix() {
            return ga_prefix;
        }

        public void setGa_prefix(String ga_prefix) {
            this.ga_prefix = ga_prefix;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public List<String> getImages() {
            return images;
        }

        public void setImages(List<String> images) {
            this.images = images;
        }
    }

    public static class TopStoriesBean implements   Serializable {
        /**
         * image : https://pic1.zhimg.com/v2-6b817d4f56bb8fb9f5e8b185b4fe3a20.jpg
         * type : 0
         * id : 9704113
         * ga_prefix : 122107
         * title : 经济危机时，娱乐业并没有更发达，反而是这帮人赚钱了
         */

        private String image;
        private int type;
        private int id;
        private String ga_prefix;
        private String title;

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getGa_prefix() {
            return ga_prefix;
        }

        public void setGa_prefix(String ga_prefix) {
            this.ga_prefix = ga_prefix;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }
    }
}
