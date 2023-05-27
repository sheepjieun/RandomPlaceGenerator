package com.example.mobileproject.bookmark.map;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.mobileproject.R;

public class mapSelfActivity extends AppCompatActivity {

    mapSelfFragment mapSelfFragment;
    ImageButton map_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map_self);

        mapSelfFragment = new mapSelfFragment();
        map_back = findViewById(R.id.mapBack);

        getSupportFragmentManager().beginTransaction()
                .add(R.id.container, mapSelfFragment)
                .commit();

        map_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });


    }
}