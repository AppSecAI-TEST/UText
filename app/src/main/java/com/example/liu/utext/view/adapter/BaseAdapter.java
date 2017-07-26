package com.example.liu.utext.view.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public abstract class BaseAdapter<T> extends RecyclerView.Adapter<BaseViewHolder> {

    private List<T> mDatas;
    private int mLayoutId;
    private OnItemClickListener mOnItemClickListener;

    BaseAdapter(int layoutId, List<T> datas) {
        mDatas = datas;
        mLayoutId = layoutId;
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(mLayoutId, parent, false);
        BaseViewHolder viewHolder = new BaseViewHolder(view, mOnItemClickListener);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        T item = getItem(position);
        convert(holder, item);
    }

    protected abstract void convert(BaseViewHolder holder, T item);

    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    public T getItem(int position) {
        if (position >= mDatas.size()) return null;
        return mDatas.get(position);
    }

    public void clear() {
        int size = mDatas.size();
        mDatas.clear();
        notifyItemRangeRemoved(0, size);
    }

    void insert(int position, T data) {
        mDatas.add(position, data);
        notifyItemInserted(position);
    }

    public void insertAll(int position, List<T> data) {
        mDatas.addAll(position, data);
        notifyItemRangeInserted(position, data.size());
    }

    public void add(T data) {
        mDatas.add(data);
        notify();
    }

    public void addAll(List<T> data) {
        int size = mDatas.size();
        mDatas.addAll(data);
        notifyItemRangeChanged(size, data.size());
    }

    public void remove(int position) {
        mDatas.remove(position);
        notifyItemRemoved(position);
    }

    public void move(int fromPosition, int toPosition) {
        T item = mDatas.remove(fromPosition);
        insert(toPosition, item);
        notifyItemMoved(fromPosition, toPosition);
    }

    public List<T> getDatas(){
        return mDatas;
    }

    public interface OnItemClickListener {
        void onItemClick(View view, int position);
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener){
        mOnItemClickListener = onItemClickListener;
    }
}
