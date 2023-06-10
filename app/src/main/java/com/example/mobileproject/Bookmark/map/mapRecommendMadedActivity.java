package com.example.mobileproject.Bookmark.map;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mobileproject.R;
import com.example.mobileproject.Bookmark.util.KakaoMap;
import com.example.mobileproject.baseactivity.BaseActivity;

import net.daum.mf.map.api.MapView;


public class mapRecommendMadedActivity extends BaseActivity {

    ImageButton btn_back, btn_start;

    MapView mapView;
    KakaoMap kakaoMap;
    ViewGroup mapContainer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map_recommend_maded);

        btn_start = findViewById(R.id.btnStart);
        //카카오맵 api 지도

        mapView = new MapView(this);
        kakaoMap = new KakaoMap(mapView);
        mapContainer = findViewById(R.id.map_view);
        mapContainer.addView(kakaoMap.getMapView());


        //뒤로가기
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        btn_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mapRecommendMadedActivity.this, mapNavigationActivity.class);
                startActivity(intent);
                mapContainer.removeView(kakaoMap.getMapView());
            }
        });

    }
}