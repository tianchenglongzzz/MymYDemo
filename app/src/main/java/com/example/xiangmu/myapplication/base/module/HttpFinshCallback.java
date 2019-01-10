package com.example.xiangmu.myapplication.base.module;

/**
 * @packge: com.example.xiangmu.myapplication.base.module
 * @filename:HttpFinshCallback
 * @date :${DATA} 15:04
 */
public interface HttpFinshCallback {
    void  shetShowProgressbar();
    void  setHideProgressbar();
    void  setError(String error);
}
