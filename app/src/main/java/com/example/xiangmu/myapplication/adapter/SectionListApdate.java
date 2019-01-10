package com.example.xiangmu.myapplication.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.example.xiangmu.myapplication.R;
import com.example.xiangmu.myapplication.beans.SectionListBean;
import com.example.xiangmu.myapplication.utils.HtmlUtil;
import com.example.xiangmu.myapplication.utils.ImgUtis;
import com.facebook.drawee.view.SimpleDraweeView;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.net.URI;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @packge: com.example.xiangmu.myapplication.adapter
 * @filename:SectionListApdate
 * @date :${DATA} 16:57
 */
public class SectionListApdate extends XRecyclerView.Adapter {


    private final List<SectionListBean.DataBean> data;
    private Context mContext;

    public SectionListApdate(List<SectionListBean.DataBean> data) {
        this.data = data;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        mContext = parent.getContext();
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_section, null);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {

        ViewHolder holder1=(ViewHolder)holder;
        ImgUtis.setFace(data.get(position).getThumbnail(),holder1.mImgS,mContext);
       /* Glide.with(mContext).load(data.get(position).getThumbnail()).apply(RequestOptions.bitmapTransform( new RoundedCorners(20))).into(holder1.mImgS);

            holder1.mTvSa.setText(data.get(position).getDescription());*/

        holder1.mTvSb.setText(data.get(position).getName());
        holder1.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("TAG",mSItemClick+""+data.get(position).getId()+data.get(position).getName());

                mSItemClick.setclick(data.get(position).getId(),data.get(position).getName());
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    static class ViewHolder extends ReWenApdate.ViewHolder {
        @BindView(R.id.img_S)
        SimpleDraweeView mImgS;
        @BindView(R.id.tv_sa)
        TextView mTvSa;
        @BindView(R.id.tv_sb)
        TextView mTvSb;

        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
    private  SItemClick mSItemClick;


    public void setSItemClick(SItemClick SItemClick) {
        mSItemClick = SItemClick;
    }

   public interface  SItemClick{
            void setclick(int id,String title);
        }
}
