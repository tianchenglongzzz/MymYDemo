package com.example.xiangmu.myapplication.presenter.SJ;

import android.util.Log;

import com.example.xiangmu.myapplication.base.prensenter.BaserPresrnter;
import com.example.xiangmu.myapplication.base.prensenter.IBasePresenter;
import com.example.xiangmu.myapplication.beans.ShuJuZhiHuiBean;
import com.example.xiangmu.myapplication.module.ShuJuModel;
import com.example.xiangmu.myapplication.view.SJView;

/**
 * @packge: com.example.xiangmu.myapplication.presenter.SJ
 * @filename:SJPersenter
 * @date :${DATA} 10:12
 */
public class SJPersenter<V extends SJView> extends IBasePresenter<V> implements ShuJuModel.SJCallBack{
     ShuJuModel mShuJuModel=new ShuJuModel();
    public  void  getSjuzihui(String name, int page){
               mShuJuModel.getSJBean(this,name,page);
    }
    @Override
    public void setSJBean(ShuJuZhiHuiBean shuJuZhiHuiBean) {

              mview.showSJBean(shuJuZhiHuiBean);
    }


}
