package com.example.xiangmu.myapplication.activity.sj;

import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SwitchCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

import com.example.xiangmu.myapplication.R;
import com.example.xiangmu.myapplication.app.MyApp;
import com.example.xiangmu.myapplication.greendao.dataBean;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.yanzhenjie.recyclerview.swipe.SwipeMenuRecyclerView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @packge: com.example.xiangmu.myapplication.activity.sj
 * @filename:ApdateSecte
 * @date :${DATA} 18:59
 */
class ApdateSecte extends SwipeMenuRecyclerView.Adapter {

    private List<dataBean> mDataBeans;
    private XuanZheActivity mXuanZheActivity;


    public ApdateSecte(List<dataBean> dataBeans, XuanZheActivity xuanZheActivity) {
        mDataBeans = dataBeans;
        mXuanZheActivity = xuanZheActivity;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mXuanZheActivity).inflate(R.layout.item_select, null, false);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
              final ViewHolder viewHolder= (ViewHolder) holder;
              viewHolder.mItemSelectTv.setText(mDataBeans.get(position).getTitle());
              viewHolder.mSwichSeclt.setChecked(mDataBeans.get(position).getState());
              viewHolder.mSwichSeclt.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                  @Override
                  public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                      dataBean dataBean = mDataBeans.get(position);
                      dataBean.setState(isChecked);
                      MyApp.getSession().getDataBeanDao().update(dataBean);
                  }
              });


    }

    @Override
    public int getItemCount() {
        return mDataBeans.size();
    }

    static class ViewHolder extends SwipeMenuRecyclerView.ViewHolder {
        @BindView(R.id.item_select_tv)
        TextView mItemSelectTv;
        @BindView(R.id.swich_seclt)
        Switch mSwichSeclt;

        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
