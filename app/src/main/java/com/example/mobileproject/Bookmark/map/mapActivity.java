package com.example.mobileproject.Bookmark.map;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mobileproject.R;
import com.example.mobileproject.Bookmark.util.KakaoMap;
import com.example.mobileproject.Bookmark.vo.MapMarkVO;
import com.example.mobileproject.baseactivity.BaseActivity;

import net.daum.mf.map.api.MapView;

public class mapActivity extends BaseActivity {

    ImageButton map_back, btn_cos_recommend, btn_random;
    Button btn_cos_setting;
    MapView mapView;
    ViewGroup mapViewContainer;
    KakaoMap kakaoMap;

    MapMarkVO[] mapMarker = new MapMarkVO[6];
    String[] name = {"서울특별시청", "시청역", "홍대입구역", "멘야산다이메", "연하동", "캘리포니아 도넛"};
    String[] category = {"쇼핑", "산책", "산책", "음식점", "음식점", "카페"};



    private static final int GPS_ENABLE_REQUEST_CODE = 2001;
    private static final int PERMISSIONS_REQUEST_CODE = 100;
    String[] REQUIRED_PERMISSIONS  = {Manifest.permission.ACCESS_FINE_LOCATION};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        btn_cos_recommend = findViewById(R.id.btnCosRecommend);
        btn_cos_setting = findViewById(R.id.btnCosSetting);
        btn_random = findViewById(R.id.btnRandom);

        initView();



        //코스 추천 버튼 이벤트
        btn_cos_recommend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mapActivity.this, mapCourseCategoryActivity.class);
                intent.putExtra("cate", category);
                startActivity(intent);
                //mapViewContainer.removeView(kakaoMap.getMapView());
            }
        });

        //코스 수동 설정 버튼 이벤트
        btn_cos_setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mapActivity.this, "공사 중", Toast.LENGTH_SHORT).show();
            }
        });

        //코스 랜덤 설정 버튼 이벤트
        btn_random.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mapActivity.this, "공사 중", Toast.LENGTH_SHORT).show();
            }
        });



    }

    private void initView() {

        //카카오맵 api 지도 네이티브
        mapView = new MapView(this);
        kakaoMap = new KakaoMap(mapView);
        ViewGroup mapContainer = findViewById(R.id.map_view);
        mapContainer.addView(kakaoMap.getMapView());


        kakaoMap.MyLocation(); //현재 위치 표시

        //TODO.북마크에서 가져온 장소에 개수만큼 2차원 배열 생성
        double[][] latlon = new double[6][2]; // 장소의 경도, 위도

        //서울특별시 위도경도
        latlon[0][0] = 37.5666612;
        latlon[0][1] = 126.9783785;

        //시청역 위도경도
        latlon[1][0] = 37.5657037;
        latlon[1][1] = 126.9768616;

        //홍대입구역 위도경도
        latlon[2][0] = 37.5551463;
        latlon[2][1] = 126.9215309;

        //멘야산다이메 위도경도
        latlon[3][0] = 37.5536013;
        latlon[3][1] = 126.9214235;

        //연하동 위도경도
        latlon[4][0] = 37.5604702;
        latlon[4][1] = 126.9235247;

        //캘리포니아 도넛 위도경도
        latlon[5][0] = 37.5511476;
        latlon[5][1] = 126.920215;



        for(int i = 0; i < 6; i++){
            mapMarker[i] = new MapMarkVO(latlon[i][0], latlon[i][1], name[i], category[i]);
        }

        kakaoMap.MapPOIItem(mapMarker); //지도 마커 표시



    }

}