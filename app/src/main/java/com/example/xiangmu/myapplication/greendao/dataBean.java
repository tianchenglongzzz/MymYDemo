package com.example.xiangmu.myapplication.greendao;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * @packge: com.example.xiangmu.myapplication.greendao
 * @filename:dataBean
 * @date :${DATA} 16:59
 */
@Entity
public class dataBean {
    @Id
    private  Long id;
    String  title;
    boolean  state;
    @Generated(hash = 232484620)
    public dataBean(Long id, String title, boolean state) {
        this.id = id;
        this.title = title;
        this.state = state;
    }
    @Generated(hash = 238468224)
    public dataBean() {
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
    public boolean getState() {
        return this.state;
    }
    public void setState(boolean state) {
        this.state = state;
    }

    
}
