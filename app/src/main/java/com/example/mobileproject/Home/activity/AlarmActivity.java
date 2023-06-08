package com.example.mobileproject.Home.activity;

import android.os.Bundle;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mobileproject.Home.adapter.AlarmAdapter;
import com.example.mobileproject.R;
import com.example.mobileproject.baseactivity.BaseActivity;
import com.example.mobileproject.data.Alarm;

import java.util.ArrayList;
import java.util.List;

public class AlarmActivity extends BaseActivity {
    private RecyclerView recyclerView;
    private AlarmAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm);


        setupActionBar("공지사항", true); //액션바 타이틀 설정

        recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        String[] strArray = {"양지은", "임경빈", "유장호", "선지성", "김우빈", "손석구", "아이유", "봉미선", "신짱구"};
        List<Alarm> alarms = new ArrayList<>();
        // 테스트 데이터 생성
        for(int i = 0; i < strArray.length; i++) {
            alarms.add(new Alarm("친구신청", strArray[i] + "님께서 친구 신청을 하였습니다!"));
        }

        adapter = new AlarmAdapter(alarms);
        recyclerView.setAdapter(adapter);
    }

}