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

import java.util.ArrayList;
import java.util.List;

/**
 * @author ddnosh
 * @website http://blog.csdn.net/ddnosh
 */
public class OldMultipleFragment extends Fragment {

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
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(getContext(), data);
        rv.setLayoutManager(new LinearLayoutManager(getContext()));
        rv.setAdapter(adapter);

        return view;
    }

    class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

        private final static int TYPE_0 = 0;
        private final static int TYPE_1 = 1;

        private Context context;
        private List<String> data;

        public RecyclerViewAdapter(Context context, List<String> data) {
            this.context = context;
            this.data = data;
        }

        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = null;
            if (viewType == TYPE_0) {
                view = LayoutInflater.from(context).inflate(R.layout.item_0, parent, false);
            } else if (viewType == TYPE_1) {
                view = LayoutInflater.from(context).inflate(R.layout.item_1, parent, false);
            }
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
            holder.name.setText(data.get(position));

            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.d("RecyclerViewAdapter", "position = " + position);
                }
            });

        }

        @Override
        public int getItemViewType(int position) {
            if (position % 2 == 0) {
                return TYPE_0;
            } else {
                return TYPE_1;
            }
        }

        @Override
        public int getItemCount() {
            return data.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder {

            private TextView name;

            public ViewHolder(View itemView) {
                super(itemView);
                name = itemView.findViewById(R.id.tv);
            }
        }
    }
}
