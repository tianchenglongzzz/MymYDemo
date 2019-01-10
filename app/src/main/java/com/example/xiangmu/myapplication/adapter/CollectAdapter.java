package com.example.xiangmu.myapplication.adapter;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.xiangmu.myapplication.MainActivity;
import com.example.xiangmu.myapplication.R;
import com.example.xiangmu.myapplication.activity.SJXqActivity;
import com.example.xiangmu.myapplication.activity.ganhuo.FuliActivity;
import com.example.xiangmu.myapplication.activity.ganhuo.GanActivity;
import com.example.xiangmu.myapplication.activity.weixin.WeiXinActivity;
import com.example.xiangmu.myapplication.base.activity.zhihu.ZhiHuDataActivity;
import com.example.xiangmu.myapplication.greendao.ScBean;
import com.example.xiangmu.myapplication.utils.ImgUtis;
import com.facebook.drawee.view.SimpleDraweeView;
import com.yanzhenjie.recyclerview.swipe.SwipeMenuRecyclerView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @packge: com.example.xiangmu.myapplication.adapter
 * @filename:CollectAdapter
 * @date :${DATA} 10:24
 */
public class CollectAdapter extends SwipeMenuRecyclerView.Adapter {
    private final FragmentActivity activity;
    private List<ScBean> scBeans;

    public CollectAdapter(List<ScBean> scBeans, FragmentActivity activity) {
        this.scBeans = scBeans;
        this.activity = activity;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(activity).inflate(R.layout.item_collect, null);


        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
       ViewHolder viewHolder= (ViewHolder)holder;
      if (!scBeans.get(position).getType().equals("福利")) {
          viewHolder.mCollectTitle.setText(scBeans.get(position).getTitle());
      }
      if (scBeans.get(position).getType().equals("福利")){
          DisplayMetrics dm = activity.getResources().getDisplayMetrics();
         int width = dm.widthPixels;
        int   height = dm.heightPixels;
          ViewGroup.LayoutParams layoutParams = viewHolder.mCardView.getLayoutParams();
          layoutParams.height=height/3-((height/3)/10);
          viewHolder.mCardView.setLayoutParams(layoutParams);
          LinearLayout.LayoutParams layout= (LinearLayout.LayoutParams) viewHolder.mCollectImg.getLayoutParams();
       layout.height=height/4;
       layout.width=width+(width/10);
       layout.setMargins(0,0,0,0);
        viewHolder.mCollectImg.setLayoutParams(layout);
          viewHolder.mCollectTitle.setText("");
      }
       if (scBeans.get(position).getType().equals("干货")){
            viewHolder.mCollectImg.setImageResource(scBeans.get(position).getNwsId());
       }else {
           ImgUtis.setFace(scBeans.get(position).getImgurl(),viewHolder.mCollectImg,activity);
       }

        viewHolder.mCollectType.setText(scBeans.get(position).getType());
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                  if (scBeans.get(position).getType().equals("知乎")){
                      Intent intent = new Intent(activity, ZhiHuDataActivity.class);
                      intent.putExtra("id",scBeans.get(position).getNwsId());
                      activity.startActivity(intent);
                  }
                  if (scBeans.get(position).getType().equals("微信")){
                      Intent intent = new Intent(activity,WeiXinActivity.class);
                      intent.putExtra("title",scBeans.get(position).getTitle());
                      intent.putExtra("url",scBeans.get(position).getConent());
                      intent.putExtra("img",scBeans.get(position).getImgurl());
                      activity.startActivity(intent);
                  }
                  if (scBeans.get(position).getType().equals("干货")){
                      Intent intent = new Intent(activity, GanActivity.class);
                      intent.putExtra("name",scBeans.get(position).getConent());
                      intent.putExtra("title",scBeans.get(position).getTitle());
                      intent.putExtra("img",scBeans.get(position).getNwsId());
                     activity.startActivity(intent);
                  }
                  if (scBeans.get(position).getType().equals("福利")){
                      Intent intent = new Intent(activity, FuliActivity.class);
                      intent.putExtra("name",scBeans.get(position).getImgurl());
                      activity.startActivity(intent);
                  }
                  if (scBeans.get(position).getType().equals("数据智慧")){
                      Intent intent = new Intent(activity, SJXqActivity.class);
                      intent.putExtra("name",scBeans.get(position).getConent());
                      intent.putExtra("img",scBeans.get(position).getImgurl());
                      activity.startActivity(intent);
                  }
            }
        });

    }

    @Override
    public int getItemCount() {
        return scBeans.size();
    }

    static class ViewHolder extends  SwipeMenuRecyclerView.ViewHolder{


        @BindView(R.id.card)
        CardView mCardView;
        @BindView(R.id.collect_img)
        SimpleDraweeView mCollectImg;
        @BindView(R.id.collect_type)
        TextView mCollectType;
        @BindView(R.id.collect_title)
        TextView mCollectTitle;

        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
