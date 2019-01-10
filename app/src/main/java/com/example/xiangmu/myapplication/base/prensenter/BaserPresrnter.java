package com.example.xiangmu.myapplication.base.prensenter;

/**
 * @packge: com.example.xiangmu.myapplication.base.prensenter
 * @filename:BaserPresrnter
 * @date :${DATA} 15:43
 */
public interface BaserPresrnter<V> {
    //绑定View
    void attachView(V v);
    //解绑View
    void detachView();
}
