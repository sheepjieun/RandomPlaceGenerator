package com.example.mobileproject;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Grid_Fragment extends Fragment {

    private ArrayList<Integer> image_itemList;
    private RecyclerView grid_recycler;
    private Grid_RecyclerViewAdapter grid_recycler_adapter;
    GridLayoutManager gridLayoutManager;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_grid, container , false);

        image_itemList = new ArrayList<>();

        image_itemList.add(R.drawable.eye_img);
        image_itemList.add(R.drawable.eye_img);
        image_itemList.add(R.drawable.eye_img);

        grid_recycler = view.findViewById(R.id.grid_rv);
        gridLayoutManager = new GridLayoutManager(getContext(),3);
        grid_recycler.setLayoutManager(gridLayoutManager);
        grid_recycler_adapter = new Grid_RecyclerViewAdapter(image_itemList);
        grid_recycler.setAdapter(grid_recycler_adapter);


        return view;


    }
}
