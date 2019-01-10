package com.example.xiangmu.myapplication.activity.sj;

import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;

import com.example.xiangmu.myapplication.R;
import com.example.xiangmu.myapplication.app.MyApp;
import com.example.xiangmu.myapplication.base.activity.SimpleActivity;
import com.example.xiangmu.myapplication.greendao.dataBean;
import com.yanzhenjie.recyclerview.swipe.SwipeMenuRecyclerView;
import com.yanzhenjie.recyclerview.swipe.touch.OnItemMoveListener;

import java.util.Collections;
import java.util.List;

import butterknife.BindView;

/**
 * @packge: com.example.xiangmu.myapplication.activity.sj
 * @filename:XuanZheActivity
 * @date :${DATA} 13:56
 */
public class XuanZheActivity extends SimpleActivity {


    @BindView(R.id.select_xr)
    SwipeMenuRecyclerView mSelectXr;
    @BindView(R.id.tool_bar)
    Toolbar mToolbar;
    private List<dataBean> mDataBeans;
    private ApdateSecte mApdateSecte;

    @Override
    public void viewCreated(View view) {
        super.viewCreated(view);
        setTooBar(mToolbar,"修改");
        mDataBeans = MyApp.getSession().getDataBeanDao().loadAll();
        mApdateSecte = new ApdateSecte(mDataBeans,this);
        final LinearLayoutManager manager = new LinearLayoutManager(this);
        mSelectXr.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
        mSelectXr.setLayoutManager(manager);
        mSelectXr.setLongPressDragEnabled(true);// 开启长按拖拽
        mSelectXr.setAdapter(mApdateSecte);

        mSelectXr.setOnItemMoveListener(new OnItemMoveListener() {
            @Override
            public boolean onItemMove(int fromPosition, int toPosition) {
                MyApp.getSession().getDataBeanDao().deleteAll();
                Collections.swap(mDataBeans,fromPosition,toPosition);
                for (int i = 0; i <mDataBeans.size(); i++) {

                    MyApp.getSession().getDataBeanDao().insert(new dataBean(null,mDataBeans.get(i).getTitle(),mDataBeans.get(i).getState()));
                }
                mApdateSecte.notifyItemMoved(fromPosition,toPosition);
                return false;
            }

            @Override
            public void onItemDismiss(int position) {

            }
        });

    }

    @Override
    protected void initData() {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

    }

    @Override
    protected int createLayoutId() {
        return R.layout.activity_xuanzhe;
    }




}
