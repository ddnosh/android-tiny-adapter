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

import java.util.ArrayList;
import java.util.List;

/**
 * @author ddnosh
 * @website http://blog.csdn.net/ddnosh
 */
public class OldSingleFragment extends Fragment {

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
        OldAdapter oldAdapter = new OldAdapter(getContext(), data);
        rv.setLayoutManager(new LinearLayoutManager(getContext()));
        rv.setAdapter(oldAdapter);

        return view;
    }
}
