package com.example.xiangmu.myapplication.activity.zhihu;

import android.support.annotation.NonNull;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.example.xiangmu.myapplication.R;
import com.example.xiangmu.myapplication.base.activity.BaseActivity;
import com.example.xiangmu.myapplication.base.prensenter.BaserPresrnter;
import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.MaterialCalendarView;
import com.prolificinteractive.materialcalendarview.OnDateSelectedListener;

import org.greenrobot.eventbus.EventBus;

import java.text.SimpleDateFormat;
import java.util.Date;

import butterknife.BindView;
import butterknife.OnClick;

public class CalendarActivity extends BaseActivity {

 @BindView(R.id.toobar)
 Toolbar mToolbar;
 @BindView(R.id.tv_calender_enter)
 TextView tv_calender;
 @BindView(R.id.view_calender)
    MaterialCalendarView mMaterialCalendarView;
    private String mReplace;

    @Override
    protected BaserPresrnter createPresenter() {

        return null;
    }

    @Override
    public void viewCreated(View view) {
        super.viewCreated(view);
        setTooBar(mToolbar,"选择日期");
        mMaterialCalendarView.setOnDateChangedListener(new OnDateSelectedListener() {
            @Override
            public void onDateSelected(@NonNull MaterialCalendarView widget, @NonNull CalendarDay date, boolean selected) {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                Date date1 = date.getDate();
                String format = sdf.format(date1);
                String[] split = format.split(" ");
                String timer=split[0];
                mReplace = timer.replace("-", "");
            }
        });

    }

    @OnClick(R.id.tv_calender_enter)
    public  void  getCaleder(){

        EventBus.getDefault().postSticky(mReplace);
        finish();

    }
    @Override
    protected void initData() {

    }

    @Override
    protected int createLayoutId() {
        return R.layout.activity_calendar;
    }
}
