package com.example.mobileproject.bookmark.map;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.mobileproject.R;
import com.example.mobileproject.bookmark.MainActivity;

public class mapNavigationActivity extends AppCompatActivity {

    ImageButton btn_x;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map_navigation);

        btn_x = findViewById(R.id.btnX);

        btn_x.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mapNavigationActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}