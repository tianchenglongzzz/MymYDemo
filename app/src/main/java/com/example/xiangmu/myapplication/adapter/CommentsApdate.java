package com.example.xiangmu.myapplication.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
/*import com.bumptech.glide.request.RequestOptions;*/
import com.example.xiangmu.myapplication.R;
import com.example.xiangmu.myapplication.beans.CommentBean;
import com.example.xiangmu.myapplication.utils.DateUtil;
import com.example.xiangmu.myapplication.utils.ImgUtis;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @packge: com.example.xiangmu.myapplication.adapter
 * @filename:CommentsLongApdate
 * @date :${DATA} 8:29
 */
public class CommentsApdate extends XRecyclerView.Adapter {

    private static final int STATE_NULL = 0;    //未知
    private static final int STATE_NONE = 1;    //无需展开
    private static final int STATE_EXPAND = 2;  //已展开
    private static final int STATE_SHRINK = 3;  //已收缩

    private static final int MAX_LINE = 2;  //起始最多显示2行
    private final CommentBean mCommentBean;

    private Context mContext;
    private final List<CommentBean.CommentsBean> mComments;

    public CommentsApdate(CommentBean commentBean) {
        mComments = commentBean.getComments();
        mCommentBean = commentBean;


    }



    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        mContext = parent.getContext();
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_comments, null);
        ViewHolder holder = new ViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        final ViewHolder viewHolder = (ViewHolder) holder;
     /*   RequestOptions mRequestOptions = RequestOptions.circleCropTransform()
                .diskCacheStrategy(DiskCacheStrategy.NONE)//不做磁盘缓存
                .skipMemoryCache(true);//不做内存缓存*/
        //apply(mRequestOptions)
        ImgUtis.setimg(mComments.get(position).getAvatar(),mContext,viewHolder.mCivCommentFace);
        viewHolder.mTvCommentName.setText(mComments.get(position).getAuthor());
        viewHolder.mTvCommentContent.setText(mComments.get(position).getContent());
        viewHolder.mTvCommentTime.setText(DateUtil.formatTime2String(mComments.get(position).getTime()));
        if (mComments.get(position).getReply_to()!= null && mComments.get(position).getReply_to().getId() != 0) {
            viewHolder.mTvCommentReply.setVisibility(View.VISIBLE);
            SpannableString ss = new SpannableString("@" + mComments.get(position).getReply_to().getAuthor() + ": " + mComments.get(position).getReply_to().getContent());
            ss.setSpan(new ForegroundColorSpan(ContextCompat.getColor(mContext,R.color.colorPrimary)), 0,mComments.get(position).getReply_to().getAuthor().length() + 2 , Spanned.SPAN_INCLUSIVE_INCLUSIVE);
//            holder.tvReply.setText(String.format("@%s: %s",info.getReply_to().getAuthor(),info.getReply_to().getContent()));
            viewHolder.mTvCommentReply.setText(ss);
            if (mComments.get(position).getReply_to().getExpandState() == STATE_NULL) {
                if ( mComments.get(viewHolder.getAdapterPosition()).getReply_to()!=null     ){//未知
                viewHolder.mTvCommentReply.post(new Runnable() {
                    @Override
                    public void run() {
                        if (viewHolder.mTvCommentReply.getLineCount() > MAX_LINE) {
                            viewHolder.mTvCommentReply.setMaxLines(MAX_LINE);
                            viewHolder.mTvCommentExpand.setVisibility(View.VISIBLE);
                            viewHolder.mTvCommentExpand.setText("展开");
                            Log.e("null", viewHolder + "=========" + mComments + "=======" + mComments.get(viewHolder.getAdapterPosition()).getReply_to());
                            mComments.get(viewHolder.getAdapterPosition()).getReply_to().setExpandState(STATE_SHRINK);
                            viewHolder.mTvCommentExpand.setOnClickListener(new OnStateClickListener(viewHolder.getAdapterPosition(), viewHolder.mTvCommentReply));
                        } else {
                            if (viewHolder != null && viewHolder.mTvCommentExpand != null) {
                                viewHolder.mTvCommentExpand.setVisibility(View.GONE);
                                mComments.get(viewHolder.getAdapterPosition()).getReply_to().setExpandState(STATE_NONE);
                            }
                        }
                    }
                });
            }
            } else if(mComments.get(position).getReply_to().getExpandState() == STATE_NONE) {  //无需展开
                viewHolder.mTvCommentExpand.setVisibility(View.GONE);
            } else if(mComments.get(position).getReply_to().getExpandState() == STATE_EXPAND) {    //已展开
                viewHolder.mTvCommentReply.setMaxLines(Integer.MAX_VALUE);
                viewHolder.mTvCommentExpand.setText("收起");
                viewHolder.mTvCommentExpand.setVisibility(View.VISIBLE);
                viewHolder.mTvCommentExpand.setOnClickListener(new OnStateClickListener(holder.getAdapterPosition(), viewHolder.mTvCommentReply));
            } else {    //已收缩
                viewHolder.mTvCommentExpand.setMaxLines(MAX_LINE);
                viewHolder.mTvCommentExpand.setText("展开");
                viewHolder.mTvCommentExpand.setVisibility(View.VISIBLE);
                viewHolder.mTvCommentExpand.setOnClickListener(new OnStateClickListener(holder.getAdapterPosition(), viewHolder.mTvCommentReply));
            }
        } else {
            viewHolder.mTvCommentExpand.setVisibility(View.GONE);
            viewHolder.mTvCommentExpand.setVisibility(View.GONE);
        }
    }
    private class OnStateClickListener implements View.OnClickListener {

        TextView replyView;
        int position;

        public OnStateClickListener(int position,TextView replyView) {
            this.position = position;
            this.replyView = replyView;
        }

        @Override
        public void onClick(View view) {
            TextView tv = (TextView) view;
            if (mComments.get(position).getReply_to().getExpandState() == STATE_SHRINK) {
                tv.setText("收起");
                replyView.setMaxLines(Integer.MAX_VALUE);
                replyView.setEllipsize(null);
                mComments.get(position).getReply_to().setExpandState(STATE_EXPAND);
            } else {
                tv.setText("展开");
                replyView.setMaxLines(MAX_LINE);
                replyView.setEllipsize(TextUtils.TruncateAt.END);
                mComments.get(position).getReply_to().setExpandState(STATE_SHRINK);
            }
        }
    }
    @Override
    public int getItemCount() {
        return mComments.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.civ_comment_face)
        ImageView mCivCommentFace;
        @BindView(R.id.tv_comment_name)
        TextView mTvCommentName;
        @BindView(R.id.tv_comment_content)
        TextView mTvCommentContent;
        @BindView(R.id.tv_comment_reply)
        TextView mTvCommentReply;
        @BindView(R.id.tv_comment_time)
        TextView mTvCommentTime;
        @BindView(R.id.tv_comment_expand)
        TextView mTvCommentExpand;
        @BindView(R.id.tv_comment_like)
        TextView mTvCommentLike;

        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
