package com.example.xiangmu.myapplication.fragment.zhihupinglun;


import android.annotation.SuppressLint;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;

import com.example.xiangmu.myapplication.R;
import com.example.xiangmu.myapplication.adapter.CommentsApdate;
import com.example.xiangmu.myapplication.base.fragment.BaseFragment;
import com.example.xiangmu.myapplication.beans.CommentBean;
import com.example.xiangmu.myapplication.presenter.zhihu.CommPresenter;
import com.example.xiangmu.myapplication.view.CommentView;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import butterknife.BindView;

/**
 * A simple {@link Fragment} subclass.
 */
@SuppressLint("ValidFragment")
public class StortFragment extends BaseFragment<CommentView,CommPresenter<CommentView>> implements CommentView {
   @BindView(R.id.stortrr_rx)
    XRecyclerView mXRecyclerView;
   private  int id;
    @SuppressLint("ValidFragment")
    public StortFragment(int id) {
        this.id=id;
    }


    @Override
    public CommPresenter<CommentView> ctreatePresrnter() {
        return new CommPresenter();
    }

    @Override
    public int getViewLayout() {
        return R.layout.fragment_stort;
    }

    @Override
    public void initData() {
       perstrnter.getCommmentStortCallBack(id);
    }

    @Override
    public void show(CommentBean commentBean) {
        CommentsApdate commentsApdate = new CommentsApdate(commentBean);
        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        mXRecyclerView.setLayoutManager(manager);
        mXRecyclerView.setAdapter(commentsApdate);
    }

    @Override
    public void showError(String err) {

    }
}
