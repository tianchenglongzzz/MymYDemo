package com.example.xiangmu.myapplication.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.util.Log;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.xiangmu.myapplication.R;
import com.facebook.drawee.view.SimpleDraweeView;

import java.net.URL;

/**
 * @packge: com.example.xiangmu.myapplication.utils
 * @filename:ImgUtis
 * @date :${DATA} 7:39
 */
public class ImgUtis {

    private static final String TAG = "ImgUtis";
    public  static  void  setimg(String url, Context context, ImageView imageView){
        SharedPreferences my = context.getSharedPreferences("cc", Context.MODE_PRIVATE);
        boolean mm = my.getBoolean("mv", false);
        if (mm){
            Log.e(TAG, "无图模式");
        }else {
            Glide.with(context).load(url).into(imageView);
        }


    }
    public  static  void  setFace(String url, SimpleDraweeView simpleDraweeView, Context context){
        SharedPreferences my = context.getSharedPreferences("cc", Context.MODE_PRIVATE);
        boolean mm = my.getBoolean("mv", false);
        if (mm){

        }else {
            Uri uri = Uri.parse(url);
            simpleDraweeView.setImageURI(uri);

        }
    }
}
