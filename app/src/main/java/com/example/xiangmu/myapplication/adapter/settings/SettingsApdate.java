package com.example.xiangmu.myapplication.adapter.settings;

import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.xiangmu.myapplication.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @packge: com.example.xiangmu.myapplication.adapter.settings
 * @filename:SettingsApdate
 * @date :${DATA} 21:13
 */
public class SettingsApdate extends RecyclerView.Adapter {

    private final ArrayList<String> mChanggui;
    private final ArrayList<Integer> mIntegers;
    private final FragmentActivity mActivity;

    public SettingsApdate(ArrayList<String> changgui, ArrayList<Integer> integers, FragmentActivity activity) {
        mChanggui = changgui;
        mIntegers = integers;
        mActivity = activity;


    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mActivity).inflate(R.layout.item_settings, null);
        return new ViewHolder(view);


    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHolder viewHolder = (ViewHolder) holder;
        viewHolder.mSeettingImg.setImageAlpha(mIntegers.get(position));
        viewHolder.mSeettingTv.setText(mChanggui.get(position));
    }

    @Override
    public int getItemCount() {
        return 3;
    }



    static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.seetting_img)
        ImageView mSeettingImg;
        @BindView(R.id.seetting_tv)
        TextView mSeettingTv;
        @BindView(R.id.seetting_check)
        CheckBox mSeettingCheck;

        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

}
