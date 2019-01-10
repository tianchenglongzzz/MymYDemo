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
public class LongFragment extends BaseFragment<CommentView,CommPresenter<CommentView>> implements CommentView {
  private  int id;
    @BindView(R.id.long_xr)
  XRecyclerView mXRecyclerViewx;
    @SuppressLint("ValidFragment")
    public LongFragment(int id) {
      this.id=id;
        // Required empty public constructor
    }


    @Override
    public CommPresenter<CommentView> ctreatePresrnter() {
        return new CommPresenter();
    }

    @Override
    public int getViewLayout() {
        return R.layout.fragment_long;
    }

    @Override
    public void initData() {
          perstrnter.getCommmentLongCallBack(id);
    }

    @Override
    public void show(CommentBean commentBean) {
      CommentsApdate commentsApdate = new CommentsApdate(commentBean);
        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        mXRecyclerViewx.setLayoutManager(manager);
        mXRecyclerViewx.setAdapter(commentsApdate);


    }

  @Override
  public void showError(String err) {

  }
}
