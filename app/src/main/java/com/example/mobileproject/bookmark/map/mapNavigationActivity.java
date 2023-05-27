package com.example.mobileproject.bookmark.map;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.example.mobileproject.R;
import com.example.mobileproject.bookmark.MainActivity;

public class mapNavigationActivity extends AppCompatActivity {

    ImageButton btn_x;
    mapNavigationFragment mapNavigationFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map_navigation);

        mapNavigationFragment = new mapNavigationFragment();
        btn_x = findViewById(R.id.btnX);
        View view_main  = findViewById(R.id.mainView);
        View view_sub = findViewById(R.id.container);


        //종료하고 메인화면으로 이동
        btn_x.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mapNavigationActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        //fragment 실행
        getSupportFragmentManager().beginTransaction()
                .add(R.id.container, mapNavigationFragment)
                .commit();

        view_main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ViewGroup.LayoutParams params = view_sub.getLayoutParams();
                params.height = dpToPx( mapNavigationActivity.this, 41);
                view_sub.setLayoutParams(params);
            }
        });

        view_sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ViewGroup.LayoutParams params = view_sub.getLayoutParams();
                params.height = dpToPx(mapNavigationActivity.this, 205);
                view_sub.setLayoutParams(params);
            }
        });

    }
    public static int dpToPx(Context context, int dp) {
        float density = context.getResources().getDisplayMetrics().density;
        return (int) (dp * density);
    }
}