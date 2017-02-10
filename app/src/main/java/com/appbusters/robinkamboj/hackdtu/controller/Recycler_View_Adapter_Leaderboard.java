package com.appbusters.robinkamboj.hackdtu.controller;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.appbusters.robinkamboj.hackdtu.R;
import com.appbusters.robinkamboj.hackdtu.model.Data;
import com.appbusters.robinkamboj.hackdtu.model.Data_Leaderboard;
import com.appbusters.robinkamboj.hackdtu.model.View_Holder;
import com.appbusters.robinkamboj.hackdtu.model.View_Holder_Leaderboard;

import java.util.Collections;
import java.util.List;

public class Recycler_View_Adapter_Leaderboard extends RecyclerView.Adapter<View_Holder_Leaderboard>{

    List<Data_Leaderboard> list = Collections.emptyList();
    Context context;

    public Recycler_View_Adapter_Leaderboard(List<Data_Leaderboard> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public View_Holder_Leaderboard onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.row_layout2,parent,false);
        context = parent.getContext();
        return new View_Holder_Leaderboard(v);
    }

    @Override
    public void onBindViewHolder(View_Holder_Leaderboard holder, int position) {
        holder.name.setText(list.get(position).name);
        holder.total_distance.setText(list.get(position).total_distance);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
