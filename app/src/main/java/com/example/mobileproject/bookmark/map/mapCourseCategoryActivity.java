package com.example.mobileproject.bookmark.map;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.mobileproject.R;
import com.example.mobileproject.bookmark.MainActivity;

import java.util.ArrayList;

public class mapCourseCategoryActivity extends AppCompatActivity {

    private ArrayList<mapCourseCategoryData> arrayListItem;
    private mapCourseCategoryAdapter mapCourseCategoryAdapter;
    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;

    Integer[] images = {R.drawable.img_restaurant, R.drawable.img_cafe, R.drawable.img_walk, R.drawable.img_culture, R.drawable.img_shopping, R.drawable.img_play, R.drawable.img_vacation};
    ImageButton map_back, map_cancel, map_next;
    int[] buttonIds = {R.id.btnMapCategory1, R.id.btnMapCategory2, R.id.btnMapCategory3, R.id.btnMapCategory4, R.id.btnMapCategory5, R.id.btnMapCategory6, R.id.btnMapCategory7 };
    ImageButton[] btn_map_category = new ImageButton[buttonIds.length];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map_category);

        map_back = findViewById(R.id.mapBack);
        map_cancel = findViewById(R.id.mapCancel);
        map_next = findViewById(R.id.mapNext);

        //카테고리 버튼 인플레이팅
        for(int i = 0; i < buttonIds.length; i++){
            ImageButton imageButton = findViewById(buttonIds[i]);
            btn_map_category[i] = imageButton;

        }

        //recyclerView
        recyclerView = findViewById(R.id.recyclerViewMap);
        linearLayoutManager = new LinearLayoutManager(mapCourseCategoryActivity.this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);

        arrayListItem = new ArrayList<>();
        mapCourseCategoryAdapter = new mapCourseCategoryAdapter(arrayListItem);
        recyclerView.setAdapter(mapCourseCategoryAdapter);

        //TODO.처음 눌렀을 때랑 마지막에 눌렀을 때 화살표가 없어야 된다.
        //TODO.내가 가지고 있는 카테고리만 선택 가능하고 개수도 제한
        //카테고리 버튼을 눌렀을 때 recyclerView 추가 되는 이벤트
        View.OnClickListener buttonClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int i = 0;
                //어떤 버튼을 눌렀는지 확인
                switch (v.getId()){
                    case R.id.btnMapCategory1:
                        break;
                    case R.id.btnMapCategory2:
                        i = 1;
                        break;
                    case R.id.btnMapCategory3:
                        i = 2;
                        break;
                    case R.id.btnMapCategory4:
                        i = 3;
                        break;
                    case R.id.btnMapCategory5:
                        i = 4;
                        break;
                    case R.id.btnMapCategory6:
                        i = 5;
                        break;
                    case R.id.btnMapCategory7:
                        i = 6;
                        break;

                }

                mapCourseCategoryData newItem = new mapCourseCategoryData(images[i]);

                // 아이템을 리스트에 추가
                arrayListItem.add(newItem);

                // 어댑터에 데이터 변경 알림
                mapCourseCategoryAdapter.notifyDataSetChanged();
            }
        };

        //카테고리 별 버튼 이벤트
        btn_map_category[0].setOnClickListener(buttonClickListener);
        btn_map_category[1].setOnClickListener(buttonClickListener);
        btn_map_category[2].setOnClickListener(buttonClickListener);
        btn_map_category[3].setOnClickListener(buttonClickListener);
        btn_map_category[4].setOnClickListener(buttonClickListener);
        btn_map_category[5].setOnClickListener(buttonClickListener);
        btn_map_category[6].setOnClickListener(buttonClickListener);




        //뒤로가기 버튼 이벤트
        map_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        //초기화 버튼 이벤트
        map_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                arrayListItem.clear();
                mapCourseCategoryAdapter.updateList();
                Toast.makeText(mapCourseCategoryActivity.this, "거 코드 너무 어려운 거 아니요;", Toast.LENGTH_SHORT).show();
            }
        });

        //다음으로 넘어가는 버튼 이벤트
        map_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mapCourseCategoryActivity.this, mapRecommendActivity.class);
                startActivity(intent);
            }
        });

//        btn_map_restaurant.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//            }
//        });
//
//        btn_map_cafe.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                mapCourseCategoryData = new mapCourseCategoryData(images[1]);
//                arrayListItem.add(mapCourseCategoryData);
//
//            }
//        });
//
//        btn_map_walk.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                mapCourseCategoryData = new mapCourseCategoryData(images[2]);
//                arrayListItem.add(mapCourseCategoryData);
//
//            }
//        });
//
//        btn_map_culture.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                mapCourseCategoryData = new mapCourseCategoryData(images[3]);
//                arrayListItem.add(mapCourseCategoryData);
//
//            }
//        });
//
//        btn_map_shopping.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                mapCourseCategoryData = new mapCourseCategoryData(images[4]);
//                arrayListItem.add(mapCourseCategoryData);
//
//            }
//        });
//
//        btn_map_play.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                mapCourseCategoryData = new mapCourseCategoryData(images[5]);
//                arrayListItem.add(mapCourseCategoryData);
//
//            }
//        });
//
//        btn_map_vacation.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                mapCourseCategoryData = new mapCourseCategoryData(images[6]);
//                arrayListItem.add(mapCourseCategoryData);
//
//            }
//        });

    }
}