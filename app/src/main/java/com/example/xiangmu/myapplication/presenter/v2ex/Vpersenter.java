package com.example.xiangmu.myapplication.presenter.v2ex;

import com.example.xiangmu.myapplication.base.prensenter.IBasePresenter;
import com.example.xiangmu.myapplication.beans.TopicListBean;
import com.example.xiangmu.myapplication.module.VexMode;
import com.example.xiangmu.myapplication.view.v2exView;

import java.util.ArrayList;

/**
 * @packge: com.example.xiangmu.myapplication.presenter.v2ex
 * @filename:Vpersenter
 * @date :${DATA} 12:18
 */
public class Vpersenter<V extends v2exView>extends IBasePresenter<V> implements VexMode.TocCallBack {
    VexMode mVexMode=new VexMode();
     public  void  getTpcBean(String name){
          mVexMode.getTocBeanvoid(this,name);
     }
    @Override
    public void setTocBean(ArrayList<TopicListBean> tocBean) {
           mview.showv2ex(tocBean);
    }


}
