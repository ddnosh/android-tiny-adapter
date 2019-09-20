package com.androidwind.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.View;
import android.widget.TextView;

/**
 * @author ddnosh
 * @website http://blog.csdn.net/ddnosh
 */
public class TinyViewHolder extends RecyclerView.ViewHolder {

    private View mView;

    public TinyViewHolder(@NonNull View itemView) {
        super(itemView);
        mView = itemView;
    }

    public void setText(int viewId, String text) {
        TextView tv = ViewUtil.get(mView, viewId);
        tv.setText(text);
    }
}
