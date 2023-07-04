package com.example.mobileproject.Bookmark.map;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.mobileproject.Bookmark.vo.UserPlaceVO;
import com.example.mobileproject.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import lombok.NonNull;

public class mapCoursePlaceActivity extends AppCompatActivity implements mapCoursePlaceAdapter.OnItemClickListener {


    private ArrayList<mapCoursePlaceData> arrayListItem; // 즐겨찾기 아이템 목록을 담는 ArrayList
    private mapCoursePlaceAdapter mapCoursePlaceAdapter; // 즐겨찾기 아이템 어댑터
    private RecyclerView recyclerView; // RecyclerView 객체
    private LinearLayoutManager linearLayoutManager; // RecyclerView의 레이아웃 매니저
    private mapCoursePlaceData mapCoursePlaceData;

    private ArrayList<String> selectCategory = new ArrayList<>(); // activity로 보내줄 카테고리를 저장
    private ArrayList<String> selectName = new ArrayList<>(); // 선택 취소한 카테고리를 저장

    Integer[] images = {R.drawable.exam_ramen, R.drawable.exam_move, R.drawable.exam_mega, R.drawable.exam_roycafe, R.drawable.exam_wowpark, R.drawable.exam_janghone};
    String[] name = {"멘야산다이메", "스즈메의 문단속", "메가박스 홍대점", "로이커피", "와우공원", "장호네"};
    String[] location = {"홍대", "", "홍대", "까치산", "김포", "김포"};
    String[] kategorie = {"음식점", "문화생활", "문화생활", "카페", "공원", "놀거리"};

    ImageButton btn_next;

    ArrayList<UserPlaceVO> userPlaceVO = new ArrayList<>(); //데이터베이스에서 가져온 값
    ArrayList<UserPlaceVO> nextList = new ArrayList<>(); // 다음 acivity로 넘길 값

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map_course_place);

        btn_next = findViewById(R.id.btnNext);

        //TODO.데이터베이스 연결해서 값을 가져와야 함
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        db.collection("bookmark_place")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @SuppressLint("NotifyDataSetChanged")
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            //TODO 리스트 bookmark place 생성
                            //TODO for문으로 UserPlaceVO.class에 추가
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                UserPlaceVO place = document.toObject(UserPlaceVO.class);
                                userPlaceVO.add(place);
                            }
                            for (int i = 0; i < userPlaceVO.size(); i++) {
                                UserPlaceVO userPlace = userPlaceVO.get(i);
                                mapCoursePlaceData = new mapCoursePlaceData(userPlace.getImgURL(), userPlace.getPlaceName(), userPlace.getAddressName(), userPlace.getCategoryName());
                                arrayListItem.add(mapCoursePlaceData);


                            }
                            Log.d("Glide img", mapCoursePlaceData.getMapImageView());
                            mapCoursePlaceAdapter.notifyDataSetChanged();
                        } else {
                        }
                    }
                });

        // RecyclerView 객체와 레이아웃 매니저 객체 생성
        recyclerView = findViewById(R.id.listViewMap);
        linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        // ArrayList 객체 생성
        arrayListItem = new ArrayList<>();

        // 즐겨찾기 아이템 어댑터 객체 생성
        mapCoursePlaceAdapter = new mapCoursePlaceAdapter(arrayListItem, this);

        // RecyclerView에 어댑터 연결
        recyclerView.setAdapter(mapCoursePlaceAdapter);



        //TODO.intent.put 추가
        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                for(int i = 0; i < selectName.size(); i++){
                    UserPlaceVO list = userPlaceVO.get(i);
                    String selectList = selectName.get(i);
                    if(selectList.equals(list.getPlaceName())){
                        nextList.add(list);
                    }
                }
                Intent intent = new Intent(mapCoursePlaceActivity.this, mapRecommendActivity.class);
                intent.putExtra("userList", nextList);
                startActivity(intent);
            }
        });

    }
    //TODO.값을 저장하는 인터페이스 override
    @Override
    public void onItemClickSelect(mapCoursePlaceData item) {
        selectCategory.add(item.getMapCategory());
        selectName.add(item.getMapName());
    }

    //TODO.값을 삭제하는 인터페이스 override
    @Override
    public void onItemClickUnSelect(mapCoursePlaceData item) {
        Iterator<String> categoryIterator = selectCategory.iterator();
        Iterator<String> nameIterator = selectName.iterator();
        while (categoryIterator.hasNext() && nameIterator.hasNext()) {
            String category = categoryIterator.next();
            String name = nameIterator.next();
            if (name.equals(item.getMapName())) {
                categoryIterator.remove();
                nameIterator.remove();
            }
        }
    }



}