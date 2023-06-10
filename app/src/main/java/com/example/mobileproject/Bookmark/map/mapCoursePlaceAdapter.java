package com.example.mobileproject.Bookmark.map;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mobileproject.R;

import java.util.ArrayList;

public class mapCoursePlaceAdapter extends RecyclerView.Adapter<mapCoursePlaceAdapter.CustomHolder> {

    private ArrayList<mapCoursePlaceData> arrayList;

    public mapCoursePlaceAdapter(ArrayList<mapCoursePlaceData> arrayList) {
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public CustomHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_map_course_place, parent, false);
        CustomHolder holder = new CustomHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull CustomHolder holder, int position) {

        holder.mapImageView.setImageResource(arrayList.get(position).getMapImageView());
        holder.mapName.setText(arrayList.get(position).getMapName());
        holder.mapLocation.setText(arrayList.get(position).getMapLocation());
        holder.mapCategory.setText(arrayList.get(position).getMapCategory());

        holder.itemView.setTag(position);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                if(arrayList.get(position).isMapCheck()){
//                    holder.mapLayout.setBackgroundResource(R.drawable.layout_map_place_select);
//                    arrayList.get(position).setMapCheck(false);
//                }else{
//                    holder.mapLayout.setBackgroundResource(R.drawable.layout_map_place_unselect);
//                    arrayList.get(position).setMapCheck(true);
//                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return (null != arrayList ? arrayList.size() : 0);
    }

    public class CustomHolder extends RecyclerView.ViewHolder {

        protected ImageView mapImageView;
        protected TextView mapName;
        protected TextView mapLocation;
        protected TextView mapCategory;
        protected ConstraintLayout mapLayout;
        public CustomHolder(@NonNull View itemView) {
            super(itemView);
            mapImageView = (ImageView) itemView.findViewById(R.id.mapImageView);
            mapName = (TextView) itemView.findViewById(R.id.mapName);
            mapLocation = (TextView) itemView.findViewById(R.id.mapLocation);
            mapCategory = (TextView) itemView.findViewById(R.id.mapCategory);
            mapLayout = (ConstraintLayout) itemView.findViewById(R.id.mapLayout);

        }
    }
}
