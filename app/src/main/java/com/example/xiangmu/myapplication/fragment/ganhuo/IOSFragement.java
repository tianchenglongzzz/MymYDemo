package com.example.xiangmu.myapplication.fragment.ganhuo;

import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;

import com.example.xiangmu.myapplication.R;
import com.example.xiangmu.myapplication.adapter.ganhuo.GanApdate;
import com.example.xiangmu.myapplication.adapter.ganhuo.GanApdateIos;
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
 * @filename:IOSFragement
 * @date :${DATA} 14:18
 */
public class IOSFragement extends BaseFragment<GanHuoView,GanHuoPresenter<GanHuoView>> implements  GanHuoView {
    private static final String TAG = "IOSFragement";
    @BindView(R.id.gan_huo_ios)
    XRecyclerView mXRecyclerView;

    private int  page=1;
    private ArrayList<MeiZhIShuiJiBean.ResultsBean> mResultsBeans;
    private ArrayList<GanHuoWenZhangBean.ResultsBean> mGanHuoWenZhangBeans;
    private GanApdateIos mIos;
    @Override
    public void initFrementApdate() {
        super.initFrementApdate();
        mResultsBeans = new ArrayList<>();
        mGanHuoWenZhangBeans = new ArrayList<>();
        mIos = new GanApdateIos(mResultsBeans, mGanHuoWenZhangBeans, "IOS");
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        mXRecyclerView.setLayoutManager(linearLayoutManager);
        mXRecyclerView.setAdapter(mIos);

    }
    @Override
    public GanHuoPresenter<GanHuoView> ctreatePresrnter() {
        return new GanHuoPresenter();
    }

    @Override
    public int getViewLayout() {
        return R.layout.fragment_gan_ios;
    }

    @Override
    public void initData() {
        if (perstrnter!=null) {
            perstrnter.getMeiNv(1);
            perstrnter.getWenzhang("iOS", 10, page);
        }
    }

    @Override
    public void showError(String err) {

    }

    @Override
    public void showWenZang(GanHuoWenZhangBean zhangBean) {
          mIos.addAll(zhangBean.getResults());

    }

    @Override
    public void showMeiNV(MeiZhIShuiJiBean meiZhIShuiJiBean) {
        mResultsBeans.addAll(meiZhIShuiJiBean.getResults());
        mIos.notifyDataSetChanged();
    }

    @Override
    public void showQuery(GanHuoWenZhangBean ganHuoWenZhangBean) {
        Log.e(TAG,"我拿到数据拉");
        mIos.replace(ganHuoWenZhangBean.getResults());
    }

    public void  setQuery(final String query){

        perstrnter.getQueryGank(query,"iOS",10,page);
    }
}
