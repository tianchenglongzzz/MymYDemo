package com.example.xiangmu.myapplication.fragment.ganhuo;

import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;

import com.example.xiangmu.myapplication.R;
import com.example.xiangmu.myapplication.adapter.ganhuo.GanApdate;
import com.example.xiangmu.myapplication.base.fragment.BaseFragment;
import com.example.xiangmu.myapplication.beans.GanHuoWenZhangBean;
import com.example.xiangmu.myapplication.beans.ganhuo.MeiZhIShuiJiBean;
import com.example.xiangmu.myapplication.presenter.ganhuo.GanHuoPresenter;
import com.example.xiangmu.myapplication.view.GanHuoView;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;

import butterknife.BindView;

/**
 * @packge: com.example.xiangmu.myapplication.fragment.ganhuo
 * @filename:AndroidFragment
 * @date :${DATA} 14:18
 */
public class AndroidFragment  extends BaseFragment<GanHuoView,GanHuoPresenter<GanHuoView>> implements GanHuoView {
        private static final String TAG = "AndroidFragment";

    @BindView(R.id.gan_huo_android)
    XRecyclerView mXRecyclerView;

    private int  page=1;
    private ArrayList<MeiZhIShuiJiBean.ResultsBean> mResultsBeans;
    private ArrayList<GanHuoWenZhangBean.ResultsBean> mGanHuoWenZhangBeans;
    private GanApdate mAndroid;

    @Override
    public GanHuoPresenter ctreatePresrnter() {
        return new GanHuoPresenter();
    }

    @Override
    public void initFrementApdate() {
        super.initFrementApdate();
        mResultsBeans = new ArrayList<>();
        mGanHuoWenZhangBeans = new ArrayList<>();
        mAndroid = new GanApdate(mResultsBeans, mGanHuoWenZhangBeans, "Android");
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        mXRecyclerView.setLayoutManager(linearLayoutManager);
        mXRecyclerView.setAdapter(mAndroid);

    }

    @Override
    public int getViewLayout() {
        return R.layout.frgment_ganh_android;
    }

    @Override
    public void initData() {
 if (perstrnter!=null) {
     perstrnter.getWenzhang("Android", 10, page);
 }
    }

    @Override
    public void showError(String err) {

    }

    @Override
    public void showWenZang(GanHuoWenZhangBean zhangBean) {
        Log.d("TAG",zhangBean.getResults().size()+"");
         mAndroid.replace(zhangBean);
         if (perstrnter!=null) {
             perstrnter.getMeiNv(1);
         }

    }

    @Override
    public void showMeiNV(MeiZhIShuiJiBean meiZhIShuiJiBean) {

         mAndroid.addAll(meiZhIShuiJiBean.getResults());

    }

    @Override
    public void showQuery(GanHuoWenZhangBean ganHuoWenZhangBean) {
        Log.e(TAG,"我拿到数据拉");
          mAndroid.replace(ganHuoWenZhangBean);
    }

    public void  setQuery(final String query){

            perstrnter.getQueryGank(query,"Android",10,page);
        }

}
