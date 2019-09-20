package com.androidwind.adapter;

import android.util.SparseArray;
import android.view.View;

/**
 * @author ddnosh
 * @website http://blog.csdn.net/ddnosh
 */
public class ViewUtil {

    @SuppressWarnings("unchecked")
    public static <T extends View> T get(View view, int id) {
        if (view == null) {
            throw new NullPointerException("itemView could not be null!!!");
        }
        SparseArray<View> viewHolder = (SparseArray<View>) view.getTag();
        if (viewHolder == null) {
            viewHolder = new SparseArray<View>();
            view.setTag(viewHolder);
        }
        View childView = viewHolder.get(id);
        if (childView == null) {
            childView = view.findViewById(id);
            viewHolder.put(id, childView);
        }
        return (T) childView;
    }
}
