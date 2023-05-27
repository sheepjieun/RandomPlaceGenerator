package com.example.mobileproject.bookmark.map;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.mobileproject.R;

public class mapCourseCategoryActivity extends AppCompatActivity {

    ImageButton map_back, map_cancel, map_next;
    ImageButton  btn_map_restaurant, btn_map_cafe, btn_map_walk, btn_map_culture, btn_map_shopping, btn_map_play, btn_map_vacation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map_category);

        map_back = findViewById(R.id.mapBack);
        map_cancel = findViewById(R.id.mapCancel);
        map_next = findViewById(R.id.mapNext);
        btn_map_restaurant = findViewById(R.id.btnMapRestaurant);
        btn_map_cafe = findViewById(R.id.btnMapCafe);
        btn_map_walk = findViewById(R.id.btnMapWalk);
        btn_map_culture = findViewById(R.id.btnMapCulture);
        btn_map_shopping = findViewById(R.id.btnMapShopping);
        btn_map_play = findViewById(R.id.btnMapPlay);
        btn_map_vacation = findViewById(R.id.btnMapVacation);


        map_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        map_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mapCourseCategoryActivity.this, "건들지마!!!", Toast.LENGTH_SHORT).show();
            }
        });

        map_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mapCourseCategoryActivity.this, mapRecommendActivity.class);
                startActivity(intent);
            }
        });

    }
}