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
public abstract class TinyViewTypeAdapter<T> extends RecyclerView.Adapter<TinyViewHolder> {

    private Context mContext;
    private List<T> mList;
    private IViewType mIViewType;

    public TinyViewTypeAdapter(Context context, List<T> list, IViewType<T> iViewType) {
        this.mContext = context;
        this.mList = list;
        this.mIViewType = iViewType;
    }

    @Override
    public int getItemViewType(int position) {
        return mIViewType.getItemViewType(position, mList.get(position));
    }

    @Override
    public TinyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(mIViewType.getItemView(viewType), parent, false);
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

    public interface IViewType<T> {
        int getItemViewType(int position, T t);

        int getItemView(int viewType);
    }
}
