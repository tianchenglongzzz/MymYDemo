package com.example.xiangmu.myapplication.view;

import com.example.xiangmu.myapplication.base.view.BaseView;
import com.example.xiangmu.myapplication.beans.GanHuoWenZhangBean;
import com.example.xiangmu.myapplication.beans.ganhuo.MeiZhIShuiJiBean;

/**
 * @packge: com.example.xiangmu.myapplication.view
 * @filename:GanHuoView
 * @date :${DATA} 14:09
 */
public interface GanHuoView  extends BaseView {
     void showWenZang(GanHuoWenZhangBean zhangBean);
     void showMeiNV(MeiZhIShuiJiBean meiZhIShuiJiBean);
     void showQuery(GanHuoWenZhangBean ganHuoWenZhangBean);
}
