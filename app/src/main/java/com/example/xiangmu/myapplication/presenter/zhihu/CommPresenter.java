package com.example.xiangmu.myapplication.presenter.zhihu;

import com.example.xiangmu.myapplication.base.prensenter.IBasePresenter;
import com.example.xiangmu.myapplication.beans.CommentBean;
import com.example.xiangmu.myapplication.module.ZhihuModle;
import com.example.xiangmu.myapplication.view.CommentView;

/**
 * @packge: com.example.xiangmu.myapplication.presenter.zhihu
 * @filename:CommPresenter
 * @date :${DATA} 20:58
 */
public class CommPresenter<V extends CommentView> extends IBasePresenter<V> implements ZhihuModle.CommenCallback {

   ZhihuModle mZhihuModle= new ZhihuModle();

    public  void getCommmentLongCallBack(int id){
        mZhihuModle.getCommenLongBean(this,id);
    }
    public  void getCommmentStortCallBack(int id){
      mZhihuModle.getCommenStortBean(this,id);
    }
    @Override
    public void setCommenLongCallback(CommentBean commentBean) {
         mview.show(commentBean);
    }

    @Override
    public void setCommenStortCallback(CommentBean commentBean) {
        mview.show(commentBean);
    }



}
