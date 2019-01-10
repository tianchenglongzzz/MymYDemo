package com.example.xiangmu.myapplication.adapter.sj;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.example.xiangmu.myapplication.beans.SelectBean;

import java.util.ArrayList;

/**
 * @packge: com.example.xiangmu.myapplication.adapter.sj
 * @filename:ApdateSectile
 * @date :${DATA} 15:04
 */
public class ApdateSectile extends RecyclerView.Adapter {

    private final ArrayList<SelectBean> mSelectBeans;

    public ApdateSectile(ArrayList<SelectBean> selectBeans) {
        mSelectBeans = selectBeans;

    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
