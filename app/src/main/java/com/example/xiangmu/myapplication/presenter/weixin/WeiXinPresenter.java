package com.example.xiangmu.myapplication.presenter.weixin;

import android.support.v7.view.menu.MenuView;

import com.example.xiangmu.myapplication.base.prensenter.IBasePresenter;
import com.example.xiangmu.myapplication.beans.WeiXinBean;
import com.example.xiangmu.myapplication.module.WeiXinModel;
import com.example.xiangmu.myapplication.view.weixin.WeiXinView;

/**
 * @packge: com.example.xiangmu.myapplication.presenter.weixin
 * @filename:WeiXinPresenter
 * @date :${DATA} 19:39
 */
public class WeiXinPresenter<V extends WeiXinView> extends IBasePresenter<V> implements WeiXinModel.WeiXinCallBack {

    WeiXinModel mWeiXinModel=new WeiXinModel();
public  void getWeinBean(String key,int num,int page){
    mWeiXinModel.getWeiXinben(this,key,num,page);
}
    public  void getWeinQueryBean(String key,int num,int page,String query){
        mWeiXinModel.getWeiXinbenQuery(this,key,num,page,query);
    }
    @Override
    public void setWinXinBean(WeiXinBean winXinBean) {
          mview.show(winXinBean);
    }


}
