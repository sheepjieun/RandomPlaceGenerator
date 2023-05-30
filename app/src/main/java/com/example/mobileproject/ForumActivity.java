package com.example.mobileproject;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class ForumActivity extends AppCompatActivity {

    ImageButton grid_frag , text_frag , search;

    Text_Fragment textFragment_;
    Grid_Fragment gridFragment_;

    FrameLayout list_frame , place_frame;

    Button slideButton , placeButton;
    ListView slide_list , place_list;

    List<String> place_items , slide_items;

    Place_list_Adapter place_item_adapter;
    Slide_list_Adapter slide_item_adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forum_main);

        gridFragment_ = new Grid_Fragment();
        textFragment_ = new Text_Fragment();

        grid_frag = findViewById(R.id.grid_view);
        text_frag = findViewById(R.id.text_view);

        search = findViewById(R.id.search_img);

        placeButton = findViewById(R.id.place);
        slideButton = findViewById(R.id.slide_down);
        slide_list= findViewById(R.id.slide_down_list);

        place_list = findViewById(R.id.place_list);

        place_items = new ArrayList<>();
        place_items.add("서울시");
        place_items.add("경기도");
        place_items.add("강원도");
        place_items.add("충청도");
        place_items.add("경상도");
        place_items.add("전라도");
        place_items.add("제주도");

        slide_items = new ArrayList<>();
        slide_items.add("최신순");
        slide_items.add("조회순");
        slide_items.add("추천순");


        place_item_adapter = new Place_list_Adapter(this , place_items);
        slide_item_adapter = new Slide_list_Adapter(this , slide_items);


        place_list.setAdapter(place_item_adapter);
        place_frame = findViewById(R.id.place_frame);

        list_frame = findViewById(R.id.list_frame);

        // 클릭 이벤트 리스너 배열 생성
        View.OnClickListener[] place_clickListeners = new View.OnClickListener[place_items.size()];
        View.OnClickListener[] slide_clickListeners = new View.OnClickListener[slide_items.size()];
        // 클릭 이벤트 리스너 배열을 어댑터에 설정
        place_item_adapter.setItemClickListeners(place_clickListeners);
        slide_item_adapter.setItemClickListeners(slide_clickListeners);

        slide_list.setAdapter(slide_item_adapter);

        list_frame.bringToFront();
        place_frame.bringToFront();

        slideButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int i = 0; i < slide_clickListeners.length; i++) {
                    final int index = i;
                    slide_clickListeners[i] = new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Toast.makeText(ForumActivity.this, "클릭한 아이템: " + slide_items.get(index), Toast.LENGTH_SHORT).show();
                            // 클릭한 아이템에 대한 동작 수행
                        }
                    };
                }
                if (slide_list.getVisibility() == View.GONE) {
                    slide_slideDown();
                } else {
                    slide_slideUp();
                }
            }
        });

        placeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                for (int i = 0; i < place_clickListeners.length; i++) {
                    final int index = i;
                    place_clickListeners[i] = new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Toast.makeText(ForumActivity.this, "클릭한 아이템: " + place_items.get(index), Toast.LENGTH_SHORT).show();
                            // 클릭한 아이템에 대한 동작 수행
                        }
                    };
                }
                if (place_list.getVisibility() == View.GONE) {
                    place_slideDown();
                } else {
                    place_slideUp();
                }
            }
        });

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(ForumActivity.this , SearchActivity.class);
                startActivity(intent);
            }
        });

        text_frag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                text_frag.setColorFilter(Color.BLACK);
                grid_frag.setColorFilter(0xFFC6C6C6);

                frag_textbtn();
            }
        });

        grid_frag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                grid_frag.setColorFilter(Color.BLACK);
                text_frag.setColorFilter(0xFFC6C6C6);

                frag_gridbtn();
            }
        });

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment, textFragment_).commit();
    }

    public void frag_textbtn() {
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment, textFragment_).commit();
    }

    public void frag_gridbtn() {
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment, gridFragment_).commit();
    }
    private void slide_slideDown() {
        Animation slideAnimation = AnimationUtils.loadAnimation(this, R.anim.slide_down);
        slide_list.startAnimation(slideAnimation);
        slide_list.setVisibility(View.VISIBLE);
    }

    private void slide_slideUp() {
        Animation slideAnimation = AnimationUtils.loadAnimation(this, R.anim.slide_up);
        slide_list.startAnimation(slideAnimation);
        slide_list.setVisibility(View.GONE);
    }


    private void place_slideDown() {
        Animation slideAnimation = AnimationUtils.loadAnimation(this, R.anim.slide_down);
        place_list.startAnimation(slideAnimation);
        place_list.setVisibility(View.VISIBLE);
    }

    private void place_slideUp() {
        Animation slideAnimation = AnimationUtils.loadAnimation(this, R.anim.slide_up);
        place_list.startAnimation(slideAnimation);
        place_list.setVisibility(View.GONE);
    }

}

