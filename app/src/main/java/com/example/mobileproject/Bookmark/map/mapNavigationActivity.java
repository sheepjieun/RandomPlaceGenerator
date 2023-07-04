package com.example.mobileproject.Bookmark.map;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mobileproject.Bookmark.vo.MapMarkVO;
import com.example.mobileproject.Bookmark.vo.UserPlaceVO;
import com.example.mobileproject.Home.activity.MainActivity;
import com.example.mobileproject.R;
import com.example.mobileproject.Bookmark.BookmarkFragment;
import com.example.mobileproject.Bookmark.util.KakaoMap;
import com.example.mobileproject.baseactivity.BaseActivity;
import com.example.mobileproject.baseactivity.RecommendBaseActivity;

import net.daum.mf.map.api.MapView;

import java.util.ArrayList;

public class mapNavigationActivity extends RecommendBaseActivity {

    ImageButton btn_x;
    mapNavigationFragment mapNavigationFragment;
    MapView mapView;
    KakaoMap kakaoMap;
    ViewGroup mapContainer;

    MapMarkVO[] mapMarker = new MapMarkVO[1];
    String[] name = {"서울특별시청", "시청역", "홍대입구역", "멘야산다이메", "연하동", "캘리포니아 도넛"};
    String[] category = {"쇼핑", "산책", "산책", "음식점", "음식점", "카페"};

    ArrayList<UserPlaceVO> userPlaceVO = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map_navigation);

        mapNavigationFragment = new mapNavigationFragment();
        View view_main  = findViewById(R.id.mainView);
        View view_sub = findViewById(R.id.container);

        //TODO.변경(이거 되는지 안 되는지 확인을 다시 해봐야 됨)

        //TODO.kakaoMap api 사용
        initView();
/*

        mapView = new MapView(this);
        kakaoMap = new KakaoMap(mapView);
        ViewGroup mapContainer = findViewById(R.id.map_view);
        mapContainer.addView(kakaoMap.getMapView());
*/



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

    //TODO. 마커와 line추가
    private void initView() {

        //카카오맵 api 지도 네이티브
        mapView = new MapView(this);
        kakaoMap = new KakaoMap(mapView);
        mapContainer = findViewById(R.id.map_view);
        mapContainer.addView(kakaoMap.getMapView());


        kakaoMap.MyLocation(); //현재 위치 표시

        //TODO.북마크에서 가져온 장소에 개수만큼 2차원 배열 생성
        double[][] latlon = new double[6][2]; // 장소의 경도, 위도

        //멘야산다이메 위도경도
        latlon[0][0] = 37.5536013;
        latlon[0][1] = 126.9214235;

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


        mapMarker[0] = new MapMarkVO(latlon[0][0], latlon[0][1], "멘야산다이메");

        kakaoMap.MapPOIItem(mapMarker); //지도 마커 표시



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.close_menu, menu); // your_menu.xml 이 메뉴 리소스의 이름
        return true;
    }
}