package com.example.mobileproject.Bookmark.map;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mobileproject.Home.activity.MainActivity;
import com.example.mobileproject.R;
import com.example.mobileproject.Bookmark.BookmarkFragment;
import com.example.mobileproject.Bookmark.util.KakaoMap;
import com.example.mobileproject.baseactivity.BaseActivity;

import net.daum.mf.map.api.MapView;

public class mapNavigationActivity extends BaseActivity {

    ImageButton btn_x;
    mapNavigationFragment mapNavigationFragment;
    MapView mapView;
    KakaoMap kakaoMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map_navigation);

        mapNavigationFragment = new mapNavigationFragment();
        View view_main  = findViewById(R.id.mainView);
        View view_sub = findViewById(R.id.container);

        mapView = new MapView(this);
        kakaoMap = new KakaoMap(mapView);
        ViewGroup mapContainer = findViewById(R.id.map_view);
        mapContainer.addView(kakaoMap.getMapView());


        //종료하고 메인화면으로 이동
        btn_x.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mapNavigationActivity.this, MainActivity.class);
                startActivity(intent);
                mapContainer.removeView(mapView);
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