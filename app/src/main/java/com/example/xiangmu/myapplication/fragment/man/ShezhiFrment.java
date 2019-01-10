package com.example.xiangmu.myapplication.fragment.man;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatDelegate;
import android.support.v7.widget.AppCompatCheckBox;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.xiangmu.myapplication.MainActivity;
import com.example.xiangmu.myapplication.R;
import com.example.xiangmu.myapplication.base.fragment.SimpeFragment;
import com.example.xiangmu.myapplication.base.prensenter.BaserPresrnter;
import com.example.xiangmu.myapplication.utils.DataCleanManager;


import butterknife.BindView;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * @packge: com.example.xiangmu.myapplication.fragment.man
 * @filename:ShezhiFrment
 * @date :${DATA} 11:12
 */
public class ShezhiFrment extends SimpeFragment {


    @BindView(R.id.cb_setting_cache)
    AppCompatCheckBox mCbSettingCache;
    @BindView(R.id.cb_setting_image)
    AppCompatCheckBox mCbSettingImage;
    @BindView(R.id.cb_setting_night)
    AppCompatCheckBox mCbSettingNight;
    @BindView(R.id.ll_setting_feedback)
    LinearLayout mLlSettingFeedback;
    @BindView(R.id.tv_setting_clear)
    TextView mTvSettingClear;
    @BindView(R.id.ll_setting_clear)
    LinearLayout mLlSettingClear;
    @BindView(R.id.tv_setting_update)
    TextView mTvSettingUpdate;
    @BindView(R.id.ll_setting_update)
    LinearLayout mLlSettingUpdate;
    private View view;
    private Unbinder unbinder;
    private SharedPreferences.Editor mEdit;
    private SharedPreferences mCc;
    private boolean mMm;

    @Override
    public void initFrementApdate() {
        super.initFrementApdate();
        mCc = getActivity().getSharedPreferences("cc", Context.MODE_PRIVATE);
        setNight();
        setIMG();
        try {
            getNeicun();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    private void getNeicun() throws Exception {
        mTvSettingClear.setText(DataCleanManager.getCacheSize(Environment.getDataDirectory().getAbsoluteFile()));
    }

    private void setIMG() {
        mMm = mCc.getBoolean("mv", false);
        mCbSettingImage.setChecked(mMm);
        mCbSettingImage.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                SharedPreferences.Editor edit = mCc.edit();
                edit.putBoolean("mv",isChecked);
                edit.commit();
            }
        });
    }

    private void setNight() {
        boolean name = mCc.getBoolean("name", true);
        mCbSettingNight.setChecked(name);
        mCbSettingNight.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    getEdit(mCc, isChecked);

                    AppCompatDelegate.setDefaultNightMode(
                            AppCompatDelegate.MODE_NIGHT_YES);
                     MainActivity mainActivity= (MainActivity) mActivity;
                     mainActivity.setTooBatNight();
                    mActivity.recreate();
                } else {
                    getEdit(mCc, isChecked);
                    AppCompatDelegate.setDefaultNightMode(
                            AppCompatDelegate.MODE_NIGHT_NO);
                    mActivity.recreate();
                }
            }
        });
    }

    private void getEdit(SharedPreferences cc,boolean isChecked) {
        mEdit = cc.edit();
        mEdit.putBoolean("name",isChecked);
        mEdit.commit();
    }

    @Override
    public BaserPresrnter ctreatePresrnter() {
        return null;
    }

    @Override
    public int getViewLayout() {
        return R.layout.fragment_shezhi;
    }

    @Override
    public void initData() {

    }




    @OnClick({R.id.cb_setting_cache, R.id.cb_setting_image, R.id.cb_setting_night, R.id.ll_setting_feedback, R.id.tv_setting_clear, R.id.ll_setting_clear, R.id.tv_setting_update, R.id.ll_setting_update})
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.cb_setting_cache:
                break;
            case R.id.cb_setting_image:
                break;
            case R.id.cb_setting_night:
               // setNieit();
                break;
            case R.id.ll_setting_feedback:
                break;
            case R.id.tv_setting_clear:
                break;
            case R.id.ll_setting_clear:

                break;
            case R.id.tv_setting_update:
                break;
            case R.id.ll_setting_update:
                break;
        }
    }


}
