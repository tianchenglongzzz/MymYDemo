package com.example.xiangmu.myapplication.presenter.SJ;

import android.util.Log;

import com.example.xiangmu.myapplication.base.prensenter.BaserPresrnter;
import com.example.xiangmu.myapplication.base.prensenter.IBasePresenter;
import com.example.xiangmu.myapplication.beans.XiangQingBean;
import com.example.xiangmu.myapplication.module.ShuJuModel;
import com.example.xiangmu.myapplication.view.SJView;
import com.example.xiangmu.myapplication.view.SJXQView;
import com.example.xiangmu.myapplication.view.XiangQingView;

/**
 * @packge: com.example.xiangmu.myapplication.presenter.SJ
 * @filename:XQPersenter
 * @date :${DATA} 19:19
 */
public class XQPersenter<V extends SJXQView>  extends IBasePresenter<V> implements ShuJuModel.XiangQingCallback{
  ShuJuModel mShuJuModel =   new ShuJuModel();
public  void   getXiangQingBean(String name){
       mShuJuModel.getXqBean(this,name);

}
    @Override
    public void setSJBean(XiangQingBean xiangQingBean) {
        Log.d("show","我拿到数据拉");
                mview.show(xiangQingBean);

    }


}
