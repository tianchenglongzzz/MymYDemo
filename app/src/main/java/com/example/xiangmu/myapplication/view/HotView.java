package com.example.xiangmu.myapplication.view;

import com.example.xiangmu.myapplication.base.view.BaseView;
import com.example.xiangmu.myapplication.beans.DailyListBean;
import com.example.xiangmu.myapplication.beans.HotListBean;

/**
 * @packge: com.example.xiangmu.myapplication.view
 * @filename:HotView
 * @date :${DATA} 19:16
 */
public interface HotView extends BaseView {
    void  show(HotListBean hotListBean);
}
