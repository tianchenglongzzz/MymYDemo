package com.example.xiangmu.myapplication.presenter.ganhuo;

import com.example.xiangmu.myapplication.base.prensenter.IBasePresenter;
import com.example.xiangmu.myapplication.beans.GanHuoWenZhangBean;
import com.example.xiangmu.myapplication.beans.ganhuo.MeiZhIShuiJiBean;
import com.example.xiangmu.myapplication.module.GankModel;
import com.example.xiangmu.myapplication.view.GanHuoView;

/**
 * @packge: com.example.xiangmu.myapplication.presenter.ganhuo
 * @filename:GanHuoPresenter
 * @date :${DATA} 14:08
 */
public class GanHuoPresenter<V extends GanHuoView> extends IBasePresenter<V> implements GankModel.MeiNVRandomCallBack {
 GankModel mGankModel=new GankModel();

    public  void getMeiNv(int num){
         mGankModel.getMeiZhIShuiJiBean(this,num);
    }
    public  void getWenzhang(String tache,int num,int page) {
        mGankModel.getWenZhangBean(this,tache,num,page);
    }
    public  void  getQueryGank(String query, String type, int num , int page){
             mGankModel.getQueryGank(query,type,num,page,this);
    }
    @Override
    public void setMeiNvList(MeiZhIShuiJiBean bean) {

        mview.showMeiNV(bean);
    }

    @Override
    public void seiWenZHnaglist(GanHuoWenZhangBean bean) {
           mview.showWenZang(bean);
    }

    @Override
    public void setQueryGank(GanHuoWenZhangBean bean) {
       mview.showQuery(bean);
    }


}
