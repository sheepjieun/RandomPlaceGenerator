package com.example.mobileproject.bookmark.map;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.mobileproject.R;

public class mapActivity extends AppCompatActivity {

    ImageButton map_back, btn_cos_recommend, btn_random;
    Button btn_cos_setting;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        map_back = findViewById(R.id.mapBack);
        btn_cos_recommend = findViewById(R.id.btnCosRecommend);
        btn_cos_setting = findViewById(R.id.btnCosSetting);
        btn_random = findViewById(R.id.btnRandom);

        //카카오맵 api 웹앱
        WebView webView = (WebView) findViewById(R.id.webView);
//        WebSettings webSettings = webView.getSettings();
//        webSettings.setJavaScriptEnabled(true); // allow the js
//
//        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON); //화면이 계속 켜짐
//        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_FULL_USER);
        //webView.getSettings().setJavaScriptEnabled(true);


        webView.setWebViewClient(new WebViewClient());
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl("file:///android_asset/kakaoMap.html");
        //webView.loadUrl("https://www.naver.com");

        //뒤로가기
        map_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        //코스 추천 버튼 이벤트
        btn_cos_recommend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mapActivity.this, mapCourseCategoryActivity.class);
                startActivity(intent);
            }
        });

        //코스 수동 설정 버튼 이벤트
        btn_cos_setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mapActivity.this, mapSelfActivity.class);
                startActivity(intent);
            }
        });

        //코스 랜덤 설정 버튼 이벤트
        btn_random.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mapActivity.this, "아직 작업 중이야! 건들지마!!", Toast.LENGTH_SHORT).show();
            }
        });

    }
}