package com.androidwind.adapter.sample;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.androidwind.adapter.TinyViewHolder;
import com.androidwind.adapter.TinyViewTypeAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ddnosh
 * @website http://blog.csdn.net/ddnosh
 */
public class NewMultipleFragment extends Fragment {

    private RecyclerView rv;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.fragment_adapter, container, false);

        rv = view.findViewById(R.id.rv);

        List<String> data = new ArrayList<>();
        data.add("aaron");
        data.add("bob");
        data.add("charles");
        data.add("dick");
        TinyViewTypeAdapter adapter = new TinyViewTypeAdapter<String>(getContext(), data, new TinyViewTypeAdapter.IViewType<String>() {
            @Override
            public int getItemViewType(int position, String s) {
                if (position % 2 == 0) {
                    return 0;
                } else {
                    return 1;
                }
            }

            @Override
            public int getItemView(int viewType) {
                if (viewType == 0) {
                    return R.layout.item_0;
                } else {
                    return R.layout.item_1;
                }
            }
        }) {
            @Override
            public void onHandler(TinyViewHolder tinyViewHolder, String result) {
                tinyViewHolder.setText(R.id.tv, result);
            }
        };
        rv.setLayoutManager(new LinearLayoutManager(getContext()));
        rv.setAdapter(adapter);

        return view;
    }
}
