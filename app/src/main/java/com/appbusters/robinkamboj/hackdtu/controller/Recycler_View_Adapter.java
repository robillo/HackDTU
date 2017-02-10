package com.appbusters.robinkamboj.hackdtu.controller;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.appbusters.robinkamboj.hackdtu.R;
import com.appbusters.robinkamboj.hackdtu.model.Data;
import com.appbusters.robinkamboj.hackdtu.model.View_Holder;

import java.util.Collections;
import java.util.List;

public class Recycler_View_Adapter extends RecyclerView.Adapter<View_Holder>{

    List<Data> list = Collections.emptyList();
    Context context, p_context;
    View_Holder holder_;
    private int position_;
    String name, starting_point, destination_point, distance;

    public Recycler_View_Adapter(List<Data> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public View_Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        //inflate the layout, initialize the View_Holder
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.row_layout,parent,false);
        p_context = parent.getContext();
        return new View_Holder(v);
    }

    @Override
    public void onBindViewHolder(View_Holder holder, int position) {
        position_ = position;
        holder.name.setText(list.get(position_).name);
        holder.starting_point.setText(list.get(position_).starting_point);
        holder.destination_point.setText(list.get(position_).destination_point);
        holder.distance.setText(list.get(position_).distance);
        holder_ = holder;
        holder.setClickListener(new ItemClickListener() {
            @Override
            public void onClick(View view, int position, boolean isLongClick) {
                if(isLongClick){
                    name = list.get(position).name;
                    starting_point = list.get(position).starting_point;
                    destination_point = list.get(position).destination_point;
                    distance = list.get(position).distance;
                    holder_.intent(name, starting_point, destination_point, distance);
                }
                else {
                    name = list.get(position).name;
                    starting_point = list.get(position).starting_point;
                    destination_point = list.get(position).destination_point;
                    distance = list.get(position).distance;
                    holder_.intent(name, starting_point, destination_point, distance);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
