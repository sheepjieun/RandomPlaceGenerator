package com.example.mobileproject.activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mobileproject.R;
import com.example.mobileproject.adapter.BestAdapter;

import java.util.ArrayList;
import java.util.List;

public class BestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recyclerview_best);

        RecyclerView recyclerView = findViewById(R.id.recyclerview_best);
        recyclerView.setHasFixedSize(true); // if your recyclerview's size is fixed, set this to true for performance improvement

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        List<String> myDataset = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            myDataset.add("장소 " + (i+1));
        }

        BestAdapter mAdapter = new BestAdapter(myDataset, BestAdapter.VIEW_TYPE_BEST);
        recyclerView.setAdapter(mAdapter);

    }
}