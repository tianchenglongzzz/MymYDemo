package com.example.xiangmu.myapplication.greendao;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * @packge: com.example.xiangmu.myapplication.greendao
 * @filename:ScBean
 * @date :${DATA} 21:32
 */

@Entity
public class ScBean {
    @Id
    Long id;
    String title;
    int nwsId;
    String conent;
    String type;
    String imgurl;
    @Generated(hash = 537778763)
    public ScBean(Long id, String title, int nwsId, String conent, String type,
            String imgurl) {
        this.id = id;
        this.title = title;
        this.nwsId = nwsId;
        this.conent = conent;
        this.type = type;
        this.imgurl = imgurl;
    }
    @Generated(hash = 660583168)
    public ScBean() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getTitle() {
        return this.title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public int getNwsId() {
        return this.nwsId;
    }
    public void setNwsId(int nwsId) {
        this.nwsId = nwsId;
    }
    public String getConent() {
        return this.conent;
    }
    public void setConent(String conent) {
        this.conent = conent;
    }
    public String getType() {
        return this.type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public String getImgurl() {
        return this.imgurl;
    }
    public void setImgurl(String imgurl) {
        this.imgurl = imgurl;
    }
}

