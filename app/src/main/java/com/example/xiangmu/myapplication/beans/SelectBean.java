package com.example.xiangmu.myapplication.beans;

/**
 * @packge: com.example.xiangmu.myapplication.beans
 * @filename:SelectBean
 * @date :${DATA} 14:21
 */
public class SelectBean {
    boolean select;
    String mString;
    int  p;

    public SelectBean(boolean select, String string, int p) {
        this.select = select;
        mString = string;
        this.p = p;
    }

    public void setSelect(boolean select) {
        this.select = select;
    }

    public void setString(String string) {
        mString = string;
    }

    public void setP(int p) {
        this.p = p;
    }

    public boolean isSelect() {

        return select;
    }

    public String getString() {
        return mString;
    }

    public int getP() {
        return p;
    }
}