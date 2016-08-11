package com.haibao.store.myapplication.base;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zzho on 2015/12/30.
 */
public abstract class BaseRecylerAdapter<T> extends RecyclerView.Adapter<MyRecylerViewHolder> implements View.OnLongClickListener, View.OnClickListener {
    protected List<T> mDatas = new ArrayList<T>();
    private int mLayoutId;
    private LayoutInflater mLayoutInflater;

    public BaseRecylerAdapter(Context context,List<T> mDatas, int layoutId) {
        mLayoutInflater = LayoutInflater.from(context);
        this.mLayoutId = layoutId;
        this.mDatas = mDatas;
    }

    @Override
    public MyRecylerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mLayoutInflater.inflate(mLayoutId, parent, false);
        if (mOnItemClickLitener != null)
            view.setOnClickListener(this);
        if (mOnItemLongClickLitener != null)
            view.setOnLongClickListener(this);
        MyRecylerViewHolder holder = new MyRecylerViewHolder(view);
        return holder;
    }

    @Override
    public final void onBindViewHolder(MyRecylerViewHolder holder, int position) {
        holder.getHolderView().setTag(position);
        convert(holder, position);
    }

    public abstract void convert(MyRecylerViewHolder holder, int position);

    public T getItem(int positon) {
        return mDatas != null && mDatas.size() > positon ? mDatas.get(positon) : null;
    }

    @Override
    public int getItemCount() {
        return mDatas == null ? 0 : mDatas.size();
    }

    public void addItem(T item, boolean isNotify) {
        mDatas.add(item);
        if (isNotify)
            notifyDataSetChanged();
    }

    public void addItem(T item) {
        addItem(item, true);
    }

    public void addAllItem(List<T> items, boolean isNotify) {
        mDatas.addAll(items);
        if (isNotify)
            notifyDataSetChanged();
    }

    public void addAllItem(List<T> items) {
        addAllItem(items, true);
    }

    public void clearItems() {
        mDatas.clear();
    }

    public void addAllAndClear(List<T> items) {
        clearItems();
        addAllItem(items);
    }

    public void destroyAdapter() {
        mDatas.clear();
    }


    /**
     * 点击事件的 处理   start
     */

    private OnItemClickLitener mOnItemClickLitener;
    private OnItemLongClickLitener mOnItemLongClickLitener;

    @Override
    public void onClick(View view) {
        int position = (Integer) view.getTag();
        if (mOnItemClickLitener != null)
            mOnItemClickLitener.onItemClick(view, position);
    }

    @Override
    public boolean onLongClick(View view) {
        int position = (Integer) view.getTag();
        if (mOnItemLongClickLitener != null) {
            mOnItemLongClickLitener.onItemLongClick(view, position);
            return true;
        }
        return false;
    }


    public interface OnItemClickLitener {
        void onItemClick(View view, int position);
    }

    public interface OnItemLongClickLitener {
        void onItemLongClick(View view, int position);
    }

    /**
     * 该方法需要在setAdapter之前调用
     */
    public BaseRecylerAdapter<T> setOnItemClickLitener(OnItemClickLitener mOnItemClickLitener) {
        this.mOnItemClickLitener = mOnItemClickLitener;
        return this;
    }

    /**
     * 该方法需要在setAdapter之前调用
     */
    public BaseRecylerAdapter<T> setOnLongItemClickLitener(OnItemLongClickLitener mOnItemLongClickLitener) {
        this.mOnItemLongClickLitener = mOnItemLongClickLitener;
        return this;
    }
}
