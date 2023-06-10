package com.example.mobileproject.Bookmark.map;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mobileproject.R;
import com.example.mobileproject.baseactivity.BaseActivity;

import java.util.ArrayList;
import java.util.Arrays;

public class mapCourseCategoryActivity extends BaseActivity {

    private ArrayList<mapCourseCategoryData> arrayListItem;
    private mapCourseCategoryAdapter mapCourseCategoryAdapter;
    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;

    //카테고리 선택 시 이미지
    Integer[] images = {R.drawable.img_restaurant
            , R.drawable.img_cafe
            , R.drawable.img_walk
            , R.drawable.img_culture
            , R.drawable.img_shopping
            , R.drawable.img_play
            , R.drawable.img_vacation};

    //카테고리 버튼 아이디
    int[] buttonIds = {R.id.btnMapCategory1
            , R.id.btnMapCategory2
            , R.id.btnMapCategory3
            , R.id.btnMapCategory4
            , R.id.btnMapCategory5
            , R.id.btnMapCategory6
            , R.id.btnMapCategory7 };

    //비활성화 버튼
    Integer[] images_disabled = {R.drawable.btn_restaurant_disabled
            , R.drawable.btn_cafe_disabled
            , R.drawable.btn_walk_disabled
            , R.drawable.btn_culture_disabled
            , R.drawable.btn_shopping_disabled
            , R.drawable.btn_play_disabled
            , R.drawable.btn_vacation_disabled};

    //활성화 버튼
    Integer[] images_activate = {R.drawable.btn_restaurant,
            R.drawable.btn_cafe,
            R.drawable.btn_walk,
            R.drawable.btn_culture,
            R.drawable.btn_shopping,
            R.drawable.btn_play,
            R.drawable.btn_vacation};

    String[] location = {"음식점", "카페", "산책", "문화생활", "쇼핑", "놀거리", "휴양지"};

    ImageButton[] btn_map_category = new ImageButton[buttonIds.length]; //카테고리 배열로 받기 위한 선언
    ImageButton map_back, map_cancel, map_next; // 뒤로가기, 초기화, next

    private ArrayList<String> categoryList = new ArrayList<>(); //받아온 카테고리 저장
    int[] categoryNum = new int[7]; //받아온 카테고리가 각각 몇 개 있는지

    private ArrayList<String> listSelect = new ArrayList<>();  // 사용자가 선택한 카테고리 저장


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map_category);

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

        String[] array = getIntent().getStringArrayExtra("cate");
        if (array != null) {
            categoryList.addAll(Arrays.asList(array));
        }


        categoryNumCheck(); // 버튼 활성화, 비활성화


        //TODO.처음 눌렀을 때랑 마지막에 눌렀을 때 화살표가 없어야 된다.
        //카테고리 버튼을 눌렀을 때 recyclerView 추가 되는 이벤트
        View.OnClickListener buttonClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int i = 0;
                //어떤 버튼을 눌렀는지 확인
                switch (v.getId()){
                    case R.id.btnMapCategory1:
                        --categoryNum[i];
                        listSelect.add(location[i]);
                        break;
                    case R.id.btnMapCategory2:
                        i = 1;
                        --categoryNum[i];
                        listSelect.add(location[i]);
                        break;
                    case R.id.btnMapCategory3:
                        i = 2;
                        --categoryNum[i];
                        listSelect.add(location[i]);
                        break;
                    case R.id.btnMapCategory4:
                        i = 3;
                        --categoryNum[i];
                        listSelect.add(location[i]);
                        break;
                    case R.id.btnMapCategory5:
                        i = 4;
                        --categoryNum[i];
                        listSelect.add(location[i]);
                        break;
                    case R.id.btnMapCategory6:
                        i = 5;
                        --categoryNum[i];
                        listSelect.add(location[i]);
                        break;
                    case R.id.btnMapCategory7:
                        i = 6;
                        --categoryNum[i];
                        listSelect.add(location[i]);
                        break;

                }

                for(int j = 0; j < 7; j++){
                    if(categoryNum[j] == 0){
                        btn_map_category[j].setImageResource(images_disabled[j]);
                        btn_map_category[j].setEnabled(false);
                    }
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


        //초기화 버튼 이벤트
        map_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                arrayListItem.clear(); // 하단에 보여줄 리스트 초기화
                mapCourseCategoryAdapter.updateList(); // 하단에 보여줄 어댑터 초기화
                listSelect.clear(); // 다음 뷰로 보내줄 리스트 초기화
                categoryNumCheck(); // 버튼 초기화

            }
        });

        //다음으로 넘어가는 버튼 이벤트
        map_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mapCourseCategoryActivity.this, mapRecommendActivity.class);
                intent.putStringArrayListExtra("listSelect", listSelect); // 사용자가 고른 카테고리 리스트를 보내준다.
                startActivity(intent);
            }
        });


    }

    private void categoryNumCheck(){

        Arrays.fill(categoryNum, 0);

        // 카테고리 버튼을 내가 고른 장소만큼만 누를 수 있게 카테고리 별로 숫자를 올린다.
        for( String category : categoryList){
            switch (category){
                case "음식점":
                    ++categoryNum[0];
                    break;
                case "카페":
                    ++categoryNum[1];
                    break;
                case "산책":
                    ++categoryNum[2];
                    break;
                case "문화생활":
                    ++categoryNum[3];
                    break;
                case "쇼핑":
                    ++categoryNum[4];
                    break;
                case "놀거리":
                    ++categoryNum[5];
                    break;
                case "휴양지":
                    ++categoryNum[6];
                    break;
            }//switch
        }//for

        // 숫자가 1이상이면 활성화가 되고 0이면 비활성화
        for(int i = 0; i < 7; i++){
            if(categoryNum[i] == 0){
                btn_map_category[i].setImageResource(images_disabled[i]);
                btn_map_category[i].setEnabled(false);
            }else{
                btn_map_category[i].setImageResource(images_activate[i]);
                btn_map_category[i].setEnabled(true);
            }
        }//for

    }//categoryNumCheck

}