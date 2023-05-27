package com.example.mobileproject.bookmark.map;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.mobileproject.R;
import com.example.mobileproject.bookmark.place.BookmarkPlaceFragment;

public class mapRecommendActivity extends AppCompatActivity {

    mapRecommendFragment mapRecommendFragment;
    ImageButton map_back;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map_recommend);

        map_back = findViewById(R.id.mapBack);


        mapRecommendFragment = new mapRecommendFragment(this);

        getSupportFragmentManager().beginTransaction()
                .add(R.id.container, mapRecommendFragment)
                .commit();

        map_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    public void nextFragment(){
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        mapMadedFragment mapMadedFragment = new mapMadedFragment();
        transaction.replace(R.id.container, mapMadedFragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }


}