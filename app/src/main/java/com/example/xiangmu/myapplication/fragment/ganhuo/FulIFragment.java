package com.example.xiangmu.myapplication.fragment.ganhuo;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.StaggeredGridLayoutManager;

import com.example.xiangmu.myapplication.R;
import com.example.xiangmu.myapplication.adapter.ganhuo.MeiZhiApdate;
import com.example.xiangmu.myapplication.base.fragment.BaseFragment;
import com.example.xiangmu.myapplication.beans.GanHuoWenZhangBean;
import com.example.xiangmu.myapplication.beans.ShuJuZhiHuiBean;
import com.example.xiangmu.myapplication.beans.ZhihuDetailBean;
import com.example.xiangmu.myapplication.beans.ganhuo.MeiZhIShuiJiBean;
import com.example.xiangmu.myapplication.presenter.ganhuo.GanHuoPresenter;
import com.example.xiangmu.myapplication.view.GanHuoView;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import butterknife.BindView;

/**
 * @packge: com.example.xiangmu.myapplication.fragment.ganhuo
 * @filename:FulIFragment
 * @date :${DATA} 14:30
 */
public class FulIFragment extends BaseFragment<GanHuoView,GanHuoPresenter<GanHuoView>> implements GanHuoView {
    private int mint=1;


    @BindView(R.id.xr_fuli)
    XRecyclerView mXRecyclerView;
    private ArrayList<GanHuoWenZhangBean.ResultsBean> mResultsBeans;
    private StaggeredGridLayoutManager mStaggeredGridLayoutManager;
    private MeiZhiApdate mMeiZhiApdate;

    private static ArrayList<Bitmap> sBitmaps=new ArrayList<>();


    @Override
    public GanHuoPresenter<GanHuoView> ctreatePresrnter() {
        return new GanHuoPresenter();
    }

    @Override
    public void initFrementApdate() {
        super.initFrementApdate();
        mResultsBeans = new ArrayList<>();
        mStaggeredGridLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        mMeiZhiApdate = new MeiZhiApdate(mResultsBeans,getActivity());
        //解决左右切换问题
        mStaggeredGridLayoutManager.setGapStrategy(StaggeredGridLayoutManager.GAP_HANDLING_NONE);
        mXRecyclerView.setLayoutManager(mStaggeredGridLayoutManager);
        mXRecyclerView.setAdapter(mMeiZhiApdate);
        mXRecyclerView.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
               mint=1;
                perstrnter.getWenzhang("福利",10,mint);
                mXRecyclerView.refreshComplete();

            }

            @Override
            public void onLoadMore() {
                mint++;
                perstrnter.getWenzhang("福利",10,mint);
                mXRecyclerView.loadMoreComplete();
            }
        });

    }

    @Override
    public int getViewLayout() {
       return  R.layout.fragment_full;
    }

    @Override
    public void initData() {
      perstrnter.getWenzhang("福利",10,mint);
    }

    @Override
    public void showError(String err) {

    }



    @Override
    public void showWenZang(GanHuoWenZhangBean zhangBean) {

        mResultsBeans.addAll(zhangBean.getResults());
        mMeiZhiApdate.notifyDataSetChanged();



    }

    @Override
    public void showMeiNV(MeiZhIShuiJiBean meiZhIShuiJiBean) {

    }

    @Override
    public void showQuery(GanHuoWenZhangBean ganHuoWenZhangBean) {

    }


}
