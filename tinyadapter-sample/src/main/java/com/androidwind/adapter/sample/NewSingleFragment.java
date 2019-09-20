package com.androidwind.adapter.sample;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.androidwind.adapter.TinyAdapter;
import com.androidwind.adapter.TinyViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ddnosh
 * @website http://blog.csdn.net/ddnosh
 */
public class NewSingleFragment extends Fragment {

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
        TinyAdapter oldAdapter = new TinyAdapter<String>(getContext(), data, R.layout.item_recyclerview) {
            @Override
            public void onHandler(TinyViewHolder tinyViewHolder, String result) {
                tinyViewHolder.setText(R.id.tv, result);
            }
        };
        rv.setLayoutManager(new LinearLayoutManager(getContext()));
        rv.setAdapter(oldAdapter);

        return view;
    }
}
