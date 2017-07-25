package com.example.liu.utext.view.adapter;

import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

class BaseViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

    private SparseArray<View> mViews;
    private BaseAdapter.OnItemClickListener mOnItemClickListener;
    BaseViewHolder(View itemView, BaseAdapter.OnItemClickListener listener) {
        super(itemView);
        itemView.setOnClickListener(this);
        mViews = new SparseArray<>();
        mOnItemClickListener = listener;
    }

    private <T extends View> T retrieveView(int viewId){
        View view = mViews.get(viewId);
        if (view == null){
            view = itemView.findViewById(viewId);
            mViews.put(viewId,view);
        }
        //noinspection unchecked
        return (T) view;
    }

    TextView getTextView(int viewId){
        return retrieveView(viewId);
    }

    ImageView getImageView(int viewId){
        return retrieveView(viewId);
    }

    public Button getButton(int viewId){
        return retrieveView(viewId);
    }

    public View getView(int viewId){
        return retrieveView(viewId);
    }

    @Override
    public void onClick(View view) {
        if (mOnItemClickListener != null){
            mOnItemClickListener.onItemClick(view,getLayoutPosition());
        }
    }
}
