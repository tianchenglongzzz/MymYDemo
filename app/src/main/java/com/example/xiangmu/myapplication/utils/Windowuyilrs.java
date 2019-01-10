package com.example.xiangmu.myapplication.utils;

import android.app.Activity;
import android.os.Build;
import android.support.v4.widget.DrawerLayout;
import android.view.View;
import android.view.ViewGroup;

/**
 * @packge: com.example.xiangmu.myapplication.utils
 * @filename:windowuyilrs
 * @date :${DATA} 11:46
 */
public class Windowuyilrs {
    public static void fitsSystemWindows(Activity activity) {
        ViewGroup contentFrameLayout = (ViewGroup) activity.findViewById(android.R.id.content);
        View parentView = contentFrameLayout.getChildAt(0);
        if (parentView != null && Build.VERSION.SDK_INT >= 14) {
            //布局预留状态栏高度的 padding
            parentView.setFitsSystemWindows(true);
            if (parentView instanceof DrawerLayout) {
                DrawerLayout drawer = (DrawerLayout) parentView;
                //将主页面顶部延伸至status bar;虽默认为false,但经测试,DrawerLayout需显示设置
                drawer.setClipToPadding(false);
            }
        }
    }

}
