package com.example.mobileproject.bookmark.place;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mobileproject.R;

import java.util.ArrayList;

public class BookmarkPlaceFragment extends Fragment {


    // 필요한 멤버 변수들 선언
    private ArrayList<BookmarkPlaceData> arrayListItem; // 즐겨찾기 아이템 목록을 담는 ArrayList
    private BookmarkPlaceListItemAdapter bookmarkListItemAdapter; // 즐겨찾기 아이템 어댑터
    private RecyclerView recyclerView; // RecyclerView 객체
    private LinearLayoutManager linearLayoutManager; // RecyclerView의 레이아웃 매니저
    private BookmarkPlaceData bookmarkData;

    // 이미지, 이름, 위치 정보를 담은 배열
    Integer[] images = {R.drawable.ramen, R.drawable.move, R.drawable.mega, R.drawable.roycafe, R.drawable.wowpark, R.drawable.janghone};
    String[] name = {"멘야산다이메", "스즈메의 문단속", "메가박스 홍대점", "로이커피", "와우공원", "장호네"};
    String[] location = {"홍대", "", "홍대", "까치산", "김포", "김포"};
    String[] kategorie = {"음식점", "문화생활", "문화생활", "카페", "공원", "놀거리"};
    Button btnKaAll, btnKaRestaurant, btnKaCafe, btnKaPark, btnKaCulture, btnKaPlay, btnKaVacation, btnKaShopping;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.bookmark_place_view, container, false);

        btnKaAll = view.findViewById(R.id.btnKaAll);
        btnKaRestaurant = view.findViewById(R.id.btnKaRestaurant);
        btnKaCafe = view.findViewById(R.id.btnKaCafe);
        btnKaCulture = view.findViewById(R.id.btnKaCultare);
        btnKaPark = view.findViewById(R.id.btnKaPark);
        btnKaPlay = view.findViewById(R.id.btnKaPlay);
        btnKaVacation = view.findViewById(R.id.btnKaVacation);
        btnKaShopping = view.findViewById(R.id.btnKaShopping);

        // RecyclerView 객체와 레이아웃 매니저 객체 생성
        recyclerView = view.findViewById(R.id.listViewPlace);
        linearLayoutManager = new LinearLayoutManager(inflater.getContext());
        recyclerView.setLayoutManager(linearLayoutManager);

        // ArrayList 객체 생성
        arrayListItem = new ArrayList<>();

        // 즐겨찾기 아이템 어댑터 객체 생성
        bookmarkListItemAdapter = new BookmarkPlaceListItemAdapter(arrayListItem);

        // RecyclerView에 어댑터 연결
        recyclerView.setAdapter(bookmarkListItemAdapter);


        // 이미지, 이름, 위치 정보를 담은 배열에서 정보를 가져와서
        // BookmarkListItem 객체를 생성하여 ArrayList에 추가
        for (int i = 0; i < name.length; i++) {
            bookmarkData = new BookmarkPlaceData(name[i], location[i], images[i], kategorie[i]);
            arrayListItem.add(bookmarkData);
        }


        btnKaAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                arrayListItem.clear();
                bookmarkListItemAdapter.updateList(arrayListItem);

                for (int i = 0; i < name.length; i++) {
                    bookmarkData = new BookmarkPlaceData(name[i], location[i], images[i], kategorie[i]);
                    arrayListItem.add(bookmarkData);
                }
            }
        });

        btnKaRestaurant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                arrayListItem.clear();
                bookmarkListItemAdapter.updateList(arrayListItem);

                for(int i = 0; i < name.length; i++){
                    if(kategorie[i] == "음식점"){
                        bookmarkData = new BookmarkPlaceData(name[i], location[i], images[i], kategorie[i]);
                        arrayListItem.add(bookmarkData);
                    }

                }
            }
        });

        btnKaCafe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                arrayListItem.clear();
                bookmarkListItemAdapter.updateList(arrayListItem);

                for(int i = 0; i < name.length; i++){
                    if(kategorie[i] == "카페"){
                        bookmarkData = new BookmarkPlaceData(name[i], location[i], images[i], kategorie[i]);
                        arrayListItem.add(bookmarkData);
                    }
                }
            }
        });

        btnKaCulture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                arrayListItem.clear();
                bookmarkListItemAdapter.updateList(arrayListItem);

                for(int i = 0; i < name.length; i++){
                    if(kategorie[i] == "문화생활"){
                        bookmarkData = new BookmarkPlaceData(name[i], location[i], images[i], kategorie[i]);
                        arrayListItem.add(bookmarkData);
                    }
                }
            }
        });

        btnKaPark.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                arrayListItem.clear();
                bookmarkListItemAdapter.updateList(arrayListItem);

                for(int i = 0; i < name.length; i++){
                    if(kategorie[i] == "공원"){
                        bookmarkData = new BookmarkPlaceData(name[i], location[i], images[i], kategorie[i]);
                        arrayListItem.add(bookmarkData);
                    }
                }
            }
        });
        btnKaShopping.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                arrayListItem.clear();
                bookmarkListItemAdapter.updateList(arrayListItem);

                for(int i = 0; i < name.length; i++){
                    if(kategorie[i] == "쇼핑"){
                        bookmarkData = new BookmarkPlaceData(name[i], location[i], images[i], kategorie[i]);
                        arrayListItem.add(bookmarkData);
                    }
                }
            }
        });
        btnKaPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                arrayListItem.clear();
                bookmarkListItemAdapter.updateList(arrayListItem);

                for(int i = 0; i < name.length; i++){
                    if(kategorie[i] == "놀거리"){
                        bookmarkData = new BookmarkPlaceData(name[i], location[i], images[i], kategorie[i]);
                        arrayListItem.add(bookmarkData);
                    }
                }
            }
        });
        btnKaVacation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                arrayListItem.clear();
                bookmarkListItemAdapter.updateList(arrayListItem);

                for(int i = 0; i < name.length; i++){
                    if(kategorie[i] == "휴양지"){
                        bookmarkData = new BookmarkPlaceData(name[i], location[i], images[i], kategorie[i]);
                        arrayListItem.add(bookmarkData);
                    }
                }
            }
        });


        return view;

    }


}
