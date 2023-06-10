package com.example.mobileproject.Recommend.activitiy;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mobileproject.Recommend.api.ApiClient;
import com.example.mobileproject.Recommend.api.ApiInterface;
import com.example.mobileproject.Recommend.model.category_search.CategoryResult;
import com.example.mobileproject.Recommend.model.category_search.Document;
import com.example.mobileproject.R;
import com.example.mobileproject.baseactivity.BaseActivity;


import net.daum.mf.map.api.MapPOIItem;
import net.daum.mf.map.api.MapPoint;
import net.daum.mf.map.api.MapView;


import java.util.List;
import java.util.Random;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RecommendActivity3 extends BaseActivity {

    public static String selected_region;
    public static String selected_category[] = {"","","","","","",""};
    TextView text_region;
    TextView text_category;
    TextView text_place_name;
    TextView text_place_address;
    TextView text_phone;
    List<Document> documents;
    String recommend_data[][] = new String[15][5];
    int[] same_num = new int[15];
    int same_num_index = 0;
    int index = 0;
    int category_index = 0;
    MapView mapView1;
    Call<CategoryResult> call;

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recommend3);

        setupActionBar("추천", true); //액션바 타이틀 설정

        //인플레이팅

        ImageButton btn_retry = findViewById(R.id.btn_retry);
        ImageButton btn_next_category = findViewById(R.id.btn_next_category);
        text_region = findViewById(R.id.selected_region_text);
        text_category = findViewById(R.id.selected_category_text);
        text_place_name = findViewById(R.id.place_name);
        text_place_address = findViewById(R.id.place_address);
        text_phone = findViewById(R.id.phone);
        //mapView1 = findViewById(R.id.map_view);
        mapView1 = (net.daum.mf.map.api.MapView) findViewById(R.id.map_view);


        for(int i = 0; i < same_num.length; i++)
            same_num[i] = -1;

        text_region.setText("추천 지역 : " + selected_region);
        for( ; category_index < 7 ; category_index++, index++){
            if(!selected_category[category_index].equals("")){
                text_category.setText("현재 카테고리 : " + selected_category[category_index++]);
                Log.d("category_index", "onCreate: " + category_index + "       " + index);
                break;
            }
        }
        getRecommendData();

        btn_retry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recommend();
            }
        });

        btn_next_category.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("TAG", "onClick: 다음 실행" + category_index);
                for( ; category_index < 7 ; category_index++){
                    Log.d("For 문 안 인덱스", ""+category_index);
                    if(!selected_category[category_index].equals("")){
                        text_category.setText("현재 카테고리 : " + selected_category[category_index++]);
                        break;
                    }
                }
                if(category_index == 7){
                    Toast.makeText(RecommendActivity3.this,"더 이상 선택된 카테고리가 없습니다.",Toast.LENGTH_SHORT).show();
                }
                else{
                    same_num_index = 0;
                    for(int i = 0; i < same_num.length; i++){
                        same_num[i] = -1;
                        Log.d("same_num 배열", "onClick: " + same_num[i]);
                    }
                    Log.d("same_num_index", "onClick: " + same_num_index);
                    getRecommendData();
                }
            }
        });

    }

    void getRecommendData(){
        ApiInterface apiInterface = ApiClient.getApiClient().create(ApiInterface.class);
        String token = "KakaoAK db7081c99d283896060f0a2759191c9b"; //REST API 키
        String query = selected_region +" "+ selected_category[index]; // 검색문
        int size = 15; // 정보 검색 수 (1~15 가능)

        Log.d("query", "recommend: "+query);
        if(selected_category[index++].equals("음식점")){
            String category_group_code = "FD6"; //카테고리 음식점
            call = apiInterface.getSearchLocation2(token, query, category_group_code, size);
        }
        else{
            call = apiInterface.getSearchLocation(token, query, size);
        }
        call.enqueue(new Callback<CategoryResult>() {
            @Override
            public void onResponse(Call<CategoryResult> call, Response<CategoryResult> response) {
                if (response.isSuccessful()) {
                    CategoryResult result = response.body();
                    documents = result.getDocuments();
                    int index1 = 0; // document를 처리하는 for문에서 사용하는 index1
                    for (Document document : documents) {
                        String placeName = document.getPlaceName();  //장소명 받아오기
                        String address = document.getAddressName(); //주소 받아오기
                        String phone = document.getPhone(); //번호 받아오기
                        String longitude = document.getX(); //경도 받아오기
                        String latitude = document.getY(); //위도 받아오기
                        // ... 기타 document 정보 활용

                        recommend_data[index1][0] = placeName;
                        recommend_data[index1][1] = address;
                        recommend_data[index1][2] = phone;
                        recommend_data[index1][3] = longitude;
                        recommend_data[index1][4] = latitude;
                        Log.d("TAG", "onResponse: " + recommend_data[index1][0] + "---" + recommend_data[index1][1] + "---" + recommend_data[index1][2]);
                        index1++;
                    }
                    recommend();

                } else {
                    // 오류 처리
                    Log.d("오류", "onResponse: 오류");
                }
            }

            @Override
            public void onFailure(Call<CategoryResult> call, Throwable t) {
                // 실패 처리
                Log.d("실패", "onResponse: 실패");
            }
        });
    }

    void recommend(){
        Random random = new Random();
        int random_num;
        boolean same_check = false;
        while(true){
            Log.d("TAG", "recommend: whlie문 동작중" + same_num_index);
            if(same_num_index >= 15){
                Toast.makeText(RecommendActivity3.this,"더 반복하려면 앱을 구독하시오.",Toast.LENGTH_SHORT).show();
                break;
            }
            random_num = random.nextInt(15);

            for(int i=0; i<same_num.length;i++){
                if(random_num == same_num[i]){
                    same_check = true;
                    break;
                }
                else
                    same_check = false;
            }


            if(same_check == false){
                same_num[same_num_index++] = random_num;
                //지도에 마커 찍기
                //중심점 변경
                mapView1.setMapCenterPoint(MapPoint.mapPointWithGeoCoord(Double.parseDouble(recommend_data[random_num][4]), Double.parseDouble(recommend_data[random_num][3])), true);
                // 줌 초기화
                // 줌 레벨 변경
                mapView1.setZoomLevel(1, true);
                // 줌 인
                mapView1.zoomIn(true);
                // 줌 아웃
                mapView1.zoomOut(true);
                MapPoint MARKER_POINT1 = MapPoint.mapPointWithGeoCoord(Double.parseDouble(recommend_data[random_num][4]), Double.parseDouble(recommend_data[random_num][3]));
                // 마커 아이콘 추가하는 함수
                MapPOIItem marker1 = new MapPOIItem();
                // 클릭 했을 때 나오는 호출 값
                marker1.setItemName("추천 장소");
                // 좌표를 입력받아 현 위치로 출력
                marker1.setMapPoint(MARKER_POINT1);
                //  (클릭 전)기본으로 제공하는 BluePin 마커 모양의 색.
                marker1.setMarkerType(MapPOIItem.MarkerType.BluePin);
                // (클릭 후) 마커를 클릭했을때, 기본으로 제공하는 RedPin 마커 모양.
                marker1.setSelectedMarkerType(MapPOIItem.MarkerType.RedPin);
                mapView1.addPOIItem(marker1);
                //텍스트뷰에 정보 올리기
                for(int i = 0; i < same_num.length; i++){
                    Log.d("same_num 배열", "onClick: " + same_num[i]);
                }
                Log.d("same_num_index", "onClick: " + same_num_index);
                Log.d("TAG", "랜덤숫자 발생 " + random_num);
                text_place_name.setText(recommend_data[random_num][0]);
                text_place_address.setText(recommend_data[random_num][1]);
                text_phone.setText(recommend_data[random_num][2]);
                break;
            }


        }
    }

}

