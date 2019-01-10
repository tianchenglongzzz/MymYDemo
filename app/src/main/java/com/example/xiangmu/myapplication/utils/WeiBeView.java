package com.example.xiangmu.myapplication.utils;

import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * @packge: com.example.xiangmu.myapplication.utils
 * @filename:WeiBeView
 * @date :${DATA} 11:31
 */
public class WeiBeView {
    public  static  void setWeiBeView(WebView beView,String url){
         beView.setWebViewClient(new WebViewClient());
        WebSettings settings = beView.getSettings();
        settings.setJavaScriptEnabled(true);
        beView.loadUrl(url);


    }

}
