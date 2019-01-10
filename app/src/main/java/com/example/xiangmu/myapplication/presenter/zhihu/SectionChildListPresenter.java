package com.example.xiangmu.myapplication.presenter.zhihu;

import com.example.xiangmu.myapplication.base.prensenter.IBasePresenter;
import com.example.xiangmu.myapplication.beans.SectionChildListBean;
import com.example.xiangmu.myapplication.module.ZhihuModle;
import com.example.xiangmu.myapplication.view.SectionChildListView;

/**
 * @packge: com.example.xiangmu.myapplication.presenter.zhihu
 * @filename:SectionChildListPresenter
 * @date :${DATA} 16:36
 */
public class SectionChildListPresenter<V extends SectionChildListView> extends IBasePresenter<V> implements ZhihuModle.SectionChildCallBack {

      ZhihuModle mZhihuModle=new ZhihuModle();
     public  void  getSectionChildListBean(int id){
         mZhihuModle.getSectionChildListBean(this,id);
     }

    @Override
    public void setSectionChildListBean(SectionChildListBean dataBean) {
            mview.show(dataBean);
    }


}
