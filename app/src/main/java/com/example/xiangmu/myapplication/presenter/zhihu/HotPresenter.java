package com.example.xiangmu.myapplication.presenter.zhihu;

import com.example.xiangmu.myapplication.base.prensenter.IBasePresenter;
import com.example.xiangmu.myapplication.beans.HotListBean;
import com.example.xiangmu.myapplication.module.ZhihuModle;
import com.example.xiangmu.myapplication.module.ZhihuModle.HotCallback;
import com.example.xiangmu.myapplication.view.HotView;

/**
 * @packge: com.example.xiangmu.myapplication.presenter.zhihu
 * @filename:HotPresenter
 * @date :${DATA} 19:18
 */
public class HotPresenter<V extends  HotView>  extends IBasePresenter<V>  implements HotCallback {

    ZhihuModle mZhihuModle=  new ZhihuModle();

    public  void   getHotlist(){
  mZhihuModle.getHotListBean(this);
    }

    @Override
    public void setHotListBean(HotListBean data) {
            mview.show(data);
    }


}
