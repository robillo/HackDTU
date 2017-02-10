package com.appbusters.robinkamboj.hackdtu.model;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.appbusters.robinkamboj.hackdtu.R;
import com.appbusters.robinkamboj.hackdtu.controller.ItemClickListener;
import com.appbusters.robinkamboj.hackdtu.view.PublicMapsActivity;

public class View_Holder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener{

    Context context;
    public TextView name;
    public TextView starting_point;
    public TextView destination_point;
    public TextView distance;
    private ItemClickListener clickListener;


    public View_Holder(View itemView) {
        super(itemView);

        name = (TextView) itemView.findViewById(R.id.name);
        starting_point = (TextView) itemView.findViewById(R.id.starting_point);
        destination_point = (TextView) itemView.findViewById(R.id.destination_point);
        distance = (TextView) itemView.findViewById(R.id.distance);

        context = itemView.getContext();
        itemView.setTag(itemView);
        itemView.setOnClickListener(this);
        itemView.setOnLongClickListener(this);

    }

    public void setClickListener(ItemClickListener itemClickListener){
        this.clickListener = itemClickListener;
    }

    @Override
    public void onClick(View view) {
        clickListener.onClick(view, getAdapterPosition(),false);
    }

    @Override
    public boolean onLongClick(View view) {
        clickListener.onClick(view, getAdapterPosition(), true);
        return true;
    }

    public void intent(String name, String starting_point, String destination_point, String distance){
        Intent i = new Intent(context, PublicMapsActivity.class);
        i.putExtra("name", name);
        i.putExtra("starting_point", starting_point);
        i.putExtra("destination_point", destination_point);
        i.putExtra("distance", distance);
        context.startActivity(i);
    }

}
