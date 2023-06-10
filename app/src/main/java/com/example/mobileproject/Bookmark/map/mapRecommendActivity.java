package com.example.mobileproject.Bookmark.map;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mobileproject.R;
import com.example.mobileproject.Bookmark.util.KakaoMap;
import com.example.mobileproject.baseactivity.BaseActivity;

import net.daum.mf.map.api.MapView;

import java.util.ArrayList;

public class mapRecommendActivity extends BaseActivity {

    ImageButton map_back, btn_disition, btn_again;
    Button btn;

    MapView mapView;
    ViewGroup mapContainer;
    KakaoMap kakaoMap;
    ArrayList<String> listSelect = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map_recommend);

        btn_disition = findViewById(R.id.btnDisition);
        btn_again = findViewById(R.id.btnRecommendAgain);

        //카카오맵 api 지도
        mapView = new MapView(this);
        kakaoMap = new KakaoMap(mapView);
        mapContainer = findViewById(R.id.map_view);
        mapContainer.addView(kakaoMap.getMapView());

        //사용자가 선택한 카테고리의 순서를 가져온다.
        listSelect.addAll(getIntent().getStringArrayListExtra("listSelect"));



        //결정하기
        btn_disition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showCustomDialog(mapRecommendActivity.this);
            }
        });

        //재추천
        btn_again.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO.코스 재추천 받음
            }
        });
    }

    public void showCustomDialog(Context context) {
        // 커스텀 다이얼로그의 레이아웃을 inflate
        LayoutInflater inflater = LayoutInflater.from(context);
        View dialogView = inflater.inflate(R.layout.map_dialog, null);

        // 다이얼로그 생성
        Dialog dialog = new Dialog(context);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE); // 타이틀 바 숨김
        dialog.setContentView(dialogView);


        int desiredWidthDp = 340; // 원하는 가로 크기(dp)
        int desiredHeightDp = 260; // 원하는 세로 크기(dp)
        int desiredWidthPx = (int) TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP,
                desiredWidthDp,
                context.getResources().getDisplayMetrics()
        );
        int desiredHeightPx = (int) TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP,
                desiredHeightDp,
                context.getResources().getDisplayMetrics()
        );
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(
                desiredWidthPx,
                desiredHeightPx
        );
        dialog.getWindow().setLayout(layoutParams.width, layoutParams.height);

        // 다이얼로그 내부의 버튼 설정
        Button checkButton = dialog.findViewById(R.id.btnCheck);
        Button closeButton = dialog.findViewById(R.id.btnCancel);

        checkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, mapRecommendMadedActivity.class);
                startActivity(intent);
                mapContainer.removeView(kakaoMap.getMapView());
            }
        });

        closeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 버튼 클릭 시 동작 작성
                dialog.dismiss(); // 다이얼로그 닫기
            }
        });

        // 다이얼로그 표시
        dialog.show();
    }



}