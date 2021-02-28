package com.example.databindingrecyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.databindingrecyclerview.databinding.ItemLayoutBinding;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> {

    private Context context;
    private List<Fruits> fruits = new ArrayList<>();

    public RecyclerAdapter(Context context, List<Fruits> fruits) {
        this.context = context;
        this.fruits = fruits;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

      ItemLayoutBinding itemLayoutBinding = DataBindingUtil.inflate(LayoutInflater.from(
              parent.getContext()),R.layout.item_layout,parent,false);

      MyViewHolder myViewHolder = new MyViewHolder(itemLayoutBinding);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        Fruits fruit = fruits.get(position);
        holder.itemLayoutBinding.setFruits(fruit);
    }

    @Override
    public int getItemCount() {
        return fruits.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

       ItemLayoutBinding itemLayoutBinding;

        public MyViewHolder(@NonNull ItemLayoutBinding itemView) {
            super(itemView.getRoot());

            itemLayoutBinding = itemView;
        }
    }
}
