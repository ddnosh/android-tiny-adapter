package com.androidwind.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * @author ddnosh
 * @website http://blog.csdn.net/ddnosh
 */
public abstract class TinyAdapter<T> extends RecyclerView.Adapter<TinyViewHolder> {

    private Context mContext;
    private List<T> mList;
    private int mResId;

    public TinyAdapter(Context context, List<T> list, int resId) {
        this.mContext = context;
        this.mList = list;
        this.mResId = resId;
    }

    @Override
    public TinyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(mResId, parent, false);
        return new TinyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TinyViewHolder tinyViewHolder, int position) {
        onHandler(tinyViewHolder, mList.get(position));
    }

    public abstract void onHandler(TinyViewHolder tinyViewHolder, T t);

    @Override
    public int getItemCount() {
        return mList.size();
    }

}
