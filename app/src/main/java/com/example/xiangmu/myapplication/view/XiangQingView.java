package com.example.xiangmu.myapplication.view;

import com.example.xiangmu.myapplication.base.view.BaseView;
import com.example.xiangmu.myapplication.beans.DetailExtraBean;
import com.example.xiangmu.myapplication.beans.ZhihuDetailBean;

/**
 * @packge: com.example.xiangmu.myapplication.view
 * @filename:XiangQingView
 * @date :${DATA} 15:00
 */
public interface XiangQingView extends BaseView {
  void   show(ZhihuDetailBean zhihuDetailBean);
   void  showDetailExtraBean(DetailExtraBean data);
}
