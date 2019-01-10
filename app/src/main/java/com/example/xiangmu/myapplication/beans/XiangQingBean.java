package com.example.xiangmu.myapplication.beans;

import java.util.List;

/**
 * @packge: com.example.xiangmu.myapplication.beans
 * @filename:XiangQingBean
 * @date :${DATA} 19:01
 */
public class XiangQingBean {

    /**
     * ERRORCODE : 0
     * RESULT : {"imgUrl":["http://inews.gtimg.com/newsapp_bt/0/7060117078/1000"],"publishTime":"2018-12-30 02:52:37","editor":"","source":"海外网","category":"要闻","title":"德国一名男子驾车冲闯停机坪被捕 汉诺威机场紧急封锁","content":"   海外网12月30日电 据BBC报道，德国一名男子周六（29日）下午驾车冲闯汉诺威机场的一个闸口，前往停机坪，随后，该男子遭警方拘捕。受事件影响，机场被紧急封锁。 据报道，德国警方称，当地时间下午，该男子驾车驶过了跑道附近的一个大门，警方随后迫使其停车，并拘捕了该男子。警方表示，随着调查的继续，所有进出的航班都已暂停。 报道称，这起安全事件发生在德国警方宣布他们因恐怖主义担忧而收紧机场安检一周后。报道还称，到目前为止还没有迹象表明星期六的事件与恐怖主义有关。（海外网 张振） "}
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
         * imgUrl : ["http://inews.gtimg.com/newsapp_bt/0/7060117078/1000"]
         * publishTime : 2018-12-30 02:52:37
         * editor :
         * source : 海外网
         * category : 要闻
         * title : 德国一名男子驾车冲闯停机坪被捕 汉诺威机场紧急封锁
         * content :    海外网12月30日电 据BBC报道，德国一名男子周六（29日）下午驾车冲闯汉诺威机场的一个闸口，前往停机坪，随后，该男子遭警方拘捕。受事件影响，机场被紧急封锁。 据报道，德国警方称，当地时间下午，该男子驾车驶过了跑道附近的一个大门，警方随后迫使其停车，并拘捕了该男子。警方表示，随着调查的继续，所有进出的航班都已暂停。 报道称，这起安全事件发生在德国警方宣布他们因恐怖主义担忧而收紧机场安检一周后。报道还称，到目前为止还没有迹象表明星期六的事件与恐怖主义有关。（海外网 张振）
         */

        private String publishTime;
        private String editor;
        private String source;
        private String category;
        private String title;
        private String content;
        private List<String> imgUrl;

        public String getPublishTime() {
            return publishTime;
        }

        public void setPublishTime(String publishTime) {
            this.publishTime = publishTime;
        }

        public String getEditor() {
            return editor;
        }

        public void setEditor(String editor) {
            this.editor = editor;
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

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public List<String> getImgUrl() {
            return imgUrl;
        }

        public void setImgUrl(List<String> imgUrl) {
            this.imgUrl = imgUrl;
        }
    }
}
