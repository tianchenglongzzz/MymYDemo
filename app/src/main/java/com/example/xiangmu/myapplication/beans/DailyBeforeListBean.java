package com.example.xiangmu.myapplication.beans;

import java.util.List;

/**
 * Created by codeest on 16/8/12.
 */

public class DailyBeforeListBean {

    /**
     * date : 20181204
     * stories : [{"images":["https://pic4.zhimg.com/v2-d67a162a80033969c37829f030e48e73.jpg"],"type":0,"id":9703121,"ga_prefix":"120422","title":"小事 · 中国人就是吃了上顿想下顿"},{"title":"穿越吧，我的巴黎","ga_prefix":"120419","images":["https://pic1.zhimg.com/v2-d4a2a7987cb6cad9d6ff8c6247849108.jpg"],"multipic":true,"type":0,"id":9702962},{"images":["https://pic2.zhimg.com/v2-4b804b63699c4f2a7684b412d683c621.jpg"],"type":0,"id":9702954,"ga_prefix":"120416","title":"想玩无人机，这些注意事项我只说一遍，说一遍，说一遍"},{"images":["https://pic4.zhimg.com/v2-13cd53faf8a1af4f6b52c68ac5d7fa57.jpg"],"type":0,"id":9703004,"ga_prefix":"120413","title":"我只是个普通人，只不过得了两次诺奖而已"},{"images":["https://pic4.zhimg.com/v2-d2fa9af7c616b6ae63034007a794a4bb.jpg"],"type":0,"id":9703035,"ga_prefix":"120412","title":"大误 · 美国人沉睡的味蕾终于被奶茶唤醒"},{"title":"今年的金球奖颁给任何人都是有争议的，包括「魔笛」","ga_prefix":"120410","images":["https://pic1.zhimg.com/v2-19b9436e34f71b0db3bbb2087c117374.jpg"],"multipic":true,"type":0,"id":9703049},{"images":["https://pic3.zhimg.com/v2-98d5b9f30132cfe082ff3dab02e8c376.jpg"],"type":0,"id":9702959,"ga_prefix":"120410","title":"刘慈欣的《三体》文笔真的很差吗？"},{"images":["https://pic1.zhimg.com/v2-81aae86942f5d1a76b15eed717f19820.jpg"],"type":0,"id":9702989,"ga_prefix":"120409","title":"厉害的人都是怎么分析问题的？"},{"images":["https://pic1.zhimg.com/v2-284a4eb4308588b53c487438377c6150.jpg"],"type":0,"id":9703024,"ga_prefix":"120408","title":"足球比赛中最刺激的部分，应该取消掉吗？"},{"images":["https://pic3.zhimg.com/v2-3d8dbd09040d5e061aca8993ac2d5366.jpg"],"type":0,"id":9703031,"ga_prefix":"120407","title":"美国最近批准了一种药效不错的抗癌药，但你也别被骗了"},{"images":["https://pic3.zhimg.com/v2-ac6723c0df7bb94c97fe337c1be3e8ce.jpg"],"type":0,"id":9702966,"ga_prefix":"120407","title":"人生海海，请用好你自己"},{"images":["https://pic4.zhimg.com/v2-eedf3a49f0c51c53d49a3d227131c1e3.jpg"],"type":0,"id":9702979,"ga_prefix":"120406","title":"瞎扯 · 如何正确地吐槽"}]
     */

    private String date;
    private List<StoriesBean> stories;

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

    public static class StoriesBean {
        /**
         * images : ["https://pic4.zhimg.com/v2-d67a162a80033969c37829f030e48e73.jpg"]
         * type : 0
         * id : 9703121
         * ga_prefix : 120422
         * title : 小事 · 中国人就是吃了上顿想下顿
         * multipic : true
         */

        private int type;
        private int id;
        private String ga_prefix;
        private String title;
        private boolean multipic;
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

        public boolean isMultipic() {
            return multipic;
        }

        public void setMultipic(boolean multipic) {
            this.multipic = multipic;
        }

        public List<String> getImages() {
            return images;
        }

        public void setImages(List<String> images) {
            this.images = images;
        }
    }
}
