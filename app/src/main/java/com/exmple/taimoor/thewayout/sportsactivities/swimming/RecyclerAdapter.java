package com.exmple.taimoor.thewayout.sportsactivities.Swimming;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.exmple.taimoor.thewayout.R;

import java.util.List;


public class RecyclerAdapter extends RecyclerView.Adapter <RecyclerAdapter.MyViewHolder>{

    public List<PlaceModel> swimmingPools;
    private Context context;

    public RecyclerAdapter(List<PlaceModel> swimmingPools, Context context){

        this.swimmingPools = swimmingPools;
        this.context = context;

    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_view_for_active_swimming_pools,parent,false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {



        holder.Name.setText("Name: " +swimmingPools.get(position).getName());
        holder.Location.setText("Location: " + swimmingPools.get(position).getLocation());

    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public int getItemCount() {

        return swimmingPools.size();

    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView Name, Location;


        public MyViewHolder(View itemView) {
            super(itemView);
            Name = itemView.findViewById(R.id.sp_name);
            Location = itemView.findViewById(R.id.sp_location);

        }
    }
}
