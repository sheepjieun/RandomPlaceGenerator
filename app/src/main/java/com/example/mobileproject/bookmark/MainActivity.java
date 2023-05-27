package com.example.mobileproject.bookmark;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.mobileproject.R;
import com.example.mobileproject.bookmark.cos.BookmarkCourseFragment;
import com.example.mobileproject.bookmark.map.mapActivity;
import com.example.mobileproject.bookmark.place.BookmarkPlaceFragment;

// MainActivity 클래스 정의
public class MainActivity extends AppCompatActivity {

    BookmarkPlaceFragment fragment_place;
    Button btn_place, btn_cos;
    ImageButton btn_map;


    // 액티비티 생성 시 호출되는 메서드
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bookmark_fragment);

        fragment_place = new BookmarkPlaceFragment();
        btn_place = findViewById(R.id.btnPlace);
        btn_cos = findViewById(R.id.btnCos);
        btn_map = findViewById(R.id.btnMap);

        getSupportFragmentManager().beginTransaction()
                .add(R.id.container, fragment_place)
                .commit();

        btn_place.setBackgroundResource(R.drawable.button_round);

        btn_place.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn_place.setTextColor(Color.parseColor("#83C5F4"));
                btn_cos.setTextColor(Color.parseColor("#000000"));
                btn_place.setBackgroundResource(R.drawable.button_round);
                btn_cos.setBackgroundResource(R.drawable.button_bg_default);
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                BookmarkPlaceFragment bmPlaceFragment = new BookmarkPlaceFragment();
                transaction.replace(R.id.container, bmPlaceFragment);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });

        btn_cos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn_place.setTextColor(Color.parseColor("#000000"));
                btn_cos.setTextColor(Color.parseColor("#83C5F4"));
                btn_cos.setBackgroundResource(R.drawable.button_round);
                btn_place.setBackgroundResource(R.drawable.button_bg_default);
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                BookmarkCourseFragment bmCosFragment = new BookmarkCourseFragment();
                transaction.replace(R.id.container, bmCosFragment);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });


        btn_map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "맵으로 이동합니다.", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, mapActivity.class);
                startActivity(intent);
            }
        });

    }

}
