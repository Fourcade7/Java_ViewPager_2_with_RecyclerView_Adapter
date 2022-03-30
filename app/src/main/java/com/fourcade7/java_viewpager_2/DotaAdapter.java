package com.fourcade7.java_viewpager_2;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import java.util.ArrayList;

public class DotaAdapter extends RecyclerView.Adapter<DotaAdapter.DotaViewHolder> {

    Context context;
    ArrayList<Dota> dotaArrayList;
    ViewPager2 viewPager2;

    public DotaAdapter(Context context, ArrayList<Dota> dotaArrayList, ViewPager2 viewPager2) {
        this.context = context;
        this.dotaArrayList = dotaArrayList;
        this.viewPager2 = viewPager2;
    }

    @NonNull
    @Override
    public DotaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.dota_layout,parent,false);
        return new DotaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DotaViewHolder holder, int position) {

        holder.imageView.setImageResource(dotaArrayList.get(position).getImagehero());





    }

    @Override
    public int getItemCount() {
        return dotaArrayList.size();
    }

    public class DotaViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;


        public DotaViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.imageview1);

        }
    }
}
