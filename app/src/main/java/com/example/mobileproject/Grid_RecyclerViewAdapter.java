package com.example.mobileproject;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Grid_RecyclerViewAdapter extends RecyclerView.Adapter<Grid_RecyclerViewAdapter.ViewHolder> {

    private ArrayList<Integer> image_itemList;

    public Grid_RecyclerViewAdapter(ArrayList<Integer> image_itemList) {
        this.image_itemList = image_itemList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.image_item_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Integer item = image_itemList.get(position);
        holder.img_btn.setImageResource(item);
    }

    @Override
    public int getItemCount() {
        return image_itemList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageButton img_btn;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            img_btn = itemView.findViewById(R.id.imageButton);
        }
    }
}

