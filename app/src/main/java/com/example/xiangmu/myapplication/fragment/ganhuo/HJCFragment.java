package com.example.xiangmu.myapplication.fragment.ganhuo;

import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;

import com.example.xiangmu.myapplication.R;
import com.example.xiangmu.myapplication.adapter.ganhuo.GanApdate;
import com.example.xiangmu.myapplication.adapter.ganhuo.GanApdateHjc;
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
 * @filename:HJCFragment
 * @date :${DATA} 14:20
 */
public class HJCFragment extends BaseFragment<GanHuoView,GanHuoPresenter<GanHuoView>> implements GanHuoView {
    private static final String TAG = "HJCFragment";
    @BindView(R.id.gan_huo_hjc)
    XRecyclerView mXRecyclerView;
    private int  page=1;
    private ArrayList<MeiZhIShuiJiBean.ResultsBean> mResultsBeans;
    private ArrayList<GanHuoWenZhangBean.ResultsBean> mGanHuoWenZhangBeans;
    private GanApdateHjc mAndroid;
    @Override
    public GanHuoPresenter ctreatePresrnter() {

        return  new GanHuoPresenter();
    }    @Override
    public int getViewLayout() {
        return R.layout.fragment_gan_hjc;
    }
    @Override
    public void initFrementApdate() {        super.initFrementApdate();
        mResultsBeans = new ArrayList<>();
        mGanHuoWenZhangBeans = new ArrayList<>();
        mAndroid = new GanApdateHjc(mResultsBeans, mGanHuoWenZhangBeans, "Hjs");
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        mXRecyclerView.setLayoutManager(linearLayoutManager);
        mXRecyclerView.setAdapter(mAndroid);

    }
    @Override
    public void initData() {
        if (perstrnter!=null) {
            perstrnter.getWenzhang("前端", 10, page);
        }
    }

    @Override
    public void showError(String err) {

    }

    @Override
    public void showWenZang(GanHuoWenZhangBean zhangBean) {
          mAndroid.addAll(zhangBean);
    }

    @Override
    public void showMeiNV(MeiZhIShuiJiBean meiZhIShuiJiBean) {
        mResultsBeans.addAll(meiZhIShuiJiBean.getResults());
        mAndroid.notifyDataSetChanged();
    }

    @Override
    public void showQuery(GanHuoWenZhangBean ganHuoWenZhangBean) {
        Log.e(TAG,"我拿到数据拉");

           mAndroid.replace(ganHuoWenZhangBean.getResults());

    }

    public void  setQuery(final String query){

        perstrnter.getQueryGank(query,"前端",10,page);
    }
}
