package com.example.xiangmu.myapplication.adapter.ganhuo;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.xiangmu.myapplication.R;
import com.example.xiangmu.myapplication.beans.GanHuoWenZhangBean;
import com.example.xiangmu.myapplication.beans.ganhuo.MeiZhIShuiJiBean;
import com.facebook.drawee.view.SimpleDraweeView;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * @packge: com.example.xiangmu.myapplication.adapter
 * @filename:BefoApdate
 * @date :${DATA} 15:16
 */
public class GanApdateIos extends XRecyclerView.Adapter {


    private static  boolean V = true;
    private final ArrayList<MeiZhIShuiJiBean.ResultsBean> resultsBeans;
    private final ArrayList<GanHuoWenZhangBean.ResultsBean> ganHuoWenZhangBeans;
    private final String tach;
    private Context mContext;
    private IosApdate mAndroidApdate;

    public GanApdateIos(ArrayList<MeiZhIShuiJiBean.ResultsBean> resultsBeans, ArrayList<GanHuoWenZhangBean.ResultsBean> ganHuoWenZhangBeans, String tach) {
        this.resultsBeans = resultsBeans;
        this.ganHuoWenZhangBeans = ganHuoWenZhangBeans;
        this.tach = tach;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        mContext = parent.getContext();
        if (viewType == 0) {

            View view = LayoutInflater.from(mContext).inflate(R.layout.item_ganhuo_img, null);
            return new ViewHolderIMG(view);

        } else {

            View view = LayoutInflater.from(mContext).inflate(R.layout.item_ios, null);
            return new ViewHolderIOS(view);
        }



    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        int itemViewType = getItemViewType(position);
        if (itemViewType == 0) {
            ViewHolderIMG viewHolderIMG = (ViewHolderIMG) holder;
            //  Log.e("======",resultsBeans.get(position).getImages().get(position)+"");
            Log.e("======", resultsBeans + "=====");
            if (resultsBeans.size() != 0) {
                Uri uri = Uri.parse(resultsBeans.get(0).getUrl());
                viewHolderIMG.mGanhuoSimFace.setImageURI(uri);
                viewHolderIMG.tv_name.setText(resultsBeans.get(0).getWho());
            }

        } else {
            if (V) {
                V=false;
                ViewHolderIOS viewHolder = (ViewHolderIOS) holder;
                mAndroidApdate = new IosApdate(ganHuoWenZhangBeans);
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(mContext);
                viewHolder.mXrIosItem.setLayoutManager(linearLayoutManager);
                viewHolder.mXrIosItem.setAdapter(mAndroidApdate);
            }else {
                V=true;
                if (ganHuoWenZhangBeans!=null) {
                    if (mAndroidApdate != null) {
                        mAndroidApdate.addAll(ganHuoWenZhangBeans);
                    }
                }
            }

        }


    }


    @Override
    public int getItemCount() {
        return 2;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return 0;
        } else {
            return 1;
        }


    }

    public void addAll(List<GanHuoWenZhangBean.ResultsBean> results) {
        ganHuoWenZhangBeans.addAll(results);
        notifyDataSetChanged();
    }

    public void replace(List<GanHuoWenZhangBean.ResultsBean> results) {
         ganHuoWenZhangBeans.clear();
          ganHuoWenZhangBeans.addAll(results);
          notifyDataSetChanged();
    }


    class ViewHolderIMG extends RecyclerView.ViewHolder {

        SimpleDraweeView mGanhuoSimFace;
        TextView tv_name;
        ViewHolderIMG(View view) {
            super(view);
            tv_name=view.findViewById(R.id.gan_text_name);
            mGanhuoSimFace = view.findViewById(R.id.gan_sim_face);
        }
    }

    class ViewHolderIOS extends RecyclerView.ViewHolder {

        XRecyclerView mXrIosItem;

        ViewHolderIOS(View view) {
            super(view);

           mXrIosItem=view.findViewById(R.id.xr_ios_item);
        }
    }

}
