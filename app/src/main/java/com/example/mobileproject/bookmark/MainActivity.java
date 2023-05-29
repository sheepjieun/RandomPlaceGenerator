package com.example.mobileproject.bookmark;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.mobileproject.R;
import com.example.mobileproject.bookmark.course.BookmarkCourseFragment;
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

        GradientDrawable drawable = new GradientDrawable();
        drawable.setShape(GradientDrawable.RECTANGLE); // 버튼의 모서리를 둥글게 만들기 위해 설정
        drawable.setStroke(0, Color.TRANSPARENT); // 다른 방향의 Stroke를 없애기 위해 투명한 Stroke 설정
        drawable.setStroke(5, Color.BLACK, 0, 2); // 아래쪽에 2dp의 검은색 Stroke 적용

        btn_place.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn_place.setTextColor(Color.parseColor("#83C5F4"));
                btn_cos.setTextColor(Color.parseColor("#000000"));
                btn_place.setBackground(drawable);
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
                btn_cos.setBackground(drawable);
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
                Intent intent = new Intent(MainActivity.this, mapActivity.class);
                startActivity(intent);
            }
        });

    }

}
