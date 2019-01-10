package com.example.xiangmu.myapplication.presenter.zhihu;

import com.example.xiangmu.myapplication.base.prensenter.BaserPresrnter;
import com.example.xiangmu.myapplication.base.prensenter.IBasePresenter;
import com.example.xiangmu.myapplication.beans.SectionListBean;
import com.example.xiangmu.myapplication.module.ZhihuModle;
import com.example.xiangmu.myapplication.view.ZhiZuViewTow;

/**
 * @packge: com.example.xiangmu.myapplication.presenter.zhihu
 * @filename:SectionPresenter
 * @date :${DATA} 16:43
 */
public class SectionPresenter <V extends ZhiZuViewTow> extends IBasePresenter<V> implements ZhihuModle.SectionCallback {
    ZhihuModle mZhihuModle=new ZhihuModle();
    public  void getSectionListBean(){
          mZhihuModle.getSectionListBean(this);

    }
    @Override
    public void setSectionListBean(SectionListBean data) {
          mview.show(data);
    }

}
