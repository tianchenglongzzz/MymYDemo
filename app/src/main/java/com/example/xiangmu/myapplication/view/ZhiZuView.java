package com.example.xiangmu.myapplication.view;

import com.example.xiangmu.myapplication.base.view.BaseView;
import com.example.xiangmu.myapplication.beans.DailyBeforeListBean;
import com.example.xiangmu.myapplication.beans.DailyListBean;
import com.example.xiangmu.myapplication.beans.SectionListBean;

/**
 * @packge: com.example.xiangmu.myapplication.view
 * @filename:ZhiZuView
 * @date :${DATA} 18:35
 */
public interface ZhiZuView extends BaseView {
    void  show(DailyListBean dailyListBean);
    void showBefore(DailyBeforeListBean dataBe);
}
