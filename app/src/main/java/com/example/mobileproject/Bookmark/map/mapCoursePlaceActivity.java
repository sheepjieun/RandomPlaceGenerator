package com.example.mobileproject.Bookmark.map;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mobileproject.R;

import java.util.ArrayList;

public class mapCoursePlaceActivity extends AppCompatActivity {
    private ArrayList<mapCoursePlaceData> arrayListItem; // 즐겨찾기 아이템 목록을 담는 ArrayList
    private mapCoursePlaceAdapter mapCoursePlaceAdapter; // 즐겨찾기 아이템 어댑터
    private RecyclerView recyclerView; // RecyclerView 객체
    private LinearLayoutManager linearLayoutManager; // RecyclerView의 레이아웃 매니저
    private mapCoursePlaceData mapCoursePlaceData;

    Integer[] images = {R.drawable.exam_ramen, R.drawable.exam_move, R.drawable.exam_mega, R.drawable.exam_roycafe, R.drawable.exam_wowpark, R.drawable.exam_janghone};
    String[] name = {"멘야산다이메", "스즈메의 문단속", "메가박스 홍대점", "로이커피", "와우공원", "장호네"};
    String[] location = {"홍대", "", "홍대", "까치산", "김포", "김포"};
    String[] kategorie = {"음식점", "문화생활", "문화생활", "카페", "공원", "놀거리"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map_course_place);

        // RecyclerView 객체와 레이아웃 매니저 객체 생성
        recyclerView = findViewById(R.id.listViewMap);
        linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        // ArrayList 객체 생성
        arrayListItem = new ArrayList<>();

        // 즐겨찾기 아이템 어댑터 객체 생성
        mapCoursePlaceAdapter = new mapCoursePlaceAdapter(arrayListItem);

        // RecyclerView에 어댑터 연결
        recyclerView.setAdapter(mapCoursePlaceAdapter);

        for (int i = 0; i < name.length; i++) {
            mapCoursePlaceData = new mapCoursePlaceData(images[i], name[i], location[i], kategorie[i]);
            arrayListItem.add(mapCoursePlaceData);
        }

    }
}