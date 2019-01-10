package com.example.xiangmu.myapplication.beans;

import java.util.List;

/**
 * @packge: com.example.xiangmu.myapplication.beans
 * @filename:SujuZhiHui
 * @date :${DATA} 22:45
 */
public class ShuJuZhiHuiBean {

    /**
     * ERRORCODE : 0
     * RESULT : {"newsList":[{"publishTime":"2018-12-30 02:52:37","newsId":"75ca6b5b131e443130bc7446ba595a64","newsImg":"https://inews.gtimg.com/newsapp_ls/0/7060126617_640330/0","source":"海外网","category":"要闻","title":"德国一名男子驾车冲闯停机坪被捕 汉诺威机场紧急封锁"},{"publishTime":"2018-12-30 01:30:34","newsId":"97477aaa19416ba593f6d5386edd6106","newsImg":"https://inews.gtimg.com/newsapp_ls/0/7062140931_640330/0","source":"万象历史","category":"要闻","title":"88年前的今天屠呦呦出生：获得诺贝尔奖的\u201c三无\u201d科学家"},{"publishTime":"2018-12-30 01:09:42","newsId":"9524393b93cf7328fae25a8068ce1252","newsImg":"https://inews.gtimg.com/newsapp_ls/0/7059491931_640330/0","source":"香蕉娱乐","category":"要闻","title":"刘德华娇妻朱丽倩带女儿逛街，获保镖保姆四人贴身照顾"},{"publishTime":"2018-12-30 00:36:47","newsId":"f2f5b42e6b34999152c48460defcdaac","newsImg":"https://inews.gtimg.com/newsapp_ls/0/7059655490_640330/0","source":"中国新闻网","category":"要闻","title":"2018年中国接收安置退役士兵40多万名 军转干部逾8万人"},{"publishTime":"2018-12-30 00:04:10","newsId":"af814ca6dacd111de939ceb8f60f0290","newsImg":"https://inews.gtimg.com/newsapp_ls/0/7059293098_640330/0","source":"中国新闻网","category":"要闻","title":"公安部新规维护民警执法权威 辅警享受同等权益"},{"publishTime":"2018-12-30 00:03:34","newsId":"8705e4b585d977f40664cef1553f24eb","newsImg":"https://inews.gtimg.com/newsapp_ls/0/7059258988_640330/0","source":"中国新闻网","category":"要闻","title":"九部门联合发布中小学生\u201c减负三十条\u201d：明文规定考试次数"},{"publishTime":"2018-12-30 00:01:34","newsId":"650a130a055d1d9422a575c7d10f011e","newsImg":"https://inews.gtimg.com/newsapp_ls/0/7061457177_640330/0","source":"物种日历","category":"要闻","title":"物种日历：力量与技巧相结合的猎隼，曾经承担过历史重任"}],"page":2,"allPage":2}
     */

    private String ERRORCODE;
    private RESULTBean RESULT;

    public String getERRORCODE() {
        return ERRORCODE;
    }

    public void setERRORCODE(String ERRORCODE) {
        this.ERRORCODE = ERRORCODE;
    }

    public RESULTBean getRESULT() {
        return RESULT;
    }

    public void setRESULT(RESULTBean RESULT) {
        this.RESULT = RESULT;
    }

    public static class RESULTBean {
        /**
         * newsList : [{"publishTime":"2018-12-30 02:52:37","newsId":"75ca6b5b131e443130bc7446ba595a64","newsImg":"https://inews.gtimg.com/newsapp_ls/0/7060126617_640330/0","source":"海外网","category":"要闻","title":"德国一名男子驾车冲闯停机坪被捕 汉诺威机场紧急封锁"},{"publishTime":"2018-12-30 01:30:34","newsId":"97477aaa19416ba593f6d5386edd6106","newsImg":"https://inews.gtimg.com/newsapp_ls/0/7062140931_640330/0","source":"万象历史","category":"要闻","title":"88年前的今天屠呦呦出生：获得诺贝尔奖的\u201c三无\u201d科学家"},{"publishTime":"2018-12-30 01:09:42","newsId":"9524393b93cf7328fae25a8068ce1252","newsImg":"https://inews.gtimg.com/newsapp_ls/0/7059491931_640330/0","source":"香蕉娱乐","category":"要闻","title":"刘德华娇妻朱丽倩带女儿逛街，获保镖保姆四人贴身照顾"},{"publishTime":"2018-12-30 00:36:47","newsId":"f2f5b42e6b34999152c48460defcdaac","newsImg":"https://inews.gtimg.com/newsapp_ls/0/7059655490_640330/0","source":"中国新闻网","category":"要闻","title":"2018年中国接收安置退役士兵40多万名 军转干部逾8万人"},{"publishTime":"2018-12-30 00:04:10","newsId":"af814ca6dacd111de939ceb8f60f0290","newsImg":"https://inews.gtimg.com/newsapp_ls/0/7059293098_640330/0","source":"中国新闻网","category":"要闻","title":"公安部新规维护民警执法权威 辅警享受同等权益"},{"publishTime":"2018-12-30 00:03:34","newsId":"8705e4b585d977f40664cef1553f24eb","newsImg":"https://inews.gtimg.com/newsapp_ls/0/7059258988_640330/0","source":"中国新闻网","category":"要闻","title":"九部门联合发布中小学生\u201c减负三十条\u201d：明文规定考试次数"},{"publishTime":"2018-12-30 00:01:34","newsId":"650a130a055d1d9422a575c7d10f011e","newsImg":"https://inews.gtimg.com/newsapp_ls/0/7061457177_640330/0","source":"物种日历","category":"要闻","title":"物种日历：力量与技巧相结合的猎隼，曾经承担过历史重任"}]
         * page : 2
         * allPage : 2
         */

        private int page;
        private int allPage;
        private List<NewsListBean> newsList;

        public int getPage() {
            return page;
        }

        public void setPage(int page) {
            this.page = page;
        }

        public int getAllPage() {
            return allPage;
        }

        public void setAllPage(int allPage) {
            this.allPage = allPage;
        }

        public List<NewsListBean> getNewsList() {
            return newsList;
        }

        public void setNewsList(List<NewsListBean> newsList) {
            this.newsList = newsList;
        }

        public static class NewsListBean {
            /**
             * publishTime : 2018-12-30 02:52:37
             * newsId : 75ca6b5b131e443130bc7446ba595a64
             * newsImg : https://inews.gtimg.com/newsapp_ls/0/7060126617_640330/0
             * source : 海外网
             * category : 要闻
             * title : 德国一名男子驾车冲闯停机坪被捕 汉诺威机场紧急封锁
             */

            private String publishTime;
            private String newsId;
            private String newsImg;
            private String source;
            private String category;
            private String title;

            public String getPublishTime() {
                return publishTime;
            }

            public void setPublishTime(String publishTime) {
                this.publishTime = publishTime;
            }

            public String getNewsId() {
                return newsId;
            }

            public void setNewsId(String newsId) {
                this.newsId = newsId;
            }

            public String getNewsImg() {
                return newsImg;
            }

            public void setNewsImg(String newsImg) {
                this.newsImg = newsImg;
            }

            public String getSource() {
                return source;
            }

            public void setSource(String source) {
                this.source = source;
            }

            public String getCategory() {
                return category;
            }

            public void setCategory(String category) {
                this.category = category;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }
        }
    }
}
