package com.example.xiangmu.myapplication.presenter.zhihu;

import com.example.xiangmu.myapplication.base.prensenter.IBasePresenter;
import com.example.xiangmu.myapplication.beans.DetailExtraBean;
import com.example.xiangmu.myapplication.beans.ZhihuDetailBean;
import com.example.xiangmu.myapplication.module.ZhihuModle;
import com.example.xiangmu.myapplication.view.XiangQingView;

/**
 * @packge: com.example.xiangmu.myapplication.presenter.zhihu
 * @filename:XiangQingPresenter
 * @date :${DATA} 14:58
 */
public class XiangQingPresenter<V extends XiangQingView> extends IBasePresenter<V> implements ZhihuModle.XiangQingCallback {
  ZhihuModle mZhihuModle=   new ZhihuModle();
     public  void getZhihuDetailBean(int id){
           mZhihuModle.getZhihuDetailBean(this,id);

     }
    public  void getDetailExtraBean(int id){
        mZhihuModle.getDetailExtraBean(this,id);

    }
    @Override
    public void setZhihuDetailBean(ZhihuDetailBean zhihuDetailBean) {
              mview.show(zhihuDetailBean);
    }

    @Override
    public void setDetailExtraBean(DetailExtraBean data) {
          mview.showDetailExtraBean(data);
    }


}
